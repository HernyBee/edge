import java.util.Properties;

/**
 * title: Constant
 * projectName： edge
 * author： 张政淇
 * date： 2019/9/6
 * time： 17:16
 */
public class Constant {
    public static Properties props = new Properties();
    static {
        props.put("bootstrap.servers", "zzq:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }
}
