package org.py.jdk11.java.base.algorithm;

@SuppressWarnings("ALL")
public class StringTest {

    // 全局变量或成员变量
    private static final int SIZE = 256;

    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // 计算b[i]的ASCII值
            bc[ascii] = i;
        }
    }


    public int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        generateBC(b, m, bc); // 构建坏字符哈希表
        int i = 0; // i表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            // j: 坏字符在模式串的下标
            // a[i + j] : 第一个不匹配的字符
            // bc[(int) a[i + j]] : 模式串中能匹配主串的最大下标
            // (j - bc[(int) a[i + j]]) : 可能为负，暂不考虑向后移
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }


}
