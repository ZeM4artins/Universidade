package Ex1;

import java.util.*;
import java.util.stream.Collectors;

public class Parque {

    private String nome;
    private Map<String, Lugar> Lugar_parque;

    public Parque () {
        this.nome = null;
        this.Lugar_parque = new HashMap<>();
    }

    public Parque (String nome, Map<String,Lugar> Lugar) {
        this.nome = nome;
        setLugar(Lugar);
    }

    public Parque (Parque parque) {
        this.nome = parque.getNome();
        this.Lugar_parque = parque.getLugar();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Lugar> getLugar() {
        return new HashMap<>(this.Lugar_parque);
    }

    public void setLugar(Map<String, Lugar> lugar) {
        this.Lugar_parque = new HashMap<>(this.Lugar_parque);
    }

    public  boolean equals (Object o) {
        if (this==o) return true;
        if (o==null || this.getClass()!=o.getClass()) return false;
        Parque parque = (Parque) o;
        return Objects.equals(nome,parque.nome) && Objects.equals(Lugar_parque,parque.Lugar_parque);
    }

    public Parque clone () {
        return new Parque(this);
    }

    //---------------------------------------------------------------

    public List<String> getAllMatriculas() {
        System.out.println(new ArrayList<>(this.Lugar_parque.keySet()));
        return  new ArrayList<>(this.Lugar_parque.keySet());
    }

    public void novaocupacao (Lugar lugar) {
        this.Lugar_parque.put(lugar.getMatricula(), lugar.clone());
    }

    public void removeLugar (Lugar lugar) {
        this.Lugar_parque.remove(lugar.getMatricula());
    }

    public void alteratempo (String Matricula, int tempo) {
        this.Lugar_parque.get(Matricula).setMinutos(tempo);
    }

    public int minutosatribuidos () {
        return this.Lugar_parque.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

    public boolean existeLugar (String Matricula) {
        return  this.Lugar_parque.containsKey(Matricula);
    }

    public List<Lugar> getAllLugares () {
        return this.Lugar_parque.values().stream().map(Lugar::clone).collect(Collectors.toList());
    }

    public Lugar getInfo (String Matricula) {
        return this.Lugar_parque.get(Matricula).clone();
    }










    public static void main(String[] args) {
        Parque P = new Parque();
        Lugar lugar = new Lugar();

        P.getAllMatriculas();

    }



}
