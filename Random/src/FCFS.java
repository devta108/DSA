import java.util.Arrays;
import java.util.Scanner;

public class FCFS {
    static void waitingTime(int[] startTime,int[] executionTime){
        int processtime = 0;
        for(int i=0;i<startTime.length;i++){
//            if(i==0) so
            int temp = processtime-startTime[i];
            System.out.println("Waiting time for P"+(i+1)+" process is : "+temp);
            processtime += executionTime[i];
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter number of processes...");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] startTime = new int[n];
        int[] excecutionTime = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter start time for p"+(i+1)+" task");
            startTime[i] = sc.nextInt();
            System.out.println("Enter execution time for p"+(i+1)+"task");
            excecutionTime[i] = sc.nextInt();
        }
        waitingTime(startTime,excecutionTime);
        System.out.println(Arrays.toString(startTime));
        System.out.println(Arrays.toString(excecutionTime));
    }
}
