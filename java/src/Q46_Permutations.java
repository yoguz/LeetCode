import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        helper(result, new LinkedList<>(), numList);

        return result;

    }

    private void helper(List<List<Integer>> result, List<Integer> inc, List<Integer> dec) {
        if (dec.size() == 1) {
            inc.add(dec.get(0));
            result.add(inc);
        } else {
            for (int i = 0; i < dec.size(); ++i) {
                List<Integer> incClone = new LinkedList<>(inc);
                List<Integer> decClone = new LinkedList<>(dec);
                incClone.add(decClone.get(i));
                decClone.remove(i);
                helper(result, incClone, decClone);
            }
        }
    }

    public static void main(String[] args) {
        Q46_Permutations obj = new Q46_Permutations();
        List<List<Integer>> res = obj.permute(new int[]{1,2,3,4});
        for (List<Integer> li: res) {
            for (Integer i: li)
                System.out.print(i + ", ");
            System.out.println();
        }

    }
}
