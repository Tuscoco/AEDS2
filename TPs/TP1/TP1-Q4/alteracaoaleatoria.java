import java.util.*;

public class alteracaoaleatoria {

    static Random gerador = new Random();
    
    public static boolean fim(String str){

        boolean resultado = false;

        if(str.equals("FIM")){
            resultado = true;
        }

        return resultado;
    }

    public static char charAleatorio(){

        char caractere = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));

        return caractere;

    }

    public static String trocar(String str){

        char caractere1 = charAleatorio();
        char caractere2 = charAleatorio();
        char[] strchar = str.toCharArray();

        for(int i = 0; i < str.length();i++){

            if(str.charAt(i) == caractere1){
                strchar[i] = caractere2;
            }
            
        }

        String resultado = new String(strchar);

        return resultado;
    }
    
    public static void main(String[] args) {
        
        String[] str = new String[100];
        int i = 0;

        while(!fim(str[i] = MyIO.readString())){

            if(!fim(str[i])){

                str[i] = trocar(str[i]);

            }
            
            i++;
            
        }

        for(int j = 0; j < i;j++){
            System.out.println(str[j]);
        }
        
    }

}
