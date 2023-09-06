import java.util.ArrayList;

public class Aeroporto {
    private String iata;
    private ArrayList<Aeronave> aeronaves;
    private ArrayList<Pessoa> pessoas;

    public Aeroporto(String iata) {
        this.iata = iata;
        this.aeronaves = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public ArrayList<Aeronave> getAeronaves() {
        return aeronaves;
    }

    public void setAeronaves(ArrayList<Aeronave> aeronaves) {
        this.aeronaves = aeronaves;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void aterrissarAeronave(Aeronave aeronave){
        System.out.println("Aeronave Nº" + aeronave.getNumVoo()  + " aterrisou em no aeroporto de " + iata);
    }

    public void adicionarAeronave(Aeronave aeronave){
        this.aeronaves.add(aeronave);
    }

    public void removerAeronave(Aeronave aeronave){
        this.aeronaves.remove(aeronave);
    }

    public void adicionarPessoa(Pessoa pessoa){
        this.pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa){
        this.pessoas.remove(pessoa);
    }

}
