import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常 必须在jdk 1.6及以前的版本下允许 因为jdk1.7开始逐步"去永久代"
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by gaozengrong on 17/2/4.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {

        testIntern();

        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     * 在jdk1.6和jdk1.7下运行 结果不一样
     * 在jdk1.6下会得到两个false  在jdk1.7下会得到一个true和一个false
     */
    public static void testIntern(){
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
