import java.util.*;

public class Main {
    
    public static double[][] preencherMatriz(){
        
        Scanner scan = new Scanner(System.in);
        double[][] matriz = new double[12][12];

        for(int i = 0;i < 12;i++){

            for(int j = 0;j < 12;j++){

                matriz[i][j] = scan.nextDouble();

            }

        }

        scan.close();

        return matriz;

    }

    public static double media(double[][] matriz){

        double resultado = 0;

        for(int i = 0;i < 12;i++){

            for(int j = 0;j < 12;j++){

                if(j > i){

                    resultado += matriz[i][j];

                }

            }

        }

        resultado /= 66;

        return resultado;

    }

    public static double soma(double[][] matriz){

        double resultado = 0;

        for(int i = 0;i < 12;i++){

            for(int j = 0;j < 12;j++){

                if(j > i){

                    resultado += matriz[i][j];

                }

            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double resultado;

        char op = scan.next().charAt(0);

        double[][] matriz = preencherMatriz();

        if(op == 'S'){

            resultado = soma(matriz);

        }else{

            resultado = media(matriz);

        }

        System.out.printf("%.1f\n",resultado);

        scan.close();

    }

}

//////////////ERRADO
