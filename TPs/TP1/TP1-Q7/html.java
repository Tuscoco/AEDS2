import java.io.*;
import java.util.*;
import java.net.*;

/**
 * html
 */

public class html {

   public static int[] vogais;

   public static final char[] caracteresEspeciais = {
      225,
      233,
      237, 
      243,
      250,
      224,
      232,
      236,
      242, 
      249,
      227,
      245,
      226,
      234,
      238,
      244,
      251 
   };

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("deprecation")
    public static String getHtml(String endereco){

        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
  
        try {
           url = new URL(endereco);
           is = url.openStream();  // throws an IOException
           br = new BufferedReader(new InputStreamReader(is));
  
           while ((line = br.readLine()) != null) {
              resp += line + "\n";
           }
        } catch (MalformedURLException mue) {
           mue.printStackTrace();
        } catch (IOException ioe) {
           ioe.printStackTrace();
        } 
  
        try {
           is.close();
        } catch (IOException ioe) {

  
        }
  
        return resp;

     }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public static void contarVogais(String site){

      vogais = new int[23];

      for(int i = 0;i < site.length();i++){

         char caractere = site.charAt(i);

         if(caractere == 'a'){

            vogais[0]++;

         }else if(caractere == 'e'){

            vogais[1]++;

         }else if(caractere == 'i'){

            vogais[2]++;

         }else if(caractere == 'o'){

            vogais[3]++;

         }else if(caractere == 'u'){

            vogais[4]++;

         }else if(caractere == caracteresEspeciais[0]){

            vogais[5]++;

         }else if(caractere == caracteresEspeciais[1]){

            vogais[6]++;

         }else if(caractere == caracteresEspeciais[2]){

            vogais[7]++;

         }else if(caractere == caracteresEspeciais[3]){

            vogais[8]++;

         }else if(caractere == caracteresEspeciais[4]){

            vogais[9]++;

         }else if(caractere == caracteresEspeciais[5]){

            vogais[10]++;

         }else if(caractere == caracteresEspeciais[6]){

            vogais[11]++;

         }else if(caractere == caracteresEspeciais[7]){

            vogais[12]++;

         }else if(caractere == caracteresEspeciais[8]){

            vogais[13]++;

         }else if(caractere == caracteresEspeciais[9]){

            vogais[14]++;

         }else if(caractere == caracteresEspeciais[10]){

            vogais[15]++;

         }else if(caractere == caracteresEspeciais[11]){

            vogais[16]++;

         }else if(caractere == caracteresEspeciais[12]){

            vogais[17]++;

         }else if(caractere == caracteresEspeciais[13]){

            vogais[18]++;

         }else if(caractere == caracteresEspeciais[14]){

            vogais[19]++;

         }else if(caractere == caracteresEspeciais[15]){

            vogais[20]++;

         }else if(caractere == caracteresEspeciais[16]){

            vogais[21]++;

         }

      }

     }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public static int contarConsoantes(String site){

      String c = "bcdfghjklmnpqrstvwxyz";
      int resultado = 0;

      for(int i = 0;i < c.length();i++){

         char caractere = c.charAt(i);

         for(int j = 0;j < site.length();j++){

            char h = site.charAt(j);

            if(h == caractere){

               resultado++;

            }

         }

      }

      return resultado;

     }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public static int contarBRs(String site){}

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public static boolean fim(String str){

        boolean fim = false;

        if(str.equals("FIM")){

            fim = true;

        }

        return fim;

     }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args){
        
        MyIO.setCharset("UTF-8");
        Scanner scan = new Scanner(System.in);

        String name = "";
        String endereco = "";
        String html = "";
        int br = 0,table = 0,consoantes = 0;


        do{

         name = scan.nextLine();

         if(!fim(name)){

            endereco = scan.nextLine();

            html = getHtml(endereco);

         }

        }while(!fim(name));

        scan.close();

    }
    
}