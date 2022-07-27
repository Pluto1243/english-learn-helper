package com.wj.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wj.boot.entity.Group;
import com.wj.boot.entity.Words;
import com.wj.boot.entity.request.CheckRequest;
import com.wj.boot.exception.CommonException;
import com.wj.boot.exception.EmError;
import com.wj.boot.mapper.GroupMapper;
import com.wj.boot.mapper.WordsMapper;
import com.wj.boot.service.IWordsService;
import com.wj.boot.utils.WordsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 单词业务实现类
 *
 * @author wangjie
 * @date 15:00 2022年07月27日
 **/
@Service
public class WordsServiceImpl implements IWordsService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private WordsMapper wordsMapper;


    @Override
    public Integer uploadWords(String groupName, MultipartFile multipartFile) {
        int count = 0;
        InputStream in = null;
        BufferedReader reader = null;
        //判断分组是否存在
        if (groupMapper.exists(new QueryWrapper<Group>().eq("groupName", groupName))) {
            throw new CommonException(EmError.GROUP_NAME_EXIST);
        }
        // 新建分组
        Group group = new Group();
        group.setGroupName(groupName);
        groupMapper.insert(group);
        try {
            in = multipartFile.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            String word = null;
            while((word = reader.readLine()) != null) {
                word = word.trim().replaceAll("[^A-Za-z]", "");
                if (StringUtils.hasLength(word)) {
                    Words words = new Words();
                    words.setWord(word);
                    // 翻译单词
                    words.setTranslation(WordsUtils.getTranslate(word));
                    words.setGroupId(group.getId());
                    // 睡0.05秒
                    Thread.sleep(50);
                    // 保存到数据库
                    wordsMapper.insert(words);
                    System.out.println(words.toString());
                    count++;
                }
            }
        } catch (Exception e) {
            throw new CommonException(EmError.UPLOAD_ERROR);
        } finally {
            try {
                in.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public List<Words> checkWords(CheckRequest checkRequest) {
        // 从范围里获取单词
        String limit = "limit " + checkRequest.getStartAt() + "," + checkRequest.getEndAt();
        List<Words> words = wordsMapper.selectList(
                                new QueryWrapper<Words>()
                                    .eq("groupId", checkRequest.getGroupId())
                                    .last(limit));
        // 打乱顺序
        Collections.shuffle(words);
        // 范围值大于题数时  截取题数
        if ((checkRequest.getEndAt() - checkRequest.getStartAt()) >= checkRequest.getNum()) {
            return words.subList(0, checkRequest.getNum()).stream().map(it -> {
                it.setTranslation(null);
                return it;
            }).collect(Collectors.toList());
        }
        return words.stream().map(it -> {
            it.setTranslation(null);
            return it;
        }).collect(Collectors.toList());
    }
}
