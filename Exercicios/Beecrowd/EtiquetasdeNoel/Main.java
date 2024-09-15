import java.util.*;

/**
 * Main
 */

public class Main {

    public static int verificarIndice(String[] str,String s){

        int resp = 0;
        
        for(int i = 0;i < str.length;i++){

            if(str[i].equals(s)){
                resp = i;
                i = str.length;
            }

        }

        return resp;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        String[] str = new String[n * 2];

        for(int i = 0;i < n * 2;i++){
            str[i] = scan.nextLine();
        }

        int m = scan.nextInt();
        scan.nextLine();

        for(int i = 0;i < m;i++){

            String crianca = scan.nextLine();
            String palavra = scan.nextLine();

            int ind = verificarIndice(str, palavra);

            System.out.println(crianca);
            System.out.println(str[ind + 1]);
            System.out.println();

        }

        scan.close();

    }
    
}