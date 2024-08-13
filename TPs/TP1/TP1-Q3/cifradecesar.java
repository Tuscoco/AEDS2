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

                int temp = letra + chave;

                temp -= 94;
    
                resultadochar[i] = (char) temp;


            }else if(letra < 32 || letra > 126 || (char) letra == '�'){

                resultadochar[i] = (char) letra;

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

    public static String tratarString(String str){

        char[] array = str.toCharArray();

        for(int i = 0;i < str.length();i++){

            if(array[i] == 'ﾢ'){
                array[i] = '�';
            }

        }

        return new String(array);

    }
    
    public static void main(String[] args) {

        String str = "START";
        Scanner scan = new Scanner(System.in);

        do{

            //str = MyIO.readLine();
            str = scan.nextLine();

            if(!fim(str)){

                String temp = criptografar(str);

                System.out.println(tratarString(temp));

            }

        }while(!fim(str));

        scan.close();

    }

}