

public class ArvoreBinaria {

    public No raiz;

    public ArvoreBinaria(){

        raiz = null;

    }

    public void inserir(int x) throws Exception{

        raiz = inserir(x, raiz);

    }

    private No inserir(int x, No i) throws Exception{

        if(i == null){

            i = new No(x);

        }else if(x < i.elemento){

            i.esq = inserir(x, i.esq);

        }else if(x > i.elemento){

            i.dir = inserir(x, i.dir);

        }else{

            throw new Exception("Erro!");

        }

        return i;

    }

    public boolean pesquisar(int x){

        return pesquisar(x, raiz);

    }

    private boolean pesquisar(int x, No i){

        boolean resp;

        if(i == null){

            resp = false;

        }else if(x == i.elemento){

            resp = true;

        }else if(x < i.elemento){

            resp = pesquisar(x, i.esq);

        }else{

            resp = pesquisar(x, i.dir);

        }

        return resp;

    }

    public void caminharCentral(){

        caminharCentral(raiz);

    }

    private void caminharCentral(No i){

        if(i != null){

            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);

        }

    }
    
}