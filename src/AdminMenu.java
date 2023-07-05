import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminMenu
{
    public void main() {
        JFrame jfrm = new JFrame("CRIMINAL RECORD");

        JButton jbar = new JButton("ADD RECORD");
        JButton jbdr = new JButton("DELETE RECORD");
        JButton jber = new JButton("EDIT RECORD");
        JButton jbvr = new JButton("VIEW RECORD");
        JButton jblogout = new JButton("LOGOUT");


        jbar.setBounds(250,60,200,65);
        jbdr.setBounds(250,180,200,65);
        jber.setBounds(50,60,200,65);
        jbvr.setBounds(50,180,200,65);
        jblogout.setBounds(250,260,200,65);




//      Adding Action to Buttons
        jbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();


                try {
                    AddRecord obj = new AddRecord();
                    obj.main();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jbdr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();


                try {
                DeleteRecord obj = new DeleteRecord();
                obj.main();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        jber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();


                try {
                EditRecord obj = new EditRecord();
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
                ViewRecord obj = new ViewRecord();
                    obj.main();
                } catch (SQLException ex) {
                }

            }
        });
        jblogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                LoginPage obj = new LoginPage();
                obj.adlogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                jfrm.dispose();
            }
        });



        jfrm.setSize(650,400);
        jfrm.add(jbar);
        jfrm.add(jbvr);
        jfrm.add(jber);
        jfrm.add(jbdr);
        jfrm.add(jblogout);



        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}