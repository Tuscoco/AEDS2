import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        int op = 1;

        while(op != 0){

            System.out.println("====================================================================================");
            System.out.println("0 -> Encerrar");
            System.out.println("1 -> Inserir Contato");
            System.out.println("2 -> Mostrar Todos");
            System.out.println("3 -> Mostrar de acordo com a letra");
            System.out.println("====================================================================================");
            op = scan.nextInt();
            scan.nextLine();

            if(op == 1){

                System.out.print("Insira o nome: ");
                String nome = scan.nextLine();
                System.out.print("Insira o email: ");
                String email = scan.nextLine();

                Contato contato = new Contato(nome, email);

                arvore.inserirLista(contato);

            }else if(op == 2){

                arvore.caminharCentral();

            }else if(op == 3){

                System.out.print("Insira uma letra: ");
                char c = scan.next().charAt(0);
                scan.nextLine();

                arvore.mostrarListaLetra(c);

            }

        }

        scan.close();

    }

}
