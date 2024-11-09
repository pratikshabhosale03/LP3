import java.util.*;

class Node{
    int freq;
    Node left,right;
    String symbol;
    String huff=" ";

    public Node(int freq,String symbol,Node left,Node right){

        this.freq=freq;
        this.symbol=symbol;
        this.left=left;
        this.right=right;
    }

}
public class huffman{

    public static void print(Node node,String val){
        String newVal=val+node.huff;
    
        if(node.left!=null){
            print(node.left,newVal);
        }
        if(node.right!=null){
            print(node.right,newVal);
        }
        if(node.left==null && node.right==null){
            System.out.println(node.symbol+"->"+newVal);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of symbols");
        int num=sc.nextInt();

        List<Node>nodes=new ArrayList<>();
        for(int i=0;i<num;i++){
            System.out.println("enter the symbol ");
            String symbol=sc.next();
            System.out.println("enter the frequency");
            int freq=sc.nextInt();
            nodes.add(new Node(freq,symbol,null,null));
        }
        while(nodes.size()>1){
            Collections.sort(nodes,Comparator.comparingInt(n->n.freq));
            Node left=nodes.remove(0);
            Node right=nodes.remove(0);

            left.huff="0";
            right.huff="1";
            Node newNode=new Node(left.freq+right.freq,left.symbol+right.symbol,left,right);
            nodes.add(newNode);
        }
        System.out.println("Hffman code is : ");
        print(nodes.get(0)," ");
    }


}

