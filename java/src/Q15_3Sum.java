import java.util.*;

public class Q15_3Sum {

    public List<List<Integer>> threeSum_OnMemory(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3)
            return list;

        int i = 0, j;
        while (i < nums.length-2) {
            Set<Integer> set = new HashSet<>();
            j = i+1;

            while (j < nums.length) {
                boolean addedJ = false;
                if (set.contains(nums[j])) {
                    List<Integer> group = new ArrayList<>();
                    group.add(nums[i]);
                    group.add(-nums[j]-nums[i]);
                    group.add(nums[j]);
                    list.add(group);
                    addedJ = true;
                }
                set.add(-nums[i]-nums[j]);

                while (addedJ && j < nums.length-1 && nums[j] == nums[j+1])
                    j++;
                j++;
            }

            while (i < nums.length-3 && nums[i] == nums[i+1])
                i++;
            i++;
        }

        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3)
            return list;

        int i = 0, lo, hi;
        while (i < nums.length-2 && nums[i] < 1) {
            lo = i+1;
            hi = nums.length-1;

            while (lo < hi) {
                if (nums[lo] + nums[hi] == -nums[i]) {
                    list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1])
                        lo++;
                    while (lo < hi && nums[hi] == nums[hi-1])
                        hi--;
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] > -nums[i]) {
                    hi--;
                } else {
                    lo++;
                }
            }

            while (i < nums.length-3 && nums[i] == nums[i+1])
                i++;
            i++;
        }

        return list;
    }

    public static void main(String[] args) {
        Q15_3Sum obj = new Q15_3Sum();
        List<List<Integer>> res = obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list: res) {
            for (Integer i : list)
                System.out.print(i + ", ");
            System.out.println();
        }
    }
}
