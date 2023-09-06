public class Aeronave {
    private int numVoo;
    private int qntDeAssentos;
    private int numeroDePax;

    public Aeronave(int numVoo, int qntDeAssentos) {
        this.numVoo = numVoo;
        this.qntDeAssentos = qntDeAssentos;
        this.numeroDePax = 0;
    }

    public int getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(int numVoo) {
        this.numVoo = numVoo;
    }

    public int getQntDeAssentos() {
        return qntDeAssentos;
    }

    public void setQntDeAssentos(int qntDeAssentos) {
        this.qntDeAssentos = qntDeAssentos;
    }

    public int getNumeroDePax() {
        return numeroDePax;
    }

    public void setNumeroDePax(int numeroDePax) {
        this.numeroDePax = numeroDePax;
    }

    public void voar(){
        System.out.println("Aeronave " + numVoo + " decolou.");
    }
}
