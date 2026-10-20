public class Musica {
    private String nome;
    private Artista artista;
    private int duracao;
    private Album album;

    public Musica(String nome, Artista artista, int duracao, Album album) {
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
        this.album = album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getNome() {
        return nome;
    }

    public void listarMusica() {
        System.out.println(
                this.nome + " — " + this.artista.getNomeArtistico() + " — " +  conversaoMinutos()
        );
    }

    public String conversaoMinutos() {
        int minuto = this.duracao / 60;
        int segundos = this.duracao % 60;

        return String.format("%02d:%02d", minuto, segundos);
    }
}
