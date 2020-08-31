import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;

/**
 * Created by zhigan  on 15.08.2020.
 */
public class Arab {

    static void PrinadlezhnostArabskoyPeremennoy(String P) {
        int pap = 0;
        for (int i = 0; i < P.length(); ++i) {
            for (int k = 0; k < massiv_knopok_4.length; ++k) {
                if (P.charAt(i) == massiv_knopok_4[k].simvol_knopki) {
                    ++pap;
                }
            }
        }
        if (pap != P.length()) {
            try {
                throw new IOException();
            } catch (IOException ioe) {
                System.err.println("Переменная (" + P + ") не принадлежит Арабской");
                System.exit(0);
            }
        }
    }

    //АРАБСКИЕ КНОПКИ
    public static Button k_0a = new Button("Ноль", "", "0", "", 48);
    public static Button k_1a = new Button("Один", "", "1", "", 49);
    public static Button k_2a = new Button("Два", "", "2", "", 50);
    public static Button k_3a = new Button("Три", "", "3", "", 51);
    public static Button k_4a = new Button("Четыре", "", "4", "", 52);
    public static Button k_5a = new Button("Пять", "", "5", "", 53);
    public static Button k_6a = new Button("Шесть", "", "6", "", 54);
    public static Button k_7a = new Button("Семь", "", "7", "", 55);
    public static Button k_8a = new Button("Восемь", "", "8", "", 56);
    public static Button k_9a = new Button("Девять", "", "9", "", 57);

    //МАССИВЫ
    public static Button[] massiv_knopok_3 = {k_1a, k_2a, k_3a, k_4a, k_5a, k_6a, k_7a, k_8a, k_9a};
    public static Button[] massiv_knopok_4 = {k_0a, k_1a, k_2a, k_3a, k_4a, k_5a, k_6a, k_7a, k_8a, k_9a};
}
