package org.lihanyu.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//登录界面
public class LoginFrame extends JFrame implements ActionListener {
    private JLabel l_user, l_pwd; //用户名标签，密码标签
    private JTextField t_user;//用户名文本框
    private JPasswordField t_pwd; //密码文本框
    private JButton b_ok, b_cancel; //登录按钮，退出按钮



    public LoginFrame() {
        super("欢迎使用学生管理系统!");
        l_user = new JLabel("用户名：", JLabel.RIGHT);
        l_pwd = new JLabel(" 密码：", JLabel.RIGHT);
        t_user = new JTextField(36);
        t_pwd = new JPasswordField(36);
        b_ok = new JButton("登录");
        b_cancel = new JButton("退出");
        //布局方式FlowLayout，一行排满排下一行
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l_user);
        c.add(t_user);
        c.add(l_pwd);
        c.add(t_pwd);
        c.add(b_ok);
        c.add(b_cancel);
        //为按钮添加监听事件
        b_ok.addActionListener(this);
        b_cancel.addActionListener(this);
        //界面大小不可调整
        this.setResizable(false);
        this.setSize(455, 150);
        //界面显示居中
        Dimension screen = this.getToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
        this.show();
    }

    //验证账号密码
    public void actionPerformed(ActionEvent e) {
        if (b_cancel == e.getSource()) {
            //添加退出代码 ok
            System.exit(0);
            //
        } else if (b_ok == e.getSource()) {
            //添加代码，验证身份成功后显示主界面ok
            try {
                FileReader f = new FileReader("src/main/resources/pwd.txt");
                //传入
                BufferedReader b1 = new BufferedReader(f);
                String s = b1.readLine();
                boolean flag = false;
                if (t_user.getText().trim().equals("123") && t_pwd.getText().equals(s)) {
                    new MainFrame(t_user.getText().trim());
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag == false) {
                    JOptionPane.showMessageDialog(null, "用户名密码出错", "警告", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
