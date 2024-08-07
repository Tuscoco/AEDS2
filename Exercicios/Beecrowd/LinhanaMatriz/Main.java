import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double[][] M = new double[12][12];

        int lop = scan.nextInt();
        char op = scan.next().charAt(0);

        for(int i = 0;i < 12;i++){

            for(int j = 0;j < 12;j++){

                M[i][j] = scan.nextDouble();

            }

        }

        switch(op){

            case 'S':
                double soma = 0;

                for(int i = 0;i < 12;i++){

                    soma += M[lop][i];

                }

                System.out.printf("%.1f\n",soma);
            break;

            case 'M':
                double media = 0;

                for(int i = 0;i < 12;i++){

                    media += M[lop][i];

                }

                media /= 12;

                System.out.printf("%.1f\n",media);
            break;

        }

        scan.close();

    }

}
