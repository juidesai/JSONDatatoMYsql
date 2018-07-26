
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException, ParseException {
        InsertData objectId = new InsertData();
        System.out.println("Press 1 to get Highest Price of a stock on a date of your choice");
        System.out.println("Press 2 to get Lowest Price of a stock on a date of your choice");
        System.out.println("Press 3 to get Total Volume of a stock on a date of your choice");
        System.out.println("Press 4 to insert data from JSON");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of your choice");
        ExecuteQuery objectEq = new ExecuteQuery();
        int num = Integer.parseInt(sc.next());
        switch (num) {
            case 1:
                objectEq.getMaxPrice();
                break;
            case 2:
                objectEq.getMinPrice();
                break;
            case 3:
                objectEq.getTotalSum();
                break;
            case 4:
                objectId.insert();
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}



