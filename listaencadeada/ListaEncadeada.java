package listaencadeada;

import colecao.IColecao;

public class ListaEncadeada<T> implements IColecao<T> {

    private No<T> prim;
    private int quantidade;

    public ListaEncadeada() {
        prim = null;
        quantidade = 0;
    }

    @Override
    public void adicionar(T novoValor) {

        No<T> novo = new No<>(novoValor);

        if (prim == null) {
            prim = novo;
        } else {

            No<T> aux = prim;

            while (aux.prox != null) {
                aux = aux.prox;
            }

            aux.prox = novo;
        }

        quantidade++;
    }

    @Override
    public T pesquisar(T valor) {

        No<T> aux = prim;

        while (aux != null) {

            if (aux.valor.equals(valor)) {
                return aux.valor;
            }

            aux = aux.prox;
        }

        return null;
    }

    @Override
    public boolean remover(T valor) {

        if (prim == null) {
            return false;
        }

        if (prim.valor.equals(valor)) {
            prim = prim.prox;
            quantidade--;
            return true;
        }

        No<T> aux = prim;

        while (aux.prox != null) {

            if (aux.prox.valor.equals(valor)) {
                aux.prox = aux.prox.prox;
                quantidade--;
                return true;
            }

            aux = aux.prox;
        }

        return false;
    }

    @Override
    public int quantidadeNos() {
        return quantidade;
    }

    @Override
    public String toString() {

        String s = "";
        No<T> aux = prim;

        while (aux != null) {

            s += aux.valor;

            if (aux.prox != null) {
                s += ",";
            }

            aux = aux.prox;
        }

        return s;
    }
}