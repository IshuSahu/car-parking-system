import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class ParkingSystem {

    static int totalSlots, availableSlots;
    static ArrayList<String> parkedCars = new ArrayList<String>();
    static DbFunction dbf;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of parking slots:");
        totalSlots = sc.nextInt();
        availableSlots = totalSlots;

        // Establish the database connection
        dbf = new DbFunction();
        String dbUrl = "jdbc:mysql://localhost:3306/parking_system";
        String username = "root";
        String password = "Mysql!@12";
        Connection connection =dbf.connect_to_db(dbUrl,username, password);
//        dbf.Create_table (connection);
        run(connection);
    }

    public static void run(Connection conn) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("Pressed-1 to Park a car");
            System.out.println("Pressed-2 to Remove a car");
            System.out.println("Pressed-3 to View parked cars");
            System.out.println("Pressed-4 to Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    parkCar(conn);
                    break;
                case 2:
                    removeCar(conn);
                    break;
                case 3:
                    viewParkedCars(conn);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void parkCar(Connection conn) {
        if (availableSlots == 0) {
            System.out.println("Sorry, there are no available parking slots.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the license plate number of the car:");
        String licensePlate = sc.nextLine();
        dbf.Insert_Car(conn,licensePlate);
        parkedCars.add(licensePlate);
        availableSlots--;
        System.out.println("Car parked successfully. Available slots: " + availableSlots);
    }

    public static void removeCar(Connection conn) {
        if (availableSlots == totalSlots) {
            System.out.println("There are no parked cars.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the license plate number of the car to be removed:");
        String licensePlate = sc.nextLine();

        if (parkedCars.contains(licensePlate)) {
            dbf.Remove_Car(conn,licensePlate);
            availableSlots++;
            System.out.println("Available slots: " + availableSlots);
        } else {
            System.out.print(" The car is not parked here.");
        }
    }

    public static void viewParkedCars(Connection conn) {
        if (availableSlots == totalSlots) {
            System.out.println("There are no parked cars.");
            return;
        }
        dbf.View_Cars(conn);
    }
}
