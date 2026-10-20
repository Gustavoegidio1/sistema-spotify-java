import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Sistema sistema = new Sistema();

        Plano planoFamily = new Plano("Family", 40.90);
        sistema.adicionarPlano(planoFamily);
        Plano planoIndividual = new Plano("Individual", 23.90);
        sistema.adicionarPlano(planoIndividual);
        Plano planoDuo = new Plano("Duo", 31.90);
        sistema.adicionarPlano(planoDuo);
        Plano planoStudent = new Plano("Student", 12.90);
        sistema.adicionarPlano(planoStudent);

        menu(teclado, sistema, sistema.getPlanos());
    }


    public static void menu(Scanner teclado, Sistema sistema, ArrayList<Plano> planos) {
        while(true) {
            System.out.print(
                    "Menu de Opções:\n" +
                            "1 - Cadastrar Usuário\n" +
                            "2 - Fazer Login\n" +
                            "3 - Finalizar Sessão" +
                            "Escolha: "
            );

            int escolha = teclado.nextInt();
            teclado.nextLine();

            if (escolha == 1) {
                cadastrarUsuario(teclado, sistema, planos);
            }
            else if (escolha == 2) {
                Usuario usuario = fazerLogin(teclado, sistema);
                if(usuario != null) {
                    if(sistema.verificarOuvinte(usuario)) {
                        menuOuvinte(teclado, sistema, (Ouvinte) usuario);
                    }

                    else if(sistema.verificarArtista(usuario)) {
                        menuArtista(teclado, sistema, (Artista) usuario);
                    }
                }

                else {
                    System.out.println("Usuário inexistente!");
                    continue;
                }
            }

            else if(escolha == 3) {
                System.out.println("Sessão finalizada.");
                return;
            }

            else {
                System.out.println("Opção inexistente");
            }
        }
    }

    public static void cadastrarUsuario(Scanner teclado, Sistema sistema, ArrayList<Plano> planos) {
        String nome;
        String email;
        String senha;

        while(true) {
            System.out.print(
                    "Qual conta deseja criar:\n" +
                            "1 - Ouvinte\n" +
                            "2 - Artista\n" +
                            "Escolha: ");
            int escolha = teclado.nextInt();
            teclado.nextLine();

            if (escolha == 1 || escolha == 2) {
                System.out.print("Digite o Nome: ");
                nome = teclado.nextLine();

                while (true) {
                    System.out.print("Digite o seu E-mail: ");
                    email = teclado.nextLine();
                    if (!sistema.verificarEmail(email)) {
                        System.out.println("E-mail inválido/incorreto!");
                        continue;
                    }
                    break;
                }

                while (true) {
                    System.out.print("Digite sua Senha com no mínimo 8 caracteres: ");
                    senha = teclado.nextLine();
                    if (!sistema.verificarSenha(senha)) {
                        System.out.println("A senha deve ter pelo menos 8 caracteres!");
                        continue;
                    }
                    break;
                }

                if (escolha == 1) {
                    Plano planoProcurado = escolherPlano(teclado, planos);
                    Ouvinte ouvinte = new Ouvinte(nome, email, senha, planoProcurado);
                    planoProcurado.adicionarOuvinteLista(ouvinte);
                    sistema.adicionarUsuario(ouvinte);
                    sistema.adicionarOuvinte(ouvinte);
                    System.out.println("Ouvinte criado com sucesso!");
                    return;

                } else if (escolha == 2) {
                    System.out.print("Digite o Nome Artístico: ");
                    String nomeArtistico = teclado.nextLine();
                    Artista artista = new Artista(nome, email, senha, nomeArtistico);
                    sistema.adicionarUsuario(artista);
                    sistema.adicionarArtista(artista);
                    System.out.println("Artista criado com sucesso!");
                    return;
                }
            }
            else {
                System.out.println("Opção inexistente!");
                continue;
            }
        }
    }

    public static Plano escolherPlano(Scanner teclado, ArrayList<Plano> planos) {
        while (true) {
            System.out.print(
                    "Qual plano deseja escolher:\n" +
                            "1 - Family:\nR$40,90 / mês\n" +
                            "2 - Individual:\nR$23,90 / mês\n" +
                            "3 - Duo\nR$31,90 / mês\n" +
                            "4 - Student\nR$12,90 / mês\n" +
                            "Escolha: "
            );

            int escolhaPlano = teclado.nextInt();
            teclado.nextLine();

            if (escolhaPlano == 1) {
                return procurarPlano(1, planos);
            } else if (escolhaPlano == 2) {
                return procurarPlano(2, planos);
            } else if (escolhaPlano == 3) {
                return procurarPlano(3, planos);
            } else if (escolhaPlano == 4) {
                return procurarPlano(4, planos);
            } else {
                System.out.println("Plano inexistente, digite novamente:");
                continue;
            }
        }
    }

    public static Plano procurarPlano(int idPlano, ArrayList<Plano> planos) {
        for(Plano plano : planos) {
            if (plano.getId() == idPlano) {
                return plano;
            }
        }
        return null;
    }

    public static Usuario fazerLogin(Scanner teclado, Sistema sistema) {
        for (int tentativa = 3; tentativa >= 1; tentativa--) {
            System.out.print("Digite o E-mail: ");
            String email = teclado.nextLine();

            System.out.print("Digite a Senha: ");
            String senha = teclado.nextLine();
            Usuario usuario = sistema.verificarLogin(email, senha);

            if (usuario != null) {
                return usuario;
            }
            else {
                System.out.println("E-mail/Senha errados");
                System.out.println("Você tem mais " + (tentativa - 1) + " tentativas");
            }
        }
        return null;
    }


    public static void menuOuvinte(Scanner teclado, Sistema sistema, Ouvinte ouvinte) {
        while(true) {
            System.out.print(
                    "Menu Ouvinte:\n" +
                            "1 - Criar Playlist\n" +
                            "2 - Adicionar Música\n" +
                            "3 - Ver Playlist\n" +
                            "4 - Sair\n" +
                            "Escolha: "
            );

            int escolha = teclado.nextInt();
            teclado.nextLine();

            if (escolha == 1) {
                criarPlaylist(ouvinte, sistema, teclado);
            } else if (escolha == 2) {
                adicionarMusica(teclado, sistema, ouvinte);
            } else if (escolha == 3) {
                verPlaylist(ouvinte, teclado);
            }
            else if (escolha == 4) {
                return;
            }

            else {
                System.out.println("Opção inexistente!");
            }
        }
    }

    public static void criarPlaylist(Ouvinte ouvinte, Sistema sistema, Scanner teclado) {
        while(true) {
            System.out.print("Digite o Nome: ");
            String nome = teclado.nextLine();

            if(!ouvinte.verificarPlaylist(nome)) {
                continue;
            }
            Playlist playlist = new Playlist(nome, ouvinte);
            ouvinte.adicionarPlaylist(playlist);
            sistema.adicionarPlaylist(playlist);

            System.out.println("Playlist criada com sucesso.");
            return;
        }
    }

    public static void adicionarMusica(Scanner teclado, Sistema sistema, Ouvinte ouvinte) {
        while(true) {
            System.out.print("Digite o Nome da Música: ");
            String nomeMusica = teclado.nextLine();
            ArrayList<Musica> encontradas = sistema.verificarMusica(nomeMusica);
            if (!encontradas.isEmpty()) {
                System.out.print(
                        "Qual música deseja adicionar:\n" +
                                "Escolha: "
                );
                int escolhaMusica = teclado.nextInt();
                teclado.nextLine();

                for (Musica musica : encontradas) {
                    if (escolhaMusica == encontradas.indexOf(musica) + 1) {
                        while (true) {
                            System.out.println("Qual playlist deseja adicionar: ");
                            ouvinte.listarPlaylistsIndice();
                            System.out.print("Escolha: ");
                            int escolhaPlaylist = teclado.nextInt();
                            Playlist playlist = ouvinte.encontrarPlaylist(escolhaPlaylist);
                            if (playlist != null) {
                                playlist.adicionarMusica(musica);
                                System.out.println("Música adicionada com sucesso!");
                                return;
                            }
                            System.out.println("Opção inexistente!");
                            continue;
                        }

                    }
                    else {
                        System.out.println("Opção inexistente!");
                    }
                }
            } else {
                System.out.println("Nenhuma música encontrada!");
                continue;
            }
        }

    }

    public static void verPlaylist(Ouvinte ouvinte, Scanner teclado) {
        while (true) {
            ouvinte.listarPlaylistsIndice();
            System.out.print("Qual Playlist deseja ver: ");
            int escolhaPlaylist = teclado.nextInt();

            Playlist playlist = ouvinte.encontrarPlaylist(escolhaPlaylist);

            if (playlist != null) {
                playlist.listarPlaylist();
                return;
            } else {
                continue;
            }
        }
    }

    public static void menuArtista(Scanner teclado, Sistema sistema, Artista artista) {
        while(true) {
            System.out.print(
                    "Menu Artista:\n" +
                            "1 - Publicar Álbum\n" +
                            "2 - Publicar Música\n" +
                            "3 - Sair\n" +
                            "Escolha: "
            );

            int escolha = teclado.nextInt();
            teclado.nextLine();

            if (escolha == 1) {
                publicarAlbum(artista, sistema, teclado);
            }
            else if (escolha == 2) {
                publicarMusica(artista, sistema, teclado);
            }

            else if(escolha == 3) {
                return;
            }
            else {
                System.out.println("Opção inexistente!");
                continue;
            }
        }
    }

    public static Musica criarMusica(Artista artista, Scanner teclado) {
        while(true) {
            System.out.print("Digite o Nome da Música: ");
            String nome = teclado.nextLine();

            if (!artista.verificarMusica(nome)) {
                continue;
            }

            System.out.print("Qual a Duração(segundos): ");
            int duracao = teclado.nextInt();
            teclado.nextLine();

            return new Musica(nome, artista, duracao, null);
        }
    }

    public static void publicarAlbum(Artista artista, Sistema sistema, Scanner teclado) {
        while(true) {
           System.out.print("Digite o Nome do Álbum: ");
           String nome = teclado.nextLine();

           if (!artista.verificarAlbum(nome)) {
               continue;
           }
           Album album = new Album(nome, artista);
           sistema.adicionarAlbum(album);
           artista.adicionarAlbum(album);

           while(true) {
               System.out.print("Deseja adicionar Música ao Álbum(s/n): ");
               String escolha = teclado.nextLine();
               if (escolha.equals("s") || escolha.equals("S")) {
                   Musica musica = criarMusica(artista, teclado);
                   musica.setAlbum(album);
                   album.adicionarMusica(musica);
                   artista.adicionarMusica(musica);
                   sistema.adicionarMusica(musica);
               }
               else if (escolha.equals("n") || escolha.equals("N")) {
                   return;
               }
               continue;
           }
       }

    }

    public static void publicarMusica(Artista artista, Sistema sistema, Scanner teclado) {
        Musica musica = criarMusica(artista, teclado);

        sistema.adicionarMusica(musica);
        artista.adicionarMusica(musica);

    }
}
