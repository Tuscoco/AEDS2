import java.util.*;

/**
 * cifradecesar
 */

public class cifradecesar {
    
    public static String criptografar(String str, int chave){

        int i = 0;
        char[] resultadochar = str.toCharArray();

        for(i = 0;i < str.length();i++){

            int letra = str.charAt(i);

            if(letra + chave > 126){

                if(str.charAt(i) == '�'){

                    resultadochar[i] = (char) (letra + chave);

                }else{

                    int temp = letra + chave;

                    temp -= 94;
    
                    resultadochar[i] = (char) temp;

                }

            }else{

                resultadochar[i] = (char) (letra + chave);

            }

        }

        String resultado = new String(resultadochar);
        return resultado;

    }

    public static String criptografar(String str){
        return criptografar(str, 3);
    }

    public static boolean fim(String str){

        boolean resultado = false;

        if(str.equals("FIM")){
            resultado = true;
        }

        return resultado;

    }
    
    public static void main(String[] args) {

        String str = "START";
        Scanner scan = new Scanner(System.in);

        do{

            //str = MyIO.readLine();
            str = scan.nextLine();

            if(!fim(str)){

                System.out.println(criptografar(str));

            }

        }while(!fim(str));

        scan.close();

    }

}