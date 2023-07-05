import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteRecord
{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");

    public DeleteRecord() throws SQLException {
    }

    public void main()
        {
            JFrame jfrm = new JFrame();
            JLabel jlblid = new JLabel("CRIMINAL ID");
            JTextField jtxtid = new JTextField();


            JButton jbdelete = new JButton("DELETE");
            JButton jbcancel = new JButton("CANCEL");





            jlblid.setBounds(10,50,200,30);
            jtxtid.setBounds(200,50,200,30);

            jbdelete.setBounds(10,230,100,30);
            jbcancel.setBounds(110,230,100,30);




            jbdelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = jtxtid.getText();
                    String q = "SELECT * FROM criminalrecords WHERE criminal_id = ?";
                    try {
                    PreparedStatement stm = con.prepareStatement(q);
                    stm.setInt(1, Integer.parseInt(id));
                    ResultSet rs = stm.executeQuery();
                    if (rs.next()) {
                        String qu = "DELETE FROM criminalrecords WHERE criminal_id = ?";
                        PreparedStatement st = con.prepareStatement(qu);
                        st.setInt(1, Integer.parseInt(id));
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Record deleted Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null,"Record doesn't exist");
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


            jfrm.add(jlblid);
            jfrm.add(jtxtid);

            jfrm.add(jbdelete);
            jfrm.add(jbcancel);




            jfrm.setLayout(null);
            jfrm.setVisible(true);
        }
}
