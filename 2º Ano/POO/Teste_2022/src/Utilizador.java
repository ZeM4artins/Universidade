import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Utilizador implements Serializable {
    private String numUser;
    private String nomeUser;
    private LocalDate dataAdesao; // data de adesão do utilizador à aplicação
    private Set<Livro> colecao;

    public Utilizador(String numUser, String nomeUser, Iterator<Livro> livros) {
        this.numUser = numUser;
        this.nomeUser = nomeUser;
        this.colecao = new TreeSet<>();
        while (livros.hasNext()) {
            this.colecao.add(livros.next());
        }
    }

    public String getNumUser() {
        return numUser;
    }

    public void setNumUser(String numUser) {
        this.numUser = numUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public LocalDate getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(LocalDate dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    public Set<Livro> getColecao() {
        return colecao;
    }

    public void setColecao(Set<Livro> colecao) {
        this.colecao = colecao;
    }

    public void avancaPags(String codISBN, int n) throws LivroInexistenteException {
        int aux = 0;
        for (Livro l : this.colecao) {
            if (l.codISBN.equals(codISBN)) {
                aux++;
                int i = 0;
                while (i<n) {
                    l.getPagLidas().add(l.getPagPorLer().remove(i));
                    i++;
                }
            }
        }
        if (aux==0) throw new LivroInexistenteException(codISBN);
    }

    public Livro livroMaisLido() {
        int pags_maislido = 0;
        Livro maislido = new Livro();
        for (Livro l : this.colecao) {
            if (l.getPagLidas().size() > pags_maislido) {
                pags_maislido = l.getPagLidas().size();
                maislido = l;
            } else if (l.getPagLidas().size() == pags_maislido) {
                if (l.getNomeLivro().compareTo(maislido.getNomeLivro()) > 0) {
                    pags_maislido = l.getPagLidas().size();
                    maislido = l;
                }
            }
        }
        return maislido;
    }

//    public List<String> reproduzLivros() {
//
//    }

}
