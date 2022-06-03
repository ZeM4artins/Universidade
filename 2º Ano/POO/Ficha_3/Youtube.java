public class Youtube {

    private String nomedovideo;
    private String conteudodovideo;
    private String datadecarregamento;
    private int resolucao;
    private double duracao;
    private String [] comentarios;
    private int like;
    private int dislike;

    public Youtube () {
        this.nomedovideo = null;
        this.conteudodovideo = "Uma merda qlq";
        this.datadecarregamento = null;
        this.resolucao = 0;
        this.duracao = 0.0;
        this.comentarios = null;
        this.like = 0;
        this.dislike = 0;
    }

    public String getNomedovideo() {
        return nomedovideo;
    }

    public void setNomedovideo(String nomedovideo) {
        this.nomedovideo = nomedovideo;
    }

    public String getConteudodovideo() {
        return conteudodovideo;
    }

    public void setConteudodovideo(String conteudodovideo) {
        this.conteudodovideo = conteudodovideo;
    }

    public String getDatadecarregamento() {
        return datadecarregamento;
    }

    public void setDatadecarregamento(String datadecarregamento) {
        this.datadecarregamento = datadecarregamento;
    }

    public int getResolucao() {
        return resolucao;
    }

    public void setResolucao(int resolucao) {
        this.resolucao = resolucao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public void insereComentario(String comentario) {
        this.comentarios[this.comentarios.length] = comentario;
    }

    public void thumbsUp() {
        this.like++;
    }

    public String processa() {
        System.out.println(this.conteudodovideo);
        return  conteudodovideo;
    }

    public static void main(String[] args) {
        Youtube y1 = new Youtube();

    }

}
