

public class T1 {

    public int[] tabela;
    public boolean[] reservado;
    public T2 tabela2;

    public T1(){

        tabela = new int[10];
        reservado = new boolean[10];
        tabela2 = new T2();

    }

    public int hash(int x){

        return x % 10;

    }

    public void inserir(int x) throws Exception{

        int index = hash(x);

        if(reservado[index] == false){

            tabela[index] = x;
            reservado[index] = true;

        }else{

            tabela2.inserir(x);

        }

    }

    public boolean pesquisa(int x){

        int index = hash(x);

        if(reservado[index] == true && tabela[index] == x){

            return true;

        }

        return tabela2.pesquisa(x);

    }
    
}