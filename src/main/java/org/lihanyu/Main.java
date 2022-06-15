package org.lihanyu;

import org.lihanyu.config.SpringConfig;
import org.lihanyu.domain.User;
import org.lihanyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = ctx.getBean(UserService.class);

        List<User> users = userService.selectAll();
        System.out.println(users);
    }
}