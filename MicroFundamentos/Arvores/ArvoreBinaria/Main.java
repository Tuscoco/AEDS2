import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);

        ArvoreBinaria arvore = new ArvoreBinaria();

        for(int i = 1;i <= 100;i++){

            arvore.inserir(i);

        }

        System.out.println("Digite um numero:");
        int n = scan.nextInt();

        if(arvore.pesquisar(n)){

            System.out.println("Esta na arvore");

        }else{

            System.out.println("Não esta na arvore");

        }

        arvore.caminharCentral();
        System.out.println();

        scan.close();

    }
    
}