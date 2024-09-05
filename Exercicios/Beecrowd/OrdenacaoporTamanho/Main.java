import java.util.*;

/**
 * Main
 */

public class Main {

    public static void ordenar(String[] arrayStr){

        for(int i = 1;i < arrayStr.length;i++){

            String temp = arrayStr[i];
            int j = i - 1;

            while((j >= 0) && (arrayStr[j].length() < temp.length())){

                arrayStr[j + 1] = arrayStr[j];
                j--;

            }

            arrayStr[j + 1] = temp;

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        for(int i = 0;i < n;i++){

            String str = scan.nextLine();

            String[] arrayStr = str.split(" ");

            ordenar(arrayStr);

            String resultado = String.join(" ", arrayStr);

            System.out.println(resultado);

        }

        scan.close();

    }
    
}