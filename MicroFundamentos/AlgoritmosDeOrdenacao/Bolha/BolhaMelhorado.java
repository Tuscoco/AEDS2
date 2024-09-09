import java.util.*;

public class BolhaMelhorado {
    
    public static void swap(int j,int jj,int[] array){

        int temp = array[j];
        array[j] = array[jj];
        array[jj] = temp;

    }
    
    public static void ordenar(int[] array){

        boolean swapped = true;
        for(int i = (array.length - 1);i > 0 && swapped;i--){

            swapped = false;

            for(int j = 0;j < i;j++){

                if(array[j] > array[j + 1]){

                    swap(j, j + 1, array);
                    swapped = true;

                }

            }

        }

    }
    
    public static void main(String[] args) {
        
        int[] array = {10,9,8,7,6,5,4,3,2,1};

        System.out.print("[");
        for(int i = 0;i < array.length;i++){

            System.out.print(array[i] + " ");

        }
        System.out.println("]");
        
        ordenar(array);

        System.out.print("[");
        for(int i = 0;i < array.length;i++){

            System.out.print(array[i] + " ");

        }
        System.out.println("]");

    }

}
