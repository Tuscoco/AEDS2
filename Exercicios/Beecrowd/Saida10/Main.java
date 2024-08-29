/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        for(int i = 0;i < 9;i++){

            if(i == 0 || i == 8){
                System.out.println("       A");
            }else if(i == 1 || i == 7){
                System.out.println("      B B");
            }else if(i == 2 || i == 6){
                System.out.println("     C   C");
            }else if(i == 3 || i == 5){
                System.out.println("    D     D");
            }else if(i == 4){
                System.out.println("   E       E");
            }

        }

    }
    
}