import java.time.LocalDateTime;
import java.util.List;

public class EpisodioVideo extends Episodio{

    private List<Byte> conteudo_Video;

    //Construtores

    public EpisodioVideo () {
        super();
        this.conteudo_Video = null;
    }

    public EpisodioVideo (String nome, double duracao, int classificacao, List<String> conteudo, int numeroVezesTocada, LocalDateTime ultimaVez, List<Byte> conteudo_Video) {
        super(nome, duracao, classificacao, conteudo, numeroVezesTocada, ultimaVez);
        this.conteudo_Video = conteudo_Video;
    }

    //Getters e setters

    public List<Byte> getConteudo_Video (){
        return this.conteudo_Video;
    }

    public void setConteudo_Video (List<Byte> conteudo_Video) {
        this.conteudo_Video = conteudo_Video;
    }
}
