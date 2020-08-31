import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zhigan on 13.08.2020.*
 */
public class Calculator {
    public static void main(String[] args) {

        /*Test.test = 1;
        Test.a = 1;//для ТЕСТА
        Test.z = '+';// для ТЕСТА*/
        for (Test.iiii = 1; Test.a < 11; ++Test.iiii) {
            System.out.println("Input:");
            //String DP = Test.Testing();
            String DP = ZakhvatDannykhPolzovatelem();
            if (DP.length() == 0) {
                try {
                    throw new IOException();
                } catch (IOException ioe) {
                    System.err.println("Строка пустая, Вы не ввели данные, поэтому выходим из программы");
                    System.exit(0);
                }
            }
            TipKalkulyatora = OpredelyayemTipKalkulyatora(DP);
            int s = DP.indexOf(ArifmeticheskayaOperatsiya(DP));// Находим индекс арифметического знака в строке
            String DP1 = DP.substring(0, s); // Отделяем от строки переменную находящиюся до арифметического знака
            String DP2 = DP.substring(++s, DP.length()); // Отделяем от строки переменную находящиюся после арифметического знака

            if (TipKalkulyatora == "Arabskiy") {
                Arab.PrinadlezhnostArabskoyPeremennoy(DP1);
                Arab.PrinadlezhnostArabskoyPeremennoy(DP2);
                //System.out.println("ДВЕ ПЕРЕМЕННЫХ ПРИНАДЛЕЖАТ ОДНОМУ ТИПУ КАЛЬКУЛЯТОРА");
                k_ravno.Peremennaya_1 = String.valueOf(Filtr_ot_1_do_10(DP1));
                k_ravno.Peremennaya_2 = String.valueOf(Filtr_ot_1_do_10(DP2));
                k_ravno.CalculationA = Rezultat(Byte.valueOf(k_ravno.Peremennaya_1), Byte.valueOf(k_ravno.Peremennaya_2), k_ravno.ArifmeticheskayaOperatsiya);
                Display.display_1.Calculation = k_ravno.CalculationA;
                Display.Display_0123456789(Display.display_1);
            }

            if (TipKalkulyatora == "Rimskiy") {
                Roman.PrinadlezhnostRimskimSimvolam(DP1);
                Roman.PrinadlezhnostRimskimSimvolam(DP2);
                //System.out.println("ДВЕ ПЕРЕМЕННЫХ ПРИНАДЛЕЖАТ ОДНОМУ ТИПУ КАЛЬКУЛЯТОРА");
                k_ravno.Peremennaya_1 = String.valueOf(Filtr_ot_1_do_10(String.valueOf(Roman.IdentifikatsiyaRimskogoChisla(DP1))));
                k_ravno.Peremennaya_2 = String.valueOf(Filtr_ot_1_do_10(String.valueOf(Roman.IdentifikatsiyaRimskogoChisla(DP2))));
                k_ravno.CalculationA = Rezultat(Byte.valueOf(k_ravno.Peremennaya_1), Byte.valueOf(k_ravno.Peremennaya_2), k_ravno.ArifmeticheskayaOperatsiya);
                k_ravno.CalculationR = Roman.Konverter_Arabskikh_v_Rimskiye(k_ravno.CalculationA);
                Display.display_2.Calculation = k_ravno.CalculationR;
                Display.Display_0123456789(Display.display_2);
            }

        }
    }

    //МЕТОДЫ ОБРАБОТКИ ИНФОРМАЦИИ
    static String ZakhvatDannykhPolzovatelem() {
        Scanner DannyyePolzovatelya = new Scanner(System.in);//Сканируем консоль
        return DannyyePolzovatelya.nextLine();//Возвращаем отсканированную строку
    }

    /**
     * Тут можно описать документацию метода OpredelyayemTipKalkulyatora()
     */
    static String OpredelyayemTipKalkulyatora(String DP) {

        String OTK = "n";
        for (int i = 0; i < Roman.massiv_knopok_1.length; ++i) {
            if (DP.charAt(0) == Roman.massiv_knopok_1[i].simvol_knopki) {
                OTK = "Rimskiy";
            }
        }

        for (int i = 0; i < Arab.massiv_knopok_3.length; ++i) {
            if (DP.charAt(0) == Arab.massiv_knopok_3[i].simvol_knopki) {
                OTK = "Arabskiy";
            }
        }

        if (OTK == "n") {
            try {
                throw new IOException();
            } catch (IOException ioe) {
                System.err.println("Калькулятор НЕ Римский и НЕ Арабский");
                System.exit(0);
            }
        }
        return OTK;
    }

    static int ArifmeticheskayaOperatsiya(String DP) {
        int m = 0;//Количество арифметических операций в строке
        int d = 0;//Индекс знака Арифметической операции

        for (int i = 0; i < DP.length(); ++i) {
            for (int k = 0; k < massiv_knopok_5.length; ++k) {
                if (DP.charAt(i) == massiv_knopok_5[k].simvol_knopki) {
                    d = DP.charAt(i);//Фиксируем индекс Арифметической операции в строке
                    ++m;
                    if (m > 1) {
                        try {
                            throw new IOException();
                        } catch (IOException ioe) {
                            System.err.println("Несколько арифметических операций, поэтому мы выходим из приложения");
                            System.exit(0);
                        }
                    }
                }
            }
        }
        if (m == 0) {
            try {
                throw new IOException();
            } catch (IOException ioe) {
                System.err.println("Арифметические операции не найдены, поэтому мы выходим из приложения");
                System.exit(0);
            }
        }
        k_ravno.ArifmeticheskayaOperatsiya = (char) d;
        return d;// Возвращаем индекс символа арефметической операции
    }

    static Byte Filtr_ot_1_do_10(String DPn) {
        try {
            if (Byte.valueOf(DPn) < Byte.valueOf(Arab.k_1a.arabskoye_znacheniye_knopki) | Byte.valueOf(DPn) > Byte.valueOf(Arab.k_9a.arabskoye_znacheniye_knopki) + 1) {
                try {
                    throw new IOException();
                } catch (IOException iox) {
                    System.err.println("Переменная (" + DPn + ") находится вне допустимого диапазона чисел");
                    System.exit(0);
                }
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Переменная (" + DPn + ") находится вне допустимого диапазона чисел Byte и вообще в целом");
            //System.err.println("nfe\t" + nfe);
            System.exit(0);
        }
        //System.out.println("Переменная " + DPn + " находится в диапазоне от 1 до 10");
        return Byte.valueOf(DPn);
    }

    static String Rezultat(Byte x, Byte y, char c) {
        int h = 0;
        float f = 0;

        String rezultat;
        if (c == k_umnozheniye.simvol_knopki) {
            h = x * y;
        }
        if (c == k_slozheniye.simvol_knopki) {
            h = x + y;
        }
        if (c == k_vychitaniye.simvol_knopki) {
            h = x - y;
        }
        if (c == k_deleniye.simvol_knopki) {
            f = (float) x / y;
            h = x / y;
        }
        rezultat = Float.toString(f);
        Integer r = Integer.valueOf(rezultat.substring(rezultat.indexOf('.') + 1, rezultat.length()));
        if (r > 0) {
            if (TipKalkulyatora == "Arabskiy") {
                rezultat = Float.toString(f);
            }
            if (TipKalkulyatora == "Rimskiy") {
                rezultat = Integer.toString(h);
                //System.out.println("Дробей римляне избегали! Поэтому я решил извлекать из дробного числа только целое, без округления");
            }
        }
        if (r == 0) {
            rezultat = Integer.toString(h);
        }
        return rezultat;
    }

    //АРИФМЕТИЧЕСКИЕ КНОПКИ
    public static Button k_umnozheniye = new Button("Умножение", "", "", "*", 42);
    public static Button k_slozheniye = new Button("Сложение", "", "", "+", 43, 0);
    public static Button k_vychitaniye = new Button("Вычитание", "", "", "-", 45, 1);
    public static Button k_deleniye = new Button("Деление", "", "", "/", 47);
    public static Button k_ravno = new Button("Равно", "=", 61);

    //МАССИВЫ
    public static Button[] massiv_knopok_5 = {k_umnozheniye, k_slozheniye, k_vychitaniye, k_deleniye};

    //ГЛОБАЛЬНЫЕ ПЕРЕМЕННЫЕ
    public static String DP11;
    public static String TipKalkulyatora;
}