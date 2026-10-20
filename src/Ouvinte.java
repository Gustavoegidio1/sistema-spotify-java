import java.util.ArrayList;

 class Ouvinte extends Usuario {
    private static int proximoId = 1;

    private int id;
    private Plano plano;
    private ArrayList<Playlist> playlists;

    public Ouvinte (String nome, String email, String senha, Plano plano) {
        super(nome, email, senha);
        this.id = proximoId++;
        this.plano = plano;
        playlists = new ArrayList<>();
    }

    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public boolean verificarPlaylist(String nome) {
        for(Playlist playlist : playlists) {
            if(playlist.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nome já existente");
                return false;
            }
        }
        return true;
    }

    public void listarPlaylistsIndice() {
        for(Playlist playlist : playlists) {
            System.out.println(
                    playlists.indexOf(playlist) + 1 + " — " + playlist.getNome()
            );
        }
    }

    public Playlist encontrarPlaylist(int numeroPlaylist) {
        for(Playlist playlist : playlists) {
            if(numeroPlaylist == playlists.indexOf(playlist) + 1) {
                return playlist;
            }
        }
        return null;
    }
}
