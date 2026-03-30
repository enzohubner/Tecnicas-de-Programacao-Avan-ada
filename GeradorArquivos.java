import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorArquivos {

    public static void main(String[] args) {

        gerarArquivo("dados100000.txt", 100000);
        gerarArquivo("dados200000.txt", 200000);
        gerarArquivo("dados400000.txt", 400000);

        System.out.println("Arquivos gerados com sucesso!");
    }

    public static void gerarArquivo(String nomeArquivo, int quantidade) {

        Random random = new Random();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

            for (int i = 1; i <= quantidade; i++) {

                int matricula = i;
                String nome = "Aluno" + i;
                int nota = random.nextInt(101); // 0 a 100

                String linha = matricula + "," + nome + "," + nota;

                writer.write(linha);
                writer.newLine();
            }

            writer.close();
            System.out.println(nomeArquivo + " criado com " + quantidade + " linhas.");

        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    }
}