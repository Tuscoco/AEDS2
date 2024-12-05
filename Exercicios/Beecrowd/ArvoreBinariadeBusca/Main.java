import java.util.*;

public class Main {

    static class No{

        public int elemento;
        public No esq, dir;

        public No(int elemento){

            this.elemento = elemento;
            esq = dir = null;

        }

    }

    static class ArvoreBinaria{

        public No raiz;

        public ArvoreBinaria(){

            raiz = null;

        }

        public void inserir(int x){

            raiz = inserir(x, raiz);

        }

        private No inserir(int x, No i){

            if(i == null){

                i = new No(x);

            }else if(x < i.elemento){

                i.esq = inserir(x, i.esq);

            }else if(x > i.elemento){

                i.dir = inserir(x, i.dir);

            }

            return i;

        }

        public void caminharPre(){

            caminharPre(raiz);

        }

        private void caminharPre(No i){

            if(i != null){
                
                System.out.print(i.elemento + " ");
                caminharPre(i.esq);
                caminharPre(i.dir);

            }

        }

        public void caminharCentral(){

            caminharCentral(raiz);

        }

        private void caminharCentral(No i){

            if(i != null){

                caminharPre(i.esq);
                System.out.print(i.elemento + " ");
                caminharPre(i.dir);

            }

        }

        public void caminharPos(){

            caminharPos(raiz);

        }

        private void caminharPos(No i){

            if(i != null){

                caminharPre(i.esq);
                caminharPre(i.dir);
                System.out.print(i.elemento + " ");

            }

        }

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int c = scan.nextInt();

        for(int i = 0;i < c;i++){

            int n = scan.nextInt();

            ArvoreBinaria arvore = new ArvoreBinaria();

            for(int j = 0;j < n;j++){

                int num = scan.nextInt();
                arvore.inserir(num);

            }

            System.out.println("Case " + (i + 1) + ":");

            System.out.print("Pre.: ");
            arvore.caminharPre();
            System.out.println();

            System.out.print("In..: ");
            arvore.caminharCentral();
            System.out.println();

            System.out.print("Post: ");
            arvore.caminharPos();
            System.out.println();

        }

        scan.close();

    }
    
}