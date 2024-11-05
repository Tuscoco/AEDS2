import java.util.*;

public class Main {

    public static int ordenar(int[] array){

        int cont = 0;

        for(int i = 1;i < array.length;i++){

            int tmp = array[i];
            int j = i - 1;

            while((j >= 0) && (array[j] > tmp)){

                array[j + 1] = array[j];
                j--;
                cont++;

            }

            array[j + 1] = tmp;

        }

        return cont;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 0;i < n;i++){

            int quant = scan.nextInt();

            int[] array = new int[quant];

            for(int j = 0;j < quant;j++){

                array[j] = scan.nextInt();

            }

            int cont = ordenar(array);

            System.out.println(cont);

        }

        scan.close();

    }

}
