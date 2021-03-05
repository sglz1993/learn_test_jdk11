//package org.code.java.leetcode.editor.cn;
///**
//* Java：寻找两个正序数组的中位数
//* //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
////
////
////
//// 示例 1：
////
////
////输入：nums1 = [1,3], nums2 = [2]
////输出：2.00000
////解释：合并数组 = [1,2,3] ，中位数 2
////
////
//// 示例 2：
////
////
////输入：nums1 = [1,2], nums2 = [3,4]
////输出：2.50000
////解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
////
////
//// 示例 3：
////
////
////输入：nums1 = [0,0], nums2 = [0,0]
////输出：0.00000
////
////
//// 示例 4：
////
////
////输入：nums1 = [], nums2 = [1]
////输出：1.00000
////
////
//// 示例 5：
////
////
////输入：nums1 = [2], nums2 = []
////输出：2.00000
////
////
////
////
//// 提示：
////
////
//// nums1.length == m
//// nums2.length == n
//// 0 <= m <= 1000
//// 0 <= n <= 1000
//// 1 <= m + n <= 2000
//// -106 <= nums1[i], nums2[i] <= 106
////
////
////
////
//// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//// Related Topics 数组 二分查找 分治算法
//// 👍 3766 👎 0
//
// 参考：https://www.geekxh.com/1.99.%E5%85%B6%E4%BB%96%E8%A1%A5%E5%85%85%E9%A2%98%E7%9B%AE/21.html#_03%E3%80%81%E8%AF%81%E6%98%8E%E8%BF%87%E7%A8%8B
// 更好的算法，说明：
//    使用二分查找，递归查找
//
//
//* 2021-03-05 15:09:04
//**/
//public class P4MedianOfTwoSortedArrays {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        // TO TEST
//        System.out.println(solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
//    }
//}
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        boolean oddNum = (nums1.length + nums2.length) % 2 != 0;
//        int medianIdx = (nums1.length + nums2.length) / 2;
//        if(oddNum) {
//            medianIdx = medianIdx + 1;
//        }
//        int start1 = 0;
//        int start2 = 0;
//        double medianValue = 0;
//        while (start1 < nums1.length || start2 < nums2.length) {
//            boolean num1Value = true;
//            if(start1 >= nums1.length || (start2 < nums2.length && nums1[start1] > nums2[start2])) {
//                num1Value = false;
//            }
//            int currentValue = 0;
//            if (num1Value) {
//                currentValue = nums1[start1];
//            }else {
//                currentValue = nums2[start2];
//            }
//            if(start1 + start2 + 1 == medianIdx) {
//                medianValue = currentValue;
//                if(oddNum) {
//                    break;
//                }
//            }else if (!oddNum && (start1 + start2 + 1 == medianIdx + 1)) {
//                medianValue = (medianValue + currentValue) / 2.0;
//                break;
//            }
//            if(num1Value) {
//                start1++;
//            }else {
//                start2++;
//            }
//        }
//        return medianValue;
//    }
//
//    private int getValue(int[] nums, int idx) {
//        if(idx >= nums.length) {
//            return 0;
//        }
//        return nums[idx];
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//class Record {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int total = len1 + len2;
//        int left = (total + 1) / 2;
//        int right = (total + 2) / 2;
//        return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;
//
//    }
//
//    //找到两个数组中第k小的元素
//    public int findK(int[] nums1, int i, int[] nums2, int j, int k) {
//        if (i >= nums1.length)
//            return nums2[j + k - 1];
//        if (j >= nums2.length)
//            return nums1[i + k - 1];
//        if (k == 1) {
//            return Math.min(nums1[i], nums2[j]);
//        }
//        //计算出每次要比较的两个数的值，来决定 "删除"" 哪边的元素
//        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
//        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
//        //通过递归的方式，来模拟删除掉前K/2个元素
//        if (mid1 < mid2) {
//            return findK(nums1, i + k / 2, nums2, j, k - k / 2);
//        }
//        return findK(nums1, i, nums2, j + k / 2, k - k / 2);
//    }
//}