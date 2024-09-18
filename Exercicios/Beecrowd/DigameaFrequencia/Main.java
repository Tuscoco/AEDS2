import java.util.*;

/**
 * Main
 */

public class Main {

    public static int verificarFrequencia(String str,char c){

        int n = 0;
        for(int i = 0;i < str.length();i++){

            if(c == str.charAt(i)){
                n++;
            }

        }

        return n;

    }

    public static void mostrar(String str){
        
        List<Integer> lista = new ArrayList<>();
        
        for(int i = 0;i < str.length();){

            lista.add((int) str.charAt(i));
            int c = verificarFrequencia(str, str.charAt(i));
            lista.add(c);
            i += c;

        }

        while(!lista.isEmpty()){

            for(int i = 1;i < lista.size();i+=2){

                int menor = i;
    
                for(int j = (i + 2);j < lista.size();j+=2){
    
                    if(lista.get(i) > lista.get(j)){
    
                        menor = j;
    
                    }
    
                }
    
                int n1 = lista.remove(menor);
                int n2 = lista.remove(menor - 1);
                
                System.out.println(n2 + " " + n1);
                
            }

        }

        System.out.println();

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()){

            String str = scan.nextLine();

            mostrar(str);

        }

        scan.close();

    }
    
}