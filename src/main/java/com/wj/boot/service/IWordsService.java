package com.wj.boot.service;

import com.wj.boot.entity.Words;
import com.wj.boot.entity.request.CheckRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 单词业务接口
 *
 * @author wangjie
 * @date 15:00 2022年07月27日
 **/
public interface IWordsService {

    Integer uploadWords(String groupName, MultipartFile multipartFile);

    List<Words> checkWords(CheckRequest checkRequest);
}
