import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaginaComAudio extends Pagina implements Serializable {
    private String narrador;
    private List<Byte> som;

    public PaginaComAudio(List<String> texto, String narrador, List<Byte> audio) {
        super(texto);
        this.narrador = narrador;
        this.som = new ArrayList<>(audio);
    }
    /* método que devolve uma formatação do texto e audio */
//    public String reproduzPagina() {...}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaginaComAudio)) return false;
        PaginaComAudio that = (PaginaComAudio) o;
        return Objects.equals(narrador, that.narrador) && Objects.equals(som, that.som);
    }

    @Override
    public int hashCode() {
        return Objects.hash(narrador, som);
    }
}