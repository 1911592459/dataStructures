package demo.哈希表;


import java.util.HashSet;
import java.util.Set;

//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
// 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
class Solution1 {
    public int findRepeatNumber(int[] nums) {
        Set set =new HashSet();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
public class 数组中重复的数字 {
}
