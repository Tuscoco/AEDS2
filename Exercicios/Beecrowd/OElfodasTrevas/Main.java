import java.util.*;

class Rena{

    public String nome;
    public int peso;
    public int idade;
    public double altura;

    public Rena(String nome, int peso, int idade, double altura){

        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;

    }

}

public class Main {

    public static void ordenar(Rena[] vetor){

        for(int i = 1;i < vetor.length;i++){

            Rena tmp = vetor[i];
            int j =  i - 1;

            while(j >= 0 && (vetor[j].peso < tmp.peso || 
            (vetor[j].peso == tmp.peso && vetor[j].idade > tmp.idade) || 
            (vetor[j].peso == tmp.peso && vetor[j].idade == tmp.idade && vetor[j].altura > tmp.altura) || 
            (vetor[j].peso == tmp.peso && vetor[j].idade == tmp.idade && vetor[j].altura == tmp.altura && vetor[j].nome.compareTo(tmp.nome) > 0))){

                vetor[j + 1] = vetor[j];
                j--;

            }

            vetor[j + 1] = tmp;

        }

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 0;i < n;i++){

            int tam = scan.nextInt();
            int quant = scan.nextInt();
            scan.nextLine();

            Rena[] vetor = new Rena[tam];

            for(int j = 0;j < tam;j++){

                String str = scan.nextLine();
                String[] vet = str.split(" ");

                if(vet.length == 4){

                    vetor[j] = new Rena(vet[0], Integer.parseInt(vet[1]), Integer.parseInt(vet[2]), Double.parseDouble(vet[3]));

                }

            }

            ordenar(vetor);

            System.out.println("CENARIO {" + (i + 1) + "}");
            for(int j = 0;j < quant;j++){

                System.out.println((j + 1) + " - " + vetor[j].nome);

            }

        }
        
        scan.close();

    }
    
}