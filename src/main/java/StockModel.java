import java.sql.Date;
import java.sql.Timestamp;

public class StockModel {

    private String symbol;
    private double price;
    private long volume;
    private Date date;


    public StockModel(){

    }

    public StockModel(String symbol, double price, long volume, Date date){
        this.symbol=symbol;
        this.price=price;
        this.volume=volume;
        this.date=date;
    }
    public final String getSymbol() {
        return symbol;
    }

    public final void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    public final long getVolume() {
        return volume;
    }

    public final void setVolume(long volume) {
        this.volume = volume;
    }

    public final Date getDate() {
        return date;
    }

    public final void setDate(Date date) {
        this.date = date;
    }
}
