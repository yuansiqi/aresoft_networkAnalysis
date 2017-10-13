package cn.aresoft.manager.smo;

import cn.aresoft.manager.dao.SysEmployeeDao;
import cn.aresoft.manager.model.SysEmployeeModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuans on 2017/9/24.
 */
@Service
public class UserSmoImpl implements  UserSmo {

    @Resource
    private SysEmployeeDao sysEmployeeDao;
    @Override
    public List<SysEmployeeModel> queryUser() {
        return sysEmployeeDao.getAll();
    }
}
