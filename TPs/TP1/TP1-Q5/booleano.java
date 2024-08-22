import java.util.*;

/**
 * booleano
 */

 public class booleano {
    
    public static boolean OR(boolean c,boolean c2){
        return (c || c2);
    }
    
    public static boolean AND(boolean c,boolean c2){
        return (c && c2);
    }
    
    public static boolean NOT(boolean c){
        return !(c);
    }

    public static boolean fim(int n){

        boolean resultado = false;

        if(n == 0){

            resultado = true;

        }

        return resultado;

    }
    
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n;
        
        do{

            n = scan.nextInt();

            if(!fim(n)){

                int[] letras = new int[n];
    
                for(int i = 0;i < n;i++){
        
                    letras[i] = scan.nextInt();
        
                }

                String algBoo = scan.nextLine();

            }

        }while(!fim(n));

        scan.close();

    }
    
}