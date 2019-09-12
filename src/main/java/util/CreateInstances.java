package util;

import entity.ClusterInstance;
import weka.core.DenseInstance;
import weka.core.Instance;

/**
 * @ClassName: CreateInstances
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/12 15:47
 * @Version: 1.0
 */
public class CreateInstances {
    public static Instance getInstance(ClusterInstance clusterInstance) {
        double[] vals = new double[5];
        vals[0] = clusterInstance.getI1();
        vals[1] = clusterInstance.getI2();
        vals[2] = clusterInstance.getI3();
        vals[3] = clusterInstance.getI4();
        vals[4] = clusterInstance.getI5();
        return new DenseInstance(1.0, vals);
    }
}
