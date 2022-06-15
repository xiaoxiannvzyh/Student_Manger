package org.lihanyu.service.impl;


import org.lihanyu.dao.UserMapper;
import org.lihanyu.domain.User;
import org.lihanyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    //SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {


        /*
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        sqlSession.close();
        return users;*/
        return userMapper.selectAll();
    }

    @Override
    public void addUser(User user) {
        /*
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        sqlSession.close();
         */
    }
}
