import java.util.Scanner;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for(int i = 1;i <= num;i++){

            if(num % i == 0){

                System.out.println(i);

            }

        }

        scan.close();

    }
    
}