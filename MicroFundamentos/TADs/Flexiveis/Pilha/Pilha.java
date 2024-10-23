/**
 * Pilha
 */

public class Pilha {

    private CelulaM topo;

    public Pilha(){

        topo = null;

    }

    public void inserir(int x){

        CelulaM tmp = new CelulaM(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;

    }

    public int remover() throws Exception{

        if(topo == null){

            throw new Exception("Erro!");

        }

        int elemento = topo.elemento;
        CelulaM tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;

    }

    public void mostrar(){

        System.out.print("[ ");

        for(CelulaM i = topo;i != null;i = i.prox){

            System.out.print(i.elemento + " ");

        }

        System.out.println("]");

    }
    
}