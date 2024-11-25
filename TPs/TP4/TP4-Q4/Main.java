import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.nio.charset.Charset;


class Pokemon{

    //Atributos
    private int id;
    private int generation;
    private String name;
    private String description;
    private List<String> types;
    private List<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private LocalDate captureDate;
    
    
    //Construtores
    public Pokemon(){

        id = 0;
        generation = 0;
        name = "";
        description = "";
        types = null;
        abilities = null;
        weight = 0.0;
        height = 0.0;
        captureRate = 0;
        isLegendary = false;
        captureDate = null;

    }
    
	public Pokemon(int id, int generation, String name, String description, List<String> types ,List<String> abilities, double weight,
	double height, int captureRate, boolean isLegendary, LocalDate captureDate){

		this.id = id;
		this.generation = generation;
		this.name = name;
		this.description = description;
        this.types = types;
		this.abilities = abilities;
		this.weight = weight;
		this.height = height;
		this.captureRate = captureRate;
		this.isLegendary = isLegendary;
		this.captureDate = captureDate;

	}

    //  GETTERS AND SETTERS

    //ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    //Generation
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}

    //Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    //Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    //Types
    public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}

    //Abilities
	public List<String> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}

    //Weight
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

    //Height
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

    //CaptureRate
	public int getCaptureRate() {
		return captureRate;
	}
	public void setCaptureRate(int captureRate) {
		this.captureRate = captureRate;
	}

    //IsLegendary
	public boolean isLegendary() {
		return isLegendary;
	}
	public void setLegendary(boolean isLegendary) {
		this.isLegendary = isLegendary;
	}

    //CaptureDate
	public LocalDate getCaptureDate() {
		return captureDate;
	}
	public void setCaptureDate(LocalDate captureDate) {
		this.captureDate = captureDate;
	}


    //Outros Métodos

    //ToString
    @Override
    public String toString(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "[#" + id + " -> " + name + ": " + description + " - " + toStringTypes(types) + " - " + 
        ToString(abilities) + " - " + weight + "kg - " + height + "m - " + captureRate + "% - " + isLegendary + " - " + 
        generation + " gen] - " + captureDate.format(dtf);

    }
    public String ToString(List<String> lista){
        return String.join(",", lista);
    }
    public String toStringTypes(List<String> lista){
        
        if(lista.get(1) != null){

            return "['" + lista.get(0) + "', '" + lista.get(1) + "']";

        }else{

            return "['" + lista.get(0) + "']";

        }

    }

    //Imprimir
    public void imprimir(){
        System.out.println(toString());
    }

    //Buscar pela ID
    public boolean ehId(int num){

        if(num == id){
            return true;
        }else{
            return false;
        }

    }

    //Clonar Pokemon
    public Pokemon clonar(){

        return new Pokemon(id, generation, name, description, types, abilities, weight, height, captureRate, isLegendary, captureDate);

    }
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class NoAN{

    public boolean cor;
    public Pokemon elemento;
    public NoAN esq, dir;

    public NoAN(Pokemon elemento){

        this.elemento = elemento;
        esq = dir = null;
        cor = false;

    }

    public NoAN(Pokemon elemento, boolean cor){

        this.elemento = elemento;
        esq = dir = null;
        this.cor = cor;

    }

}

class Alvinegra{

    public NoAN raiz;
    public int comparacoes;

    public Alvinegra(){

        raiz = null;
        comparacoes = 0;

    }

    public void inserir(Pokemon x) throws Exception{

        if(raiz == null){

            raiz = new NoAN(x);

        }else if(raiz.esq == null && raiz.dir == null){

            if(x.getName().compareTo(raiz.elemento.getName()) < 0){

                raiz.esq = new NoAN(x);

            }else{

                raiz.dir = new NoAN(x);

            }

        }else if(raiz.esq == null){

            if(x.getName().compareTo(raiz.elemento.getName()) < 0){

                raiz.esq = new NoAN(x);

            }else if(x.getName().compareTo(raiz.dir.elemento.getName()) < 0){

                raiz.esq = new NoAN(x);
                raiz.elemento = x;

            }else{

                raiz.esq = new NoAN(x);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = x;

            }

            raiz.esq.cor = raiz.dir.cor = false;

        }else if(raiz.dir == null){

            if(x.getName().compareTo(raiz.elemento.getName()) > 0){

                raiz.dir = new NoAN(x);

            }else if(x.getName().compareTo(raiz.esq.elemento.getName()) > 0){

                raiz.dir = new NoAN(x);
                raiz.elemento = x;

            }else{

                raiz.dir = new NoAN(x);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = x;

            }

            raiz.esq.cor = raiz.dir.cor = false;

        }else{

            inserir(x, null, null, null, raiz);

        }

        raiz.cor = false;

    }

    private void inserir(Pokemon x, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception{

        if(i == null){

            if(x.getName().compareTo(pai.elemento.getName()) < 0){

                i = pai.esq = new NoAN(x, true);

            }else{

                i = pai.dir = new NoAN(x, true);

            }

            if(pai.cor == true){

                balancear(bisavo, avo, pai, i);

            }

        }else{

            if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){

                i.cor = true;
                i.esq.cor = i.dir.cor = false;

                if(i == raiz){

                    i.cor = false;

                }else if(pai.cor == true){

                    balancear(bisavo, avo, pai, i);

                }

            }

            if(x.getName().compareTo(i.elemento.getName()) < 0){

                inserir(x, avo, pai, i, i.esq);

            }else if(x.getName().compareTo(i.elemento.getName()) > 0){

                inserir(x, avo, pai, i, i.dir);

            }else{

                throw new Exception("Erro!");

            }

        }

    }

    private NoAN rotacaoDir(NoAN no){

        NoAN noEsq = no.esq;
        NoAN noEsqDir = noEsq.dir;
  
        noEsq.dir = no;
        no.esq = noEsqDir;
  
        return noEsq;

    }

    private NoAN rotacaoEsq(NoAN no){

        NoAN noDir = no.dir;
        NoAN noDirEsq = noDir.esq;
  
        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;

    }
  
    private NoAN rotacaoDirEsq(NoAN no){

        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);

    }
  
    private NoAN rotacaoEsqDir(NoAN no){

        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);

    }

    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i){

        if(pai.cor == true){

            if(pai.elemento.getName().compareTo(avo.elemento.getName()) > 0){

                if(i.elemento.getName().compareTo(pai.elemento.getName()) > 0){

                    avo = rotacaoEsq(avo);

                }else{

                    avo = rotacaoDirEsq(avo);

                }

            }else{

                if(i.elemento.getName().compareTo(pai.elemento.getName()) < 0){

                    avo = rotacaoDir(avo);

                }else{

                    avo = rotacaoEsqDir(avo);

                }

            }
    
            if(bisavo == null){

                raiz = avo;

            }else if(avo.elemento.getName().compareTo(bisavo.elemento.getName()) < 0){

                bisavo.esq = avo;

            }else{

                bisavo.dir = avo;

            }
    
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;

        }

    }

    public boolean pesquisar(String x){

        return pesquisar(x, raiz);

    }

    private boolean pesquisar(String x, NoAN i){

        boolean resp;

        if(i == null){

            comparacoes++;
            resp = false;

        }else if(x.equals(i.elemento.getName())){

            comparacoes += 2;
            resp = true;

        }else if(x.compareTo(i.elemento.getName()) < 0){

            comparacoes += 3;
            System.out.print("esq ");
            resp = pesquisar(x, i.esq);

        }else{

            comparacoes += 3;
            System.out.print("dir ");
            resp = pesquisar(x, i.dir);

        }

        return resp;

    }

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {

    static Pokemon[] pokemons = new Pokemon[801];
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static int comp = 0;
    static long tempo;
    
    public static void preencherPokedex(){

        String pokedex = "/tmp/pokemon.csv";
        //String pokedex = "../pokemon.csv";

        try{

            RandomAccessFile file = new RandomAccessFile(pokedex, "r");

            Charset charset = Charset.forName("UTF-8");

            file.readLine();

            String linha;
            int i = 0;
            while((linha = file.readLine()) != null){

                linha = new String(linha.getBytes("ISO-8859-1"), charset);

                String[] dadospok = linha.split("\"");
                String habilidades = dadospok[1];
                String[] primeiraParte = dadospok[0].split(",", -1);
                String[] segundaParte = dadospok[2].split(",", -1);

                int id = Integer.parseInt(primeiraParte[0]);
                int generation = Integer.parseInt(primeiraParte[1]);
                String name = primeiraParte[2];
                String description = primeiraParte[3];

                List<String> types = new ArrayList<>();
                types.add(primeiraParte[4]);
                types.add(primeiraParte[5].isEmpty() ? null : primeiraParte[5]);

                List<String> abilities = new ArrayList<>();
                abilities.add(habilidades);

                double weight = segundaParte[1].isEmpty() ? 0 : Double.parseDouble(segundaParte[1]);
                double height = segundaParte[2].isEmpty() ? 0 : Double.parseDouble(segundaParte[2]);
                int captureRate = segundaParte[3].isEmpty() ? 0 : Integer.parseInt(segundaParte[3]);
                boolean isLegendary = segundaParte[4].charAt(0) == '0' ? false : true;
                LocalDate captureDate = LocalDate.parse(segundaParte[5],dtf);

                Pokemon pokemon = new Pokemon(id, generation, name, description, types, abilities, weight, 
                height, captureRate, isLegendary, captureDate);

                pokemons[i] = pokemon;

                i++;

            }

            file.close();

        }catch(IOException e){

            e.getStackTrace();

        }

    }

    public static boolean isFim(String str){

        boolean fim = false;

        if(str.equals("FIM")){
            fim = true;
        }

        return fim;

    }

    public static void criarLog(){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrícula_avinegra.txt"))){

            writer.write("857867" + "\t" + tempo + "ns\t" + comp);

        } catch (IOException e){

            e.printStackTrace();

        }

    }
    
    public static void main(String[] args) throws NumberFormatException, Exception{
        
        preencherPokedex();

        Alvinegra arvore = new Alvinegra();

        Scanner scan = new Scanner(System.in);

        String str = "";

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                arvore.inserir(pokemons[Integer.parseInt(str) - 1].clonar());

            }

        }while(!isFim(str));

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                System.out.println(str);
                System.out.print("raiz ");

                long inicio = System.nanoTime();
                
                if(arvore.pesquisar(str)){

                    System.out.println("SIM");

                }else{

                    System.out.println("NAO");

                }

                long fim = System.nanoTime();
                tempo = (fim - inicio);

            }

        }while(!isFim(str));

        comp = arvore.comparacoes;

        criarLog();

        scan.close();

    }

}