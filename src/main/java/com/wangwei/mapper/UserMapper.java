package com.wangwei.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author wangwei
 * @date 2022/6/12 10:46
 */

public interface UserMapper {

    @Select("select 'user'")
    public String getUserName();
}
