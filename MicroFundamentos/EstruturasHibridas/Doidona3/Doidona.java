
public class Doidona {

    private No raiz;

    public Doidona(){

        raiz = null;

    }

    public void inserir(String palavra){

        raiz = inserir(palavra, raiz);

    }

    private No inserir(String palavra, No i){

        if(i == null){

            i = new No(palavra.charAt(0));

        }else if(palavra.charAt(0) < i.letra){

            i.esq = inserir(palavra, i.esq);

        }else if(palavra.charAt(0) > i.letra){

            i.dir = inserir(palavra, i.dir);

        }else{

            i.t1.inserir(palavra);

        }

        return i;

    }

    public boolean pesquisar(String palavra){

        return pesquisar(palavra, raiz);

    }

    private boolean pesquisar(String palavra, No i){

        boolean resp;

        if(i == null){

            resp = false;

        }else if(palavra.charAt(0) < i.letra){

            resp = pesquisar(palavra, i.esq);

        }else if(palavra.charAt(0) > i.letra){

            resp = pesquisar(palavra, i.dir);

        }else{

            resp = i.t1.pesquisar(palavra);

        }

        return resp;

    }
    
}