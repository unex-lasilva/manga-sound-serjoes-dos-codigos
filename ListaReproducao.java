import java.util.Objects;

public class ListaReproducao {
    private String titulo;
    private ListaEncadeada<Musica> lista;

    public ListaReproducao(String titulo) {
        this.titulo = Objects.requireNonNull(titulo, "Título não pode ser nulo");
        this.lista = new ListaEncadeada<>();
    }

    public void addMusica(Musica musica) {
        lista.append(Objects.requireNonNull(musica, "Música não pode ser nula"));
    }

    public boolean removerMusica(int posicao) {
        return lista.remove(posicao);
    }

    public void inserirMusicaEm(int posicao, Musica musica) {
        lista.insertAt(posicao, Objects.requireNonNull(musica));
    }

    public boolean isVazia() { return lista.isEmpty(); }
    public int tamanho() { return lista.getTamanho(); }
    public int posicaoDa(Musica musica) { return lista.indexOf(musica); }
    public boolean contemMusica(Musica musica) { return lista.contains(musica); }
    public Musica obterMusica(int posicao) { return lista.get(posicao); }

    public String getTitulo() { return titulo; }

    public void criarListaApartirDe(ListaReproducao outra) {
        Objects.requireNonNull(outra, "Lista de origem não pode ser nula");
        lista.clear();
        for (int i = 0; i < outra.tamanho(); i++) {
            lista.append(outra.obterMusica(i));
        }
    }

    @Override
    public String toString() {
        return titulo + " (" + tamanho() + " músicas)";
    }
}
