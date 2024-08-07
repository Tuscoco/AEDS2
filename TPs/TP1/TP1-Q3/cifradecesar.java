/**
 * cifradecesar
 */

public class cifradecesar {

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
        char[] strchar = str.toCharArray();
        char[] resultadochar = new char[str.length()];
        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int i = 0;

        for(i = 0;i < str.length();i++){

            int index = verificarIndex(strchar[i]);

            if(index + chave > alfabeto.length){
                int temp = index + chave;

                temp -= alfabeto.length;

                resultadochar[i] = alfabeto[temp];
            }else{
                resultadochar[i] = alfabeto[index + chave];
            }

        }

        String resultado = new String(resultadochar);
        return resultado;
    }
    
    public static void main(String[] args) {
        
        int chave = 3;

        String str = MyIO.readString();

        String result = criptografar(str, chave);

        System.out.println(result);

    }

}