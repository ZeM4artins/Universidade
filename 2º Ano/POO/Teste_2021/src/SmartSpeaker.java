public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20; //volume maximo da coluna
    private int volume;
    private String channel;

    public SmartSpeaker() {
        super();
        this.volume = 0;
        this.channel = null;
    }

    public SmartSpeaker(String id, String channel, double consumoPorHora) {
        super(id, consumoPorHora);
        this.channel = channel;
        this.volume = 10;
    }

    @Override
    public String toString() {
        return "SmartSpeaker{" +
                "volume=" + volume +
                ", channel='" + channel + '\'' +
                '}';
    }
}
