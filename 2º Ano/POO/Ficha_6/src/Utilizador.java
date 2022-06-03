import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.*;

public class Utilizador {

    private String email;
    private String password;
    private String nome;
    private String genero;
    private double altura;
    private double peso;
    private LocalDate Data_Nascimento;
    private String Desporto_favorito;
    private Map<String, List<Atividade>> atividades;

    // Constructor

    public Utilizador () {
        this.email = null;
        this.password = null;
        this.nome = null;
        this.genero = null;
        this.altura = 0;
        this.peso = peso;
        this.Data_Nascimento = null;
        this.Desporto_favorito = null;
        this.atividades = new HashMap<>();

    }

    public Utilizador(String email, String password, String nome, String genero, double altura, double peso, LocalDate date, String despoto_favorito,Map<String, List<Atividade>> atividades) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.Data_Nascimento = date;
        this.Desporto_favorito = despoto_favorito;
        this.atividades = atividades;
    }

    public Utilizador (Utilizador u1) {
        this.email = u1.getEmail();
        this.password = u1.getPassword();
        this.nome = u1.getNome();
        this.genero = u1.getGenero();
        this.altura = u1.getAltura();
        this.peso = u1.getPeso();
        this.Data_Nascimento = u1.getData_Nascimento();
        this.Desporto_favorito = u1.getDesporto_favorito();
        this.atividades = u1.getAtividades();

    }


    //Getters e Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(LocalDate data_Nascimento) {
        Data_Nascimento = data_Nascimento;
    }

    public String getDesporto_favorito() {
        return Desporto_favorito;
    }

    public void setDesporto_favorito(String despoto_favorito) {
        Desporto_favorito = despoto_favorito;
    }

    public Map<String, List<Atividade>> getAtividades() {
        return atividades;
    }

    public void setAtividades(Map<String,List<Atividade>> act) { this.atividades = act; }

    public void setAtividades(Set<Atividade> atividades) {
        List <Atividade> grandfinale = new ArrayList<>();
        setAtividades(grandfinale);
    }

    public void setAtividades(List<Atividade> act) { this.atividades.putIfAbsent(act.get(0).getCodigo(),act);}

    public void setAtividades(Atividade act){
        List<Atividade> o = new ArrayList<>();
        o.add(act);
        this.atividades.putIfAbsent(act.getCodigo(),o);
    }}
