package org.lihanyu.service;

import org.lihanyu.domain.User;

import java.util.List;

public interface UserService {

    List<User> selectAll();

    void addUser(User user);

    User findById(Integer id);

    void delete(Integer id);

    void updateUser(User user);
}
