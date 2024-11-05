import java.util.*;

class Duende{

    public String nome;
    public int idade;

    public Duende(String nome, int idade){

        this.nome = nome;
        this.idade = idade;

    }

    public String toString(){

        return nome + " " + idade;

    }

}

public class Main {

    public static void ordenar(Duende[] vetor){

        for(int i = 1;i < vetor.length;i++){

            Duende tmp = vetor[i];
            int j = i - 1;

            while(j >= 0 && (vetor[j].idade < tmp.idade)){

                vetor[j + 1] = vetor[j];
                j--;

            }

            vetor[j + 1] = tmp;

        }

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        Duende[] duende = new Duende[n];

        for(int i = 0;i < n;i++){

            String str = scan.nextLine();
            String[] vet = str.split(" ");

            duende[i] = new Duende(vet[0], Integer.parseInt(vet[1]));

        }

        ordenar(duende);

        int times = n/3;

        for(int i = 0;i < times;i++){

            System.out.println("Time " + (i + 1));

            for(int j = i;j < n;j += times){

                System.out.println(duende[j].toString());

            }

            System.out.println();

        }

        scan.close();

    }
    
}