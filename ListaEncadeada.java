public class ListaEncadeada<T> {
    private No<T> cabeca;
    private int tamanho;

    private static class No<T> {
        private T valor;
        private No<T> proximo;

        public No(T valor) {
            this.valor = valor;
            this.proximo = null;
        }

        public T getValor() { return valor; }
        public No<T> getProximo() { return proximo; }
        public void setProximo(No<T> proximo) { this.proximo = proximo; }
    }

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void append(T valor) {
        No<T> novoNo = new No<>(valor);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No<T> atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    public boolean remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return false;

        if (posicao == 0) {
            cabeca = cabeca.getProximo();
        } else {
            No<T> anterior = getNo(posicao - 1);
            anterior.setProximo(anterior.getProximo().getProximo());
        }
        tamanho--;
        return true;
    }

    public void insertAt(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }

        No<T> novoNo = new No<>(valor);
        if (posicao == 0) {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
        } else {
            No<T> anterior = getNo(posicao - 1);
            novoNo.setProximo(anterior.getProximo());
            anterior.setProximo(novoNo);
        }
        tamanho++;
    }

    private No<T> getNo(int posicao) {
        No<T> atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public boolean isEmpty() { return tamanho == 0; }

    public int indexOf(T valor) {
        No<T> atual = cabeca;
        int indice = 0;
        while (atual != null) {
            if (atual.getValor().equals(valor)) return indice;
            atual = atual.getProximo();
            indice++;
        }
        return -1;
    }

    public boolean contains(T valor) {
        return indexOf(valor) != -1;
    }

    public void clear() {
        cabeca = null;
        tamanho = 0;
    }

    public T get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        return getNo(posicao).getValor();
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No<T> atual = cabeca;
        while (atual != null) {
            sb.append(atual.getValor());
            if (atual.getProximo() != null) sb.append(", ");
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}
