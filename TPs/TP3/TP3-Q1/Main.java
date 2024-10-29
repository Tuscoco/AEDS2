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

class Lista{

    private Pokemon[] array;
    public int n;

    public Lista(){

        array = new Pokemon[801];
        n = 0;

    }

    public void inserirInicio(Pokemon pokemon) throws Exception{

        if(n >= array.length){

            throw new Exception("Lista cheia!");

        }

        for(int i = n;i > 0;i--){

            array[i] = array[i - 1];
            
        }

        array[0] = pokemon;
        n++;

    }

    public void inserirFim(Pokemon pokemon) throws Exception{

        if(n >= array.length){

            throw new Exception("Lista cheia!");

        }

        array[n] = pokemon;
        n++;

    }

    public void inserir(int pos, Pokemon pokemon) throws Exception{

        if(n >= array.length || pos < 0 || pos > n){

            throw new Exception("Lista cheia ou posição inválida!");

        }

        for(int i = n;i > pos;i--){

            array[i] = array[i - 1];

        }

        array[pos] = pokemon;
        n++;

    }

    public Pokemon removerInicio() throws Exception{

        if(n == 0){

            throw new Exception("Lista vazia!");

        }

        Pokemon resp = array[0];
        n--;

        for(int i = 0;i < n;i++){

            array[i] = array[i + 1];

        }

        return resp;

    }

    public Pokemon removerFim() throws Exception{

        if(n == 0){

            throw new Exception("Lista vazia!");

        }

        return array[--n];

    }

    public Pokemon remover(int pos) throws Exception{

        if(n == 0 || pos < 0 || pos >= n){

            throw new Exception("Lista vazia ou posição inválida!");

        }

        Pokemon resp = array[pos];
        n--;

        for(int i = pos;i < n;i++){

            array[i] = array[i + 1];

        }

        return resp;

    }

    public void mostrar(){

        for(int i = 0;i < n;i++){

            System.out.println("[" + i + "] " + array[i].toString());

        }

    }

}


public class Main {

    static Pokemon[] pokemons = new Pokemon[801];
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static void preencherPokedex(){

        //String pokedex = "/tmp/pokemon.csv";
        String pokedex = "../pokemon.csv";

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
    
    public static void main(String[] args) throws NumberFormatException, Exception{
        
        preencherPokedex();

        Lista lista = new Lista();

        Scanner scan = new Scanner(System.in);

        String str = "";

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                lista.inserirFim(pokemons[Integer.parseInt(str) - 1].clonar());

            }

        }while(!isFim(str));

        int n = scan.nextInt();
        scan.nextLine();

        for(int i = 0;i < n;i++){

            str = scan.nextLine();

            String[] op = str.split(" ");

            if(op[0].equals("II")){

                lista.inserirInicio(pokemons[Integer.parseInt(op[1]) - 1].clonar());

            }else if(op[0].equals("IF")){

                lista.inserirInicio(pokemons[Integer.parseInt(op[1]) - 1].clonar());

            }else if(op[0].equals("I*")){

                lista.inserir(Integer.parseInt(op[1]), pokemons[Integer.parseInt(op[2]) - 1].clonar());

            }else if(op[0].equals("RI")){

                Pokemon temp = lista.removerInicio();

                System.out.println("(R) " + temp.getName());

                temp = null;

            }else if(op[0].equals("RF")){

                Pokemon temp = lista.removerFim();

                System.out.println("(R) " + temp.getName());

                temp = null;

            }else if(op[0].equals("R*")){

                Pokemon temp = lista.remover(Integer.parseInt(op[1]));

                System.out.println("(R) " + temp.getName());

                temp = null;

            }

        }

        lista.mostrar();

        scan.close();

    }

}
