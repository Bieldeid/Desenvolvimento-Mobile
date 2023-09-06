import java.security.PublicKey;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Aeronave av1 = new Aeronave(1346, 200);
        Aeronave av2 = new Aeronave(1447, 300);

        Aeroporto ae1 = new Aeroporto("GRU");
        Aeroporto ae2 = new Aeroporto("CGH");

        ae1.adicionarAeronave(av1);
        ae2.adicionarAeronave(av2);

        Piloto p1 = new Piloto("Rogerinho",47, "Masculino", "AC15762");
        Piloto p2 = new Piloto("Roger Peralta",50,"Masculino","AD19175");

        Passageiro pax1 = new Passageiro("Jake Peralta",30,"Masculino","ANKTLI");
        Passageiro pax2 = new Passageiro("Amy Peralta", 28, "Feminino", "QWERTY");

        System.out.println();
        p1.pilotar(av1);
        av1.voar();
        System.out.println();
        p2.pilotar(av2);
        av2.voar();
        System.out.println();
        pax1.realizarCheckIn(ae1);
        pax1.embarcar(av1);
        System.out.println();
        pax2.realizarCheckIn(ae2);
        pax2.embarcar(av2);
        System.out.println();
        ae1.aterrissarAeronave(av2);
        System.out.println();
        ae2.aterrissarAeronave(av1);



    }
}