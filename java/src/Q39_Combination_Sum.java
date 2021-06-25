import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q39_Combination_Sum {

    List<List<Integer>> resOld;
    public List<List<Integer>> combinationSumOld(int[] candidates, int target) {
        resOld = new ArrayList<>();
        Arrays.sort(candidates);
        helperOld(new ArrayList<>(), candidates, 0, target, 0);
        return resOld;
    }

    private void helperOld(List<Integer> list, int[] candidates, int sum, int target, int startIdx) {
        for (int i = startIdx; i < candidates.length; ++i){
            if (candidates[i] + sum > target)
                break;

            List<Integer> l2 = new ArrayList<>(list);
            l2.add(candidates[i]);
            if (candidates[i] + sum == target) {
                resOld.add(l2);
                break;
            } else {
                helperOld(l2, candidates, candidates[i]+sum, target, i);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> resList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(candidates, target, resList, list, 0);
        return resList;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> resList, List<Integer> list, int startIdx) {
        if (target == 0) {
            resList.add(list);
            return;
        }

        for (int idx = startIdx; idx < candidates.length; ++idx) {
            if (candidates[idx] > target)
                return;

            List<Integer> copyList = new LinkedList<>(list);
            copyList.add(candidates[idx]);
            helper(candidates, target-candidates[idx], resList, copyList, idx);
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
