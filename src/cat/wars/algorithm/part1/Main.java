package cat.wars.algorithm.part1;

import java.util.Arrays;

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
        c();
        d();
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
    private static void a() {
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
    private static void b() {
        double n = 1;
        while (!(100 * Math.pow(n, 2) < Math.pow(2, n))) {
            // ++n;
            n += 0.01;
        }
        System.out.println("### 1.2-3) n的最小值为何值时，运行时间为100n^2的一个算法在相同机器上快于运行时间为2^n的另一个算法?");
        System.out.println("\tn:" + n);
    }

    /**
     * 插入排序：
     * > 对于少量元素的排序，他是一个有效的算法。
     */
    private static void c() {
        System.out.println("## 插入排序：\n" +
                "> 对于少量元素的排序，他是一个有效的算法。");
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println("I: "+Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("O: "+Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int b = arr[i];
            int i2 = i - 1;
            while (-1 < i2 && arr[i2] > b) {
                arr[i2 + 1] = arr[i2];
                --i2;
            }
            arr[i2 + 1] = b;
        }
    }
    private static void insertionSortDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int b = arr[i];
            int i2 = i - 1;
            while (-1 < i2 && arr[i2] < b) {
                arr[i2 + 1] = arr[i2];
                --i2;
            }
            arr[i2 + 1] = b;
        }
    }

    private static void d(){
        System.out.println("### 2.1-2) 重写过程INSERTION-SORT, 使其按非升序(而不是非降序)排序");
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println("I: "+Arrays.toString(arr));
        insertionSortDesc(arr);
        System.out.println("O: "+Arrays.toString(arr));
    }
}
