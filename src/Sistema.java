import java.util.ArrayList;

public class Sistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Ouvinte> ouvintes;
    private ArrayList<Artista> artistas;
    private ArrayList<Plano> planos;
    private ArrayList<Musica> musicas;
    private ArrayList<Playlist> playlists;
    private ArrayList<Album> albuns;

    public Sistema() {
        usuarios = new ArrayList<>();
        ouvintes = new ArrayList<>();
        artistas = new ArrayList<>();
        planos = new ArrayList<>();
        musicas = new ArrayList<>();
        playlists = new ArrayList<>();
        albuns = new ArrayList<>();
    }

    public Usuario verificarLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)
                    && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean verificarEmail(String email) {
        String emailMinusculo = email.toLowerCase();

        if (emailMinusculo.endsWith("@gmail.com") ||
                emailMinusculo.endsWith("@gmail.com.br")) {
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean verificarSenha(String senha) {
        return senha.length() >= 8;
    }

    public boolean verificarOuvinte(Usuario usuario) {
        for(Ouvinte ouvinte : ouvintes) {
            if(ouvinte == usuario) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarArtista(Usuario usuario) {
        for(Artista artista : artistas) {
            if(artista == usuario) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Musica> verificarMusica(String nomeMusica) {
        ArrayList<Musica> encontradas = new ArrayList<>();
        for(Musica musica : musicas) {
            if(musica.getNome().equalsIgnoreCase(nomeMusica)) {
                encontradas.add(musica);
                System.out.print(encontradas.indexOf(musica) + 1 + " — ");
                musica.listarMusica();
            }
        }
        return encontradas;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarOuvinte(Ouvinte ouvinte) {
        ouvintes.add(ouvinte);
    }

    public void adicionarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void adicionarPlano(Plano plano) {
        planos.add(plano);
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }

    public ArrayList<Plano> getPlanos() {
        return planos;
    }
}
