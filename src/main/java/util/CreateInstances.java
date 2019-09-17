package util;

import entity.ClusterInstance;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;

/**
 * @ClassName: CreateInstances
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/9/12 15:47
 * @Version: 1.0
 */
public class CreateInstances {
    private static Instances m_structure;

    public static Instance getInstance(ClusterInstance clusterInstance) {
//        double[] vals = new double[5];
//        vals[0] = clusterInstance.getI1();
//        vals[1] = clusterInstance.getI2();
//        vals[2] = clusterInstance.getI3();
//        vals[3] = clusterInstance.getI4();
//        vals[4] = clusterInstance.getI5();

        Instance inst = new DenseInstance(6);
        inst.setDataset(m_structure);
        inst.setValue(0, clusterInstance.getTimestamp());
        inst.setValue(1, clusterInstance.getI1());
        inst.setValue(2, clusterInstance.getI2());
        inst.setValue(3, clusterInstance.getI3());
        inst.setValue(4, clusterInstance.getI4());
        inst.setValue(5, clusterInstance.getI5());
        return inst;
    }

    public static Instances getStructure() {
        ArrayList<Attribute> attribInfo = new ArrayList<>();
        attribInfo.add(new Attribute("timestamp", (ArrayList<String>) null));
        attribInfo.add(new Attribute("i1"));
        attribInfo.add(new Attribute("i2"));
        attribInfo.add(new Attribute("i3"));
        attribInfo.add(new Attribute("i4"));
        attribInfo.add(new Attribute("i5"));
        m_structure = new Instances("edge", attribInfo, 0);
        return new Instances(m_structure, 0);
    }
}
