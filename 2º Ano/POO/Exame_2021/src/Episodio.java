import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Episodio implements Playable {

    private String nome;
    private double duracao;
    private int classificacao; //dada pelos seus ouvintes (valor de 0..100)
    private List<String> conteudo; //corresponde ao texto que e’ dito
    //quando se reproduz o episodio
    private int numeroVezesTocada; //qts vezes e’ que o podcast foi ouvido
    private LocalDateTime ultimaVez;

    //construtores

    public Episodio () {
        this.nome = null;
        this.duracao = 0;
        this.classificacao = 0;
        this. conteudo = new ArrayList<>();
        this.numeroVezesTocada = 0;
        this.ultimaVez = null;
    }

    public Episodio(String nome, double duracao, int classificacao, List<String> conteudo, int numeroVezesTocada, LocalDateTime ultimaVez) {
        this.nome = nome;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.conteudo = conteudo;
        this.numeroVezesTocada = numeroVezesTocada;
        this.ultimaVez = ultimaVez;
    }

    //getters e setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public List<String> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<String> conteudo) {
        this.conteudo = conteudo;
    }

    public int getNumeroVezesTocada() {
        return numeroVezesTocada;
    }

    public void setNumeroVezesTocada(int numeroVezesTocada) {
        this.numeroVezesTocada = numeroVezesTocada;
    }

    public LocalDateTime getUltimaVez() {
        return ultimaVez;
    }

    public void setUltimaVez(LocalDateTime ultimaVez) {
        this.ultimaVez = ultimaVez;
    }

    //11
    public void play(){ System.out.println("Não comam pipocas!");this.conteudo.stream().forEach(System.out::print);} //System.media


    @Override
    public String toString() {
        return "Episodio{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", classificacao=" + classificacao +
                ", conteudo=" + conteudo +
                ", numeroVezesTocada=" + numeroVezesTocada +
                ", ultimaVez=" + ultimaVez +
                '}';
    }
}
