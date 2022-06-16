package org.lihanyu.View;

import org.lihanyu.config.SpringConfig;
import org.lihanyu.domain.User;
import org.lihanyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class method {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

    UserService userService = ctx.getBean(UserService.class);
    //对主界面构造函数数组进行赋值
    //对主界面构造函数数组赋值
    public Object showDetail(Object row[][]) {
        List<User> users=userService.selectAll();
        for (int i = 0; i < users.size(); i++) {
            row[i][0] = users.get(i).getName();
            row[i][1] = users.get(i).getId();
            row[i][2] = users.get(i).getEmail();
            row[i][3] = users.get(i).getPhone();
        }
        return row;
    }
}
