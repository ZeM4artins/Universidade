import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpotifyPOO {

    private List<Podcast> Podcasts;
    private List<Utilizador> Utilizadores;

    // construtores

    public SpotifyPOO () {
        this.Podcasts = new ArrayList<>();
        this.Utilizadores = new ArrayList<>();

    }

    public SpotifyPOO(List<Podcast> podcasts, List<Utilizador> utilizadores) {
        this.Podcasts = podcasts;
        this.Utilizadores = utilizadores;
    }

    //getters e setters

    public List<Podcast> getPodcasts() {
        return Podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        Podcasts = podcasts;
    }

    public List<Utilizador> getUtilizadores() {
        return Utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        Utilizadores = utilizadores;
    }

    // Prints

    @Override
    public String toString() {
        return "SpotifyPOO{" +
                "Podcasts=" + Podcasts +
                ", Utilizadores=" + Utilizadores +
                '}';
    }


    // code


    //6
    public List<Episodio> getEpisodios(String nomePodcast) {
        List<Episodio> Episodios_podcast = new ArrayList<>();
        for(Podcast p : Podcasts) {
            if (p.getNome().equals(nomePodcast)) {
                Episodios_podcast = p.getEpisodios_podcast();
            }
        }
        System.out.println(Episodios_podcast);
        return Episodios_podcast;
    }

    //8
    public void removefunc(String nomeP) throws NaoExisteException, UtilizadorSubscreveException {
        int r=0;
        int rr = 0;
        Podcast removivel = new Podcast();
        for (Utilizador u : Utilizadores) {
            for (Podcast p : u.getInscrito()) {
                if (p.getNome().equals(nomeP)) r++;
            }
        }
        for (Podcast p : Podcasts) {
            if (p.getNome().equals(nomeP)){removivel=p; rr++;}
        }
        if (rr==0) throw new NaoExisteException(nomeP);
        else {
            if (r > 0) throw new UtilizadorSubscreveException(nomeP);
            else {
                this.Podcasts.remove(removivel);
                System.out.println(Podcasts);
            }
        }
    }

    //9
    public Episodio getEpisodioMaisLongo(String u) {
        double maior_duracao = 0;
        Episodio maiorEp = new Episodio();
        for (Utilizador user : Utilizadores) {
            if (user.getId().equals(u)) {
                for (Podcast p : user.getInscrito()) {
                    for (Episodio e : p.getEpisodios_podcast()) {
                        if (e.getDuracao()>maior_duracao) {
                            maior_duracao = e.getDuracao();
                            maiorEp = e;
                        }
                    }
                }
            }
        }
        System.out.println(maior_duracao);
        System.out.println(maiorEp);
        return maiorEp;
    }

    //10
    public Map<Integer,List<Episodio>> episodiosPorClassf() {
        Map<Integer, List<Episodio>> classif_ep = new HashMap<>();
        for (Podcast p : Podcasts) {
            for (Episodio e : p.getEpisodios_podcast()) {
                classif_ep.getOrDefault(e.getClassificacao(), new ArrayList<>()).add(e);
            }
        }
        System.out.println(classif_ep);
        return classif_ep;
    }




    public static void main(String[] args) throws NaoExisteException, UtilizadorSubscreveException, AlreadyPlayingException {
        SpotifyPOO s = new SpotifyPOO();
        Episodio e = new Episodio();
        Episodio e1 = new Episodio();
        EpisodioVideo ev = new EpisodioVideo();
        Utilizador u = new Utilizador();
        Podcast p = new Podcast();

        List<Podcast> lista_pod = new ArrayList<>();
        lista_pod.add(p);

        List<Episodio> lista_ep = new ArrayList<>();
        lista_ep.add(e);
        lista_ep.add(e1);
        lista_ep.add(ev);

        List<Utilizador> lista_users = new ArrayList<>();
        lista_users.add(u);


        e.setNome("As aventuras do Tintin - ep 2");
        e.setDuracao(15);
        e.setClassificacao(4);
        e.setNumeroVezesTocada(200);

        e1.setNome("As Aventuras do Carlos - ep 3");
        e1.setDuracao(20);
        e1.setClassificacao(3);
        e1.setNumeroVezesTocada(120);

        ev.setNome("As aventuras de Tintin - ep 2 - video");
        ev.setDuracao(15);
        ev.setClassificacao(4);
        ev.setNumeroVezesTocada(200);

        u.setId("CarlosDaMaia@gmail.com");
        u.setNome("Carlos");
        u.setInscrito(lista_pod);

        p.setNome("A saga do Tintin");
        p.setEpisodios_podcast(lista_ep);

        s.setPodcasts(lista_pod);
        s.setUtilizadores(lista_users);

        // funcoes

        //s.getEpisodios("A saga do Tintin");

        //s.removefunc("A saga do Tintin");

        //s.getEpisodioMaisLongo("CarlosDaMaia@gmail.com");

        //s.episodiosPorClassf();

        u.playEpisodio("A saga do Tintin","As aventuras de Tintin - ep 2");

    }
}