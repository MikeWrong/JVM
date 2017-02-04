import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * VM Args：堆的最小值-Xms20m 堆的最大值-Xmx20m Dump出当前的内存堆转储快照-XX:+HeapDumpOnOutOfMemoryError Dump文件的路径-XX:HeapDumpPath=/Users/gaozengrong/JVM/target
 * Created by gaozengrong on 17/2/4.
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
