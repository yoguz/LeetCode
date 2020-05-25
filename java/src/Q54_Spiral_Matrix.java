import java.util.ArrayList;
import java.util.List;

public class Q54_Spiral_Matrix {

    enum direction {L, R, U, D};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return list;

        int top = -1, right = matrix[0].length, bot = matrix.length, left = -1;
        direction dir = direction.R;
        while (bot - top  > 1 && right - left > 1) {
            switch (dir) {
                case R:
                    for(int i = left+1; i < right; ++i)
                        list.add(matrix[top+1][i]);
                    top++;
                    dir = direction.D;
                    break;
                case D:
                    for(int i = top+1; i < bot; ++i)
                        list.add(matrix[i][right-1]);
                    right--;
                    dir = direction.L;
                    break;
                case L:
                    for(int i = right-1; i > left; --i)
                        list.add(matrix[bot-1][i]);
                    bot--;
                    dir = direction.U;
                    break;
                case U:
                    for(int i = bot-1; i > top; --i)
                        list.add(matrix[i][left+1]);
                    left++;
                    dir = direction.R;
                    break;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Q54_Spiral_Matrix obj = new Q54_Spiral_Matrix();
        List<Integer> list = obj.spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
        list = obj.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        });
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
        list = obj.spiralOrder(new int[][]{
                {}
        });
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
        list = obj.spiralOrder(new int[][]{
                {1,2,3,4}
        });
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
        list = obj.spiralOrder(new int[][]{
                {1},
                {2},
                {3},
                {4}
        });
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
        list = obj.spiralOrder(new int[][]{

        });
        for (int i : list) {
            System.out.print(i + ", ");
        }
    }
}
