

public class T2 {
    
    public T3 tabela3;
    public Lista lista;
    public ArvoreBinaria arvore;

    public T2(){

        tabela3 = new T3();
        lista = new Lista();
        arvore = new ArvoreBinaria();

    }

    public int hash(int x){

        return x % 3;

    }

    public void inserir(int x) throws Exception{

        int index = hash(x);

        if(index == 1){

            tabela3.inserir(x);

        }else if(index == 2){

            lista.inserir(x);

        }else{

            arvore.inserir(x);

        }

    }

    public boolean pesquisa(int x){

        int index = hash(x);

        if(index == 1){

            return tabela3.pesquisa(x);

        }else if(index == 2){

            return lista.pesquisa(x);

        }else{

            return arvore.pesquisar(x);

        }

    }

}
