import java.util.*;

/**
 * Main
 */

public class Main {

    private static int[] array;
    private static int cont = 0;
    
    public static void push(int num){

        array[cont] = num;

        cont++;

    }

    public static void pop(){

        if(cont == 0){
            System.out.println("EMPTY");
        }else{
            cont--;
        }

    }

    public static void min(){

        if(cont == 0){
            System.out.println("EMPTY");
        }
        
        int menor = array[0];
        for(int i = 1;i < cont;i++){

            if(array[i] < menor){
                menor = array[i];
            }

        }

        System.out.println(menor);

    }

    public static void OP(String str){

        String[] array = str.split(" ");

        if(array[0].equals("PUSH")){

            int num = Integer.parseInt(array[1]);
            push(num);

        }else if(array[0].equals("POP")){

            pop();

        }else if(array[0].equals("MIN")){

            min();

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        array = new int[n];

        for(int i = 0;i < n;i++){

            String str =  scan.nextLine();

            OP(str);

        }

        scan.close();

    }
    
}