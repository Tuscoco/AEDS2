import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        if(num <= 1){
            System.out.println("Top 1");
        }else if(num > 1 && num <= 3){
            System.out.println("Top 3");
        }else if(num > 3 && num <= 5){
            System.out.println("Top 5");
        }else if(num > 5 && num <= 10){
            System.out.println("Top 10");
        }else if(num > 10 && num <= 25){
            System.out.println("Top 25");
        }else if(num > 25 && num <= 50){
            System.out.println("Top 50");
        }else if(num > 50 && num <= 100){
            System.out.println("Top 100");
        }

        scan.close();

    }

}
