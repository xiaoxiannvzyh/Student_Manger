package org.lihanyu.View;

import org.lihanyu.config.SpringConfig;
import org.lihanyu.domain.User;
import org.lihanyu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

//学生编辑界面
public class BalEditFrame extends JFrame implements ActionListener {
    private JLabel l_id, l_date, l_bal, l_type, l_item;
    private JTextField t_id, t_date, t_bal, t_type, t_item;
    //    private JComboBox c_type, c_item;
    private JButton b_update, b_delete, b_select, b_new, b_clear;
    private JPanel p1, p2, p3;
    private JScrollPane scrollpane;
    private JTable table;

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

    UserService userService = ctx.getBean(UserService.class);

    //学生界面构造函数
    public BalEditFrame() {
        super("学生信息编辑");
        l_id = new JLabel("学生姓名");
        l_date = new JLabel("学号：");
        l_bal = new JLabel("电话：");
        l_type = new JLabel("邮箱：");
        l_item = new JLabel("内容：");
        t_id = new JTextField(8);
        t_date = new JTextField(8);
        t_bal = new JTextField(8);
        t_type = new JTextField(8);
        t_item = new JTextField(8);

        b_select = new JButton("查询");
        b_update = new JButton("修改");
        b_delete = new JButton("删除");
        b_new = new JButton("增加");
        b_clear = new JButton("清空");

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2, 10, 10));
        p1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("编辑学生信息"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        p1.add(l_id);
        p1.add(t_id);
        p1.add(l_date);
        p1.add(t_date);
        p1.add(l_type);
        p1.add(t_type);
        p1.add(l_item);
        p1.add(t_item);
        p1.add(l_bal);
        p1.add(t_bal);
        c.add(p1, BorderLayout.WEST);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 1, 10, 10));
        p2.add(b_new);
        p2.add(b_update);
        p2.add(b_delete);
        p2.add(b_select);
        p2.add(b_clear);

        c.add(p2, BorderLayout.CENTER);

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("显示学生信息"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        String[] cloum = {"学生姓名", "学号", "电话", "邮箱"};
        Object[][] row = new Object[50][4];

        //创建方法类
        method m = new method();
        //显示信息
        m.showDetail(row);
        //
        table = new JTable(row, cloum);
        scrollpane = new JScrollPane(table);
        scrollpane.setViewportView(table);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p3.add(scrollpane);
        c.add(p3, BorderLayout.EAST);

        b_update.addActionListener(this);
        b_delete.addActionListener(this);
        b_select.addActionListener(this);
        b_new.addActionListener(this);
        b_clear.addActionListener(this);

        //添加代码，为table添加鼠标点击事件监听addMouseListener
        table.addMouseListener(new MouseAdapter() {
                                   public void mouseClicked(MouseEvent e) {
//				仅当鼠标单击时响应
//				得到选中的行列的索引值
//              得到选中的单元格的值，表格中都是字符串
                                       int a = table.getSelectedRow();
                                       t_id.setText(row[a][0].toString());
                                       t_date.setText(row[a][1].toString());
                                       t_type.setText(row[a][2].toString());
                                       t_item.setText(row[a][3].toString());
                                       t_bal.setText(row[a][4].toString());
                                   }
                               }
        );

        this.setResizable(false);
        this.setSize(800, 300);
        Dimension screen = this.getToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
        this.show();
    }

    //学生界面构造函数重载，用于刷新学生界面
    public BalEditFrame(java.util.List<org.lihanyu.domain.User> users) {
        super("学生信息编辑");
        l_id = new JLabel("学生姓名：");
        l_date = new JLabel("学号：");
        l_bal = new JLabel("电话：");
        l_type = new JLabel("邮箱：");
        l_item = new JLabel("内容：：");
        t_id = new JTextField(8);
        t_date = new JTextField(8);
        t_bal = new JTextField(8);
        t_type = new JTextField(8);
        t_item = new JTextField(8);

        b_select = new JButton("查询");
        b_update = new JButton("修改");
        b_delete = new JButton("删除");
        b_new = new JButton("增加");
        b_clear = new JButton("清空");

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2, 10, 10));
        p1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("编辑学生信息"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        p1.add(l_id);
        p1.add(t_id);
        p1.add(l_date);
        p1.add(t_date);
        p1.add(l_type);
        p1.add(t_type);
        p1.add(l_item);
        p1.add(t_item);
        p1.add(l_bal);
        p1.add(t_bal);
        c.add(p1, BorderLayout.WEST);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 1, 10, 10));
        p2.add(b_new);
        p2.add(b_update);
        p2.add(b_delete);
        p2.add(b_select);
        p2.add(b_clear);

        c.add(p2, BorderLayout.CENTER);

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("显示学生信息"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        String[] cloum = {"学生姓名", "学号", "电话", "邮箱"};
        Object[][] row = new Object[50][5];

        //创建方法类
        method m = new method();
        //显示信息
        m.showDetail(row);

        table = new JTable(row, cloum);
        scrollpane = new JScrollPane(table);
        scrollpane.setViewportView(table);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p3.add(scrollpane);
        c.add(p3, BorderLayout.EAST);

        b_update.addActionListener(this);
        b_delete.addActionListener(this);
        b_select.addActionListener(this);
        b_new.addActionListener(this);
        b_clear.addActionListener(this);

        //添加代码，为table添加鼠标点击事件监听addMouseListener
        table.addMouseListener(new MouseAdapter() {
                                   public void mouseClicked(MouseEvent e) {
//				仅当鼠标单击时响应
//				得到选中的行列的索引值
//              得到选中的单元格的值，表格中都是字符串
                                       int a = table.getSelectedRow();
                                       t_id.setText(row[a][0].toString());
                                       t_date.setText(row[a][1].toString());
                                       t_type.setText(row[a][2].toString());
                                       t_item.setText(row[a][3].toString());
                                       t_bal.setText(row[a][4].toString());
                                       t_id.setEditable(false);
                                   }
                               }
        );

        this.setResizable(false);
        this.setSize(800, 300);
        Dimension screen = this.getToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
        this.show();
    }


    public void actionPerformed(ActionEvent e) {
        if (b_select == e.getSource()) {
            //查询所有学生信息 ok
            //添加代码
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            new BalEditFrame();
        } else if (b_update == e.getSource()) {
            //修改
            final int op = 0;
            if (op == JOptionPane.showConfirmDialog(null, "确定修改？", "提示", JOptionPane.OK_CANCEL_OPTION)) {

                org.lihanyu.domain.User user = new org.lihanyu.domain.User(t_id.getText(), t_date.getText(), t_type.getText(), t_item.getText());
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                userService.updateUser(user);
                java.util.List<org.lihanyu.domain.User> users = userService.selectAll();
                new BalEditFrame(users);
            }
        } else if (b_delete == e.getSource()) {   //删除某条学生信息
            final int op = 0;
            if (op == JOptionPane.showConfirmDialog(null, "确定修改？", "提示", JOptionPane.OK_CANCEL_OPTION)) {
                //写的方法类
                int id = Integer.parseInt(t_id.getText());
                userService.delete(id);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                java.util.List<org.lihanyu.domain.User> users = userService.selectAll();
                new BalEditFrame(users);
            }
        } else if (b_new == e.getSource()) {   //新增某条学生信息
            //添加代码
            org.lihanyu.domain.User user = new org.lihanyu.domain.User(t_id.getText(), t_date.getText(), t_type.getText(), t_item.getText());
            if (userService.findById(Integer.valueOf(t_id.getText())) == null) {
                userService.addUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "id重复，重新编辑", "警告", JOptionPane.ERROR_MESSAGE);
            }
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            List<User> users = userService.selectAll();
            new BalEditFrame(users);
        }
    }

}
