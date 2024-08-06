import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double raio = scan.nextDouble();

        double p = 3.14159;

        double area = p * Math.pow(raio, 2);

        System.out.printf("A=%.4f",area);
        System.out.println("");

        scan.close();

    }

}