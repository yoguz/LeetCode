public class Q997_Find_the_Town_Judge {

    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N];
        for (int[] aTrust : trust) {
            count[aTrust[0] - 1] = -1;
            if (count[aTrust[1] - 1] != -1)
                count[aTrust[1] - 1]++;
        }

        for (int i = 0; i < N; ++i) {
            if (count[i] == N-1)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q997_Find_the_Town_Judge obj = new Q997_Find_the_Town_Judge();
        System.out.println(obj.findJudge(3, new int[][] {{1,3}, {2,3}}));
    }
}
