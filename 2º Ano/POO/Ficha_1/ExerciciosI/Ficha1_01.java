public class Ficha1_01
{
    public int data (int dia, int mes, int ano) { //entre Março de 1900 e Fevereiro de 2100
        int totalDays = (int)((dia-1900)*365+((ano-1900)/4));
        if (ano%4==0&& (ano % 100 != 0 || ano % 400 == 0) && mes < 3) totalDays--;
        for(int i = mes; i > 0; i--) {
            if (i == 2) totalDays += 28;
            else if (i == 4 || i == 6 || i == 9 || i == 11) totalDays += 30;
            else totalDays += 31;
        }
        return totalDays % 7;
    }
}