/**
 * pesquisabinaria
 */

public class pesquisabinaria {

    public static boolean pb(int[] array,int x){

        boolean resultado = false;

        int esq = 0,dir = array.length - 1,meio;

        while(esq <= dir){

            meio = (dir + esq)/2;

            if(x == array[meio]){

                resultado = true;
                esq = array.length;

            }else if(x > meio){

                esq = meio + 1;

            }else{

                dir = meio - 1;

            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        int[] array = {12,43,65,234,56,345,76,43,8,86,435,56,786,43,33};

        int x = MyIO.readInt();

        boolean resp = pb(array, x);

        if(resp){

            System.out.println("SIM");

        }else{

            System.out.println("NAO");

        }

    }
    
}