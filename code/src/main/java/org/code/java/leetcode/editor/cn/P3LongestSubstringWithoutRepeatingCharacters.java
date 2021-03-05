//package org.code.java.leetcode.editor.cn;
//
//import java.util.HashMap;
//
///**
//* Java：无重复字符的最长子串
//* //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
////
////
////
//// 示例 1:
////
////
////输入: s = "abcabcbb"
////输出: 3
////解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
////
////
//// 示例 2:
////
////
////输入: s = "bbbbb"
////输出: 1
////解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
////
////
//// 示例 3:
////
////
////输入: s = "pwwkew"
////输出: 3
////解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
////     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
////
////
//// 示例 4:
////
////
////输入: s = ""
////输出: 0
////
////
////
////
//// 提示：
////
////
//// 0 <= s.length <= 5 * 104
//// s 由英文字母、数字、符号和空格组成
////
//// Related Topics 哈希表 双指针 字符串 Sliding Window
//// 👍 5063 👎 0
//
//* 2021-03-05 14:16:36
// *
// * 参考：https://www.huaweicloud.com/articles/0e68535af4e179c6b949dae8314176ee.html
// * 1. 滑动窗口， 空数组存放数字表示出现次数
// *
// * 2. 使用map存放，value为下标 ，也是滑动窗口，只记录最大长度
// *
// * 3. 写的记录到最大字符串位置
//**/
//public class P3LongestSubstringWithoutRepeatingCharacters {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        // TO TEST
//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
//    }
//}
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if(s == null || s.length() == 0) {
//            return 0;
//        }
//        int startIdx = 0;
//        int maxStartIdx = 0;
//        int maxEndNexIdx = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put(s.charAt(0), 0);
//        for(int i = 1; i < s.length(); i++) {
//            if(map.get(s.charAt(i)) != null) {
//                if(i - startIdx > maxEndNexIdx - maxStartIdx) {
//                    maxStartIdx = startIdx;
//                    maxEndNexIdx = i;
//                }
//                for(int j = startIdx; j < i; j++) {
//                    if(s.charAt(j) == s.charAt(i)) {
//                        startIdx = j + 1;
//                        break;
//                    }else {
//                        map.remove(s.charAt(j));
//                    }
//                }
//            }else {
//                map.put(s.charAt(i), i);
//            }
//        }
//        if(maxEndNexIdx == 0) {
//            return s.length();
//        }
//        return Math.max(maxEndNexIdx - maxStartIdx, s.length() - startIdx);
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
