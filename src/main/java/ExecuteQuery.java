import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExecuteQuery {

    public static void getMaxPrice() throws ClassNotFoundException, SQLException, ParseException {

        double maxprice=0;
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter starting date");
        String sd =sc.nextLine();
        Date sqlDate=  simpleDateFormat.parse(sd);
        java.sql.Date sdate=new java.sql.Date(sqlDate.getTime());
        System.out.println("Enter Stock: ");
        String stockName=sc.nextLine();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stock","root","Amita1995jmd@");
        Statement st=con.createStatement();
        ResultSet rs= st.executeQuery("select max(price) from stocklist where symbol =\'"+ stockName+"\' and date = \'"+ sdate+"\'");
        rs.next();
        maxprice = rs.getDouble("max(price)");
        System.out.println("Maximum Price is: " +maxprice);

        st.close();

        con.close();

    }
    public static void getMinPrice() throws SQLException, ClassNotFoundException, ParseException {
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter starting date");
        String sd =sc.nextLine();
        Date sqlDate=  simpleDateFormat.parse(sd);
        java.sql.Date sdate=new java.sql.Date(sqlDate.getTime());
        System.out.println("Enter Stock: ");
        String stockName=sc.nextLine();

        String sql1="SELECT MIN(PRICE)" +
                " FROM STOCKLIST " +
                "WHERE DATE = ? AND SYMBOL = ? ";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stock","root","Amita1995jmd@");

        PreparedStatement pstmt1=con.prepareStatement(sql1);
        pstmt1.setDate(1,sdate);
        pstmt1.setString(2,stockName);
        ResultSet rs1= pstmt1.executeQuery();
        while (rs1.next()){
            double minprice=rs1.getDouble("MIN(PRICE)");
            System.out.println("Minimum price is: "+minprice);
        }
    }

    public static void getTotalSum() throws ParseException, ClassNotFoundException, SQLException {
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter starting date");
        String sd =sc.nextLine();
        Date sqlDate=  simpleDateFormat.parse(sd);
        java.sql.Date sdate=new java.sql.Date(sqlDate.getTime());
        System.out.println("Enter Stock: ");
        String stockName=sc.nextLine();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stock?autoReconnect=true&useSSL=false","root","Amita1995jmd@");
        Statement st=con.createStatement();
        ResultSet rs= st.executeQuery("select sum(volume) from stocklist where symbol =\'"+ stockName+"\' and date = \'"+ sdate+"\'");
        rs.next();
        long totalVolume=rs.getLong("sum(volume)");
        System.out.println("Total volume is "+totalVolume);
    }

    public static void getClosingPrice() throws ParseException, ClassNotFoundException, SQLException {
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter starting date");
        String sd =sc.nextLine();
        Date sqlDate=  simpleDateFormat.parse(sd);
        java.sql.Date sdate=new java.sql.Date(sqlDate.getTime());
        System.out.println("Enter Stock: ");
        String stockName=sc.nextLine();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stock?autoReconnect=true&useSSL=false","root","Amita1995jmd@");


    }
}
