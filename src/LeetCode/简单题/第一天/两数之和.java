package LeetCode.简单题.第一天;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    /*
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            for(int j=i+1;j< n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }


        return new int[0];
    }

     */
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                res[0] =list.indexOf(nums[i]);
                res[1] =i;
            }
            list.add(target-nums[i]);
        }
        return res;
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map =new HashMap<Integer,Integer>(nums.length);
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(target-nums[i])){
                    return new int[]{map.get(target-nums[i]),i};
                }
                map.put(nums[i],i);

            }
            return new int[0];
        }
    }









}



