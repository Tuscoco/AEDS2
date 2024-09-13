import java.util.*;

/**
 * Main
 */

public class Main {

    public static int procurar(int[] array,int cha){

        int resp = 0;
        
        for(int x : array){

            if(x == cha){
                resp++;
            }

        }

        return resp;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] array = new int[5];

        int cha = scan.nextInt();

        for(int i = 0;i < array.length;i++){

            array[i] = scan.nextInt();
            
        }

        int acertos = procurar(array, cha);

        System.out.println(acertos);

        scan.close();

    }
    
}