import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {

    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            helper(nums, i, new ArrayList<>());
        }
        return list;
    }

    private void helper(int[] nums, int start, List<Integer> sublist) {
        if (start == nums.length)
            return;

        sublist.add(nums[start]);
        list.add(sublist);
        for (int i = start+1; i < nums.length; ++i) {
            helper(nums, i, new ArrayList<>(sublist));
        }
    }

    public static void main(String[] args) {
        Q78_Subsets obj = new Q78_Subsets();
        obj.subsets(new int[] {1,3,5,7});
        for (List<Integer> l: obj.list) {
            System.out.print("[");
            for (int i : l) {
                System.out.print(i + ", ");
            }
            System.out.println("]");
        }
    }
}
