public class May23LC474 {
    class Pair{
        int zeros;
        int ones;
        Pair(int zeros,int ones){
            this.zeros = zeros;
            this.ones = ones;
        }
    }
    static Pair[] count;
    public int findMaxForm(String[] strs, int m, int n) {
        count = new Pair[strs.length];
        for(int i=0;i<strs.length;i++){
            Pair temp = getZerosOnes(strs[i]);
            count[i] = temp;
        }
        int max = findMaxForm(strs,0,m,n,0);
        return max;
    }
    int findMaxForm(String[] strs,int index, int m, int n, int length){
        if(m<0 || n<0) return Integer.MIN_VALUE;
        if(m==0 && n==0) return length;
        if(index >= strs.length) return length;

        int pick = findMaxForm(strs, index+1,m-count[index].zeros,n-count[index].ones,length+1);
        int notPick = findMaxForm(strs, index+1,m,n,length);

        return Math.max(pick, notPick);
    }

    Pair getZerosOnes(String str){
        int zeros = 0;
        int ones = 0;
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '0') zeros++;
            else ones++;
        }
        return new Pair(zeros,ones);
    }
}
