import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();

        String str2 = scan.nextLine();

        String str3 = scan.nextLine();

        if(str3.equals("nao")){

            System.out.println(str1 + str2);

        }else{

            String[] array = str1.split(" " + str3);

            System.out.println(array[0] + " " + str2 + " " + str3 + array[1]);

        }

        scan.close();

    }
    
}