import java.util.*;

/**
 * Sorvete
 */

public class Sorvete {

    public static int cont = 1;
    
    public static void verificarIntervalo(int[] array) {

        List<Integer> list = new ArrayList<>();

        for(int x : array){
            list.add(x);
        }
        
        boolean terminou = false;
        int j = 1;

        while(!terminou){

            if(list.get(j) <= list.get(j - 1)){
                list.remove(j);
            }else{
                j++;
            }

            if(j == list.size()){
                terminou = true;
            }
            
        }

        if(list.size() == 3){
            list.remove(1);
        }

        System.out.println("Teste " + cont);
        j = 0;
        while(!list.isEmpty()){
            System.out.print(list.remove(j) + " ");
            System.out.println(list.remove(j));
        }
        
        cont++;

    } 
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int p = 0,s = 0;
        
        do{

            p = scan.nextInt();
            s = scan.nextInt();

            if(p != 0 && s != 0){

                int[] array = new int[s * 2];

                for(int i = 0;i < array.length;i++){
                    array[i] = scan.nextInt();
                }

                verificarIntervalo(array);

            }

        }while(p != 0 && s != 0);

        scan.close();
        
    }
    
}