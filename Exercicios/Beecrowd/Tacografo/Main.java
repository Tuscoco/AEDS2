import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int total = 0;

        for(int i = 0;i < n;i++){

            int t = scan.nextInt();
            int v = scan.nextInt();

            total += (t * v);

        }

        System.out.println(total);

        scan.close();

    }
    
}