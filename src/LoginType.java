import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginType
{
    public void main() {
        JFrame jfrm = new JFrame("CRIMINAL RECORD");

        JButton jbadmin = new JButton("ADMIN");
        JButton jbrecordmanager = new JButton("RECORD MANAGER");
        JButton jbsconstable = new JButton("CONSTABLE");
        JButton jbexit = new JButton("EXIT");


        jbadmin.setBounds(250,60,200,65);
        jbrecordmanager.setBounds(250,180,200,65);
        jbsconstable.setBounds(50,60,200,65);
        jbexit.setBounds(50,180,200,65);



//      Adding Action to Buttons
        jbadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                try {
                LoginPage obj = new LoginPage();
                obj.adlogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jbrecordmanager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                try {
                LoginPage obj = new LoginPage();
                obj.rmlogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        jbsconstable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                try {
                LoginPage obj = new LoginPage();
                obj.conlogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
            }
        });



        jfrm.setSize(650,400);
        jfrm.add(jbadmin);
        jfrm.add(jbrecordmanager);
        jfrm.add(jbsconstable);
        jfrm.add(jbexit);



        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}