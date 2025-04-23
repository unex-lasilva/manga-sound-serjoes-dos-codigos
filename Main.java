import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MangaController controlador = new MangaController();

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MANGA PLAYER ---");
            System.out.println("1. Adicionar música");
            System.out.println("2. Criar lista de reprodução");
            System.out.println("3. Adicionar música à lista");
            System.out.println("4. Reproduzir lista");
            System.out.println("5. Próxima música");
            System.out.println("6. Música anterior");
            System.out.println("7. Pausar");
            System.out.println("8. Parar");
            System.out.println("9. Excluir lista");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Caminho do arquivo: ");
                    String path = scanner.nextLine();
                    System.out.print("Nome do artista: ");
                    String artista = scanner.nextLine();
                    controlador.adicionarMusica(titulo, path, artista);
                    break;

                case 2:
                    System.out.print("Título da playlist: ");
                    String nomeLista = scanner.nextLine();
                    controlador.criarListaReproducao(nomeLista);
                    break;

                case 3:
                    System.out.print("Nome da playlist: ");
                    String playlist = scanner.nextLine();
                    System.out.print("Título da música: ");
                    String nomeMusica = scanner.nextLine();

                    ListaReproducao lista = controlador.buscarLista(playlist);
                    Musica musica = controlador.buscarMusica(nomeMusica);

                    if (lista != null && musica != null) {
                        lista.addMusica(musica);
                        System.out.println("Música adicionada.");
                    } else {
                        System.out.println("Playlist ou música não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Nome da playlist a tocar: ");
                    String nome = scanner.nextLine();
                    controlador.reproduzirListaDeReproducao(nome);
                    break;

                case 5:
                    controlador.getReprodutorLista().proximaMusica();
                    break;

                case 6:
                    controlador.getReprodutorLista().musicaAnterior();
                    break;

                case 7:
                    controlador.getReprodutorLista().pause();
                    break;

                case 8:
                    controlador.getReprodutorLista().stop();
                    break;

                case 9:
                    System.out.print("Nome da playlist a excluir: ");
                    String excluir = scanner.nextLine();
                    controlador.excluirListaReproducao(excluir);
                    break;

                case 10:
                    executando = false;
                    controlador.getReprodutorLista().stop();
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
