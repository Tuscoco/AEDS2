import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] array = new int[4];
        int j = 0;

        array[0] = scan.nextInt();
        array[1] = scan.nextInt();
        array[2] = scan.nextInt();
        array[3] = scan.nextInt();

        for(int i = 0;i < array.length;i++){

            if(array[i] == 1){
                j = i + 1;
            }

        }

        System.out.println(j);

        scan.close();

    }

}
