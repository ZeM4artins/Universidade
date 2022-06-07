import java.util.ArrayList;
import java.util.List;

public class Utilizador extends SpotifyPOO {

    private String id; //email
    private String nome;
    private List<Podcast> inscrito;

    private Episodio em_reproducao;

    // construtores

    public Utilizador () {
        this.id = null;
        this.nome = null;
        this.inscrito = new ArrayList<>();
        this.em_reproducao = null;
    }

    public Utilizador(String id, String nome, List<Podcast> inscrito,Episodio em_reproducao) {
        this.id = id;
        this.nome = nome;
        this.inscrito = inscrito;
        this.em_reproducao = em_reproducao;
    }

    //getters e setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Podcast> getInscrito() {
        return inscrito;
    }

    public void setInscrito(List<Podcast> inscrito) {
        this.inscrito = inscrito;
    }

    public Episodio getEm_reproducao() {
        return em_reproducao;
    }

    public void setEm_reproducao(Episodio em_reproducao) {
        this.em_reproducao = em_reproducao;
    }

    //Code

    public void playEpisodio(String idPodCast, String nomeEpisodio) throws AlreadyPlayingException {
        Utilizador u = new Utilizador();
        UtilizadorPremium up = new UtilizadorPremium();
        if (this.getClass().equals(u)) {
            if (this.em_reproducao == null) {
                for (Podcast p : this.inscrito) {
                    if (p.getNome().equals(idPodCast)) {
                        for (Episodio e : p.getEpisodios_podcast()) {
                            if (e.getNome().equals(nomeEpisodio)) e.play();
                        }
                    }
                }
            }
            else throw new AlreadyPlayingException(idPodCast);
        }
        else
        {
            if (this.getClass().equals(up)) {
                up.playEpisodioPremium(idPodCast, nomeEpisodio);
            }
        }

    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", inscrito=" + inscrito +
                '}';
    }
}
