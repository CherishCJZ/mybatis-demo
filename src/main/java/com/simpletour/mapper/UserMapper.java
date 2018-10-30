package com.simpletour.mapper;

import com.simpletour.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * find User by id
     *
     * @param id id
     * @return User
     */
    User findById(@Param("id") int id);
}
