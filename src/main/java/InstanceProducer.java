import com.alibaba.fastjson.JSON;
import entity.ClusterInstance;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import util.Constant;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        Producer<String, String> producer = new KafkaProducer<>(Constant.producerProps);
        Random random = new Random();
        ClusterInstance instance = new ClusterInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        for (int i = 0; i < 100000; i++) {
//        while (true) {
            instance.setTimestamp(simpleDateFormat.format(now.getTime()));
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
            if ((i + 1) % 1000 == 0) {
                System.out.println("已发送第" + (i + 1) + "条");
            }
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        producer.close();
    }
}
