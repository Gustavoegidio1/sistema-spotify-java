import java.util.ArrayList;

public class Playlist {
    private String nome;
    private int duracao;
    private Ouvinte ouvinte;
    private ArrayList<Musica> musicas;

    public Playlist(String nome, Ouvinte ouvinte) {
        this.nome = nome;
        this.ouvinte = ouvinte;
        musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        duracao += musica.getDuracao();
    }

    public void listarPlaylist() {
        System.out.println(
                this.nome + "\n" +
                "Duração: " + converterDuracao()
        );
         for(Musica musica : musicas) {
             musica.listarMusica();
         }
    }


    public String converterDuracao() {
        int duracaoTotal = 0;

        for (Musica musica : musicas) {
            duracaoTotal += musica.getDuracao();
        }

        int horas = duracaoTotal / 3600;
        int minutos = (duracaoTotal % 3600) / 60;
        int segundos = duracaoTotal % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public String getNome() {
        return nome;
    }

}
