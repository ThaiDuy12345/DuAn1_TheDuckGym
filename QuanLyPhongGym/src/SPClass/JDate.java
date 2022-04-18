package SPClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JDate {
    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = format.format(date);
        return newDate;
    }
}
