import java.util.HashMap;
import java.util.Map;

public class Q1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        Q1_Two_Sum obj = new Q1_Two_Sum();
        int[] res = obj.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}
