import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.Arrays;

public class AddRecord
{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");

    public AddRecord() throws SQLException {
    }

    public void main()
    {

        JFrame jfrm = new JFrame("Exam Registration");
        JLabel jlblid = new JLabel("CRIMINAL ID");
        JLabel jlblname = new JLabel("CRIMINAL NAME");
        JLabel jlblgender = new JLabel("CRIMINAL GENDER");
        JTextField jtxtid = new JTextField();
        JTextField jtxtname = new JTextField();
        JTextField jtxtgender = new JTextField();
        JLabel jlbldes = new JLabel("CRIME DESCRIPTION");
        JTextArea jtxtdes = new JTextArea();

        JButton jbadd = new JButton("ADD");
        JButton jbcancel = new JButton("CANCEL");




        jlblname.setBounds(10,10,200,30);
        jtxtname.setBounds(200,10,200,30);
        jlblid.setBounds(10,50,200,30);
        jtxtid.setBounds(200,50,200,30);
        jlblgender.setBounds(10,90,200,30);
        jtxtgender.setBounds(200,90,200,30);
        jbadd.setBounds(10,230,100,30);
        jbcancel.setBounds(110,230,100,30);
        jlbldes.setBounds(10,130,200,30);
        jtxtdes.setBounds(10,155,200,70);



        jbadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jtxtid.getText();
                String name = jtxtname.getText();
                String gender = jtxtgender.getText();
                String crime = jtxtdes.getText();

                String qe = "Select * from criminalrecords where criminal_id='" + id + "'";
                try {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(qe);
                if(rs.next()){
                    System.out.println("Entry with same criminal id already exists");
                    return;
                }
                    String q = "insert into criminalrecords values(?,?,?,?)";
                    PreparedStatement p = con.prepareStatement(q);
                    p.setInt(1, Integer.parseInt(id));
                    p.setString(2, name);
                    p.setString(3,gender);
                    p.setString(4, crime);
                    p.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Added Successfully");
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
        jfrm.add(jlblid);
        jfrm.add(jtxtid);
        jfrm.add(jlblname);
        jfrm.add(jtxtname);
        jfrm.add(jlblgender);
        jfrm.add(jtxtgender);
        jfrm.add(jbadd);
        jfrm.add(jbcancel);
        jfrm.add(jlbldes);
        jfrm.add(jtxtdes);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}