import java.util.*;

public class Main {

    static class No{

        public String nome;
        public No esq, dir;
        public int repetiu;

        public No(String nome){

            this.nome = nome;
            esq = dir = null;
            repetiu = 0;

        }

        public No(String nome, int repetiu){

            this.nome = nome;
            this.repetiu = repetiu;
            esq = dir = null;

        }

        public No clonar(){

            return new No(this.nome, this.repetiu);

        }

    }

    static class Arvore{

        public No raiz;
        public int cont;

        public Arvore(){

            raiz = null;
            cont = 0;

        }

        public void inserir(String x){

            raiz = inserir(x, raiz);

        }

        private No inserir(String x, No i){

            if(i == null){

                i = new No(x);
                cont++;

            }else if(x.compareTo(i.nome) < 0){

                i.esq = inserir(x, i.esq);

            }else if(x.compareTo(i.nome) > 0){

                i.dir = inserir(x, i.dir);

            }else{

                i.repetiu++;

            }

            return i;

        }

        public boolean pesquisar(String x){

            return pesquisar(x, raiz);

        }

        private boolean pesquisar(String x, No i){

            boolean resp;

            if(i == null){

                resp = false;

            }else if(x.equals(i.nome)){

                resp = true;

            }else if(x.compareTo(i.nome) < 0){

                resp = pesquisar(x, i.esq);

            }else{

                resp = pesquisar(x, i.dir);

            }

            return resp;

        }

        public No[] treeSort(){

            No[] array = new No[cont];

            treeSort(array, raiz, new int[]{0});
            
            return array;

        }

        private void treeSort(No[] array, No i, int[] c){

            if(i != null){

                treeSort(array, i.esq, c);

                array[c[0]] = i.clonar();
                array[c[0]].repetiu = i.repetiu;
                c[0]++;

                treeSort(array, i.dir, c);

            }

        }

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        Arvore assasinou = new Arvore();
        Arvore assasinado = new Arvore();

        String str = "";

        while(scan.hasNext()){

            str = scan.nextLine();
            String[] nomes = str.split(" ");

            assasinou.inserir(nomes[0]);
            assasinado.inserir(nomes[1]);

        }

        No[] assasinos = assasinou.treeSort();

        System.out.println("HALL OF MURDERERS");
        for(int i = 0;i < assasinos.length;i++){

            if(assasinado.pesquisar(assasinos[i].nome) == false){

                System.out.println(assasinos[i].nome + " " + assasinos[i].repetiu);

            }

        }

        scan.close();

    }
    
}