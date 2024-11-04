
public class Contato {

    public String nome;
    public String email;

    public Contato(String nome, String email){

        this.nome = nome;
        this.email = email;

    }

    public String toString(){

        return "Nome: " + nome + " | Email: " + email;

    }
    
}