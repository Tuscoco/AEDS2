import java.util.*;

/**
 * Main
 */

public class Main {

    public static int verificarAcao(String str,int abas){

        if(str.equals("fechou")){

            abas++;

        }else if(str.equals("clicou")){

            abas--;

        }

        return abas;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int abas = scan.nextInt(),acoes = scan.nextInt();

        for(int i = 0;i < acoes;i++){

            String str = scan.nextLine();

            abas = verificarAcao(str, abas);

        }

        System.out.println(abas - 1);

        scan.close();

    }
    
}