package com.wj.boot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 单词
 *
 * @author wangjie
 * @date 14:53 2022年07月27日
 **/
@Data
@ApiModel("单词")
@TableName("words")
public class Words implements Serializable {
    
    private Integer id;

    /**
    * 单词
    */
    @ApiModelProperty("单词")
    private String word;

    /**
    * 翻译
    */
    @ApiModelProperty("翻译")
    private String translation;

    /**
    * 分组Id
    */
    @ApiModelProperty("分组Id")
    private Integer groupId;
}