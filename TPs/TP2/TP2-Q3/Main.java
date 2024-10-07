import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


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

    public Pokemon(int id, String name){

        this.id = id;
        this.name = name;

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

    public Pokemon clone(){

        return new Pokemon(id, name);

    }
	
}

 public class Main {

    static Pokemon[] pokemons = new Pokemon[801];
    static Pokemon[] array = new Pokemon[801];
    static int comp = 0;
    static int n = 0;
    
    public static void preencherPokedex(){

        String pokedex = "/tmp/pokemon.csv";
        //String pokedex = "pokemon.csv";

        try{

            RandomAccessFile file = new RandomAccessFile(pokedex, "r");

            file.readLine();

            String linha;
            int i = 0;

            while((linha = file.readLine()) != null){

                String[] dadospok = linha.split(",");

                pokemons[i] = new Pokemon(Integer.parseInt(dadospok[0]), dadospok[2]);

                i++;

            }

            file.close();

        }catch(IOException e){

            e.getStackTrace();

        }

    }

    public static boolean pesquisa(String str){

        boolean result = false;

        for(int i = 0;i < n;i++){

            if(array[i] != null){

                comp++;
                String nome = array[i].getName();
                if(nome.equals(str)){
    
                    result = true;
                    i = n;
    
                }

            }

        }

        return result;

    }

    public static void criarLog(long tempo, int comp){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrícula_sequencial.txt"))){

            writer.write("857867" + "\t" + tempo + "ns\t" + comp);

        } catch (IOException e){

            e.printStackTrace();

        }

    }

    public static boolean isFim(String str){

        boolean result = false;

        if(str.equals("FIM")){

            result = true;

        }

        return result;

    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        long start = System.nanoTime();

        preencherPokedex();

        String str = "";

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                array[n] = pokemons[Integer.parseInt(str) - 1].clone();

                n++;

            }

        }while(!isFim(str));

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                if(pesquisa(str)){

                    System.out.println("SIM");

                }else{

                    System.out.println("NAO");

                }

            }

        }while(!isFim(str));

        long end = System.nanoTime();
        long tempo = end - start;

        criarLog(tempo, comp);

        scan.close();

    }
    
}