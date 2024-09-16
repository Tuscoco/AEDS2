/**
 * Main
 */

public class Main {

    public static void main(String[] args) throws Exception {
        
        FilaCircular fila = new FilaCircular(5);

        for(int i = 1;i <= 5;i++){

            fila.inserir(i);

        }

        fila.mostrar();

        fila.remover();
        fila.remover();

        System.out.println(fila.isVazio());

        fila.mostrar();

    }
    
}