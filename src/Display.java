/**
 * Created by zhigan  on 25.08.2020.
 */
public class Display {
    int Digit = 0;
    String Calculation;

    //КОНСТРУКТОРЫ
    Display(int Dg) {
        Digit = Dg;
    }

    public static void Display_0123456789(Display d){
        if (d.Calculation.length()<= d.Digit) {
            System.out.println("Output:");
            System.out.println(d.Calculation);
        }

        if (d.Calculation.length() > d.Digit){
            System.out.println("ИТОГИ больше длины дисплея, поэтому будет отображенно первые " + d.Digit + " символов");
            System.out.println("Output:");
            System.out.println(d.Calculation.substring(0, d.Digit));
        }
    }

    //ДИСПЛЕИ
    public static Display display_1 = new Display(90);
    public static Display display_2 = new Display(170);

}
