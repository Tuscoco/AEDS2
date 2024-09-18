import java.util.*;

/**
 * Main
 */

public class Main {

    public static int leds(String str){

        int cont = 0;
        
        for(int i = 0;i < str.length();i++){

            if(str.charAt(i) == '1'){

                cont += 2;

            }else if(str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '5'){

                cont += 5;

            }else if(str.charAt(i) == '4'){

                cont += 4;

            }else if(str.charAt(i) == '6' || str.charAt(i) == '0' || str.charAt(i) == '9'){

                cont += 6;

            }else if(str.charAt(i) == '7'){

                cont += 3;

            }else if(str.charAt(i) == '8'){

                cont += 7;

            }

        }

        return cont;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        for(int i = 0;i < n;i++){

            String str = scan.nextLine();

            System.out.println(leds(str) + " leds");

        }

        scan.close();

    }
    
}