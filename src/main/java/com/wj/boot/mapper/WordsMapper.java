package com.wj.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wj.boot.entity.Group;
import com.wj.boot.entity.Words;
import org.apache.ibatis.annotations.Mapper;

/**
 * 单词映射
 *
 * @author wangjie
 * @date 15:00 2022年07月27日
 **/
@Mapper
public interface WordsMapper extends BaseMapper<Words> {
    
}
