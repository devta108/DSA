public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int num = n;
        int count = 0;
        while(num != 0){
            int mask = num & (-num);
            num = num - mask;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-19));
        System.out.println(Integer.toBinaryString(19));
        System.out.println(Integer.toBinaryString(19&(~19 +1 )));
    }
}
