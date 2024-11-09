import java.util.*;

public class knapdp{
    
    public static int knap(int[] profit,int[] weights,int capacity){
        int n=profit.length;

        int[][]dp=new int[n+1][capacity+1];
        for(int i=1;i<=n;i++){
            for(int w=1;w<=capacity;w++){
                if(weights[i-1]<=w){
                    dp[i][w]=Math.max(profit[i-1]+dp[i-1][w-weights[i-1]],dp[i-1][w]);
                }else{
                    dp[i][w]=dp[i-1][w];
                }
            }
        }return dp[n][capacity];
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the capacity");
        int capacity=sc.nextInt();
        System.out.println("enter the no of items");
        int n=sc.nextInt();

        int[] profit=new int[n];
        int[] weights=new int[n];

        for(int i=0;i<n;i++){
            System.out.println("enter the profit for "+(i+1));
            profit[i]=sc.nextInt();
            System.out.println("enter the weight for "+(i+1));
            weights[i]=sc.nextInt();
        }
        int max=knap(profit,weights,capacity);
        System.out.println("Max profit is : "+max);
    }
}
