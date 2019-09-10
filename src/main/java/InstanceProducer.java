import com.alibaba.fastjson.JSON;
import entity.ClusterInstance;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Random;

/**
 * title: InstanceProducer
 * projectName： edge
 * author： 张政淇
 * date： 2019/9/6
 * time： 17:10
 */
public class InstanceProducer {
    public static void main(String[] args) {
        Producer<String, String> producer = new KafkaProducer<>(Constant.props);
        Random random = new Random();
        ClusterInstance instance = new ClusterInstance();
        for (int i = 0; i < 100; i++) {
            instance.setTimestamp(System.currentTimeMillis());
            instance.setI1(random.nextDouble() * 100);
            instance.setI2(random.nextDouble() * 100);
            instance.setI3(random.nextDouble() * 100);
            instance.setI4(random.nextDouble() * 100);
            instance.setI5(random.nextDouble() * 100);
            //过滤
//            if (instance.getI1() > instance.getI3()) {
//                producer.send(new ProducerRecord<>("edge", instance.getTimestamp(), JSON.toJSONString(instance)));
//            }
            //不过滤
            producer.send(new ProducerRecord<>("edge", instance.getTimestamp(), JSON.toJSONString(instance)));
        }

        producer.close();
    }
}
