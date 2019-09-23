package kafka;

import algorithm.OnlineEM;
import algorithm.OnlineKmean;
import com.alibaba.fastjson.JSON;
import entity.ClusterInstance;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import util.Constant;
import util.CreateInstances;
import weka.core.Instance;
import weka.core.Instances;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: kafka.InstanceConsumer
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/12 15:02
 * @Version: 1.0
 */
public class InstanceConsumer {
    public static void main(String[] args) {
        String groupId = args [0].trim();
        int nThreads = Integer.parseInt(args[1].trim());
//        String groupId = "2019-9-17 18:22:53";
//        int nThreads = 10;

        ExecutorService exec = Executors.newFixedThreadPool(nThreads);
        Constant.consumerProps.setProperty("group.id", groupId);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(Constant.consumerProps);
        consumer.subscribe(Collections.singletonList("edge"));
        Instances data = new Instances(CreateInstances.getStructure());
        int count = 0;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                ClusterInstance clusterInstance = JSON.parseObject(record.value(), ClusterInstance.class);
                Instance inst = CreateInstances.getInstance(clusterInstance);
                if (count == 1000) {
                    count = 0;
                    Instances newData = new Instances(data);
//                    exec.execute(new OnlineEM(newData));
                    exec.execute(new OnlineKmean(newData));
                    data.delete();
                }
                data.add(inst);
                count++;
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
//        exec.shutdown();
    }
}
