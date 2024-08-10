import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int op;

        while(true){

            op = scan.nextInt();

            if(op >= 1 && op <= 100){

                System.out.println("vai ter duas!");

            }else if(op == 0){

                System.out.println("vai ter copa!");

            }else{

                break;

            }

        }

        scan.close();

    }

}
