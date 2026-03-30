import java.io.BufferedReader;
import java.io.FileReader;
import colecao.IColecao;
import listaencadeada.ListaEncadeada;
import dominio.Aluno;

public class TesteEmpirico {

    public static void main(String[] args) {

        IColecao<Aluno> lista = new ListaEncadeada<>();

        String arquivo = "dados100000.txt";

        long inicio, fim;

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));

            String linha;
            Aluno ultimo = null;

            inicio = System.currentTimeMillis();

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int nota = Integer.parseInt(partes[2]);

                Aluno aluno = new Aluno(matricula, nome, nota);
                lista.adicionar(aluno);
                ultimo = aluno;
            }

            fim = System.currentTimeMillis();
            System.out.println("Tempo inserção: " + (fim - inicio) + " ms");

            br.close();

            inicio = System.currentTimeMillis();
            lista.pesquisar(ultimo);
            fim = System.currentTimeMillis();
            System.out.println("Busca último: " + (fim - inicio) + " ms");

            Aluno inexistente = new Aluno(0, "NAO_EXISTE", 0);

            inicio = System.currentTimeMillis();
            lista.pesquisar(inexistente);
            fim = System.currentTimeMillis();
            System.out.println("Busca inexistente: " + (fim - inicio) + " ms");

            inicio = System.currentTimeMillis();
            lista.remover(ultimo);
            fim = System.currentTimeMillis();
            System.out.println("Remoção último: " + (fim - inicio) + " ms");

            inicio = System.currentTimeMillis();
            lista.quantidadeNos();
            fim = System.currentTimeMillis();
            System.out.println("Quantidade: " + (fim - inicio) + " ms");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}