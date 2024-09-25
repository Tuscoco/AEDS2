/**
 * merge
 */

public class merge {

    public static void ordenar(int[] array){
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