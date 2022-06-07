public class NaoExisteException extends Throwable {

    public NaoExisteException (String id) {
        super(id);
        System.out.println("Não existe!");
    }
}
