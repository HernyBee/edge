import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import util.Constant;
import weka.core.Instances;

import java.time.Duration;
import java.util.Collections;
import	java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: InstanceConsumer
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/12 15:02
 * @Version: 1.0
 */
public class InstanceConsumer {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(Constant.consumerProps);
        consumer.subscribe(Collections.singletonList("edge"));
//        Instances data = new Instances();
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//            for (ConsumerRecord<String, String> record : records) {
//                if (count == 1000) {
//                    synchronized (QueryDB.class) {
//                        count = 0;
//                        Instances newData = new Instances(data);
//                        newData.deleteAttributeAt(0);
//                        newData.deleteAttributeAt(0);
//                        data.delete();
//                        exec.execute(new OnlineKmean(newData));
//                    }
//                } else {
//                    data.add(inst);
//                    count++;
//                }
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        }
        exec.shutdown();

    }
}
