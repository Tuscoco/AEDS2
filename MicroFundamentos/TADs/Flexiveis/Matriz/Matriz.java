/**
 * Matriz
 */

public class Matriz {

    private CelulaM inicio;
    private int linha, coluna;

    public Matriz(){

        linha = 3;
        coluna = 3;

        construirMatriz();

    }

    public Matriz(int linha, int coluna){

        this.linha = linha;
        this.coluna = coluna;

        construirMatriz();

    }

    public void construirMatriz(){

        inicio = new CelulaM();
        CelulaM ac,al;
        ac = al = inicio;

        for(int i = 1;i < coluna;i++){

            ac.dir = new CelulaM();
            ac.dir.esq = ac;

            ac = ac.dir;

        }

        for(int i = 1;i < linha;i++){

            al.inf = new CelulaM();
            al.inf.sup = al;
            al = al.inf;
            ac = al;

            for(int j = 1;j < coluna;j++){

                ac.dir = new CelulaM();
                ac.dir.esq = ac;
                ac = ac.dir;
                ac.sup = ac.esq.sup.dir;
                ac.sup.inf = ac;

            }

        }

    }

    public void inserir(int[] vet){

        CelulaM auxL, auxC;
        auxL = auxC = inicio;
        int index = 0;

        for(int i = 0;i < linha;i++){

            auxC = auxL;

            for(int j = 0;j < coluna;j++){

                auxC.setElemento(vet[index++]);
                auxC = auxC.dir;

            }

            auxL = auxL.inf;

        }

    }

    public void mostrar(){

        CelulaM auxL = inicio;
        CelulaM auxC = inicio;

        for(int i = 0;i < linha;i++){

            auxC = auxL;

            System.out.print("[ ");
            for(int j = 0;j < coluna;j++){

                System.out.print(auxC.getElemento() + " ");
                auxC = auxC.dir;

            }
            System.out.println("]");

            auxL = auxL.inf;

        }

    }
    
}