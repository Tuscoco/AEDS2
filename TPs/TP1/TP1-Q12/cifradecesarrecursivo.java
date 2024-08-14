/**
 * cifradecesar
 */

 public class cifradecesarrecursivo {

    public static int verificarIndex(char c){
        int i;
        int index = 0;

        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for(i = 0; i < alfabeto.length;i++){

            if(c == alfabeto[i]){
                index = i;
                break;
            }

        }

        return index;
    }
    
    public static String criptografar(String str, int chave){
        return criptografar(str, chave,0,new char[str.length()]);
    }
    
    public static String criptografar(String str, int chave,int c,char[] resultadochar){
        char[] strchar = str.toCharArray();
        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String resultado = new String();
        
        if(c == str.length()){
            
            resultado = new String(resultadochar);

        }else{

            int index = verificarIndex(strchar[c]);

            if(index + chave >= alfabeto.length){
                int temp = index + chave;

                temp -= alfabeto.length;

                resultadochar[c] = alfabeto[temp];
            }else{
                resultadochar[c] = alfabeto[index + chave];
            }

            return criptografar(str, chave, c + 1,resultadochar);

        }

        return resultado;
    }

    public static boolean fim(String str){

        boolean resultado = false;

        if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){

            resultado = true;

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        int chave = 3;

        String str = MyIO.readString();

        String result = criptografar(str, chave);

        System.out.println(result);

    }

}