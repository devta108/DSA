public class Permutation {
    static void permutations(int curr,int n,int r,int[] used,String asf){
        if(asf.length()==n){
            if(r == 0){
                System.out.println(asf);
            }
            return;
        }
        for(int i=0;i<used.length;i++){
            if(used[i] == 1) continue;
            else{
                used[i] = 1;
                permutations(curr+1,n,r-1,used,asf+(i+1));
                used[i] = 0;

            }
        }
        permutations(curr+1,n,r,used,asf+0);
    }
    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        permutations(0,n,r,new int[r],"");
    }
}
