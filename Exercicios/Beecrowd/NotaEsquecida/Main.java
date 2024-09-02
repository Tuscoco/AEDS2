import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int nota1 = scan.nextInt();
        int media = scan.nextInt();

        int nota2 = (2 * media) - nota1;
        
        System.out.println(nota2);

        scan.close();

    }
    
}