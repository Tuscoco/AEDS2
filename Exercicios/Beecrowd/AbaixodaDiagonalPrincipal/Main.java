import java.util.*;

public class Main {
    
    public static double soma(double[][] matriz) {
        
        double resultado = 0;

        for(int i = 0;i < 12;i++){

            for(int j = 0;j < 12;j++){

                if(i > j){

                    resultado += matriz[i][j];

                }

            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double[][] matriz = new double[12][12];

        char o = scan.next().charAt(0);


        for(int i = 0;i < 12;i++){

            for(int j = 0;j < 12;j++){

                double temp = scan.nextDouble();

                matriz[i][j] = temp;

            }

        }

        double resultado;

        if(o == 'S'){

            resultado = soma(matriz);

        }else{

            resultado = soma(matriz)/66;

        }

        System.out.printf("%.1f\n",resultado);

        scan.close();

    }

}
