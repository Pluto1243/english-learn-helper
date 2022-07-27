package com.wj.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wj.boot.entity.request.CheckRequest;
import com.wj.boot.entity.response.R;
import com.wj.boot.service.IWordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 单词抽查类
 *
 * @author wangjie
 * @date 14:44 2022年07月27日
 **/
@RestController
@Api(tags = "单词模块")
@RequestMapping("word")
@Validated
public class WordController {

    @Autowired
    private IWordsService wordsService;

    @PostMapping("uploadWords")
    @ApiOperation("导入单词")
    @ApiOperationSupport(order = 100)
    public R uploadWords(@NotNull(message = "请输入分组名称！") @RequestParam("groupName") String groupName,
                         @RequestParam("file") MultipartFile multipartFile) {
        return R.ok(wordsService.uploadWords(groupName, multipartFile));
    }


    @GetMapping("checkWords")
    @ApiOperation("单词抽背")
    @ApiOperationSupport(order = 101)
    public R checkWords(@Valid CheckRequest checkRequest) {
        return R.ok(wordsService.checkWords(checkRequest));
    }
}
