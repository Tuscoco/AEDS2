
public class CelulaT2 {
    
    public Celula inicio, fim;

    public CelulaT2(){

        inicio = fim = null;

    }

    public void inserir(String palavra){

        if(inicio == null){

            inicio = new Celula(palavra);
            fim = inicio;

        }else{

            Celula i = inicio;

            while(i.prox != null && i.prox.palavra.compareTo(palavra) < 0){

                i = i.prox;

            }

            Celula tmp = new Celula(palavra);

            tmp.prox = i.prox;
            i.prox = tmp;

            if(i == fim){

                fim = fim.prox;

            }

            i = null;
            tmp = null;

        }

    }

    public boolean pesquisar(String palavra){

        Celula i = inicio;

        if(i == null){

            return false;

        }

        while(i != null){

            if(i.palavra.equals(palavra)){

                return true;

            }

        }

        return false;

    }

}
