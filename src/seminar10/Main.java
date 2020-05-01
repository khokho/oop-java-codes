package seminar10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "dfrews");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM test.momo");
            while(rs.next()){
                System.out.println(rs.getInt(1) + " Name: " + rs.getString(2) + " Money: " + rs.getInt(3));
                System.out.println(rs.getObject(2).getClass());
            }
            stmt.executeUpdate("INSERT INTO test.momo values(12, 'dud', 777)");
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
