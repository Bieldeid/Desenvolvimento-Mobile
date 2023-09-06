public class Piloto extends Pessoa{
    private String licenca;
    public Piloto(String nome, int idade, String genero, String licenca) {
        super(nome, idade, genero);
        this.licenca=licenca;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    public void pilotar(Aeronave aeronave){
        System.out.println(getNome() + " estará pilotanto a aeronave Nº" + aeronave.getNumVoo());
    }
}
