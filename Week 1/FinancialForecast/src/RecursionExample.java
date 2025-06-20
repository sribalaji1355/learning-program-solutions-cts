import java.util.Scanner;

public class RecursionExample {
    int factorial(int n) {
        if (n == 0) 
            return 1;
        return n * factorial(n - 1);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        RecursionExample recursionExample = new RecursionExample();
        System.out.println(recursionExample.factorial(n));
        sc.close();
    }

}
