
import com.sun.xml.internal.ws.util.StringUtils;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javafx.util.converter.LocalTimeStringConverter;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author rafa_
 */
public class testeBanco {
    
    public static void main(String[] args) {
//        LocalTime t = LocalTime.of(15, 50);
//        LocalTime t2 = LocalTime.of(05, 10);
//        LocalTime resp =t.minusMinutes(t2.getMinute());
//        resp = resp.minusHours(t2.getHour());
//        
//        Time aa = Time.valueOf(resp); // e isso 
//        System.out.println(aa);

    String str = StringUtils.capitalize("essa e uma frase para testar");
    
        System.out.println(str);

}
}
