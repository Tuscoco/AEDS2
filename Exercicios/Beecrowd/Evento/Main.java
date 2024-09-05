import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int x = 0;
        int m = 0;

        do{

            x = scan.nextInt();
            m = scan.nextInt();

            if(x != 0 && m != 0){

                System.out.println(x * m);

            }

        }while(x != 0 && m != 0);

        scan.close();

    }
    
}