import java.util.HashMap;
import java.util.Map;

public class Q169_Majority_Element {

    public int majorityElementBad(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            counts.merge(nums[i], 1, Integer::sum);
        }

        int elem = 0, count = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > count) {
                elem = entry.getKey();
                count = entry.getValue();
            }
        }
        return elem;
    }

    public int majorityElementBad2(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            counts.merge(nums[i], 1, Integer::sum);
            if (counts.get(nums[i])>nums.length/2) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElement(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Q169_Majority_Element obj = new Q169_Majority_Element();
        int[] nums = new int[] {1,2,1,3,4,1,1};
        System.out.println(obj.majorityElement(nums));
    }
}
