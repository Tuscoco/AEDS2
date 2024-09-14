import java.util.*;

/**
 * DesempilhandoCaixas
 */

public class DesempilhandoCaixas {

    public static int desempilar(int[][] matriz,int n,int p){

        int linha = 0,coluna = 0;
        int cont = 0;

        for(int i = 0;i < n;i++){

            for(int j = 0;j < p;j++){

                if(matriz[i][j] == 1){

                    linha = i;
                    coluna = j;

                }

            }

        }

        for(int i = linha - 1;i >= 0;i--){

            if(matriz[i][coluna] != 0){
                cont++;
            }

        }

        if(coluna != 0){

            if(coluna != p - 1){

                for(int i = linha;i >= 0;i--){

                    for(int j = coluna - 1;j >=0;j--){

                        if(matriz[i][j] != 0){
                            cont++;
                        }

                    }

                }

            }

        }

        return cont;

    }
    
    public static void ajeitarMatriz(int[][] matriz,int n,int p){

        for(int i = 0;i < n;i++){
            
            for(int j = 0;j < p;j++){

                matriz[i][j] = 0;

            }

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n,p;
        
        do{

            n = scan.nextInt();
            p = scan.nextInt();

            if(n != 0 && p != 0){

                int[][] matriz = new int[n][p];
                ajeitarMatriz(matriz, n, p);

                for(int i = 0;i < p;i++){

                    int qi = scan.nextInt();
                    int j = n - 1;
                    int cont = 0;
        
                    while(cont != qi){
                        matriz[j][i] = scan.nextInt();
                        
                        j--;
                        cont++;
                    }
        
                }

                int resp = desempilar(matriz, n, p);

                System.out.println(resp);

            }

        }while(n != 0 && p != 0);

        scan.close();

    }
    
}