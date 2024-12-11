
public class T2 {
    
    public CelulaT2[] celulas;

    public T2(){

        celulas = new CelulaT2[10];

        for(int i = 0;i < 10;i++){

            celulas[i] = new CelulaT2();

        }

    }

    public int hashT2(int x){

        return x % 10;

    }

    public void inserir(String palavra){

        int index = hashT2(palavra.length());

        celulas[index].inserir(palavra);

    }

    public boolean pesquisar(String palavra){

        int index = hashT2(palavra.length());

        return celulas[index].pesquisar(palavra);

    }

}
