public class Main {

    public static void main(String[] args) {
        Trabalhador t1 = new Trabalhador();
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        Revista r1 = new Revista();
        Jornal j1 = new Jornal();
        Jornal j2 = new Jornal();

        a1.setNome("Rodolfo");
        a1.setDocumento("1111111");

        a2.setNome("Deid");
        a2.setDocumento("22222222");

        t1.setNome("Pricrila");
        t1.setDocumento("33333333");

        r1.adicionarAssinante(a2);
        j1.adicionarAssinante(t1);
        j2.adicionarAssinante(a1);

        r1.publicar("Baleia Baleia Baleia");
        j1.publicar("Mudo conta relato sobre arrastão no RJ, veja seu depoimento: '                '");
        j2.publicar("Maçã cai na cabeça de um maluco e ele cria as leis da gravidade.");

    }
}
