

public class T3 {
    
    public int[] tabela;
    public boolean[] reservado;
    public ArvoreBinaria arvore;

    public T3(){

        tabela = new int[10];
        reservado = new boolean[10];
        arvore = new ArvoreBinaria();

    }

    public int hash(int x){

        return x % 10;

    }

    public int rehash(int x){

        return ++x % 10;

    }

    public void inserir(int x) throws Exception{

        int index = hash(x);

        if(reservado[index] == false){

            tabela[index] = x;

        }else{

            index = rehash(x);

            if(reservado[index] == false){

                tabela[index] = x;
                reservado[index] = true;

            }else{

                arvore.inserir(x);

            }

        }

    }

    public boolean pesquisa(int x){

        int index = hash(x);

        if(reservado[index] == true && tabela[index] == x){

            return true;

        }

        index = rehash(x);
        
        if(reservado[index] == true && tabela[index] == x){

            return true;

        }

        return arvore.pesquisar(x);

    }

}
