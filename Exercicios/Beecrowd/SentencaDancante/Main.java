import java.util.*;

/**
 * Main
 */

public class Main {

    public static String dancar(String str){

        int cont = 0;
        char[] strChar = str.toCharArray();

        for(int i = 0;i < str.length();i++){

            if(strChar[i] != ' '){

                if(cont % 2 == 0){

                    char c = strChar[i];
                    strChar[i] = (char) Character.toUpperCase(c);
                    cont++;

                }else{

                    cont++;

                }

            }

        }

        return new String(strChar);

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()){

            String str = scan.nextLine();

            System.out.println(dancar(str));

        }

        scan.close();

    }
    
}