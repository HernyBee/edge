package util;

import com.alibaba.fastjson.JSON;
import entity.ClusterInstance;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import util.Constant;
import util.InsertInstance2DB;

import java.time.Duration;
import java.util.Collections;

/**
 * @ClassName: util.SyncKafkaToDB
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/11 16:29
 * @Version: 1.0
 */
public class SyncKafkaToDB {
    public static void main(String[] args) {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(Constant.consumerProps);
        consumer.subscribe(Collections.singletonList("edge"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                InsertInstance2DB.insert(JSON.parseObject(record.value(), ClusterInstance.class));
            }
        }
    }
}
