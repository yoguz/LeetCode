public class Q11_Container_With_Most_Water {

    // O(n^2)
    public int maxAreaNSquared(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i+1; j < height.length; ++j) {
                max = Math.max(max, (j-i)* Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length-1;
        while (i < j) {
            max = Math.max(max, (j-i)* Math.min(height[i], height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }

        return max;
    }

    public static void main(String[] args) {
        Q11_Container_With_Most_Water obj = new Q11_Container_With_Most_Water();
        System.out.println(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
