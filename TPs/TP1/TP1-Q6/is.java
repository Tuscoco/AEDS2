import java.util.*;

public class is {
    
    public static boolean real(String str){

        int i = 0;
        boolean resultado = true;
        str = str.replace(",",".");

        for(i = 0;i < str.length();i++){

            char num = str.charAt(i);
            int ascii = num;

            if(!(ascii >= 46 && ascii <= 57)){

                resultado = false;
                i = str.length();

            }

        }

        return resultado;
    }
    
    public static boolean inteiro(String str){

        int i = 0;
        boolean resultado = true;

        for(i = 0;i < str.length();i++){

            char num = str.charAt(i);
            int ascii = num;

            if(!(ascii >= 48 && ascii <= 57)){

                resultado = false;
                i = str.length();

            }

        }

        return resultado;
    }
    
    public static boolean consoantes(String str){
        char[] vogaisM = {'a','e','i','o','u'};
        int i = 0, j = 0;
        int v = 0;
        boolean resultado = false;

        for(i = 0;i < str.length();i++){

            char letra = Character.toLowerCase(str.charAt(i));
            int ascii = letra;

            if(ascii >= 97 && ascii <= 122){

                for(j = 0;j < 5;j++){

                    if(letra != vogaisM[j]){

                        v++;

                    }
                    
                }

            }

        }

        if(v == str.length() * 5){

            resultado = true;

        }

        return resultado;
    }
    
    public static boolean vogais(String str){
        char[] vogaisM = {'a','e','i','o','u'};
        int i = 0, j = 0;
        int v = 0;
        boolean resultado = false; 

        for(i = 0;i < str.length();i++){

            char letra = Character.toLowerCase(str.charAt(i));

            for(j = 0;j < 5;j++){

                if(letra == vogaisM[j]){
                
                    v++;
                
                }

            }

        }

        if(v == (str.length())){

            resultado = true;

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
        Scanner scan = new Scanner(System.in);

        do{

            str = scan.nextLine();

            if(!fim(str)){

                if(vogais(str)){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }

                if(consoantes(str)){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }

                if(inteiro(str)){
                    System.out.print("SIM ");
                }else{
                    System.out.print("NAO ");
                }

                if(real(str)){
                    System.out.print("SIM");
                }else{
                    System.out.print("NAO");
                }

                System.out.println("");

            }

        }while(!fim(str));

        scan.close();

    }

}
