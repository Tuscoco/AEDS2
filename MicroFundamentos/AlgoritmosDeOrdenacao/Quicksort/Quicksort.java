/**
 * Quicksort
 */

public class Quicksort {

    public static int[] array = {10,9,8,7,6,5,4,3,2,1};
    
    public static void swap(int n,int n2){
        int tmp = array[n];
        array[n] = array[n2];
        array[n2] = tmp;
    }
    
    public static void sort(int esq,int dir){

        int i = esq;
        int j = dir;
        int pivo = array[(esq + dir)/2];

        while(i <= j){

            while(array[i] < pivo){
                i++;
            }
            while(array[j] > pivo){
                j--;
            }

            if(i <= j){
                swap(i, j);
                i++;
                j--;
            }

        }

        if(esq < j){
            sort(esq, j);
        }

        if(i < dir){
            sort(i, dir);
        }

    }
    
    public static void main(String[] args) {
        
        System.out.print("[ ");
        for(int x : array){
            System.out.print(x + " ");
        }
        System.out.println("]");
        
        sort(0, array.length - 1);

        System.out.print("[ ");
        for(int x : array){
            System.out.print(x + " ");
        }
        System.out.println("]");

    }
    
}