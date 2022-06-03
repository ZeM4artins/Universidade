public class ExerciciosII {

    public double celsiusParaFarenheit(double graus){ //F = C x 1,8 + 32.
        double farenheit = graus * 1.8 +32;
        return farenheit;
    }

    public int maximoNumeros(int a, int b) {
        System.out.println(Math.max(a,b));
        return Math.max(a,b);
    }

    public double eurosParaLibras(double valor, double taxaConversao) {
        double libras = valor*taxaConversao;
        System.out.println(libras);
        return libras;
    }
    
}
