import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class LoginPage
{
    Connection con;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginPage() throws SQLException {
    }

    public void adlogin()
    {
        JFrame jfrm = new JFrame("CRIME RECORD MANAGEMENT");
        JLabel jlblregno = new JLabel("User Name");
        JLabel jlblpass = new JLabel("PassWord");
        JTextField jtxtregno = new JTextField();
        JPasswordField jtxtpass = new JPasswordField();
        JButton jbnext = new JButton("NEXT");
        JButton jbcancel = new JButton("CANCEL");






        jlblregno.setBounds(185,45,150,20);
        jtxtregno.setBounds(120,75,200,20);
        jlblpass.setBounds(188,115,150,20);
        jtxtpass.setBounds(120,145,200,20);
        jbnext.setBounds(95,212,120,40);
        jbcancel.setBounds(225,212,120,40);





        jbnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                String usrname = jtxtregno.getText();
                String usrpass = new String(jtxtpass.getPassword());

                String q = "Select * from login where password='" + usrpass + "' && user_id='" + usrname + "'";
                try {
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(q);
                    if (rs.next()) {
                        AdminMenu obj = new AdminMenu();
                        obj.main();
                    }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or PassWord");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jbcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                LoginType obj = new LoginType();
                obj.main();
            }
        });


        jfrm.setSize(650,400);
        jfrm.add(jlblregno);
        jfrm.add(jlblpass);
        jfrm.add(jtxtregno);
        jfrm.add(jtxtpass);
        jfrm.add(jbnext);
        jfrm.add(jbcancel);




        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    public void rmlogin()
    {
        JFrame jfrm = new JFrame("CRIME RECORD MANAGEMENT");
        JLabel jlblregno = new JLabel("User Name");
        JLabel jlblpass = new JLabel("PassWord");
        JTextField jtxtregno = new JTextField();
        JPasswordField jtxtpass = new JPasswordField();
        JButton jbnext = new JButton("NEXT");
        JButton jbcancel = new JButton("CANCEL");






        jlblregno.setBounds(185,45,150,20);
        jtxtregno.setBounds(120,75,200,20);
        jlblpass.setBounds(188,115,150,20);
        jtxtpass.setBounds(120,145,200,20);
        jbnext.setBounds(95,212,120,40);
        jbcancel.setBounds(225,212,120,40);





        jbnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                String usrname = jtxtregno.getText();
                String usrpass = new String(jtxtpass.getPassword());
                String q = "Select * from managerlogin where password='" + usrpass + "' && user_id='" + usrname + "'";
                try {
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(q);
                    if (rs.next()) {
                        RMLogin obj = new RMLogin();
                        obj.main();
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid Username or PassWord");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jbcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                LoginType obj = new LoginType();
                obj.main();
            }
        });


        jfrm.setSize(650,400);
        jfrm.add(jlblregno);
        jfrm.add(jlblpass);
        jfrm.add(jtxtregno);
        jfrm.add(jtxtpass);
        jfrm.add(jbnext);
        jfrm.add(jbcancel);




        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    public void conlogin()
    {
        JFrame jfrm = new JFrame("CRIME RECORD MANAGEMENT");
        JLabel jlblregno = new JLabel("User Name");
        JLabel jlblpass = new JLabel("PassWord");
        JTextField jtxtregno = new JTextField();
        JPasswordField jtxtpass = new JPasswordField();
        JButton jbnext = new JButton("NEXT");
        JButton jbcancel = new JButton("CANCEL");






        jlblregno.setBounds(185,45,150,20);
        jtxtregno.setBounds(120,75,200,20);
        jlblpass.setBounds(188,115,150,20);
        jtxtpass.setBounds(120,145,200,20);
        jbnext.setBounds(95,212,120,40);
        jbcancel.setBounds(225,212,120,40);





        jbnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                String usrname = jtxtregno.getText();
                String usrpass = new String(jtxtpass.getPassword());

                String q = "Select * from constablelogin where password='" + usrpass + "' && user_id='" + usrname + "'";
                try {
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(q);
                    if (rs.next()) {
                        CONViewRecord obj = new CONViewRecord();
                        obj.main();
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid Username or PassWord");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jbcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                LoginType obj = new LoginType();
                obj.main();
            }
        });


        jfrm.setSize(650,400);
        jfrm.add(jlblregno);
        jfrm.add(jlblpass);
        jfrm.add(jtxtregno);
        jfrm.add(jtxtpass);
        jfrm.add(jbnext);
        jfrm.add(jbcancel);




        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}