package algorithm;

import util.DateUtil;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

/**
 * @ClassName: OnlineKmean
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/11 17:59
 * @Version: 1.0
 */
public class OnlineKmean implements Runnable {
    private Instances instances;
    public OnlineKmean(Instances instances) {
        this.instances = instances;
    }
    @Override
    public void run() {
        try {

            String timestamp = instances.get(instances.size() - 1).toString(0);
            instances.deleteAttributeAt(0);
            // 2.初始化聚类器
            SimpleKMeans simpleKMeans = new SimpleKMeans();
            simpleKMeans.setNumClusters(30);// 设置类别数量
            simpleKMeans.setPreserveInstancesOrder(true);

            // 3.使用聚类算法对样本进行聚类
            simpleKMeans.buildClusterer(instances);
            System.out.println("线程:" + Thread.currentThread().getName() + ",最后一条数据产生时间:" + timestamp);
            System.out.println("线程:" + Thread.currentThread().getName() + ",数据进入算法消费完成时间:" + DateUtil.getStandardDateTime(System.currentTimeMillis()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        instances = null;
    }
}
