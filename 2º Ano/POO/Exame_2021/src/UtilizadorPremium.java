import java.util.ArrayList;
import java.util.List;

public class UtilizadorPremium extends Utilizador {

    private List<Episodio> filadeEspera;

    public UtilizadorPremium() {
        super();
        this.filadeEspera = new ArrayList<>();
    }

    public UtilizadorPremium(String id, String nome, List<Podcast> inscrito, Episodio em_reproducao, List<Episodio> filadeEspera) {
        super(id, nome, inscrito, em_reproducao);
        this.filadeEspera = filadeEspera;
    }

    //Getters e setters

    public List<Episodio> getFiladeEspera() {
        return this.filadeEspera;
    }

    public void setFiladeEspera(List<Episodio> filadeEspera) {
        this.filadeEspera = filadeEspera;
    }

    public void playEpisodioPremium(String idPodCast, String nomeEpisodio) throws AlreadyPlayingException {
        if (this.getEm_reproducao() == null) {
            for (Podcast p : this.getInscrito()) {
                if (p.getNome().equals(idPodCast)) {
                    for (Episodio e : p.getEpisodios_podcast()) {
                        if (e.getNome().equals(nomeEpisodio)) e.play();
                    }
                }
            }
        }
        else {
            for (Podcast p : this.getInscrito()) {
                if (p.getNome().equals(idPodCast)) {
                    for (Episodio e : p.getEpisodios_podcast()) {
                        if (e.getNome().equals(nomeEpisodio)) {
                            List<Episodio> aux = new ArrayList<>();
                            aux = this.getFiladeEspera();
                            aux.add(e);
                            this.setFiladeEspera(aux);
                        }
                    }
                }
            }
        }
    }
}
