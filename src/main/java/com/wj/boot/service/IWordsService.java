package com.wj.boot.service;

import com.wj.boot.entity.Group;
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

    /**
     * @description 上传单词
     *
     * @author wangjie
     * @date 11:29 2022年07月28日 
     * @param groupName
     * @param multipartFile
     * @return java.lang.Integer 
     */
    Integer uploadWords(String groupName, MultipartFile multipartFile);

    /**
     * @description 获得单词抽查数据
     *
     * @author wangjie
     * @date 11:29 2022年07月28日 
     * @param checkRequest
     * @return java.util.List<com.wj.boot.entity.Words> 
     */
    List<Words> checkWords(CheckRequest checkRequest);

    /**
     * @description 获得单词分组数据
     *
     * @author wangjie
     * @date 11:30 2022年07月28日 
     * @param 
     * @return java.util.List<com.wj.boot.entity.Group> 
     */
    List<Group> listGroup();
}
