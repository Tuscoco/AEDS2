import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine();

        String[] array = new String[n];

        for(int i = 0;i < n;i++){
            array[i] = scan.nextLine();
        }

        Arrays.sort(array);

        System.out.println(array[k - 1]);

        scan.close();

    }
    
}