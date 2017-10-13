package cn.aresoft.manager.dao;

import cn.aresoft.manager.model.SysEmployeeModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
@Service
 public interface SysEmployeeDao {
    List<SysEmployeeModel> getAll();
}