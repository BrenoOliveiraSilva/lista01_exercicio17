import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        double area = 0;
        boolean validInput = false;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Informe o tamanho em metros quadrados da área a ser pintada");
            try {
                area = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!");
            }
        }
        double liters = area / 6;
        double litersPlus = liters * 1.1;
        int paintCan = (int) Math.ceil(litersPlus / 18);
        double paintCanPrice = paintCan * 80;
        int gallon = (int) Math.ceil(litersPlus / 3.6);
        double gallonPrice = gallon * 25;
        int paintCanMixed = (int) Math.floor(litersPlus / 18);
        int gallonMixed = (int) Math.ceil((litersPlus % 18) / 3.6);
        if (gallonMixed == 5) {
            gallonMixed = 0;
            paintCanMixed ++;
        }
        double mixedPrice = paintCanMixed * 80 + gallonMixed * 25;
        if (paintCanMixed > 0 && gallonMixed > 0) {
            JOptionPane.showMessageDialog(null, "Metros: " + area + " m²"
            + "\nLitros de tinta necessários: " + numberFormat.format(litersPlus)
            + "\nApenas lata(s): " + paintCan + " | Custo total: " + paintCanPrice
            + "\nApenas galao(oes): " + gallon + " | Custo total: " + gallonPrice
            + "\nPara evitar desperdicio de tinta: " + paintCanMixed + " lata(s) e " + gallonMixed + " galao(oes)" + " | Custo total: " + mixedPrice);
        } else if (paintCanMixed > 0 && gallonMixed == 0) {
            JOptionPane.showMessageDialog(null, "Metros: " + area + " m²"
            + "\nLitros de tinta necessários: " + numberFormat.format(litersPlus)
            + "\nApenas lata(s): " + paintCan + " | Custo total: " + paintCanPrice
            + "\nApenas galao(oes): " + gallon + " | Custo total: " + gallonPrice
            + "\nPara evitar desperdicio de tinta: " + paintCanMixed + " lata(s) | Custo total: " + mixedPrice);
        } else if (paintCanMixed == 0 && gallonMixed > 0) {
            JOptionPane.showMessageDialog(null, "Metros: " + area + " m²"
            + "\nLitros de tinta necessários: " + numberFormat.format(litersPlus)
            + "\nApenas lata(s): " + paintCan + " | Custo total: " + paintCanPrice
            + "\nApenas galao(oes): " + gallon + " | Custo total: " + gallonPrice
            + "\nPara evitar desperdicio de tinta: " + gallonMixed + " galao(oes) | Custo total: " + mixedPrice);
        } else {
            JOptionPane.showMessageDialog(null, "Insíra um valor valído");
        }
    }
}