import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pagina implements Comparable<Pagina>, Serializable {
    private List<String> texto;

    public Pagina() {
        this.texto = new ArrayList<>();
    }
    public Pagina(List<String> texto) {
        this.texto = texto;
    }

    public Pagina clone () {
        return this.clone();
    }

    /* método que devolve uma formatação do texto */
    //public String reproduzPagina(){...}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagina)) return false;
        Pagina pagina = (Pagina) o;
        return Objects.equals(texto, pagina.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto);
    }

    @Override
    public int compareTo(Pagina o) {
        return 0;
    }
}