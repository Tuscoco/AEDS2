import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        
        double b = scan.nextDouble();

        double c = scan.nextDouble();

        double delta = Math.pow(b, 2) - (4 * a * c);

        if(delta < 0 || 2 * a == 0){
            System.out.println("Impossivel calcular");
            System.exit(0);
        }

        double x1 = (- b + Math.sqrt(delta)) / (2 * a);

        double x2 = (- b - Math.sqrt(delta)) / (2 * a);

        System.out.printf("R1 = %.5f\n",x1);
        System.out.printf("R2 = %.5f\n",x2);

        scan.close();

    }
    
}