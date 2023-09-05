public class Pessoa implements Assinante {
    private String nome;
    private String documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocument(){
        return documento;
    }

    public void setDocumento(String documento){
        this.documento = documento;
    }

    public void lerNoticia(String noticia){
        System.out.println("Mensagem: " + noticia);
    }
}
