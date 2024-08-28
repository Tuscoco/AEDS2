import java.util.*;

public class isrecursivo {
    
    public static boolean real(String str,int c){

        boolean resultado;

        if(c == str.length()){

            resultado = true;
            return resultado;

        }

        char letra = str.charAt(c);
        int ascii = letra;

        if(!(ascii >= 46 && ascii <= 57)){

            resultado = false;

        }else{

            return real(str,c + 1);

        }

        return resultado;

    }
    public static boolean real(String str){
        return real(str, 0);
    }
    
    public static boolean inteiro(String str,int c){

        boolean resultado;

        if(c == str.length()){

            resultado = true;
            return resultado;

        }

        char letra = str.charAt(c);
        int ascii = letra;

        if(ascii < 48 || ascii > 57){

            resultado = false;

        }else{

            return inteiro(str,c + 1);

        }

        return resultado;

    }
    public static boolean inteiro(String str){
        return inteiro(str, 0);
    }


    public static char[] vogaisM = {'a','e','i','o','u'};

    
    public static boolean consoantes(String str,int c){

        boolean resultado;

        if(c == str.length()){

            resultado = true;
            return resultado;

        }

        char letra = Character.toLowerCase(str.charAt(c));
        int ascii = letra;
        
        if((letra == vogaisM[0]) || (letra == vogaisM[1]) || (letra == vogaisM[2]) || (letra == vogaisM[3]) || (letra == vogaisM[4])){

            resultado = false;

        }else if(ascii < 97 || ascii > 122){

            resultado = false;

        }else{

            return consoantes(str,c + 1);

        }

        return resultado;

    }
    public static boolean consoantes(String str){
        return consoantes(str, 0);
    }
    
    public static boolean vogais(String str,int c){
        
        boolean resultado;

        if(c == str.length()){

            resultado = true;
            return resultado;

        }

        char letra = Character.toLowerCase(str.charAt(c));
        
        if((letra != vogaisM[0]) && (letra != vogaisM[1]) && (letra != vogaisM[2]) && (letra != vogaisM[3]) && (letra != vogaisM[4])){

            resultado = false;

        }else{

            return vogais(str,c + 1);

        }

        return resultado;

    }
    public static boolean vogais(String str){
        return vogais(str, 0);
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
        String str = "";

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
