
public class Doidona {

    public Celula primeiro, ultimo;
    public No raiz1, raiz2;

    public int[] tabela1;
    public boolean[] ocupado1;
    public int[] tabela2;
    public boolean[] ocupado2;

    public int tamTabela;

    public Doidona(){

        primeiro = new Celula();
        ultimo = primeiro;

        raiz1 = raiz2 = null;

        tamTabela = 10;

        tabela1 = new int[tamTabela];
        ocupado1 = new boolean[tamTabela];
        tabela2 = new int[tamTabela];
        ocupado2 = new boolean[tamTabela];

    }

    public int hash(int x){

        return x % tamTabela;

    }

    public int rehash(int x){

        return ++x % tamTabela;

    }

    public int hash2(int x){

        return x % 3;

    }

    public void inserirTabela1(int x){

        int index = hash(x);

        if(!ocupado1[index]){

            tabela1[index] = x;
            ocupado1[index] = true;

        }else{

            index = hash2(x);

            if(index == 1){
                
                inserirTabela2(x);

            }else if(index == 2){

                inserirLista(x);

            }else{

                inserirArvore2(x);

            }

        }

    }

    public void inserirTabela2(int x){

        int index = hash(x);

        if(!ocupado2[index]){

            tabela2[index] = x;
            ocupado2[index] = true;

        }else{

            index = rehash(x);

            if(!ocupado2[index]){

                tabela2[index] = x;
                ocupado2[index] = true;

            }else{

                inserirArvore1(x);

            }

        }

    }

    public void inserirArvore1(int x){

        raiz1 = inserirArvore1(x, raiz1);

    }

    private No inserirArvore1(int x, No i){

        if(i == null){

            i = new No(x);

        }else if(x < i.elemento){

            i.esq = inserirArvore1(x, i.esq);

        }else{

            i.dir = inserirArvore1(x, i.dir);

        }

        return i;

    }

    public void inserirLista(int x){

        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;

    }

    public void inserirArvore2(int x){

        raiz2 = inserirArvore2(x, raiz2);

    }

    private No inserirArvore2(int x, No i){

        if(i == null){

            i = new No(x);

        }else if(x < i.elemento){

            i.esq = inserirArvore1(x, i.esq);

        }else{

            i.dir = inserirArvore1(x, i.dir);

        }

        return i;

    }
    
}