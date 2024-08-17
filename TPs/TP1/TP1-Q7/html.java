import java.io.*;
import java.net.*;

/**
 * html
 */

public class html {

    @SuppressWarnings("deprecation")
    public static String dadosPagina(String end,String name){

        String resultado = "",line;
        URL url;
        InputStream is = null;
        BufferedReader br;
        int a=0,e=0,i=0,o=0,u=0,a1=0,e1=0,i1=0,o1=0,u1=0,a2=0,e2=0,i2=0,o2=0,u2=0,ah=0,eh=0,a3=0,e3=0,i3=0,o3=0,u3=0,consoante=0;
        int b=0,table=0;

        try{

            url = new URL(end);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){

                for(int j = 0;j < line.length();j++){

                    char caractere = line.charAt(j);
                    int c = caractere;

                }

            }

        }catch(MalformedURLException mue){
            mue.getMessage();
        }catch(IOException e){
            e.getMessage();
        }

        return resultado;

    }
    
    public static void main(String[] args){
        
    }
    
}

//NAO SEI FAZER