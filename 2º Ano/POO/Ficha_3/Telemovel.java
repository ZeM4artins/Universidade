public class Telemovel {

    private String marca;
    private String modelo;
    private String display;
    private String[] dimensao_msg;
    private String dimensao_fotos_apk;
    private String[] dimensao_fotos;
    private String[] dimensao_apk;
    private int espaco_total;
    private int fotos;
    private int apk;
    private String[] apk_ins;


    public Telemovel() {
        this.marca = "Apple";
        this.modelo = "Iphone";
        this.display = "1920x1080";
        this.dimensao_msg = null;
        this.dimensao_fotos_apk = "0";
        this.dimensao_fotos = null;
        this.dimensao_apk = null;
        this.espaco_total = 256000;
        this.fotos = 0;
        this.apk = 0;
        this.apk_ins = null;

    }

}