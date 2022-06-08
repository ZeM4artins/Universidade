import java.util.function.Consumer;

public class SmartBulbDimmable extends SmartDevice{

    private double intensidade = 0.5;
    private double totalConsumo = 0;
    private double consumoPorHora;

    public SmartBulbDimmable () {
        super();
    }

    public SmartBulbDimmable(String id, double consumoPorHora) {
        super(id,consumoPorHora);
    }

    public double consumoPorHora () {
        return this.totalConsumo * this.intensidade;
    }
}
