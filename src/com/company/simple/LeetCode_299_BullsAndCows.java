package com.company.simple;

/**
 * @description: 猜数字游戏，数字正确且位置正确为A，数字正确且位置错误为B
 * @author: 15262
 * @date: 2020/3/12
 */

class LeetCode_299_Solution {

    public String getHintNew(String secret, String guess) {
        int A = 0;

        int[] hub = new int[10];

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                // 数值为正数的下标为secret中出现过，且guess中没有出现过的字符
                hub[secret.charAt(i) - '0'] ++;
                hub[guess.charAt(i) - '0'] --;
            }
        }

        int num = 0;
        for (int i = 0; i < hub.length; i++) {
            if (hub[i] > 0) {
                num += hub[i];
            }
        }

        // secret.length - 两个字符串共有的字符数量 - secret自身独有的字符数量 = guess猜对的字符但是位置错误的
        return A + "A" + (secret.length() - num - A) + "B";
    }

    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;

        int[] guessArr = new int[guess.length()];
        int[] secretArr = new int[guess.length()];

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                guessArr[i]++;
                secretArr[i]++;
                A++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guessArr[i] == 0) {
                char c = guess.charAt(i);
                for (int j = 0; j < secret.length(); j++) {
                    if (secret.charAt(j) == c && secretArr[j] == 0) {
                        B++;
                        secretArr[j]++;
                        guessArr[i] ++;
                        break;
                    }
                }
            }
        }

        return A + "A" + B + "B";
    }
}

public class LeetCode_299_BullsAndCows {

    public static void main(String[] args) {
        LeetCode_299_Solution solution = new LeetCode_299_Solution();
        System.out.println(solution.getHintNew("1807", "7810"));
        System.out.println(solution.getHintNew("1123", "0111"));
        System.out.println(solution.getHintNew("11", "01"));
        System.out.println(solution.getHintNew("011", "110"));
        System.out.println(solution.getHintNew("1122", "0001"));
    }

}
