import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DbFunction {
    public Connection connect_to_db(String dburl, String username, String password) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dburl,username,password);
            if(conn!=null){
                System.out.println("Connection Established!");
            }
            else{
                System.out.println("Connection failed!");
            }
        }catch(Exception e){
            System.out.println("Exception "+ e);
        }
        return conn;
    }

    public void Create_table (Connection conn){
        Statement statement;
        try{
            String query = "CREATE TABLE IF NOT EXISTS cars (license_plate VARCHAR(20) PRIMARY KEY)";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Create........ ");

        }catch (Exception e){
            System.out.println("Exception "+ e);
        }
    }
    public void Insert_Car(Connection conn, String licensePlate) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO cars (license_plate) VALUES (%s)", licensePlate);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted Successfully.");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void Remove_Car(Connection conn, String licensePlate) {
        Statement statement;
        try {
            String query = "DELETE FROM cars WHERE license_plate =" + licensePlate;
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Car remove Successfully.");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    public void View_Cars(Connection conn) {
        Statement statement;
        try {
            String query = String.format("SELECT * FROM license_plate");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            // Iterate over the result set and print the data
            while (rs.next()) {
                String licenseplate = rs.getString("license_plate");
                System.out.println(licenseplate);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

}