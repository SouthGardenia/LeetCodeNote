package com.leetcode.note.easy;

import java.util.Arrays;

/**
 * Created by huzhengying on 2019/4/21.
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    示例:
        输入: [-2,1,-3,4,-1,2,1,-5,4],
        输出: 6
    连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(array));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    //动态规划
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        //定义状态，dp[i]表示以第i个元素为结尾的连续子序列的最大和
        int[] dp = new int[n];
        //状态初始化
        for(int i = 0; i < n; i++){
            dp[i] = nums[i];
        }

        //以第k个元素结尾的连续子序列的最大和要么是第k个元素本身，要么是第k个元素与以第k-1个元素结尾的子序列和的和
        //状态转移方程：dp[k] = Math.max(dp[k], dp[k]+dp[k-1]);
        for(int k = 1; k < n; k++){
            dp[k] = Math.max(dp[k], dp[k]+dp[k-1]);
        }

        Arrays.sort(dp);
        return dp[n-1];
    }

}
