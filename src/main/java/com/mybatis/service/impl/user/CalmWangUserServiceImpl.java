package com.mybatis.service.impl.user;

import com.mybatis.dao.user.CalmWangUserDao;
import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yunkai on 2017/5/24.
 */
@Service
@Transactional
public class CalmWangUserServiceImpl implements CalmWangUserServiceI {

    @Autowired
    private CalmWangUserDao miaoGeUserDao;

    @Override
    public List<CalmWangUserModel> findUserList() {
        List<CalmWangUserModel> users = miaoGeUserDao.findAll();
        return users;
    }

    @Override
    public List<CalmWangUserModel> getByName(String name) {
        CalmWangUserModel user = new CalmWangUserModel();
        List<CalmWangUserModel> users = miaoGeUserDao.getByNameAndPhone(name, "13588313834");
        return users;
    }

    @Override
    public Short saveUser(String userName, String userPhone) {
        miaoGeUserDao.saveUser(userName, userPhone);
        Short userID = miaoGeUserDao.last_insert_id();
        return userID;
    }

    @Override
    public CalmWangUserModel getById(Short id){
        return miaoGeUserDao.getById(id);
    }

    @Override
    public void update(CalmWangUserModel user) {
        miaoGeUserDao.update(user.getUser_name(), user.getID());
    }
}
