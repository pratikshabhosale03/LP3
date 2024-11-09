import java.util.*;
class Item{
    double profit,weight;

    public Item(double profit,double weight){
        this.profit=profit;
        this.weight=weight;
    }
}

public class knapsack{

    public static double knapratio(double capacity,List<Item>items){
        items.sort((a,b)->Double.compare(b.profit/b.weight,a.profit/a.weight));
        return calculate(capacity,items);
    }
    public static double knapprofit(double capacity,List<Item>items){
        items.sort((a,b)->Double.compare(b.profit,a.profit));
        return calculate(capacity,items);
    }
    public static double knapweight(double capacity,List<Item>items){
        items.sort(Comparator.comparingDouble(a->a.weight));
        return calculate(capacity,items);
    }

    public static double calculate(double capacity,List<Item>items){
        double maxProfit=0;

        for(Item item:items){
            if(item.weight<=capacity){
                maxProfit+=item.profit;
                capacity-=item.weight;
            }else{
                maxProfit+=(item.profit*capacity)/item.weight;
                break;
            }
        }return maxProfit;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the capacity of knapsack");
        double capacity=sc.nextDouble();
        System.out.println("enter the no. of items ");
        int n=sc.nextInt();

        List<Item>items=new ArrayList<>();

        for(int i=0;i<n;i++){
            System.out.println("enter the profit for "+(i+1));
            double profit=sc.nextDouble();
            System.out.println("enter the weight for "+(i+1));
            double weight=sc.nextDouble();

            items.add(new Item(profit,weight));
        }

        System.out.println("profit by knapbyratio : "+knapratio(capacity,items));
        System.out.println("profit by knapbyprofit : "+knapprofit(capacity,items));
        System.out.println("profit by knapbyweight : "+knapweight(capacity,items));
    }
}
