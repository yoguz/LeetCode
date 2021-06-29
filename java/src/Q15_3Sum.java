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

    public List<List<Integer>> threeSumOld(int[] nums) {
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

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> counts = new HashMap<>();
        Set<String> resultSet = new HashSet<>();

        for (int i: nums) {
            counts.merge(i, 1, Integer::sum);
        }

        List<List<Integer>> result = new LinkedList<>();

        int complement = 0, twoSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                break;
            for (int j = i+1; j < nums.length; ++j) {
                twoSum = -(nums[i] + nums[j]);
                if (twoSum < 0)
                    break;
                complement = counts.getOrDefault(twoSum, 0);

                if (complement > 2 || (complement > 1 && nums[i] != twoSum)
                        || (complement > 1 && nums[j] != twoSum)
                        || (complement > 0 && nums[i] != twoSum && nums[j] != twoSum)) {

                    Integer[] res = new Integer[]{nums[i], nums[j], twoSum};
                    Arrays.sort(res);
                    String key = res[0] + "," + res[1] + "," + res[2];
                    if (!resultSet.contains(key)) {
                        resultSet.add(key);
                        result.add(Arrays.asList(res));                    }
                }
            }
        }

        return result;
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
