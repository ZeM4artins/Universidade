public class Carro {

    private String Marca;
    private String Modelo;
    private int anodeconstr;
    private double consumo;
    private int kmstotais;
    private double mediaconsumo;
    private int kmsultimopercurso;
    private double mediaconsumoultimopercurso;
    private double capacidaderegenera;
    private boolean ligado;

    public Carro () {
        this.Marca = null;
        this.Modelo = null;
        this.anodeconstr = 0;
        this.consumo = 0;
        this.kmstotais = 0;
        this.mediaconsumo = 0;
        this.kmsultimopercurso = 0;
        this.mediaconsumoultimopercurso = 0;
        this.capacidaderegenera = 0;
        this.ligado = false;
    }

    public Carro (String Marca, String Modelo, int anodeconstr,
                  double consumo, int kmstotais, double mediaconsumo,
                  int kmsultimopercurso, double mediaconsumoultimopercurso,
                  double capacidaderegenera, boolean ligado) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.anodeconstr = anodeconstr;
        this.consumo = consumo;
        this.kmstotais = kmstotais;
        this.mediaconsumo = mediaconsumo;
        this.kmsultimopercurso = kmsultimopercurso;
        this.mediaconsumoultimopercurso = mediaconsumoultimopercurso;
        this.capacidaderegenera = capacidaderegenera;
        this.ligado = ligado;
    }

    public Carro (Object o) {
        
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getAnodeconstr() {
        return anodeconstr;
    }

    public void setAnodeconstr(int anodeconstr) {
        this.anodeconstr = anodeconstr;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public int getKmstotais() {
        return kmstotais;
    }

    public void setKmstotais(int kmstotais) {
        this.kmstotais = kmstotais;
    }

    public double getMediaconsumo() {
        return mediaconsumo;
    }

    public void setMediaconsumo(double mediaconsumo) {
        this.mediaconsumo = mediaconsumo;
    }

    public int getKmsultimopercurso() {
        return kmsultimopercurso;
    }

    public void setKmsultimopercurso(int kmsultimopercurso) {
        this.kmsultimopercurso = kmsultimopercurso;
    }

    public double getMediaconsumoultimopercurso() {
        return mediaconsumoultimopercurso;
    }

    public void setMediaconsumoultimopercurso(double mediaconsumoultimopercurso) {
        this.mediaconsumoultimopercurso = mediaconsumoultimopercurso;
    }

    public double getCapacidaderegenera() {
        return capacidaderegenera;
    }

    public void setCapacidaderegenera(double capacidaderegenera) {
        this.capacidaderegenera = capacidaderegenera;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void ligaCarro () {
        this.ligado = true;
    }

    public void desligaCarro () {
        this.ligado = false;
    }

    public void resetUltimaViagem() {
        if (this.ligado==false)
        {
            this.ligado=true;
            this.kmsultimopercurso=0;
            this.ligado=false;
        }
        else {
            this.kmsultimopercurso = 0;
        }
    }

    public static void main(String[] args) {

    }




}
