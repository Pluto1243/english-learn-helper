package com.wj.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wj.boot.entity.Group;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分组映射
 *
 * @author wangjie
 * @date 14:56 2022年07月27日
 **/
@Mapper
public interface GroupMapper extends BaseMapper<Group> {

}
