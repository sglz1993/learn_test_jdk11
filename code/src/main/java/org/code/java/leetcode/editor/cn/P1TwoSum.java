//package org.code.java.leetcode.editor.cn;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
//* Java：两数之和
//* //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
////
//// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
////
//// 你可以按任意顺序返回答案。
////
////
////
//// 示例 1：
////
////
////输入：nums = [2,7,11,15], target = 9
////输出：[0,1]
////解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
////
////
//// 示例 2：
////
////
////输入：nums = [3,2,4], target = 6
////输出：[1,2]
////
////
//// 示例 3：
////
////
////输入：nums = [3,3], target = 6
////输出：[0,1]
////
////
////
////
//// 提示：
////
////
//// 2 <= nums.length <= 103
//// -109 <= nums[i] <= 109
//// -109 <= target <= 109
//// 只会存在一个有效答案
////
//// Related Topics 数组 哈希表
//// 👍 10436 👎 0
//
//* 2021-03-05 13:19:09
//*
// * @author pengyue.du*/
//public class P1TwoSum {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        // TO TEST
////        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
//    }
//}
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        return myCase(nums, target);
////        return forceCase(nums, target);
////        return hashCase(nums, target);
////        return onceHashCase(nums, target);
//    }
//
//    private int[] onceHashCase(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    private int[] hashCase(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    private int[] forceCase(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    private int[] myCase(int[] nums, int target) {
//        if(nums == null) {
//            throw new IllegalArgumentException("No two sum solution");
//        }
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = 0; j < nums.length; j++) {
//                if(i == j) {
//                    continue;
//                }
//                if(nums[i] + nums[j] == target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
