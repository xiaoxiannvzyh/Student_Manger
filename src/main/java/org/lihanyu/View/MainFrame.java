package org.lihanyu.View;

import org.lihanyu.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//主界面
public class MainFrame extends JFrame implements ActionListener {
    private JMenuBar mb = new JMenuBar();
    private JMenu m_system = new JMenu("系统管理");
    private JMenu m_fm = new JMenu("学生账号管理");
    private JMenuItem mI[] = {new JMenuItem("密码重置"), new JMenuItem("退出系统")};
    private JMenuItem m_FMEdit = new JMenuItem("菜单");
    private JLabel l_bal;
    private JPanel  p_detail;
    private JTable table;
    private String username;

    //主界面构造函数
    public MainFrame(String username) {
        super(username + ",欢迎使用学生账号管理系统!");
        this.username = username;
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(mb, "North");
        mb.add(m_system);
        mb.add(m_fm);
        m_system.add(mI[0]);
        m_system.add(mI[1]);
        m_fm.add(m_FMEdit);
        m_FMEdit.addActionListener(this);
        mI[0].addActionListener(this);
        mI[1].addActionListener(this);

        p_detail = new JPanel();
        p_detail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("学生信息"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        l_bal = new JLabel();
        String[] cloum = {"学生姓名", "学号", "电话", "邮箱"};

        Object[][] row = new Object[50][4];
        table = new JTable(row, cloum);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(580, 350));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setViewportView(table);
        p_detail.add(l_bal);
        p_detail.add(scrollpane);
        c.add(p_detail, "South");

//添加代码
        //主界面显示
        method m = new method();
        m.showDetail(row);
        //
        this.setResizable(false);
        this.setSize(600, 580);
        Dimension screen = this.getToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
        this.show();
    }

    //主界面构造函数重载
    public MainFrame(String username, List<User> a1) {
        super(username + ",欢迎使用学生管理系统!");
        this.username = username;
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(mb, "North");
        mb.add(m_system);
        mb.add(m_fm);
        m_system.add(mI[0]);
        m_system.add(mI[1]);
        m_fm.add(m_FMEdit);
        m_FMEdit.addActionListener(this);
        mI[0].addActionListener(this);
        mI[1].addActionListener(this);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p_detail = new JPanel();
        p_detail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("学生明细信息"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        l_bal = new JLabel();
        String[] cloum = {"学生姓名", "学号", "电话", "邮箱"};
        Object[][] row = new Object[50][4];
        table = new JTable(row, cloum);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(580, 350));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setViewportView(table);
        p_detail.add(l_bal);
        p_detail.add(scrollpane);
        c.add(p_detail, "South");

        //添加代码
        //主界面显示

        this.setResizable(false);
        this.setSize(600, 580);
        Dimension screen = this.getToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
        this.show();
    }

    public void actionPerformed(ActionEvent e) {
        Object temp = e.getSource();
        if (temp == mI[0]) {
            //密码重置
            new ModifyPwdFrame(username);
        } else if (temp == mI[1]) {
            //添加代码
            //退出系统
            System.exit(0);
        } else if (temp == m_FMEdit) {
            //学生信息编辑
            new BalEditFrame();
        }
    }
}
