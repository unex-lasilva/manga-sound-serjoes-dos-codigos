import java.util.Objects;

public class MangaController {
    private ListaEncadeada<Musica> repositoryMusica;
    private ListaEncadeada<ListaReproducao> listasReproducao;
    private ListaEncadeada<String> artistas;
    private ReprodutorLista reprodutorLista;

    public MangaController() {
        this.repositoryMusica = new ListaEncadeada<>();
        this.listasReproducao = new ListaEncadeada<>();
        this.artistas = new ListaEncadeada<>();
        this.reprodutorLista = new ReprodutorLista();
    }

    public void adicionarMusica(String titulo, String path, String nomeArtista) {
        Musica musica = new Musica(titulo, nomeArtista, path);
        repositoryMusica.append(musica);
        if (!artistas.contains(nomeArtista)) {
            artistas.append(nomeArtista);
        }
    }

    public void criarListaReproducao(String titulo) {
        listasReproducao.append(new ListaReproducao(titulo));
    }

    public void excluirListaReproducao(String titulo) {
        for (int i = 0; i < listasReproducao.getTamanho(); i++) {
            ListaReproducao lr = listasReproducao.get(i);
            if (lr.getTitulo().equals(titulo)) {
                listasReproducao.remove(i);
                return;
            }
        }
    }

    public void reproduzirListaDeReproducao(String tituloLista) {
        ListaReproducao lr = buscarLista(tituloLista);
        if (lr != null) {
            reprodutorLista.setListaReproducao(lr);
            reprodutorLista.play();
        }
    }

    // Métodos públicos
    public Musica buscarMusica(String titulo) {
        for (int i = 0; i < repositoryMusica.getTamanho(); i++) {
            Musica m = repositoryMusica.get(i);
            if (m.getTitulo().equals(titulo)) return m;
        }
        return null;
    }

    public ListaReproducao buscarLista(String titulo) {
        for (int i = 0; i < listasReproducao.getTamanho(); i++) {
            ListaReproducao lr = listasReproducao.get(i);
            if (lr.getTitulo().equals(titulo)) return lr;
        }
        return null;
    }

    public ReprodutorLista getReprodutorLista() {
        return reprodutorLista;
    }

    public ListaEncadeada<ListaReproducao> getListasReproducao() {
        return listasReproducao;
    }

    public ListaEncadeada<Musica> getRepositoryMusica() {
        return repositoryMusica;
    }
}
