import java.util.*;

class Pessoa{

    public String nome;
    public char regiao;
    public int distancia;

    public Pessoa(String nome, char regiao, int distancia){

        this.nome = nome;
        this.regiao = regiao;
        this.distancia = distancia;

    }

}

public class Main {

    public static List<Pessoa> ordenar(List<Pessoa> lista){

        for(int i = 1;i < lista.size();i++){

            Pessoa tmp = lista.get(i);
            int j = i - 1;

            while(j >= 0 && (lista.get(j).distancia > tmp.distancia || lista.get(j).distancia == tmp.distancia && lista.get(j).nome.compareTo(tmp.nome) > 0)){

                lista.set(j + 1, lista.get(j));
                j--;

            }

            lista.set(j + 1, tmp);

        }

        return lista;

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){

            List<Pessoa> lista = new ArrayList<>();
            String str = "";
            int q = scan.nextInt();
            scan.nextLine();

            for(int i = 0;i < q;i++){

                str = scan.nextLine();

                String[] array = str.split(" ");
    
                if(array.length == 3){
    
                    Pessoa pessoa = new Pessoa(array[0], array[1].charAt(0), Integer.parseInt(array[2]));
                    lista.add(pessoa);
    
                }

            }

            lista = ordenar(lista);

            for(int i = 0;i < lista.size();i++){
    
                System.out.println(lista.get(i).nome);
    
            }

        }

        scan.close();

    }
    
}