package newListasEncadeadas;
import colecao.IColecao;
import java.util.ArrayList;


public class ListaEncadeadaArrayList<T> implements IColecao<T> {

    private ArrayList<T> lista;

    public ListaEncadeadaArrayList() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void adicionar(T novoValor) {
        lista.add(novoValor);
    }

    @Override
    public T pesquisar(T valor) {
        int index = lista.indexOf(valor);

        if (index >= 0) {
            return lista.get(index);
        }
        return null;
    }

    @Override
    public boolean remover(T valor) {
        return lista.remove(valor);
    }

    @Override
    public int quantidadeNos() {
        return lista.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i));
            
            if (i < lista.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}