import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double n1 = scan.nextDouble();
        double n2 = scan.nextDouble();

        n1 *= 3.5;
        n2 *= 7.5;

        double media = (n1 + n2)/11;

        System.out.printf("MEDIA = %.5f",media);
        System.out.println("");

        scan.close();

    }

}
