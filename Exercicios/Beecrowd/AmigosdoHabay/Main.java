import java.util.*;

class Pessoa{

    public String nome;
    public int inscricoes;
    public int letras;

    public Pessoa(String nome){

        this.nome = nome;
        inscricoes = 1;
        letras = nome.length();

    }

    public String getNome(){

        return nome;

    }

}

public class Main {

    public static String sortear(List<Pessoa> lista){

        int maior = -1;
        String resp = "";

        for(int i = 0;i < lista.size();i++){

            if(lista.get(i).letras > maior){

                maior = lista.get(i).letras;

            }

        }

        for(int i = 0;i < lista.size();i++){

            if(lista.get(i).letras == maior){

                resp = lista.get(i).nome;
                i = lista.size();

            }

        }

        return resp;

    }

    public static boolean existe(List<Pessoa> lista, String str){

        boolean resp = false;

        for(int i = 0;i < lista.size();i++){

            if(lista.get(i).nome.equals(str)){

                resp = true;
                i = lista.size();

            }

        }

        return resp;

    }

    public static boolean isFim(String str){

        boolean resp = false;

        if(str.equals("FIM")){

            resp = true;

        }

        return resp;

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        List<Pessoa> lista = new ArrayList<>();
        List<Pessoa> atsil = new ArrayList<>();
        String str = "";

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                String[] array = str.split(" ");

                if(array[1].equals("YES")){

                    Pessoa pessoa = new Pessoa(array[0]);

                    if(!existe(lista, array[0])){

                        lista.add(pessoa);

                    }

                }else if(array[1].equals("NO")){

                    Pessoa pessoa = new Pessoa(array[0]);

                    atsil.add(pessoa);

                }

            }

        }while(!isFim(str));

        String resp = sortear(lista);

        lista.sort(Comparator.comparing(Pessoa::getNome));
        atsil.sort(Comparator.comparing(Pessoa::getNome));

        for(int i = 0;i < lista.size();i++){

            System.out.println(lista.get(i).nome);

        }

        for(int i = 0;i < atsil.size();i++){

            System.out.println(atsil.get(i).nome);

        }

        System.out.println();

        System.out.println("Amigo do Habay:");
        System.out.println(resp);

        scan.close();

    }
    
}