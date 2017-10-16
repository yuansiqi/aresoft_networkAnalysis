package com.aresoft.manager.smo;

import com.aresoft.manager.dao.SysUserDao;
import com.aresoft.manager.model.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuans on 2017/9/24.
 */
@Service
public class UserSmoImpl implements  UserSmo {

    @Resource
    private SysUserDao sysUserDao;
    @Override
    public List<SysUser> queryUser() {
        return sysUserDao.getAll();
    }
}
