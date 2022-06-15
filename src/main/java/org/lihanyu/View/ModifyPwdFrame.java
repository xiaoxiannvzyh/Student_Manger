package org.lihanyu.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

//修改密码界面
public class ModifyPwdFrame extends JFrame implements ActionListener {
    private JLabel l_oldPWD, l_newPWD, l_newPWDAgain;
    private JPasswordField t_oldPWD, t_newPWD, t_newPWDAgain;
    private JButton b_ok, b_cancel;
    private String username;

    public ModifyPwdFrame(String username) {
        super("修改密码");
        this.username = username;
        l_oldPWD = new JLabel("旧密码");
        l_newPWD = new JLabel("新密码：");
        l_newPWDAgain = new JLabel("确认新密码：");
        t_oldPWD = new JPasswordField(15);
        t_newPWD = new JPasswordField(15);
        t_newPWDAgain = new JPasswordField(15);
        b_ok = new JButton("确定");
        b_cancel = new JButton("取消");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l_oldPWD);
        c.add(t_oldPWD);
        c.add(l_newPWD);
        c.add(t_newPWD);
        c.add(l_newPWDAgain);
        c.add(t_newPWDAgain);
        c.add(b_ok);
        c.add(b_cancel);
        b_ok.addActionListener(this);
        b_cancel.addActionListener(this);
        this.setResizable(false);
        this.setSize(280, 160);
        Dimension screen = this.getToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
        this.show();
    }

    public void actionPerformed(ActionEvent e) {
        if (b_cancel == e.getSource()) {
            //添加代码
            //取消
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } else if (b_ok == e.getSource()) {  //修改密码
            //添加代码
            //确定
            try {
                boolean judge = true;
                BufferedReader br = new BufferedReader(new FileReader("d:/io/pwd.txt"));
                String s = br.readLine();
                if (t_newPWD.getText().trim().equals(s)) {
                    JOptionPane.showMessageDialog(null, "新密码与原密码一样", "警告", JOptionPane.ERROR_MESSAGE);
                    judge = false;
                }
                if (t_newPWDAgain.getText().trim().contentEquals(t_newPWD.getText()) && judge == true) {
                    PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("d:/io/pwd.txt")));
                    p.println(t_newPWD.getPassword());
                    p.close();
                    JOptionPane.showMessageDialog(null, "修改密码成功", "提醒", JOptionPane.INFORMATION_MESSAGE);
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                    System.exit(0);
                } else if (judge == true && t_newPWDAgain.getText().trim().contentEquals(t_newPWD.getText()) == false) {
                    JOptionPane.showMessageDialog(null, "两次新密码不一致！", "警告", JOptionPane.ERROR_MESSAGE);
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
