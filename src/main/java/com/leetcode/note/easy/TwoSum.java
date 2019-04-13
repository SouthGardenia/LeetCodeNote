package com.leetcode.note.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huzhengying on 2019/3/14.
 *
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
 * ���Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
    ʾ��:

        ���� nums = [2, 7, 11, 15], target = 9
        ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
        ���Է��� [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 7,9,11,15};
        for(int i : twoSum(nums,2)){
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0;i < nums.length; i++) {
            int targetNum = target - nums[i];
            if (numMap.containsKey(targetNum)) {
                return new int[]{numMap.get(targetNum), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
