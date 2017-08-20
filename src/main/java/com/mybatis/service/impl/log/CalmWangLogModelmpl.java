package com.mybatis.service.impl.log;

import com.mybatis.dao.log.CalmWangLogDao;
import com.mybatis.domain.log.CalmWangLogModel;
import com.mybatis.service.log.CalmWangLogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yunkai on 2017/7/20.
 */
@Service("calmWangLogService")
@Transactional
public class CalmWangLogModelmpl implements CalmWangLogServiceI{

    @Autowired
    private CalmWangLogDao calmWangLogDao;

    @Override
    public void saveLog(Short userId){
        calmWangLogDao.saveLog(userId);
    }

    @Override
    public List<CalmWangLogModel> findList(){
        return calmWangLogDao.findList();
    }

    @Override
    public void update(Short id){
        calmWangLogDao.updateState(id);
    }
}
