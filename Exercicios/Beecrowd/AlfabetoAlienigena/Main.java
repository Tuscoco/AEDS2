import java.util.*;

/**
 * Main
 */

public class Main {

    public static boolean verificar(String alfabeto, String mensagem){

        boolean resp = true;
        int tmp;
        
        for(int i = 0;i < alfabeto.length();i++){

            tmp = 0;

            for(int j = 0;j < mensagem.length();j++){

                if(mensagem.charAt(j) == alfabeto.charAt(i)){
                    tmp++;
                }

            }

            if(tmp == 0){

                resp = false;
                i = alfabeto.length();

            }

        }

        return resp;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int k = scan.nextInt();
        int n = scan.nextInt();

        scan.nextLine();

        String alfabeto = scan.nextLine();

        String mensagem = scan.nextLine();

        if(verificar(alfabeto, mensagem)){

            System.out.println("S");

        }else{

            System.out.println("N");

        }

        scan.close();

    }
    
}