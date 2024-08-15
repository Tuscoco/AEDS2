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

                if(letra >= 32 && letra <= 126){

                    int temp = letra + chave;

                    temp -= 94;
        
                    resultadochar[i] = (char) temp;

                }else{

                    resultadochar[i] = str.charAt(i);

                }

            }else if(letra >= 32 && letra <= 126){

                resultadochar[i] = (char) (letra + chave);

            }else{

                resultadochar[i] = str.charAt(i);

            }

        }

        String result = new String(resultadochar);

        String resultado = result.replace("ï¿½","�");

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

        do{

            str = MyIO.readLine();

            if(!fim(str)){

                String temp = criptografar(str);

                System.out.println(temp);

            }

        }while(!fim(str));

    }

}