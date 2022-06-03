public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo() {
        x = 0;
        y = 0;
        raio = 0;
    }

    public Circulo(double cx, double cy, double craio) {
        x = cx;
        y = cy;
        raio = craio;
    }

    public Circulo(Circulo outro) {
        x = outro.getX();
        y = outro.getY();
        raio = outro.getRaio();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRaio() {
        return raio;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public boolean equals(Object a) {
        if (this == a) {return true;}
        if (a == null || this.getClass() != a.getClass()) {return false;}
        Circulo c = (Circulo) a;
        if (this.y == c.getY() && this.x == c.getX() && this.raio == c.getRaio()) {return true;}
        else return false;
    }

    public void alteraCentro(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double area() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * this.raio;
    }

    public String toString() {
        return "Circulo{" + "x=" + x + ", y=" + y + ", raio=" + raio + '}';
    }

    public static void main(String[] args) {
            Circulo c1 = new Circulo();
    }
}


