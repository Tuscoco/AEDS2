

public class Main {

    public static void main(String[] args) throws Exception {

        T1 tabela = new T1();

        for(int i = 0;i < 100;i++){

            tabela.inserir(i + 1);

        }

        System.out.println(tabela.pesquisa(10));

    }
    
}