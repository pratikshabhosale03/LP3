import java.util.Scanner;

public class fib {

    // Recursive Fibonacci function
    public static int fiborec(int n) {
        if (n <= 1) {
            return n;  // Base cases: fib(0) = 0, fib(1) = 1
        }
        return fiborec(n - 1) + fiborec(n - 2);  // Recursive call
    }

    // Iterative Fibonacci function
    public static int fibononrec(int n) {
        int a = 0, b = 1, sum = 0;
        System.out.print("Fibonacci Series (Iterative): ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            sum += a;  // Add the current Fibonacci number to sum
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms:");
        int n = sc.nextInt();

        // Recursive Fibonacci and sum
        int recursiveSum = 0;
        System.out.print("Fibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            int fib = fiborec(i);
            System.out.print(fib + " ");
            recursiveSum += fib;  // Add each Fibonacci number to the sum
        }
        System.out.println("\nSum (Recursive): " + recursiveSum);

        // Iterative Fibonacci and sum
        int iterativeSum = fibononrec(n);
        System.out.println("Sum (Iterative): " + iterativeSum);
        
        sc.close();
    }
}
