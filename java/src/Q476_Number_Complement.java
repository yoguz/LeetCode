public class Q476_Number_Complement {
    public int findComplement(int num) {
        return (int)((long)Math.pow(2, (int)(Math.log(num)/Math.log(2)) + 1) - num - 1);
    }

    public static void main(String[] args) {
        Q476_Number_Complement obj = new Q476_Number_Complement();
        System.out.println(obj.findComplement(5));
        System.out.println(obj.findComplement(Integer.MAX_VALUE));
        System.out.println(obj.findComplement(Integer.MAX_VALUE-1));
    }
}
