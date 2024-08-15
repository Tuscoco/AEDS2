import java.io.*;

public class arquivoemjava {
    
    public static void escreverArquivo(int n){

        try{

            RandomAccessFile file = new RandomAccessFile("tp1q8.txt","rw");
            double v;

            file.seek(0);

            for(int i = 0;i < n;i++){

                v = MyIO.readDouble();

                file.writeDouble(v);

            }

            file.close();

        }catch(IOException e){

            e.getMessage();

        }

    }

    public static void imprimir(int n){

        try{

            RandomAccessFile file = new RandomAccessFile("tp1q8.txt","r");
            long fileLength = file.length();
            double v;

            for(long i = fileLength - 8 ;i >= 0;i -= 8){

                file.seek(i);

                v = file.readDouble();

                if(v - ((int) v) == 0){

                    System.out.printf("%.0f\n",v);

                }else{

                    System.out.println(v);

                }

            }

            file.close();

        }catch(IOException e){

            e.getMessage();

        }

    }
    
    public static void main(String[] args){

        int n = MyIO.readInt();

        escreverArquivo(n);

        imprimir(n);

    }

}

