package org.lihanyu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lihanyu.config.SpringConfig;
import org.lihanyu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void deleteUser() {
        userService.delete(1);
        System.out.println(userService.selectAll());
    }

    @Test
    public void addeUser() {
        User user = new User(123, "112", "111", "111");
        userService.addUser(user);
        System.out.println(userService.selectAll());
    }

}
