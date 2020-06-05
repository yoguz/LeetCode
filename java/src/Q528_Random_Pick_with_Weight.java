public class Q528_Random_Pick_with_Weight {

    int[] w;
    int total;

    public Q528_Random_Pick_with_Weight(int[] w) {
        this.w = new int[w.length];
        this.w[0] = w[0] - 1;
        for (int i = 1; i < w.length; ++i)
            this.w[i] += w[i] + this.w[i-1];

        total = this.w[w.length-1] + 1;
    }

    public int pickIndex() {
        if (w.length == 1)
            return 0;
        int rand = (int)(Math.random() * total);
        int lo = 0, hi = w.length-1, res = 0, mid = 0;
        while (lo < hi) {
            mid = lo + (hi-lo)/2;
            if (rand == w[mid]){
                return mid;
            } else if (rand > w[mid] && rand <= w[mid+1]) {
                return mid+1;
            } else if (rand < w[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        Q528_Random_Pick_with_Weight obj = new Q528_Random_Pick_with_Weight(new int[]{1,2,3,4,5,6,7});
        for (int i = 0; i < 20; ++i)
            System.out.print(obj.pickIndex() + " ");
    }
}
