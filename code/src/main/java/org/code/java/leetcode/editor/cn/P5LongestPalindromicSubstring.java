//package org.code.java.leetcode.editor.cn;
//
///**
// * Java：最长回文子串
// * //给你一个字符串 s，找到 s 中最长的回文子串。
// * //
// * //
// * //
// * // 示例 1：
// * //
// * //
// * //输入：s = "babad"
// * //输出："bab"
// * //解释："aba" 同样是符合题意的答案。
// * //
// * //
// * // 示例 2：
// * //
// * //
// * //输入：s = "cbbd"
// * //输出："bb"
// * //
// * //
// * // 示例 3：
// * //
// * //
// * //输入：s = "a"
// * //输出："a"
// * //
// * //
// * // 示例 4：
// * //
// * //
// * //输入：s = "ac"
// * //输出："a"
// * //
// * //
// * //
// * //
// * // 提示：
// * //
// * //
// * // 1 <= s.length <= 1000
// * // s 仅由数字和英文字母（大写和/或小写）组成
// * //
// * // Related Topics 字符串 动态规划
// * // 👍 3284 👎 0
// * <p>
// * 2021-03-05 16:08:13
// * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
// **/
//public class P5LongestPalindromicSubstring {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        // TO TEST
//        System.out.println(solution.longestPalindrome("flsuqzhtcahnyickkgtfnlyzwjuiwqiexthpzvcweqzeqpmqwkydhsfipcdrsjkefehhesubkirhalgnevjugfohwnlhbjfewiunlgmomxkafuuokesvfmcnvseixkkzekuinmcbmttzgsqeqbrtlwyqgiquyylaswlgfflrezaxtjobltcnpjsaslyviviosxorjsfncqirsjpkgajkfpoxxmvsyynbbovieoothpjgncfwcvpkvjcmrcuoronrfjcppbisqbzkgpnycqljpjlgeciaqrnqyxzedzkqpqsszovkgtcgxqgkflpmrikksaupukdvkzbltvefitdegnlmzeirotrfeaueqpzppnsjpspgomyezrlxsqlfcjrkglyvzvqakhtvfmeootbtbwfhqucbnuwznigoyatvkocqmbtqghybwrhmyvvuchjpvjckiryvjfxabezchynfxnpqaeampvaapgmvoylyutymdhvhqfmrlmzkhuhupizqiujpwzarnszrexpvgdmtoxvjygjpmiadzdcxtggwamkbwrkeplesupagievwsaaletcuxtpsxmbmeztcylsjxvhzrqizdmgjfyftpzpgxateopwvynljzffszkzzqgofdlwyknqfruhdkvmvrrjpijcjomnrjjubfccaypkpfokohvkqndptciqqiscvmpozlyyrwobeuazsawtimnawquogrohcrnmexiwvjxgwhmtpykqlcfacuadyhaotmmxevqwarppknoxthsmrrknu"));;
//    }
//}
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String longestPalindrome(String s) {
//        if (s.length() <= 1) {
//            return s;
//        }
//        char[] chars = s.toCharArray();
//        for (int i = chars.length; i > 0; i--) {
//            for (int j = i; j <= chars.length; j++) {
//                if (verifyPalindromic(chars, j-i, j)) {
//                    return s.substring(j-i,j);
//                }
//            }
//        }
//        return "";
//    }
//
//    private boolean verifyPalindromic(char[] data, int start, int end) {
//        for (int i = 0; i <= (end - start) / 2; i++) {
//            if (data[i + start] != data[end - 1 - i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
