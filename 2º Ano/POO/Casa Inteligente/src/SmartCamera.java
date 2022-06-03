public class SmartCamera extends SmartDevice{

    private int resolution;
    private int file_size;
    private double consumo;

    public SmartCamera(int resolution, int file_size, double consumo) {
        this.resolution = resolution;
        this.file_size = file_size;
        this.consumo = consumo;
    }

    public SmartCamera(String s, int resolution, int file_size, double consumo) {
        super(s);
        this.resolution = resolution;
        this.file_size = file_size;
        this.consumo = consumo;
    }

    public SmartCamera(String s, boolean b, int resolution, int file_size, double consumo) {
        super(s, b);
        this.resolution = resolution;
        this.file_size = file_size;
        this.consumo = consumo;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}
