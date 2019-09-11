package util;

import java.util.Properties;

/**
 * title: util.Constant
 * projectName： edge
 * author： 张政淇
 * date： 2019/9/6
 * time： 17:16
 */
public class Constant {
    public static Properties producerProps = new Properties();
    public static Properties consumerProps = new Properties();
    static {
        producerProps.put("bootstrap.servers", "zzq:9092");
        producerProps.put("acks", "0");
        producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }
    static {
        consumerProps.setProperty("bootstrap.servers", "zzq:9092");
        consumerProps.setProperty("group.id", "test");
        consumerProps.setProperty("enable.auto.commit", "true");
        consumerProps.setProperty("auto.commit.interval.ms", "1000");
        consumerProps.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }
}
