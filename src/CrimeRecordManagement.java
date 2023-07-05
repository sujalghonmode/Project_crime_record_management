import java.sql.*;
import java.util.Scanner;

class Admin {

     int NoOfCriminal=0;
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");   
     // here "root" is the username of sql and "01@Skeshav" is the password.These are dummy credentials just to access the database from within the system.
    Admin() throws SQLException {
    }

    public void addRecord(int id, String name,String gender, String crime) throws SQLException {
        String qe = "Select * from criminalrecords where criminal_id='" + id + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(qe);
        if(rs.next()){
            System.out.println("Entry with same criminal id already exists");
            return;
        }
        String q = "insert into criminalrecords values(?,?,?,?)";
        PreparedStatement p = con.prepareStatement(q);
        p.setInt(1, id);
        p.setString(2, name);
        p.setString(3, gender);
        p.setString(4, crime);
        p.executeUpdate();
        System.out.println("Record added successfully");
    }

    public void deleteRecord(int id) throws SQLException {
        String q = "SELECT * FROM criminalrecords WHERE criminal_id = ?";
        PreparedStatement stm = con.prepareStatement(q);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            String qu = "DELETE FROM criminalrecords WHERE criminal_id = ?";
            PreparedStatement st = con.prepareStatement(qu);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("Record doesn't exist");
        }
    }

    public void editRecord(int id, String newName, String newCrime) throws SQLException {
        String q = "Select * from criminalrecords where criminal_id='" + id + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(q);
        if(rs.next()){
            Statement st = con.createStatement();
            String qu = "UPDATE criminalrecords SET criminal_name = ' "+newName+"' WHERE criminal_id = '" + id + "'";
            st.executeUpdate(qu);
            String que = "UPDATE criminalrecords SET crime = ' "+newCrime+"' WHERE criminal_id = '" + id + "'";
            st.executeUpdate(que);
            System.out.println("Record Updated Successfully");
        }else{
            System.out.println("Record doesn't exist");
        }
    }

    public void viewRecords() throws SQLException {
        System.out.println("_____________________________________________________________________");
        System.out.printf("%-20s%-30s%-10s%-20s%n", "Criminal Id", "Criminal Name","Gender","Crime");
       System.out.println("_____________________________________________________________________");
        Statement st = con.createStatement();
        String q5 = "Select * from criminalrecords";
        ResultSet set4 = st.executeQuery(q5);
        while(set4.next())
        {
            int id = set4.getInt(1);
            String name = set4.getString(2);
            String gn = set4.getString(3);
            String cr= set4.getString(4);

            System.out.printf("%-20s%-30s%-10s%-20s%n",id,name,gn,cr);

        }
        String a = "SELECT COUNT(*) FROM criminalrecords";
        Statement set = con.createStatement();
        ResultSet s = set.executeQuery(a);

        if (s.next()) {
            NoOfCriminal = s.getInt(1);
        }

    }

}

class RecordManager {

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");
     int NoOfCriminal=0;
    RecordManager() throws SQLException {
    }

    public void addRecord(int id, String name,String gender, String crime) throws SQLException {
        String qe = "Select * from criminalrecords where criminal_id='" + id + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(qe);
        if(rs.next()){
            System.out.println("Entry with same criminal id already exists");
            return;
        }
        String q = "insert into criminalrecords values(?,?,?,?)";
        PreparedStatement p = con.prepareStatement(q);
        p.setInt(1, id);
        p.setString(2, name);
        p.setString(3, gender);
        p.setString(4, crime);
        p.executeUpdate();
        System.out.println("Record added successfully");
    }

    public void viewRecords() throws SQLException {
        System.out.println("_____________________________________________________________________");
        System.out.printf("%-20s%-30s%-10s%-20s%n", "Criminal Id", "Criminal Name","Gender","Crime");
        System.out.println("_____________________________________________________________________");
        Statement st = con.createStatement();
        String q5 = "Select * from criminalrecords";
        ResultSet set4 = st.executeQuery(q5);
        while(set4.next())
        {
            int id = set4.getInt(1);
            String name = set4.getString(2);
            String gn = set4.getString(3);
            String cr= set4.getString(4);

            System.out.printf("%-20s%-30s%-10s%-20s%n",id,name,gn,cr);
        }
        String a = "SELECT COUNT(*) FROM criminalrecords";
        Statement set = con.createStatement();
        ResultSet s = set.executeQuery(a);

        if (s.next()) {
            NoOfCriminal = s.getInt(1);
        }

    }
}

class Constable {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");
     int NoOfCriminal=0;
    Constable() throws SQLException {
    }

    public void viewRecords() throws SQLException {
        System.out.println("_____________________________________________________________________");
        System.out.printf("%-20s%-30s%-10s%-20s%n", "Criminal Id", "Criminal Name","Gender","Crime");
        System.out.println("_____________________________________________________________________");
        Statement st = con.createStatement();
        String q5 = "Select * from criminalrecords";
        ResultSet set4 = st.executeQuery(q5);
        while(set4.next())
        {
            int id = set4.getInt(1);
            String name = set4.getString(2);
            String gn = set4.getString(3);
            String cr= set4.getString(4);

            System.out.printf("%-20s%-30s%-10s%-20s%n",id,name,gn,cr);
        }
        String a = "SELECT COUNT(*) FROM criminalrecords";
        Statement set = con.createStatement();
        ResultSet s = set.executeQuery(a);

        if (s.next()) {
            NoOfCriminal = s.getInt(1);
        }

    }
}

public class CrimeRecordManagement {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_records", "root", "01@Skeshav");

            Admin admin = new Admin();
            RecordManager recordManager = new RecordManager();
            Constable constable = new Constable();

            while (true) {
                System.out.println("Select login type: ");
                System.out.println("1. Admin");
                System.out.println("2. Record Manager");
                System.out.println("3. Constable");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("ENTER YOUR USERNAME: ");
                        String Username = scanner.next();
                        System.out.print("ENTER YOUR PASSWORD: ");
                        String password = scanner.next();
                        String q = "Select * from login where password='" + password + "' && user_id='" + Username + "'";
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery(q);
                        if (rs.next()) {
                            System.out.println("SUCCESSFULLY LOGIN");
                            while (true) {
                                System.out.println("Admin Menu:");
                                System.out.println("1. Add Record");
                                System.out.println("2. Delete Record");
                                System.out.println("3. Edit Record");
                                System.out.println("4. View Records");
                                System.out.println("5. Logout");

                                int adminChoice = scanner.nextInt();
                                scanner.nextLine();  // Consume newline character

                                switch (adminChoice) {
                                    case 1:
                                        System.out.print("Enter criminal ID: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter criminal name: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter criminal gender:");
                                        String gender = scanner.nextLine();
                                        System.out.print("Enter crime description: ");
                                        String crime = scanner.nextLine();
                                        admin.addRecord(id, name, gender, crime);
                                        break;
                                    case 2:
                                        System.out.print("Enter criminal ID to delete: ");
                                        int deleteId = scanner.nextInt();
                                        scanner.nextLine();
                                        admin.deleteRecord(deleteId);
                                        break;
                                    case 3:
                                        System.out.print("Enter criminal ID to edit: ");
                                        int editId = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter new name: ");
                                        String newName = scanner.nextLine();
                                        System.out.print("Enter new crime: ");
                                        String newCrime = scanner.nextLine();
                                        admin.editRecord(editId, newName, newCrime);
                                        break;
                                    case 4:
                                        admin.viewRecords();
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                if (adminChoice == 5) {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Invalid ID or password. Please try again.");
                        }
                    }
                    case 2 -> {
                        System.out.print("ENTER YOUR Username: ");
                        String Username1 = scanner.next();
                        System.out.print("ENTER YOUR PASSWORD: ");
                        String password1 = scanner.next();
                        String q1 = "Select * from managerlogin where password='" + password1 + "' && user_id='" + Username1 + "'";
                        Statement st = con.createStatement();
                        ResultSet r = st.executeQuery(q1);
                        if (r.next()) {
                            System.out.println("SUCCESSFULLY LOGIN");
                            while (true) {
                                System.out.println("Record Manager Menu:");
                                System.out.println("1. Add Record");
                                System.out.println("2. View Records");
                                System.out.println("3. Logout");

                                int managerChoice = scanner.nextInt();
                                scanner.nextLine();  // Consume newline character

                                switch (managerChoice) {
                                    case 1:
                                        System.out.print("Enter criminal ID: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter criminal name: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter gender:");
                                        String gender = scanner.nextLine();
                                        System.out.print("Enter crime description: ");
                                        String crime = scanner.nextLine();
                                        recordManager.addRecord(id, name, gender, crime);
                                        break;
                                    case 2:
                                        recordManager.viewRecords();
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }

                                if (managerChoice == 3) {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Invalid Password or id");
                        }
                    }
                    case 3 -> {
                        System.out.print("ENTER YOUR Username: ");
                        String Username2 = scanner.next();
                        System.out.print("ENTER YOUR PASSWORD: ");
                        String password2 = scanner.next();
                        String q2 = "Select * from constablelogin where password='" + password2 + "' && user_id='" + Username2 + "'";
                        Statement ste = con.createStatement();
                        ResultSet r1 = ste.executeQuery(q2);
                        if (r1.next()) {
                            System.out.println("SUCCESSFULLY LOGIN");
                            constable.viewRecords();
                        } else {
                            System.out.println("invalid username or password");
                        }
                    }
                    case 4 -> System.exit(0);
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
