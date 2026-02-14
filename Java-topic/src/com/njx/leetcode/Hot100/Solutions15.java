package  com.njx.leetcode.Hot100;
import java.util.*;

public class Solutions15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);  // ① 排序

        for (int i = 0; i < nums.length - 2; i++) {

            // ② 第一个数去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // ③ 第二个数去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // ④ 第三个数去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;   // 太小
                }
                else {
                    right--;  // 太大
                }
            }
        }

        return result;
    }
}
//思路是先锚定一个数，然后用双指针来寻找另外两个数
//难点是第二第三去重 while (left < right && nums[left] == nums[left + 1])意思是先满足在数组内，然后跳过同样的数
//例如：[1,1,1,2,2,3,4,5,6]当双指针时下表234都一样那就跳过，直接到数3，比卖你出现同样的三元组