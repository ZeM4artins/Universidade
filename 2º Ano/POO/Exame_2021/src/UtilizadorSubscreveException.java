public class UtilizadorSubscreveException extends Throwable{

    public UtilizadorSubscreveException (String id) {
        super(id);
        System.out.println("Utilizador subscreve!");
    }
}
