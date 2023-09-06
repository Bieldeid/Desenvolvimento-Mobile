public class Passageiro extends Pessoa{
    private String codLocalizador;
    public Passageiro(String nome, int idade, String genero, String codLocalizador) {
        super(nome, idade, genero);
        this.codLocalizador = codLocalizador;
    }

    public String getCodLocalizador() {
        return codLocalizador;
    }

    public void setCodLocalizador(String codLocalizador) {
        this.codLocalizador = codLocalizador;
    }

    public void realizarCheckIn(Aeroporto aeroporto){
        System.out.println("O(a) passageiro(a) " + getNome() + " com o PNR: " + getCodLocalizador() + " realizou o check-in no aeroporto de " + aeroporto.getIata());
    }
}
