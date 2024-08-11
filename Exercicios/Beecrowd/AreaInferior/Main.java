package Exercicios.Beecrowd.AreaInferior;

import java.util.*;

public class Main {

    public static double soma(double[][] matriz){

        double resultado = 0;
        int c = 1;

        for(int i = 11;i > 6;i--,c++){

            for(int j = c;j <= 11 - c;j++){

                resultado += matriz[i][j];

            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char o = scan.next().charAt(0);

        double[][] matriz = new double[12][12];


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

            resultado = soma(matriz)/30;

        }

        System.out.printf("%.1f\n",resultado);

        scan.close();

    }

}
