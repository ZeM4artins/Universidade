import java.util.*;
import java.util.stream.Collectors;

public class Fitness {

    private Map<String,Utilizador> utilizadorList;
    private List<Atividade> ativiaddes;

    //Constructor

    public Fitness () {
        this.utilizadorList = new HashMap<>();
    }

    public Fitness(HashMap<String,Utilizador> utilizadorList) {
        this.utilizadorList = utilizadorList;
    }

    // code

    //Fase 1

    public boolean existeUtilizador(String email) {
        return this.utilizadorList.containsKey(email);
    }

    public int quantos() {
        return this.utilizadorList.size();
    }

    public int quantos(String actividade, String email) {
        return this.utilizadorList.get(email).getAtividades().get(actividade).size();
    }

    public Utilizador getUtilizador(String email) {
        return this.utilizadorList.get(email);
    }

    public void adicionaUser (Atividade a1) throws act_rep_exception {
        if (this.ativiaddes.contains(a1)) throw new act_rep_exception();
        else ativiaddes.add(a1);
    }

    public void adiciona(String email, Atividade act) {
        this.utilizadorList.get(email).setAtividades(act);
    }

    public List<Atividade> getAllActividades() {
        List<Atividade> copy = new ArrayList<>();
        copy=this.ativiaddes;
        return copy;
    }

    public void adiciona(String email, Set<Atividade> activs) {
        this.utilizadorList.get(email).setAtividades(activs);
    }

    public int tempoTotalUtilizador(String email) {
        int tempo = 0 ;
        for (Atividade a : this.ativiaddes)
            if (a.getUser().equals(getUtilizador(email))) tempo += a.getDuracao();
        return tempo;
    }

    public Atividade actividadeMaisExigente() {
        double maiornumerodecals = 0;
        int maisexig=0;
        for (int i = 0; i<this.ativiaddes.size(); i++) {
            if (this.ativiaddes.get(i).calorias()>maiornumerodecals) {
                maiornumerodecals = this.ativiaddes.get(i).calorias();
                maisexig=i;
            }
        }
        return this.ativiaddes.get(maisexig);
    }

    public Utilizador utilizadorMaisActivo() {
        Atividade a = actividadeMaisExigente();
        return a.getUser();
    }

    //Fase 2
    public void sortByValue(boolean order, Map<Utilizador,Double> map) {
        List<Map.Entry<Utilizador,Double>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Utilizador, Double>>() {
            public int compare(Map.Entry<Utilizador,Double> o1, Map.Entry<Utilizador, Double> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
    }

    public Set<Utilizador> ordenarUtilizadores_set(){
        Map<Utilizador,Double> caloriasUser = new HashMap<>();
        for(Atividade a:this.act){
            if(caloriasUser.containsKey(a.getUser()==null)) caloriasUser.put(a.getUser(),a.calorias());
            else caloriasUser.put(a.getUser(), caloriasUser.get(a.getUser()) + a.calorias() );
        }
        sortByValue(true,caloriasUser);
        Set<Utilizador> novos = caloriasUser.keySet().stream().collect(Collectors.toSet());
        return novos;
    }


    public List<Utilizador> ordenarUtilizadores_List() {
        Map <Utilizador,Double> caloriasUtilizador = new HashMap<>();
        for (Atividade a : this.ativiaddes) {
            if (caloriasUtilizador.containsKey(a.getUser()==null)) caloriasUtilizador.put(a.getUser(), a.calorias());
            else caloriasUtilizador.put(a.getUser(),caloriasUtilizador.get(a.getUser())+a.calorias());
        }
        sortByValue(true,caloriasUtilizador);
        List<Utilizador> fim = caloriasUtilizador.keySet().stream().collect(Collectors.toList());
        return  fim;
    }


    public Set<Utilizador> ordenarUtilizador(Comparator<Utilizador> c) {
        Set<Utilizador> something = 
    }





}
