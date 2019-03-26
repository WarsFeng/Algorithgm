package cat.wars.algorithm.part1;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 3/26/19
 * Time: 11:17 PM
 */

public class Main {


    public static void main(String[] args) {
        a();
        b();
    }

    /**
     * 假设我们正比较插入排序与归并排序在相同机器上的实现。对规模为n的输入，插入排序
     * 运行8n^2步，而归并排序运行64nlgn步。问对哪些n值，插入排序优于并归排序?
     * 8n^2 < 64nlgn
     * n < 8lgn
     * n < 8log2n
     * <p>
     * 采用java求解
     * log2n = logen / loge2
     */
    static void a() {
        int n = 1;
        int threshold = 0;
        int threshold2 = 0;
        // n < 8log2n
        // threshold
        while (threshold == 0) {
            if (n < 8 * Math.log(n) / Math.log(2)) {
                threshold = n;
                break;
            }
            ++n;
        }
        // threshold2
        while (threshold2 == 0) {
            if (!(n < 8 * Math.log(n) / Math.log(2))) {
                threshold2 = --n;
                break;
            }
            ++n;
        }
        System.out.println("### 1.2-2) 假设我们正比较插入排序与归并排序在相同机器上的实现。对规模为n的输入，插入排序\n" +
                "运行8n^2步，而归并排序运行64nlgn步。问对哪些n值，插入排序优于并归排序?");
        System.out.println("\t当N在[" + threshold + "," + threshold2 + "]区间时插入排序效率优于和并排序");
    }

    /**
     * n的最小值为何值时，运行时间为100n^2的一个算法在相同机器上快于运行时间为2^n的另一个算法
     * <p>
     * 200n^2 < 2^n
     */
    static void b() {
        double n = 1;
        while (!(100 * Math.pow(n, 2) < Math.pow(2, n))) {
            // ++n;
            n += 0.01;
        }
        System.out.println("### 1.2-3) n的最小值为何值时，运行时间为100n^2的一个算法在相同机器上快于运行时间为2^n的另一个算法?");
        System.out.println("\tn:" + n);
    }

}
