import java.util.*;

/**
 * Main
 */

public class Main {
    
    public static boolean verificar(String str){

        boolean resultado = true;
        int length = 0;
        
        for(int i = 0;i < str.length();i++){

            if(str.charAt(i) == '(' || str.charAt(i) == ')'){

                length++;

            }

        }
        
        char[] parenteses = new char[length];
        for(int i = 0,j = 0;i < str.length();i++){

            if(str.charAt(i) == '(' || str.charAt(i) == ')'){

                parenteses[j] = str.charAt(i);
                j++;

            }

        }

        if(parenteses.length % 2 == 0){

            int contA = 0;
            int contF = 0;

            for(int i = 0;i < parenteses.length;i++){

                if(parenteses[i] == '('){

                    contA++;

                }else if(parenteses[i] == ')'){

                    contF++;

                    if(i == 0){

                        resultado = false;

                    }

                }

            }

            if(contA != contF){

                resultado = false;

            }

        }else{

            resultado = false;

        }

        return resultado;

    }
    
    public static boolean fim(String str){

        boolean resultado = false;

        if(str.equals("FIM")){

            resultado = true;

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String str = new String();

        do{

            str = scan.nextLine();

            if(!fim(str)){

                if(verificar(str)){

                    System.out.println("correto");

                }else{

                    System.out.println("incorreto");

                }

            }

        }while(!fim(str));

        scan.close();

    }
    
}