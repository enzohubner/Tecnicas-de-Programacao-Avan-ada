package colecao;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);

        System.out.println(lista);

        System.out.println("Pesquisar 20: " + lista.pesquisar(20));

        lista.remover(20);

        System.out.println(lista);

        System.out.println("Quantidade: " + lista.quantidadeNos());
    }
}
