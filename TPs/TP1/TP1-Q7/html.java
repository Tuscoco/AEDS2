import java.io.*;
import java.util.*;
import java.net.*;

/**
 * html
 */

public class html {

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
           // nothing to see here
  
        }
  
        return resp;
     }

     public static boolean fim(String str){

        boolean fim = false;

        if(str.equals("FIM")){

            fim = true;

        }

        return fim;

     }

    public static void main(String[] args){
        
        MyIO.setCharset("UTF-8");
        Scanner scan = new Scanner(System.in);

        String name = "";
        String endereco = "";
        String html = "";
        int br = 0,table = 0,consoantes = 0;


        do{}

        scan.close();

    }
    
}

//NAO SEI FAZER