import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ListIterator;


public class Ficha4 {


    // STACK

    public class Stack {
        ArrayList<String> stack = new ArrayList<String>();;

        public String top () {
            String x = (stack.get(stack.size()-1));
            System.out.println(x);
            return x;
        }

        public void push(String s) {
            stack.add(s);
        }

        public void pop() {
            stack.remove(stack.size()-1);
        }

        public boolean empty() {
            if (stack.size()==0){System.out.println("true"); return  true;}
            else {System.out.println("false");return false;}
        }

        public int length() {
            System.out.println(stack.size());
            return stack.size();
        }

        public void showStack (){
            System.out.println(stack);
        }

    }

    //----------------------------------------------------------------------------------------

    // CASA INTELIGENTE

    public class CasaInteligente {

        private ArrayList<Lampada> lampadas = new ArrayList<>();

        public void addLampada(Lampada l) {
            lampadas.add(l);
        }

        public void ligaLampadaNormal(int index) {
            lampadas.get(index).lampON();
        }

        public void ligaLampadaEco(int index) {
            lampadas.get(index).lampECO();
        }

        public int qtEmEco() {
            int eco=0;
            for (int i=0; i<lampadas.size();i++) {
            if (lampadas.get(i).getModo() == Lampada.Modo.ECO) eco++;
            }
            return eco;
        }

        public void removeLampada(int index) {
            lampadas.remove(index);
        }

        public void ligaTodasEco() {
            lampadas.stream().forEach(Lampada::lampECO);
            }

        public void ligaTodasMax() {
            lampadas.stream().forEach(Lampada::lampON);
        }

        public double consumoTotal() {
            return lampadas.stream().mapToDouble(Lampada::totalConsumo).sum();
        }

        public Lampada maisGastadora () {
            return lampadas.stream().map(Lampada::clone).max((l1,l2)->comparesl(l1,l2)).get();
        }

        public int comparesl(Lampada l1, Lampada l2) {
            if (l1.totalConsumo()>(l2.totalConsumo())) return 1;
            if (l1.totalConsumo()<(l2.totalConsumo())) return -1;
            return 0;
        }

//        public Set<Lampada> podiumEconomia () {
//            for (int i=0; i<3;i++) {
//                lampadas.stream().map(Lampada::clone).min((l1, l2) -> compares(l1, l2)).get();
//
//            }
//            return
//        }

        public void reset(){
            lampadas.stream().forEach(l->l.setPeriodoConsumo(0.0));
        }

        }

        //--------------------------------------------------------------------------------------------

    //  FACEBOOK

    public class FBFeed {

        private ArrayList<FBPost> FB  = new ArrayList<>();

        public FBFeed() {
            this.FB  = new ArrayList<FBPost>();
        }


        public int nrdePosts (String user) {
            return Postsof(user).size();

        }

        public List<FBPost> Postsof (String user)
        {
            return  FB.stream()
                    .map(FBPost::clone)
                    .filter(f->f.getUser().equals(user))
                    .collect(Collectors.toList());
        }

        public List<FBPost> postsOfDate (String user, LocalDateTime inicio, LocalDateTime fim) {
            return  FB.stream()
                    .map(FBPost::clone)
                    .filter(f->f.getCreationDate().compareTo(inicio)>=0&&f.getCreationDate().compareTo(fim)<=0)
                    .collect(Collectors.toList());
        }


        public FBPost getPost(int id){
            for(FBPost f : this.FB){
                if(f.getId()==id)
                    return f.clone();
            }
            return null;
        }

        public void comment(FBPost post, String comentario) {
            for (FBPost p : this.FB) {
                if (p.equals(post)) p.setComments(comentario);
            }
        }

        public void comment(int postid, String comentario) {
            for (FBPost p : this.FB) {
                if (p.getId()==postid) {
                    p.setComments(comentario);
                }
            }
        }

        public void like(int postid) {
            for (FBPost p : this.FB) {
                if (p.getId()==postid) p.setLikes(p.getLikes()+1);
            }
        }


        public List<Integer> top5Comments_int(){
            return FB.stream().map(FBPost::clone)
                    .sorted((f1,f2)->comparesF(f1,f2))
                    .limit(5)
                    .map(FBPost::getId)
                    .collect(Collectors.toList());
        }

        public int comparesF(FBPost f1, FBPost f2) {
            if ((f1.getComments().size())>(f2.getComments().size())) return 1;
            if ((f1.getComments().size())<(f2.getComments().size())) return -1;
            return 0;
        }

    }


    public static void main(String[] args) {

        switch(Integer.parseInt(args[0])) {


            case 1: {
                Ficha4 f4 = new Ficha4();
                Stack stack = f4.new Stack();

                stack.empty();
                stack.push("Carlos");
                stack.empty();
                stack.push("Carla");
                stack.showStack();
                stack.length();
                stack.pop();
                stack.showStack();
                stack.length();
            }
            break;

        }
    }

}

