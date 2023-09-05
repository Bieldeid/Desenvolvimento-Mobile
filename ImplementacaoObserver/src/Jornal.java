import java.util.*;
import java.util.ArrayList;

public class Jornal implements Publicador{

    private String nome;
    private List<Assinante> assinante = new ArrayList<>();

    public String getNome(){
        return nome;
    }

    public void setNome(){
        this.nome = nome;
    }

    public void adicionarAssinante(Assinante a){
        assinante.add(a);
    }

    public void removerAssinante(Assinante a){
        assinante.remove(a);
    }

    @Override
    public void publicar(String noticia) {
        for(Assinante assinante : assinante){
            assinante.lerNoticia(noticia);
        }
    }
}
