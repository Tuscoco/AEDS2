public class bolha {
    
    public static int comp = 0;

    public static void swap(int j,int jj,int[] array){

        int temp = array[j];
        array[j] = array[jj];
        array[jj] = temp;

    }
    
    public static void ordenar(int[] array){

        int n = array.length;

        for(int i = 0;i < n - 1;i++){

            for(int j = 0;j < n - 1;j++){

                comp++;
                if(array[j] > array[j + 1]){

                    swap(j, j + 1, array);

                }

            }

        }

    }
    
    public static void main(String[] args) {
        
        int[] array = {10,9,8,7,6,5,4,3,2,1};

        System.out.print("[ ");
        for(int i = 0;i < array.length;i++){

            System.out.print(array[i] + " ");

        }
        System.out.println("]");
        
        ordenar(array);

        System.out.print("[ ");
        for(int i = 0;i < array.length;i++){

            System.out.print(array[i] + " ");

        }
        System.out.println("]");

        System.out.println();

        System.out.println(comp);

    }

}
