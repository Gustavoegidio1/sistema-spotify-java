import java.util.ArrayList;

public class Artista extends Usuario {
    private static int proximoId = 1;

    private int id;
    private String nomeArtistico;
    private ArrayList<Album> albuns;
    private ArrayList<Musica> musicas;

    public Artista(String nome, String email, String senha, String nomeArtistico) {
       super(nome, email, senha);
       this.id = proximoId++;
       this.nomeArtistico = nomeArtistico;
       albuns = new ArrayList<>();
       musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    public boolean verificarAlbum(String nome) {
        for(Album album : albuns) {
            if(album.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nome já existente!");
                return false;
            }
        }
        return true;
    }

    public boolean verificarMusica(String nome) {
        for(Musica musica : musicas) {
            if(musica.getNome().equals(nome)) {
                return false;
            }
        }
        return true;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }
}
