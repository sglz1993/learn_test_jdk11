package org.py.jdk11.java.base.algorithm;

@SuppressWarnings("All")
public class 回溯算法2背包问题Test {

    public static int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值

    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public static void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }
        // 第i个物品不装
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            System.out.println(String.format("i:%s  \t  ->   \t  item:%s", i, items[i]));
            // 在不满足超重的情况下，第i个物品装
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    /**
     * 问题：背包，n个物品不能拆分，背包怎么装最大的东西
     */
    public static void main(String[] args) {
        f(0, 0, new int[]{11, 22, 33, 41, 52, 63, 74, 76, 81, 92}, 10, 100);
        System.out.println(maxW);
    }

}
