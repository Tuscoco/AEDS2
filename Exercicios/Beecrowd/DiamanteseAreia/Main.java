import java.util.*;

/**
 * Main
 */

public class Main {

    public static int contar(String str){

        boolean retirou = true;
        int cont = 0;
        List<Character> lista = new ArrayList<>();

        for(int i = 0;i < str.length();i++){
            lista.add(str.charAt(i));
        }

        while(retirou){

            retirou = false;

            for(int i = 0;i < lista.size() - 1;i++){

                if(lista.get(i) == '<' && lista.get(i + 1) == '>'){

                    cont++;
                    lista.remove(i);
                    lista.remove(i);

                    retirou = true;
                    i = lista.size();

                }

            }

        }

        return cont;

    }
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        for(int i = 0;i < n;i++){

            String str = scan.nextLine();

            str = str.replace(".", "");

            System.out.println(contar(str));

        }

        scan.close();
        
    }
    
}