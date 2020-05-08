public class Q1232_Check_If_It_Is_a_Straight_Line {

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; ++i) {
            if (Math.abs((coordinates[i][1]*1.0 - coordinates[i-1][1]) / (coordinates[i][0] - coordinates[i-1][0]))
                    != Math.abs((coordinates[i-1][1]*1.0 - coordinates[i-2][1]) / (coordinates[i-1][0] - coordinates[i-2][0])))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q1232_Check_If_It_Is_a_Straight_Line obj = new Q1232_Check_If_It_Is_a_Straight_Line();
        System.out.println(obj.checkStraightLine(new int [][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}}));
        System.out.println(obj.checkStraightLine(new int [][]{{-4,-4},{1,1},{3,3},{5,5},{2,2}}));

    }
}
