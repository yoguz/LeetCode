import java.util.HashMap;
import java.util.Map;

public class Q525_Contiguous_Array {

    // Completely misunderstood the problem. This is the solution for {0+1+| 1+0+} subarrays
    /*
    public int findMaxLength(int[] nums) {
        if (nums.length < 2)
            return 0;

        int max = 0;
        int[] count = new int[2];
        int first = nums[0];
        count[first]++;
        for (int i = 1; i < nums.length; ++i) {
            if (count[0] == 0 || count[1] == 0 || (nums[i] != first)) {
                count[nums[i]]++;
            } else {
                max = Math.max(max, 2*Math.min(count[0], count[1]));
                count[first] = 1;
                first ^= first;
            }
        }

        max = Math.max(max, 2*Math.min(count[0], count[1]));
        return max;
    }
    */

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, max = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            count += nums[i] == 0 ? -1 : 1;
            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                max = Math.max(max, i-map.get(count));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q525_Contiguous_Array obj = new Q525_Contiguous_Array();
        System.out.println(obj.findMaxLength(new int[]{0,1}));
        System.out.println(obj.findMaxLength(new int[]{1,0}));
        System.out.println(obj.findMaxLength(new int[]{0,1,1}));
        System.out.println(obj.findMaxLength(new int[]{1,0,0,1,1}));
        System.out.println(obj.findMaxLength(new int[]{1,0,0,1,1,1,0}));
        System.out.println(obj.findMaxLength(new int[]{1,0,0,1,1,1,0}));
    }
}
