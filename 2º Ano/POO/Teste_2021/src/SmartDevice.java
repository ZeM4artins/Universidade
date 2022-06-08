import java.time.LocalDateTime;

public class SmartDevice {
    private String id;
    private boolean on;
    private double consumoPorHora;
    private LocalDateTime inicio;
//...

    public SmartDevice () {
    this.id = null;
    this.on = false;
    this.consumoPorHora = 0;
    this.inicio = null;
    }

    public SmartDevice( String id, double consumoPorHora) {
        this.id = id;
        this.on = false;
        this.consumoPorHora = consumoPorHora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(double consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }


   public double totalConsumo() {return this.consumoPorHora;}


    //liga o device. Se for a primeira vez inicializa o tempo de inicio
    public void turnOn() {
        this.on = true;
        if (this.inicio == null)
            this.inicio = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "id='" + id + '\'' +
                ", on=" + on +
                ", consumoPorHora=" + consumoPorHora +
                ", inicio=" + inicio +
                '}';
    }
}
