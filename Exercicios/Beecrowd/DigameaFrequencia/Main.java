import java.util.*;

/**
 * Main
 */

public class Main {

    public static int verificarFrequencia(String str,char c){}

    public static void mostrar(String str){
        
        List<Integer> lista = new ArrayList<>();
        
        for(int i = 0;i < str.length();){

            lista.add((int) str.charAt(i));
            i += verificarFrequencia(str, str.charAt(i));

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()){

            String str = scan.nextLine();

        }

        scan.close();

    }
    
}