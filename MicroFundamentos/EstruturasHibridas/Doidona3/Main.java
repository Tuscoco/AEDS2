import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Doidona doida = new Doidona();

        for(int i = 0;i < 10;i++){

            String nome = scan.nextLine();

            doida.inserir(nome);

        }

        System.out.println("Pesquisar: ");
        String nome = scan.nextLine();

        System.out.println(doida.pesquisar(nome));

        scan.close();

    }

}
