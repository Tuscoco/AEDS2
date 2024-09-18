import java.util.*;

/**
 * Main
 */

public class Main {

    public static String verificar(String[] array){

        boolean possui = false;
        String resultado = "";

        for(int i = 0;i < array.length;i++){

            if(array[i].equals("Beiju")){

                possui = true;
                array[i] = "";

            }

        }

        resultado = String.join("_", array);

        if(possui){

            return "Beiju" + resultado;

        }else{

            return resultado;

        }



    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()){

            String str = scan.nextLine();

            str = str.replace("[", "");
            str = str.replace("]", "");

            String[] array = str.split("_");

            System.out.println(verificar(array));

        }

        scan.close();

    }
    
}