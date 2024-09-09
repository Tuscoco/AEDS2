/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        ListaLinear lista = new ListaLinear();

        int n = 9;

        for(int i = 0;i < 10;i++,n--){
            lista.inserirFinal(n);
        }

        lista.mostrar();

        lista.ordenar();

        lista.mostrar();

    }
    
}
