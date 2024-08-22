
import java.util.*;

public class selecao {
    
    public static void swap(int menor,int i,int[] array){

        int temp = array[menor];
        array[menor] = array[i];
        array[i] = temp;

    }

    public static void ordenar(int[] array){

        int n = array.length;

        for(int i = 0;i < (n - 1);i++){

            int menor = i;

            for(int j = (i + 1);j < n;j++){

                if(array[menor] > array[j]){

                    menor = j;

                }

            }

            swap(menor, i, array);

        }

    }
    
    public static void main(String[] args) {
        
        int[] array = {10,9,8,7,6,5,4,3,2,1};

        ordenar(array);

        for(int i = 0;i < array.length;i++){

            System.out.println(array[i]);

        }

    }

}
