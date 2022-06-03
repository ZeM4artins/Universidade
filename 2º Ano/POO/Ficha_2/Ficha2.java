import javax.imageio.stream.ImageInputStream;
import javax.management.MBeanAttributeInfo;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


public class Ficha2 {

    public static void Exercicio1a() {

        Scanner input = new Scanner(System.in);

        System.out.println("Qual a dimensão do array?");
        int tamanho = input.nextInt();

        int min = 0;
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for (int i = 0; i < tamanho; i++) {
            if (i == 0) {
                min = input.nextInt();
                numeros.add(min);
            } else {
                int value = input.nextInt();
                if (min > value) min = value;
                numeros.add(value);
            }
        }

        System.out.println("O minimo é "+min);
    }

    public static void Exercicio1b() {

        Scanner input = new Scanner(System.in);

        System.out.println("Qual a dimensão do array?");
        int tamanho = input.nextInt();

        System.out.println("Quais os indices que quer recolher?");
        int indice1 = input.nextInt();
        int indice2 = input.nextInt();

        ArrayList<Integer> lista = new ArrayList<Integer>();

        System.out.println("Qual a sua lista?");
        for (int i=0;i<tamanho;i++) {
            int n;
            n = input.nextInt();
            lista.add(n);
            if (i==indice1) System.out.println("O numero no indice 1 é "+ lista.get(i));
            if (i==indice2) System.out.println("O numero no indice 2 é "+ lista.get(i));
        }
    }

    public static void Exercicio1c () {


        Scanner input = new Scanner(System.in);

        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();

        System.out.println("Qual a dimensão da sua primeira lista");
        int tamanho1 = input.nextInt();
        System.out.println("Indique a sua lista:");
        for (int i=0;i<tamanho1;i++) {
        int n = input.nextInt();
        lista1.add(n);
        }

        System.out.println("Qual a dimensão da sua segunda lista");
        int tamanho2 = input.nextInt();
        System.out.println("Indique a sua lista:");
        for (int i=0;i<tamanho2;i++) {
            int n = input.nextInt();
            lista2.add(n);
        }

        int tamanhomenor;
        if (tamanho1<tamanho2) tamanhomenor = tamanho1;
        else tamanhomenor = tamanho2;

        ArrayList<Integer> juncao = new ArrayList<Integer>();

        for (int i=0;i<tamanho1;i++) {
            for (int j=0;j<tamanho2;j++)
                if (lista1.get(i)==lista2.get(j)) {
                    juncao.add(lista1.get(i));
                    break;
                }
        }

        System.out.println(juncao);

    }


    public static void Exercicio2 () {

        int [][] notasTurma = new int [5][5]; // i alunos j cadeiras

        



    }


    public static void main(String[] args) {

        Exercicio1c();
    }
}
