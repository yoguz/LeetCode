import java.util.HashSet;
import java.util.Set;

public class Q217_Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i]))
                return true;

            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Q217_Contains_Duplicate obj = new Q217_Contains_Duplicate();
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,3,4,5,6,7,8}));
    }

}
