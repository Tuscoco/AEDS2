import java.util.*;

/**
 * Main
 */

public class Main {

    public static void ordenar(String[] str){

        boolean trocou = true;
        int n = str.length;

        for(int i = (n - 1);i > 0 && trocou;i--){

            trocou = false;

            for(int j = 0;j < i;j++){

                if(str[j].compareTo(str[j + 1]) > 0){

                    String tmp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = tmp;
                    trocou = true;

                }

            }

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine();

        String[] array = new String[n];

        for(int i = 0;i < n;i++){
            array[i] = scan.nextLine();
        }

        ordenar(array);

        System.out.println(array[k - 1]);

        scan.close();

    }
    
}