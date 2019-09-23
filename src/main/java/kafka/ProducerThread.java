package kafka;

import com.alibaba.fastjson.JSON;
import entity.ClusterInstance;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import util.Constant;

import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @ClassName: kafka.ProducerThread
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/16 12:50
 * @Version: 1.0
 */
public class ProducerThread implements Runnable {

    @Override
    public void run() {
        Producer<String, String> producer = new KafkaProducer<>(Constant.producerProps);
        Random random = new Random();
        ClusterInstance instance = new ClusterInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        for (int i = 0; i < 10000; i++) {
            instance.setTimestamp(simpleDateFormat.format(System.currentTimeMillis()));
            instance.setI1(random.nextDouble() * 100);
            instance.setI2(random.nextDouble() * 100);
            instance.setI3(random.nextDouble() * 100);
            instance.setI4(random.nextDouble() * 100);
            instance.setI5(random.nextDouble() * 100);
            //过滤
            if (instance.getI1() > instance.getI3()) {
                producer.send(new ProducerRecord<>("edge", instance.getTimestamp(), JSON.toJSONString(instance)));
            }
            //不过滤
//            producer.send(new ProducerRecord<>("edge", instance.getTimestamp(), JSON.toJSONString(instance)));
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((i + 1) % 1000 == 0) {
                System.out.println("线程:" + Thread.currentThread().getName() + ",时间:" + simpleDateFormat.format(System.currentTimeMillis()) + ",已发送第" + (i + 1) + "条");
            }
        }
        producer.close();
    }
}
