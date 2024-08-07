import java.util.*;

public class is {
    
    public static boolean real(String str){
        char[] strchar = str.toCharArray();
        char[] algarismos = {'1','2','3','4','5','6','7','8','9','0','.'};
        int i = 0, j = 0;
        int v;
        boolean resultado = true;

        for(i = 0;i < str.length();i++){

            v = 0;

            for(j = 0;j < algarismos.length;j++){
                if(strchar[i] == algarismos[j]){
                    v++;
                }
            }

            if(v != 1){
                resultado = false;
                i = str.length();
            }

        }

        return resultado;
    }
    
    public static boolean inteiro(String str){
        char[] strchar = str.toCharArray();
        char[] algarismos = {'1','2','3','4','5','6','7','8','9','0'};
        int i = 0, j = 0;
        int v;
        boolean resultado = true;

        for(i = 0;i < str.length();i++){

            v = 0;

            for(j = 0;j < algarismos.length;j++){
                if(strchar[i] == algarismos[j]){
                    v++;
                }
            }

            if(v != 1){
                resultado = false;
                i = str.length();
            }

        }

        return resultado;
    }
    
    public static boolean consoantes(String str){
        char[] strchar = str.toCharArray();
        char[] vogais = {'a','e','i','o','u'};
        char[] algarismos = {'1','2','3','4','5','6','7','8','9','0'};
        int i = 0, j = 0;
        int v,n;
        boolean resultado = true;

        for(i = 0; i < str.length();i++){

            v = 0;
            n = 0;

            for(j = 0; j < vogais.length; j++){
                if(strchar[i] != vogais[j]){
                    v++;
                }
                if(strchar[i] == algarismos[j]){
                    n++;
                }
            }

            if(v != 5 || n != 0){
                resultado = false;
                i = str.length();
            }

        }

        return resultado;
    }
    
    public static boolean vogais(String str){
        char[] strchar = str.toCharArray();
        char[] vogais = {'a','e','i','o','u'};
        int i = 0, j = 0;
        int v;
        boolean resultado = true;

        for(i = 0; i < str.length();i++){

            v = 0;

            for(j = 0; j < vogais.length; j++){
                if(strchar[i] == vogais[j]){
                    v++;
                }
            }

            if(v != 1){
                resultado = false;
                i = str.length();
            }

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
        
        String str = "";

        do{

            str = MyIO.readString();

            if(!fim(str)){

                if(vogais(str)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

                if(consoantes(str)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

                if(inteiro(str)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

                if(real(str)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

            }

        }while(!fim(str));

    }

}
