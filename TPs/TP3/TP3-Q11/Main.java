import java.util.*;

/////////////////////////////////////////////////////////////////////////////////////////////////

class CelulaM {

    private int elemento;
    public CelulaM dir,esq,sup,inf;

    public CelulaM(){

        this.elemento = 0;
        dir = esq = sup = inf = null;

    }

    public void setElemento(int elemento){
        this.elemento = elemento;
    }

    public int getElemento(){
        return elemento;
    }
    
}

/////////////////////////////////////////////////////////////////////////////////////////////////

class Matriz {

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

    public CelulaM getInicio(){
        return inicio;
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

    public Matriz soma(Matriz matriz){

        CelulaM auxL1, auxC1;
        CelulaM auxL2, auxC2;

        auxL1 = auxC1 = this.inicio;
        auxL2 = auxC2 = matriz.getInicio();
        
        Matriz nova = new Matriz(linha, coluna);
        int[] vetor = new int[linha * coluna];
        int index = 0;

        for(int i = 0;i < linha;i++){

            auxC1 = auxL1;
            auxC2 = auxL2;

            for(int j = 0;j < coluna;j++){

                vetor[index] = auxC1.getElemento() + auxC2.getElemento();
                auxC1 = auxC1.dir;
                auxC2 = auxC2.dir;
                index++;

            }

            auxL1 = auxL1.inf;
            auxL2 = auxL2.inf;

        }

        nova.inserir(vetor);

        return nova;

    }

    public Matriz multiplicacao(Matriz matriz){

        CelulaM auxL1, auxC1;
        CelulaM auxL2, auxC2;

        auxL1 = auxC1 = this.inicio;
        auxL2 = auxC2 = matriz.getInicio();
        
        Matriz nova = new Matriz(linha, coluna);
        int[] vetor = new int[linha * coluna];
        int index = 0;

        for(int i = 0;i < linha;i++){

            auxC1 = auxL1;
            auxC2 = auxL2;

            for(int j = 0;j < coluna;j++){

                vetor[index] = auxC1.getElemento() * auxC2.getElemento();
                auxC1 = auxC1.dir;
                auxC2 = auxC2.dir;
                index++;

            }

            auxL1 = auxL1.inf;
            auxL2 = auxL2.inf;

        }

        nova.inserir(vetor);

        return nova;

    }

    public void mostrarDiagonalPrincipal(){

        CelulaM aux = inicio;

        for(int i = 0;i < linha;i++){
            
            System.out.print(aux.getElemento() + " ");
            aux = aux.dir;
            
            if(aux != null){

                aux = aux.inf;

            }

        }

        System.out.println();

    }

    public void mostrarDiagonalSecundaria(){

        CelulaM aux = inicio;

        while(aux.dir != null){

            aux = aux.dir;

        }

        for(int i = 0;i < linha;i++){

            System.out.print(aux.getElemento() + " ");
            aux = aux.esq;
            
            if(aux != null){

                aux = aux.inf;

            }

        }

        System.out.println();

    }

    public void mostrar(){

        CelulaM auxL = inicio;
        CelulaM auxC = inicio;

        for(int i = 0;i < linha;i++){

            auxC = auxL;

            for(int j = 0;j < coluna;j++){

                System.out.print(auxC.getElemento() + " ");
                auxC = auxC.dir;

            }
            System.out.println();

            auxL = auxL.inf;

        }

    }
    
}

/////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int tests = scan.nextInt();

        for(int i = 0;i < tests;i++){

            int l = scan.nextInt();
            int c = scan.nextInt();

            Matriz mat1 = new Matriz(l, c);
            int[] vet1 = new int[l * c];

            for(int j = 0;j < (l * c);j++){

                vet1[j] = scan.nextInt();

            }

            mat1.inserir(vet1);

            mat1.mostrarDiagonalPrincipal();
            mat1.mostrarDiagonalSecundaria();
            

            l = scan.nextInt();
            c = scan.nextInt();

            Matriz mat2 = new Matriz(l, c);
            int[] vet2 = new int[l * c];

            for(int j = 0;j < (l * c);j++){

                vet2[j] = scan.nextInt();

            }

            mat2.inserir(vet2);

            //////////////////////////////////////////////////////////////////
            
            Matriz somada = mat1.soma(mat2);
            somada.mostrar();

            Matriz multiplicada = mat1.multiplicacao(mat2);
            multiplicada.mostrar();

        }

        scan.close();

    }
    
}