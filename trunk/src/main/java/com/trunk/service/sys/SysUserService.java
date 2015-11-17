package com.trunk.service.sys;

import com.trunk.bean.sys.SysUser;
import com.trunk.dao.UserDao;
import com.trunk.dao.sys.SysUserMapper;
import com.trunk.dao.util.Condition;
import com.trunk.dao.util.SearchOperator;
import com.trunk.dao.util.Searchable;
import com.trunk.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zoro on 2015/11/17.
 */
@Service
public class SysUserService {


    @Autowired
    private SysUserMapper userMapper;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public SysUser findByUsername(String username) {
        Searchable searchable = new Searchable();
        searchable.addCondition(new Condition("accountname", SearchOperator.eq, username));
        return userMapper.selectBySearchable(searchable);
    }


}
