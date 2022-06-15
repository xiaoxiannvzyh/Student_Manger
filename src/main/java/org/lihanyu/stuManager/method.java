package org.lihanyu.stuManager;

import org.lihanyu.config.SpringConfig;
import org.lihanyu.domain.User;
import org.lihanyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.List;

public class method {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

    UserService userService = ctx.getBean(UserService.class);
    //对主界面构造函数数组进行赋值
    //对主界面构造函数数组赋值
    public Object showDetail(Object row[][]) {
        List<User> users=userService.selectAll();
        for (int i = 0; i < users.size(); i++) {
            row[i][0] = users.get(i).getId();
            row[i][1] = users.get(i).getName();
            row[i][2] = users.get(i).getEmail();
            row[i][3] = users.get(i).getPhone();
        }
        return row;
    }

    //加载目标文件信息，并以ArrayList<MyAccount>形式返回
    public List<User> loadList(List<User> users) {
        try {
            FileInputStream fis = new FileInputStream("d:/io/xu.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (List<org.lihanyu.domain.User>) (ois.readObject());
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    //用于删除原文件
    public void delete() {
        File f = new File("d:/io/xu.txt");
        f.delete();
    }

    //创建新文件并写入信息
    public void update(List<User> a1) {
        try {
            File f = new File("d:/io/xu.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a1);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
