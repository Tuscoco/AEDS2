import java.util.*;

/**
 * Main
 */

public class Main {

    private static int[] array;
    
    public static boolean pode(){

        boolean isTrue = true;
        
        for(int i = 1;i < array.length;i+=2){

            for(int j = i + 2;j < array.length;j+=2){

                if(array[j] >= array[i]){
                    isTrue = false;
                }

            }

        }

        return isTrue;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n,k;

        do{

            n = scan.nextInt();
            k = scan.nextInt();

            if(n != 0 && k != 0){

                array = new int[n * 2];

                for(int i = 0;i < array.length;i+=2){

                    array[i] = scan.nextInt();
                    array[i + 1] = scan.nextInt();

                }

                if(!pode()){
                    System.out.println("Sim");
                }else{
                    System.out.println("Nao");
                }

            }

        }while(n != 0 && k != 0);

        scan.close();

    }
    
}