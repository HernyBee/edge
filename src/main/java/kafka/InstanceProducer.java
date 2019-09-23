package kafka;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * title: kafka.InstanceProducer
 * projectName： edge
 * author： 张政淇
 * date： 2019/9/6
 * time： 17:10
 */
public class InstanceProducer {
    public static void main(String[] args) {
        int threadNum = 50;
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            exec.execute(new ProducerThread());
        }
        exec.shutdown();
    }
}
