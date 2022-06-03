package Ex1;

import java.util.Objects;

public class Lugar{

    private String matricula ;
        private  String  nome;
        private int minutos ;
        private boolean permanente ;

        public Lugar() {
            this.matricula = null;
            this.nome = null;
            this.minutos = 0;
            this.permanente = false;
        }

        public Lugar (String matricula,String nome, int minutos, boolean permanente) {
            this.matricula = matricula;
            this.nome = nome;
            this. minutos = minutos;
            this.permanente = permanente;
        }

    public Lugar (Lugar lugar){
        this.matricula = lugar.getMatricula();
        this.nome = lugar.getNome();
        this.minutos = lugar.getMinutos();
        this.permanente = lugar.isPermanente();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lugar clone() {
        return new Lugar(this);
    }

    public boolean equals (Object o) {
            if (this==o) return true;
            if (o==null || this.getClass()!=o.getClass()) return false;
            Lugar lugar = (Lugar) o;
            return minutos == lugar.minutos && permanente == lugar.permanente && Objects.equals(matricula, lugar.matricula) && Objects.equals(nome, lugar.nome);
    }

}
