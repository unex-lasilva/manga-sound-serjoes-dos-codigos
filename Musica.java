import java.util.Objects;

public class Musica {
    private final String titulo;
    private final String artista;
    private final String path;
    private int duracao;

    public Musica(String titulo, String artista, String path) {
        this(titulo, artista, path, 0);
    }

    public Musica(String titulo, String artista, String path, int duracao) {
        this.titulo = Objects.requireNonNull(titulo, "Título não pode ser nulo");
        this.artista = Objects.requireNonNull(artista, "Artista não pode ser nulo");
        this.path = Objects.requireNonNull(path, "Path não pode ser nulo");
        setDuracao(duracao);
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getPath() { return path; }
    public int getDuracao() { return duracao; }

    public void setDuracao(int duracao) {
        if (duracao < 0) throw new IllegalArgumentException("Duração não pode ser negativa");
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return titulo.equals(musica.titulo) &&
                artista.equals(musica.artista) &&
                path.equals(musica.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, artista, path);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d:%02d)", artista, titulo, duracao / 60, duracao % 60);
    }

    public String getDuracaoFormatada() {
        return String.format("%d:%02d", duracao / 60, duracao % 60);
    }
}
