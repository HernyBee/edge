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
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp now = new Timestamp(System.currentTimeMillis());
    public static String getStandardDateTime(long timestamp) {
        return simpleDateFormat.format(timestamp);

    }
}
