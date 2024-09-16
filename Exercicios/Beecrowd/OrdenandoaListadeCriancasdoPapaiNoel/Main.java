import java.util.*;

/**
 * Main
 */

public class Main {

    public static int[] verificarComportamento(String[] array){

        int[] comportamento = {0,0};

        for(int i = 0;i < array.length;i++){

            if(array[i].charAt(0) == '+'){

                array[i] = array[i].replace("+ ","");
                comportamento[0]++;

            }else{

                array[i] = array[i].replace("- ","");
                comportamento[1]++;

            }

        }

        Arrays.sort(array);

        return comportamento;

    }
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        String[] array = new String[n];

        for(int i = 0;i < n;i++){

            array[i] = scan.nextLine();

        }

        int[] comp = verificarComportamento(array);

        for(String x : array){

            System.out.println(x);

        }

        System.out.println("Se comportaram: " + comp[0] + " | " + "Nao se comportaram: " + comp[1]);

        scan.close();
        
    }
    
}