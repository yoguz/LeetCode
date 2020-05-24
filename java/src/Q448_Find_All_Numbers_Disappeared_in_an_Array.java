import java.util.ArrayList;
import java.util.List;

public class Q448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Q448_Find_All_Numbers_Disappeared_in_an_Array obj = new Q448_Find_All_Numbers_Disappeared_in_an_Array();
        List<Integer> list = obj.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.print("[");
        for (Integer i: list) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
