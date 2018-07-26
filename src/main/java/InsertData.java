import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertData {
    static List<StockModel> stockdetail=null;

    public static void readURL() throws IOException {
        ObjectMapper objMap=new ObjectMapper();
        String urlLink="https://bootcamp-training-files.cfapps.io/week1/week1-stocks.json";
        InputStream stream = null;
        BufferedInputStream buf=null;
        try{
            URL url=new URL(urlLink);
            stream=url.openStream();
            buf=new BufferedInputStream(stream);
            stockdetail=objMap.reader().
                    withType(new TypeReference<List<StockModel>>(){}).readValue(buf);
            System.out.println("Java object created from JSON string");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            stream.close();
            buf.close();
        }
    }

    public static void insert() throws IOException, ClassNotFoundException, SQLException {
        try {
            readURL();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stock?autoReconnect=true&useSSL=false","root","Amita1995jmd@");
        PreparedStatement pstmt=con.prepareStatement("INSERT INTO STOCKLIST(SYMBOL,PRICE,VOLUME,DATE) VALUES(?,?,?,?)");
        for(StockModel stocks:stockdetail){
            pstmt.setString(1, stocks.getSymbol());
            pstmt.setDouble(2,stocks.getPrice());
            pstmt.setLong(3,stocks.getVolume());
            pstmt.setDate(4, stocks.getDate());
            pstmt.execute();
        }
    }
}
