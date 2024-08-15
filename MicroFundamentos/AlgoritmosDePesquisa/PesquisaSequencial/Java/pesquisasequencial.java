/**
 * pesquisasequencial
 */

public class pesquisasequencial {

    public static boolean ps(int[] array,int x){

        boolean resultado = false;

        for(int i = 0;i < array.length;i++){

            if(x == array[i]){

                resultado = true;
                i = array.length;

            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        int[] array = {12,43,5,3564,32,5,656,23,54,7623,7,34,867,23,756,98,34};

        System.out.print("Informe um numero: ");
        int x = MyIO.readInt();

        boolean resp = ps(array, x);

        if(resp){

            System.out.println("O numero " + x + " esta presente no array!");

        }else{

            System.out.println("O numero " + x + " NAO esta presente no array!");

        }

    }
    
}
