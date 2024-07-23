import java.util.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class arquivoemjava {
    
    public static void escreverArquivo(int n){

        try{

            Scanner scan = new Scanner(System.in);

            RandomAccessFile file = new RandomAccessFile("tp1q8.txt", "rw");
    
            file.writeInt(n);
    
            int i = 0;
    
            for(i = 0; i < n;i++){
    
                int a = scan.nextInt();
    
                file.writeInt(a);
    
            }
    
            file.close();
            scan.close();

        }catch(IOException e){
            e.getMessage();
        }

    }

    public static void imprimir(int n){

        try{

            RandomAccessFile file = new RandomAccessFile("tp1q8.txt", "r");

            file.seek(n);
    
            for(int i = 0; i <= n;i++){
                System.out.println(file.read());
            }
    
            file.close();

        }catch(IOException e){
            e.getMessage();
        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        escreverArquivo(n);

        imprimir(n);

    }

}

/////////////////ERRADO
