import java.util.LinkedList;
import java.util.List;

public class Q207_Course_Schedule {

    enum Color {
        WHITE,
        GRAY,
        BLACK
    };

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] dependants = new LinkedList[numCourses];
        Color[] colors = new Color[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            colors[i] = Color.WHITE;
            dependants[i] = new LinkedList<>();
        }

        for (int[] pre: prerequisites) {
            dependants[pre[0]].add(pre[1]);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (colors[i] == Color.WHITE && isCyclic(dependants, colors, i))
                return false;
        }

        return true;
    }

    private boolean isCyclic(List<Integer>[] dependants, Color[] colors, int course){
        colors[course] = Color.GRAY;

        for (Integer dependant: dependants[course]) {
            if (colors[dependant] == Color.GRAY)
                return true;

            else if (colors[dependant] == Color.WHITE && isCyclic(dependants, colors, dependant))
                return true;
        }

        colors[course] = Color.BLACK;
        return false;
    }

    public static void main(String[] args) {
        Q207_Course_Schedule obj = new Q207_Course_Schedule();
        System.out.println(obj.canFinish(2, new int[][]{{1,0}}));
        System.out.println(obj.canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}
