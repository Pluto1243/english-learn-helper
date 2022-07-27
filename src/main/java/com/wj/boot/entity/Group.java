package com.wj.boot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分组类
 *
 * @author wangjie
 * @date 14:52 2022年07月27日
 **/
@Data
@ApiModel("分组")
@TableName("`group`")
public class Group implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("分组名称")
    private String groupName;
}