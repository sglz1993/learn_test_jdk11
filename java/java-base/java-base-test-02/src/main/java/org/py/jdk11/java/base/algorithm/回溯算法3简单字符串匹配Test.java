package org.py.jdk11.java.base.algorithm;

/**
 * 正则表达式中，最重要的就是通配符，通配符结合在一起，可以表达非常丰富的语义。为了方便讲解，我假设正表达式中只包含“*”和“?”这两种通配符，并且对这
 * 两个通配符的语义稍微做些改变，其中，“*”匹配任意多个（大于等于0个）任意字符，“?”匹配零个或者一个任意字符。基于以上背景假设，我们看下，如何用回
 * 溯算法，判断一个给定的文本，能否跟给定的正则表达式匹配？
 */
@SuppressWarnings("All")
public class 回溯算法3简单字符串匹配Test {

    public static void main(String[] args) {
        Pattern p = new Pattern("asd*sdf*sdfs");
        System.out.println(p.match("asdsdsdfsdsdfsdsdfs"));
        System.out.println(p.match("asdsassdksddfsdfs"));
    }

    static class Pattern {

        private boolean matched = false;
        private char[] pattern; // 正则表达式
        private int plen; // 正则表达式长度

        public Pattern(String pattern) {
            this.pattern = pattern.toCharArray();
            this.plen = pattern.length();
        }

        public boolean match(String text) { // 文本串及长度
            matched = false;
            rmatch(0, 0, text.toCharArray(), text.length());
            return matched;
        }

        private void rmatch(int ti, int pj, char[] text, int tlen) {
            if (matched) return; // 如果已经匹配了，就不要继续递归了
            if (pj == plen) { // 正则表达式到结尾了
                if (ti == tlen) matched = true; // 文本串也到结尾了
                return;
            }
            if (pattern[pj] == '*') { // *匹配任意个字符
                for (int k = 0; k <= tlen - ti; ++k) {
                    rmatch(ti + k, pj + 1, text, tlen);
                }
            } else if (pattern[pj] == '?') { // ?匹配0个或者1个字符
                rmatch(ti, pj + 1, text, tlen);
                rmatch(ti + 1, pj + 1, text, tlen);
            } else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
                rmatch(ti + 1, pj + 1, text, tlen);
            }
        }
    }
}

