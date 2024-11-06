import java.util.*;

public class Main {

    public static boolean verificar(String[] array){

        for(int i = 0;i < array.length - 1;i++){

            String tmp = array[i];

            for(int j = i + 1;j < array.length;j++){

                if(array[j].equals(tmp)){

                    return false;

                }

            }

        }

        return true;

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = -1;

        while(n != 0){

            n = scan.nextInt();

            if(n != 0){

                scan.nextLine();

                String[] x = new String[n];
                String[] y = new String[n];
    
                for(int i = 0;i < n;i++){
    
                    String str = scan.nextLine();
                    String[] vet = str.split(" -> ");
    
                    x[i] = vet[0];
                    y[i] = vet[1];
    
                }
    
                if(!verificar(x)){
    
                    System.out.println("Not a function.");
    
                }else if(verificar(x) == true && verificar(y) == false){
    
                    System.out.println("Not invertible.");
    
                }else if(verificar(x) && verificar(y)){
    
                    System.out.println("Invertible.");
    
                }

            }

        }

        scan.close();

    }
    
}
