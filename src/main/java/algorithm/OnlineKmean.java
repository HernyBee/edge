package algorithm;

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
            // 2.初始化聚类器
            SimpleKMeans simpleKMeans = new SimpleKMeans();
            simpleKMeans.setNumClusters(30);// 设置类别数量
            simpleKMeans.setPreserveInstancesOrder(true);

            // 3.使用聚类算法对样本进行聚类
            simpleKMeans.buildClusterer(instances);

            // 4.打印聚类结果
            Instances tempIns = simpleKMeans.getClusterCentroids();
//            System.out.println(KM.toString());
            System.out.println("CentroIds: " + tempIns);
            System.out.println("finish time:" + System.currentTimeMillis());
//            System.out.println("-------------------/n");
//            int[] res = KM.getAssignments();
//            System.out.println(Arrays.toString(res));
//            for (int i = 0; i < tempIns.size(); i++) {
//                Instance temp = tempIns.get(i);
//                System.out.println(temp.numAttributes());
//                for (int j = 0; j < temp.numAttributes(); j++) {
//                    System.out.print(temp.value(j) + ",");
//                }
//                System.out.println("");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        instances = null;
    }
}
