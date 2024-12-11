
public class T1 {
    
    public String palavras[];
    public boolean ocupado[];
    public T2 t2;

    public T1(){

        palavras = new String[10];
        ocupado = new boolean[10];
        t2 = new T2();

    }

    public int hashT1(char c){

        return  c % 10;

    }

    public int rehashT1(char c){

        return ++c % 10;

    }

    public void inserir(String palavra){

        int index = hashT1(palavra.charAt(palavra.length() - 1));

        if(!ocupado[index]){

            palavras[index] = palavra;
            ocupado[index] = true;

        }else{

            index = rehashT1(palavra.charAt(palavra.length() - 1));

            if(!ocupado[index]){

                palavras[index] = palavra;
                ocupado[index] = true;

            }else{

                t2.inserir(palavra);

            }

        }

    }

    public boolean pesquisar(String palavra){

        int index = hashT1(palavra.charAt(palavra.length() - 1));

        if(ocupado[index] && palavras[index].equals(palavra)){

            return true;

        }else{

            index = rehashT1(palavra.charAt(palavra.length() - 1));

            if(ocupado[index] && palavras[index].equals(palavra)){

                return true;

            }else{

                return t2.pesquisar(palavra);

            }

        }

    }

}
