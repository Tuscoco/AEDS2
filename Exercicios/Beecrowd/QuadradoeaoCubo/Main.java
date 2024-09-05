import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 1;i <= n;i++){

            System.out.println((i) + " " + (i * i) + " " + (i * i * i));

        }

        scan.close();

    }
    
}