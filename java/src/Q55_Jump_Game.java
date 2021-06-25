public class Q55_Jump_Game {

    public boolean canJump(int[] nums) {
        int step = 1;
        nums[nums.length-1]++;

        for (int num: nums) {
            step = Math.max(--step, num);

            if (step == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Q55_Jump_Game obj = new Q55_Jump_Game();
        System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
        System.out.println(obj.canJump(new int[]{3,2,1,0,4}));
    }
}
