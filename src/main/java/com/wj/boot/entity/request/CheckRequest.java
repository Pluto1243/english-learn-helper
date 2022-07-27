package com.wj.boot.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 单词抽背请求类
 *
 * @author wangjie
 * @date 15:56 2022年07月27日
 **/
@Data
@ApiModel("单词抽查请求类")
public class CheckRequest implements Serializable {

    @NotNull(message = "请输入分组Id！")
    @ApiModelProperty("分组Id")
    private Integer groupId;

    @NotNull(message = "请输入起始位置！")
    @ApiModelProperty("起始位置")
    private Integer startAt;

    @NotNull(message = "请输入截止位置！")
    @ApiModelProperty("截止位置")
    private Integer endAt;

    @NotNull(message = "请输入个数！")
    @ApiModelProperty("个数")
    private Integer num;
}
