package com.qkainan.dao;

import com.qkainan.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userDao {
        List<user> findByIdAndUsername(@Param("id") Integer id , @Param("username") String username);
}
