/**
 * Created by zhigan on 26.08.2020.
 */
public class Test {

    public static String Testing() {


        String DP = "";
        if (Test.test == 2) {
            DP = Test.Test_2();//ТЕСТИРУЕМ
            return DP;
        }
        if (Test.test == 1) {
            DP = Test.Test_1();//ТЕСТИРУЕМ
            return DP;
        }
        return DP;
    }

    public static String Test_1() {

        if (iiii == 1 & a == 1 & z == '+') {
            System.out.println("АРАБСКИЕ вычисления");
            System.out.println("Арифметические операции на СЛОЖЕНИЕ");
        }

        if (iiii == 1 & a == 1 & z == '-') {
            System.out.println("Арифметические операции на ВЫЧЕТАНИЕ");
        }

        if (iiii == 1 & a == 1 & z == '*') {
            System.out.println("Арифметические операции на УМНОЖЕНИЕ");
        }

        if (iiii == 1 & a == 1 & z == '/') {
            System.out.println("Арифметические операции на ДЕЛЕНИЕ");
        }

        String DP = "" + a + z + iiii;

        if (iiii == 10) {
            if (z == '+' & a == 10) {
                z = '-';
                a = 0;
            }
            if (z == '-' & a == 10) {
                z = '*';
                a = 0;
            }
            if (z == '*' & a == 10) {
                z = '/';
                a = 0;
            }

            if (z == '/' & a == 10) {
                //System.out.println("iiii " + Calculator.iiii + "\ta " + Calculator.a + "\tz " + Calculator.z);
                z = '+';
                a = 0;
                test = 2;
            }

            ++a;
            iiii = 0;
        }
        System.out.println(DP);
        return DP;
    }//A

    public static String Test_2() {
        if (iiii == 1 & a == 1 & z == '+') {
            System.out.println("РИМСКИЕ вычисления");
            System.out.println("Арифметические операции на СЛОЖЕНИЕ");
        }

        if (iiii == 1 & a == 1 & z == '-') {
            System.out.println("Арифметические операции на ВЫЧЕТАНИЕ");
        }

        if (iiii == 1 & a == 1 & z == '*') {
            System.out.println("Арифметические операции на УМНОЖЕНИЕ");
        }

        if (iiii == 1 & a == 1 & z == '/') {
            System.out.println("Арифметические операции на ДЕЛЕНИЕ");
        }

        String DP = "" + Roman.Konverter_Arabskikh_v_Rimskiye(String.valueOf(a)) + z + Roman.Konverter_Arabskikh_v_Rimskiye(String.valueOf(iiii));
        //System.out.println("Вы ввели строку \t" + DP);

        if (iiii == 10) {
            if (z == '+' & a == 10) {
                z = '-';
                a = 0;
                //System.out.println("Арифметические операции на ВЫЧЕТАНИЕ");
            }
            if (z == '-' & a == 10) {
                z = '*';
                a = 0;
                //System.out.println("Арифметические операции на УМНОЖЕНИЕ");
            }
            if (z == '*' & a == 10) {
                z = '/';
                a = 0;
                //System.out.println("Арифметические операции на ДЕЛЕНИЕ");
            }

            if (iiii == 10 & a == 10 & z == '/') {
                test = 3;
            }
            ++a;
            iiii = 0;
        }
        System.out.println(DP);
        return DP;
    }//R

    //ГЛОБАЛЬНЫЕ ПЕРЕМЕННЫЕ
    public static int test;//для ТЕСТА
    public static int a;//для ТЕСТА
    public static int iiii;//для ТЕСТА
    public static char z;//для ТЕСТА

}
