import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RMLogin
{
    public void main() {
        JFrame jfrm = new JFrame("CRIMINAL RECORD");

        JButton jbar = new JButton("ADD RECORD");


        JButton jbvr = new JButton("VIEW RECORD");
        JButton jblogout = new JButton("LOGOUT");


        jbar.setBounds(220,60,200,65);


        jbvr.setBounds(220,120,200,65);
        jblogout.setBounds(220,180,200,65);




//      Adding Action to Buttons
        jbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();


                try {
                RMAddRecord obj = new RMAddRecord();
                obj.main();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jbvr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();


                try {
                RMViewRecord obj = new RMViewRecord();
                    obj.main();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        jblogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                LoginPage obj = new LoginPage();
                obj.rmlogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                jfrm.dispose();
            }
        });



        jfrm.setSize(650,400);
        jfrm.add(jbar);
        jfrm.add(jbvr);


        jfrm.add(jblogout);



        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}