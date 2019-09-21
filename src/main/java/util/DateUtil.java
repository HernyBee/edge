package util;
import java.sql.Timestamp;
import	java.text.SimpleDateFormat;

/**
 * @ClassName: DateUtil
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/12 15:06
 * @Version: 1.0
 */
public class DateUtil {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    public static String getStandardDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        return(sdf.format(timestamp));
    }
}
