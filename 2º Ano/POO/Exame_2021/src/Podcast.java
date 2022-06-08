import java.util.ArrayList;
import java.util.List;

public class Podcast {

    private String nome;
    private List<Episodio> episodios_podcast;


    // construtores
    public Podcast () {
        this.nome = null;
        this.episodios_podcast = new ArrayList<>();
    }

    public Podcast(String nome, List<Episodio> episodios_podcast) {
        this.nome = nome;
        this.episodios_podcast = episodios_podcast;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Episodio> getEpisodios_podcast() {
        return episodios_podcast;
    }

    public void setEpisodios_podcast(List<Episodio> episodios_podcast) {
        this.episodios_podcast = episodios_podcast;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "nome='" + nome + '\'' +
                ", episodios_podcast=" + episodios_podcast +
                '}';
    }
}
