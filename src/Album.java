import java.util.ArrayList;

public class Album {
    private String nome;
    private Artista artista;
    private ArrayList<Musica> musicas;

    public Album(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
        musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public String getNome() {
        return nome;
    }
}
