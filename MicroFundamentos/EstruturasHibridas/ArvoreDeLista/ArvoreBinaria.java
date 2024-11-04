
public class ArvoreBinaria {

    public No raiz;

    public ArvoreBinaria() throws Exception{

        raiz = null;

        construir();

    }

    private void construir() throws Exception{

        char l = 'A';

        for(int i = 0;i < 26;i++,l++){

            if(l >= 'A' && l <= 'Z'){

                inserir(l);

            }

        }

    }

    public void inserir(char x) throws Exception{

        raiz = inserir(x, raiz);

    }

    private No inserir(char x, No i) throws Exception{

        if(i == null){

            i = new No(x);

        }else if(x < i.letra){

            i.esq = inserir(x, i.esq);

        }else if(x > i.letra){

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

        }else if(x == i.letra){

            resp = true;

        }else if(x < i.letra){

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
            i.lista.mostrar();
            caminharCentral(i.dir);

        }

    }

    //////////////////////////////////////////////////////////////////////////////////////
    
    public void inserirLista(Contato x){

        inserirLista(x, raiz);

    }

    private void inserirLista(Contato x, No i){

        if(i == null){

            System.out.println("Erro!");

        }else if(x.nome.charAt(0) == i.letra){

            i.lista.inserirFim(x);

        }else if(x.nome.charAt(0) < i.letra){

            inserirLista(x, i.esq);

        }else{

            inserirLista(x, i.dir);

        }

    }

    public void mostrarListaLetra(char x){

        mostrarListaLetra(x, raiz);

    }

    private void mostrarListaLetra(char x, No i){

        if(i == null){

            System.out.println("Erro!");

        }else if(x == i.letra){

            i.lista.mostrar();

        }else if(x < i.letra){

            mostrarListaLetra(x, i.esq);

        }else{

            mostrarListaLetra(x, i.dir);

        }

    }

}