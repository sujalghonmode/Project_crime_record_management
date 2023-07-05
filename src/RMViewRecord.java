import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RMViewRecord extends CrimeRecordManagement
{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");

    public RMViewRecord() throws SQLException {
    }

    public void main() throws SQLException {
        Admin obj = new Admin();
        obj.viewRecords();


        JFrame jfrm = new JFrame();
        JLabel crimeid = new JLabel("CRIMINAL ID");
        JLabel crimename = new JLabel("CRIMINAL NAME");
        JLabel crimegender = new JLabel("CRIMINAL GENDER");
        JLabel crimedesp = new JLabel("CRIMINAL DESCRIPTION");
        JButton jbback = new JButton("BACK");

        JLabel[] id = new JLabel[obj.NoOfCriminal];
        JLabel[] name = new JLabel[obj.NoOfCriminal];
        JLabel[] gender = new JLabel[obj.NoOfCriminal];
        JLabel[] crime = new JLabel[obj.NoOfCriminal];


        Statement st = con.createStatement();
        String q5 = "Select * from criminalrecords";
        ResultSet set4 = st.executeQuery(q5);
        int j=0;
        while(set4.next())
        {
            int ide = set4.getInt(1);
            String namee = set4.getString(2);
            String gne = set4.getString(3);
            String cre= set4.getString(4);
            id[j] = new JLabel(intToString(ide));
            name[j] = new JLabel(namee);
            gender[j] = new JLabel(gne);
            crime[j] = new JLabel(cre);
            j+=1;
        }

        for(int i = 0 ; i < obj.NoOfCriminal;i++)
        {
            id[i].setBounds(10,50+30*i,200,30);
            name[i].setBounds(210,50+30*i,200,30);
            gender[i].setBounds(410,50+30*i,200,30);
            crime[i].setBounds(610,50+30*i,200,30);
        }
        crimename.setBounds(10,10,200,30);
        crimeid.setBounds(210,10,200,30);
        crimegender.setBounds(410,10,200,30);
        crimedesp.setBounds(610,10,200,30);
        jbback.setBounds(10,600,200,50);

        for(int i = 0 ; i < obj.NoOfCriminal ; i++)
        {
            jfrm.add(id[i]);
            jfrm.add(name[i]);
            jfrm.add(gender[i]);
            jfrm.add(crime[i]);
        }

        jbback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                RMLogin obj = new RMLogin();
                obj.main();
            }
        });


        jfrm.add(crimeid);
        jfrm.add(crimename);
        jfrm.add(crimegender);
        jfrm.add(crimedesp);
        jfrm.add(jbback);


        jfrm.setSize(850,700);
        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    private String intToString(int ide) {
        return String.valueOf(ide);
    }
}
