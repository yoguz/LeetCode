public class Q338_Counting_Bits {

    public int[] countBits(int num) {
        int result[] = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index){
            if (offset * 2 == index){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Q338_Counting_Bits obj = new Q338_Counting_Bits();
        int[] res = obj.countBits(25);
        for (int i: res)
            System.out.print(i + ", ");
    }
}
