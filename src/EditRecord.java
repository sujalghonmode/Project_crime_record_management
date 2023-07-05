import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

public class EditRecord
{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");

    public EditRecord() throws SQLException {
    }

    public void main()
    {
        JFrame jfrm = new JFrame("Exam Registration");
        JLabel jlblid = new JLabel("CRIMINAL ID");
        JLabel jlblname = new JLabel("NEW NAME");
        JTextField jtxtname = new JTextField();
        JTextField jtxtid = new JTextField();
        JLabel jlbldes = new JLabel("CRIME DESCRIPTION");
        JTextArea jtxtdes = new JTextArea();

        JButton jbedit = new JButton("EDIT");
        JButton jbcancel = new JButton("CANCEL");






        jlblname.setBounds(10,50,200,30);
        jtxtname.setBounds(200,50,200,30);
        jlblid.setBounds(10,10,200,30);
        jtxtid.setBounds(200,10,200,30);
        jbedit.setBounds(10,230,100,30);
        jbcancel.setBounds(110,230,100,30);
        jlbldes.setBounds(10,130,200,30);
        jtxtdes.setBounds(10,155,200,70);



        jbedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jtxtid.getText();
                String newName = jtxtname.getText();
                String newCrime = jtxtdes.getText();


                String q = "Select * from criminalrecords where criminal_id='" + id + "'";
                try {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(q);
                if(rs.next()){
                    Statement st = con.createStatement();
                    String qu = "UPDATE criminalrecords SET criminal_name = ' "+newName+"' WHERE criminal_id = '" + id + "'";
                    st.executeUpdate(qu);
                    String que = "UPDATE criminalrecords SET crime = ' "+newCrime+"' WHERE criminal_id = '" + id + "'";
                    st.executeUpdate(que);
                    JOptionPane.showMessageDialog(null,"Record Updated Successfully");

                }else {
                    JOptionPane.showMessageDialog(null,"Record Updated SuccessfullyRecord doesn't exist");
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
                AdminMenu obj = new AdminMenu();
                obj.main();
            }
        });


        jfrm.setSize(650,300);
        jfrm.add(jlblname);
        jfrm.add(jtxtname);
        jfrm.add(jlblid);
        jfrm.add(jtxtid);

        jfrm.add(jbedit);
        jfrm.add(jbcancel);
        jfrm.add(jlbldes);
        jfrm.add(jtxtdes);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}