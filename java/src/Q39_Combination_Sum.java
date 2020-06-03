import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_Combination_Sum {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(), candidates, 0, target, 0);
        return res;
    }

    private void helper(List<Integer> list, int[] candidates, int sum, int target, int startIdx) {
        for (int i = startIdx; i < candidates.length; ++i){
            if (candidates[i] + sum > target)
                break;

            List<Integer> l2 = new ArrayList<>(list);
            l2.add(candidates[i]);
            if (candidates[i] + sum == target) {
                res.add(l2);
                break;
            } else {
                helper(l2, candidates, candidates[i]+sum, target, i);
            }
        }
    }

    public static void main(String[] args) {
        Q39_Combination_Sum obj = new Q39_Combination_Sum();
        List<List<Integer>> res = obj.combinationSum(new int[]{2,3,6,7}, 7);
        for (List<Integer> elem: res) {
            for (Integer i: elem)
                System.out.print(i + ", ");
            System.out.println();
        }
    }
}
