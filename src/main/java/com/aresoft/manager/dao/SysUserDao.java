package com.aresoft.manager.dao;

import com.aresoft.manager.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
@Service
 public interface SysUserDao {
    List<SysUser> getAll();
}