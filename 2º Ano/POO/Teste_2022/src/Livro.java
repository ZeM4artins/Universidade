import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Livro extends Pagina implements Comparable<Livro>, Serializable {
    public String codISBN; //código ISBN do livro
    private String nomeLivro;
    private String autor;
    private String editora;
    private List<Pagina> pagLidas; // páginas já lidas

    private List<Pagina> pagPorLer; //páginas ainda por ler.

    // para o ultimo exercicio

    //private List<PaginaMultimedia> pagLidas; poderia por a null o som e a multimedia caso fossem inexistentes
    //private List <PaginaMultimedia> pagPorLer;
    public Livro () {
        this.codISBN = null;
        this.nomeLivro = null;
        this.autor = null;
        this.editora = null;
        this.pagLidas = null;
        this.pagPorLer = null;
    }

    public Livro(String codISBN, String nomeLivro, String autor, String editora, List<Pagina> pagLidas, List<Pagina> pagPorLer) {
        this.codISBN = codISBN;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.editora = editora;
        this.pagLidas = pagLidas;
        this.pagPorLer = pagPorLer;
    }

    public String getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(String codISBN) {
        this.codISBN = codISBN;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Pagina> getPagLidas() {
        return pagLidas;
    }

    public void setPagLidas(List<Pagina> pagLidas) {
        this.pagLidas = pagLidas;
    }

    public List<Pagina> getPagPorLer() {
        return pagPorLer;
    }

    public void setPagPorLer(List<Pagina> pagPorLer) {
        this.pagPorLer = pagPorLer;
    }

    /* método que devolve a página com o número indicado */
    public Pagina devolvePag(int numPag) throws PagInexistenteException {
        Pagina res = null;
        int numLidas = this.pagLidas.size(); //número de páginas lidas
        int porLer = this.pagPorLer.size();
        if (numPag > numLidas+porLer)
            throw new PagInexistenteException(numLidas);
        if (numPag <= numLidas )
            res = this.pagLidas.get(numPag -1);
        else
            res = this.pagPorLer.get(numPag-numLidas -1);
        return res.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return Objects.equals(codISBN, livro.codISBN) && Objects.equals(nomeLivro, livro.nomeLivro) && Objects.equals(autor, livro.autor) && Objects.equals(editora, livro.editora) && Objects.equals(pagLidas, livro.pagLidas) && Objects.equals(pagPorLer, livro.pagPorLer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codISBN, nomeLivro, autor, editora, pagLidas, pagPorLer);
    }

    @Override
    public int compareTo(Livro o) {
        return 0;
    }
}
