import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.nio.charset.Charset;
import java.io.BufferedWriter;
import java.io.FileWriter;


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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class CelulaDupla{

    public Pokemon elemento;
    public CelulaDupla prox, ant;

    public CelulaDupla(){

        this.elemento = null;
        this.prox = this.ant = null;

    }

    public CelulaDupla(Pokemon pok){

        this.elemento = pok;
        this.prox = this.ant = null;

    }

}

class ListaDupla{

    private CelulaDupla primeiro, ultimo;
    private int tam;
    public int comp = 0;

    public ListaDupla(){

        primeiro = new CelulaDupla();
        ultimo = primeiro;
        tam = 0;

    }

    public void inserirInicio(Pokemon pok){

        CelulaDupla tmp = new CelulaDupla(pok);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro == ultimo){

            ultimo = tmp;

        }else{

            tmp.prox.ant = tmp;

        }

        tam++;
        tmp = null;

    }

    public void inserirFim(Pokemon pok){

        ultimo.prox = new CelulaDupla(pok);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;

        tam++;

    }

    public Pokemon removerInicio() throws Exception{

        if(primeiro == ultimo){

            throw new Exception("Erro!");

        }

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;

        Pokemon elemento = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;
        tam--;

        return elemento;

    }

    public Pokemon removerFim() throws Exception{

        if(primeiro == ultimo){

            throw new Exception("Erro!");

        }

        Pokemon elemento = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        tam--;

        return elemento;

    }

    public void inserir(int pos, Pokemon pok) throws Exception{

        if(pos < 0 || pos > tam){

            throw new Exception("Erro!");

        }else if(pos == 0){

            inserirInicio(pok);

        }else if(pos == tam){

            inserirFim(pok);

        }else{

            CelulaDupla i = primeiro;
            for(int j = 0;j < pos;j++, i = i.prox);

            CelulaDupla tmp = new CelulaDupla(pok);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;

        }

        tam++;

    }

    public Pokemon remover(int pos) throws Exception{

        Pokemon elemento;

        if(primeiro == ultimo || pos < 0 || pos >= tam){

            throw new Exception("Erro!");

        }else if(pos == 0){

            elemento = removerInicio();

        }else if(pos == tam - 1){

            elemento = removerFim();

        }else{

            CelulaDupla i = primeiro.prox;
            for(int j = 0;j < pos;j++, i = i.prox);

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            elemento = i.elemento;
            i.prox = i.ant = null;
            i = null;

        }

        tam--;

        return elemento;

    }

    public void swap(CelulaDupla i, CelulaDupla j){

        Pokemon tmp = i.elemento;
        i.elemento = j.elemento;
        j.elemento = tmp;

    }

    public void ordenar(CelulaDupla esq, CelulaDupla dir, int es, int di){

        if(es >= di || esq == null || dir == null){

            return;

        }

        CelulaDupla i = esq;
        int ii = es;
        CelulaDupla j = dir;
        int jj = di;
        CelulaDupla pivot = dir;

        while(ii <= jj){

            comp++;
            while(i != null && (i.elemento.getGeneration() < pivot.elemento.getGeneration() || 
            (i.elemento.getGeneration() == pivot.elemento.getGeneration() && 
            i.elemento.getName().compareTo(pivot.elemento.getName()) < 0))){

                i = i.prox;
                ii++;

            }

            comp++;
            while(j != null && (j.elemento.getGeneration() > pivot.elemento.getGeneration() || 
            (j.elemento.getGeneration() == pivot.elemento.getGeneration() && 
            j.elemento.getName().compareTo(pivot.elemento.getName()) > 0))){

                j = j.ant;
                jj--;

            }

            if(ii <= jj && i != null && j != null){

                swap(i, j);
                i = i.prox;
                j = j.ant;
                ii++;
                jj--;

            }

        }

        if(es < jj && esq != null){

            ordenar(esq, j, es, jj);

        }

        if(ii < di && i != null){

            ordenar(i, dir, ii, di);

        }

    }

    public void ordenar(){

        ordenar(primeiro.prox, ultimo, 0, tam - 1);

    }

    public void mostrar(){

        CelulaDupla i = primeiro.prox;

        while(i != null){

            System.out.println(i.elemento.toString());
            i = i.prox;

        }

    }

    public int getComp(){

        return comp;

    }

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class Main {

    static Pokemon[] pokemons = new Pokemon[801];
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

    public static void criarLog(int comp){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrícula_quicksort3.txt"))){

            writer.write("857867" + "\t" + tempo + "ns\t" + comp);

        } catch (IOException e){

            e.printStackTrace();

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

        ListaDupla lista = new ListaDupla();

        Scanner scan = new Scanner(System.in);

        String str = "";

        do{

            str = scan.nextLine();

            if(!isFim(str)){

                lista.inserirFim(pokemons[Integer.parseInt(str) - 1].clonar());

            }

        }while(!isFim(str));

        long inicio = System.nanoTime();

        lista.ordenar();

        long fim = System.nanoTime();
        tempo = (fim - inicio);

        lista.mostrar();

        criarLog(lista.getComp());

        scan.close();

    }

}
