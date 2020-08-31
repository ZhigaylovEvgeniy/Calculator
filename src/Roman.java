import java.io.IOException;

/**
 * Created by zhigan on 15.08.2020.
 * <p>
 * ЭКСКУРС
 * 1) Дробей римляне избегали! Поэтому я решил извлекать из дробного числа только целое, без округления
 * <p>
 * 2) В системе римских цифр отсутствует ноль, но ранее использовалось обозначение нуля как nulla (нет),
 * nihil (ничто) и N (первая буква этих слов ).
 * Я ВЫБРАЛ
 * N
 */
public class Roman {

    static void PrinadlezhnostRimskimSimvolam(String P) {
        for (int i = 0; i < P.length(); ++i) {
            Byte pap = 0;
            for (int k = 0; k < massiv_knopok_1.length; ++k) {
                if (P.charAt(i) == massiv_knopok_1[k].simvol_knopki) {
                    ++pap;
                }
            }
            if (pap == 0) {
                try {
                    throw new IOException();
                } catch (IOException ioe) {
                    System.err.println("Переменная (" + P + ") не принадлежит Римской");
                    System.exit(0);
                }
            }
        }
    }

    static int MaksimalnayaRazryadnostRimskogoChisla(String DP1) {
        int m_r_r_c = 0;
        for (int i = 0; i < DP1.length(); ++i) {
            for (int ii = 0; ii < massiv_knopok_1.length; ++ii) {
                if (DP1.charAt(i) == massiv_knopok_1[ii].simvol_knopki) {
                    if (massiv_knopok_1[ii].razryadnost_knopki > m_r_r_c) {
                        m_r_r_c = massiv_knopok_1[ii].razryadnost_knopki;
                    }
                }
            }
        }
        return m_r_r_c;
    }

    static int IdentifikatsiyaRimskogoChisla(String DP) {
        int MRRC = MaksimalnayaRazryadnostRimskogoChisla(DP);
        int IRCD = 0;
        int IRCYp = 0;
        int IRCY = 0;
        int RC = 0;
        if (MRRC == k_1r.razryadnost_knopki) {
            //System.out.println("Еденицы");
            IRCY = IdentifikatsiyaRimskogoChislaIzYedenits(DP);
            //System.out.println("Индетификация Римского Числа из Десяток = " + IRCY);
            RC = IRCY;
            return RC;
        }

        if (MRRC == k_5r.razryadnost_knopki) {
            //System.out.println("Еденицы (половинка)");
            IRCYp = IdentifikatsiyaRimskogoChislaIzYedenitsPolovinok(DP);
            //System.out.println("Индетификация Римского Числа из Десяток = " + IRCYp);
            RC = IRCYp;
            return RC;
        }

        if (MRRC == k_10r.razryadnost_knopki) {
            //System.out.println("10Десятки");
            IRCD = IdentifikatsiyaRimskogoChislaIzDesyatok(DP);
            //System.out.println("Индетификация Римского Числа из Десяток = " + IRCD);
            RC = IRCD;
            return RC;
        }
        return RC;
    }

    static int IdentifikatsiyaRimskogoChislaIzDesyatok(String DP1) {
        int MRRC = MaksimalnayaRazryadnostRimskogoChisla(DP1);
        int VDRC = 0;//Десятки
        int VYpRC = 0;//Еденицы половинки
        int VYRC = 0;//Еденицы
        if (MRRC == k_10r.razryadnost_knopki) {
            VDRC = MMRC10(DP1, Vozvrashchayem_desyatki_ot_Rimskogo_chisla(DP1));
            DP1 = Calculator.DP11;
            MRRC = MaksimalnayaRazryadnostRimskogoChisla(DP1);
            if (MRRC == k_10r.razryadnost_knopki) {
                //проверяем еденицы на цифру 9
                VYRC = MMRC10_09(DP1, Vozvrashchayem_desyatki_ot_Rimskogo_chisla(DP1));
                //System.out.println("5\t" + VDRC + "\t" + VYpRC + "\t" + VYRC);
                return (VDRC + VYpRC + VYRC);
            }
            if (MRRC == k_5r.razryadnost_knopki) {
                VYRC = MMRC5(DP1, Vozvrashchayem_yedenitsyPolovinki_ot_Rimskogo_chisla(DP1));
                return (VDRC + VYpRC + VYRC);
            }

            if (MRRC == k_1r.razryadnost_knopki) {
                VYRC = MMRC1(DP1, Vozvrashchayem_yedenitsy_ot_Rimskogo_chisla(DP1));
                //System.out.println("25\t" + VDRC + "\t" + VYpRC + "\t" + VYRC);
                return (VDRC + VYpRC + VYRC);
            }
        }
        //System.out.println("25\t" + VDRC + "\t" + VYpRC + "\t" + VYRC);
        return (VDRC + VYpRC + VYRC);
    }

    static int IdentifikatsiyaRimskogoChislaIzYedenitsPolovinok(String DP1) {
        int MRRC = MaksimalnayaRazryadnostRimskogoChisla(DP1);
        int VYpRC = 0;//Еденицы половинки
        int VYRC = 0;//Еденицы
        if (MRRC == k_5r.razryadnost_knopki) {
            VYRC = MMRC5(DP1, Vozvrashchayem_yedenitsyPolovinki_ot_Rimskogo_chisla(DP1));
            return (VYpRC + VYRC);
        }

        if (MRRC == k_1r.razryadnost_knopki) {
            VYRC = MMRC1(DP1, Vozvrashchayem_yedenitsy_ot_Rimskogo_chisla(DP1));
            //System.out.println("25\t" + VYpRC + "\t" + VYRC);
            return (VYpRC + VYRC);
        }
        //System.out.println("25\t" + VYpRC + "\t" + VYRC);
        return (VYpRC + VYRC);
    }

    static int IdentifikatsiyaRimskogoChislaIzYedenits(String DP1) {
        int MRRC = MaksimalnayaRazryadnostRimskogoChisla(DP1);
        int VYRC = 0;//Еденицы
        if (MRRC == k_1r.razryadnost_knopki) {
            VYRC = MMRC1(DP1, Vozvrashchayem_yedenitsy_ot_Rimskogo_chisla(DP1));
        }
        //System.out.println("25\t" + VYRC);
        return VYRC;
    }

    static int MMRC1(String DP1, int VYRC) {
        if (VYRC == 1) {
            DP1 = DP1.substring(1, DP1.length());//обрезаем еденицы от строки
            //System.out.println("10\tНОВАЯ СТРОКА DP1\t" + DP1);
        }
        if (VYRC == 2) {
            DP1 = DP1.substring(2, DP1.length());//обрезаем еденицы от строки
            //System.out.println("11\tНОВАЯ СТРОКА DP1\t" + DP1);
        }
        if (VYRC == 3) {
            DP1 = DP1.substring(3, DP1.length());//обрезаем еденицы от строки
            //System.out.println("12\tНОВАЯ СТРОКА DP1\t" + DP1);
        }
        if (DP1.length() > 0) {
            try {
                throw new IOException();
            } catch (IOException ioe) {
                System.err.println("Римское число записано не верно, выходим из приложения");
                System.exit(0);
            }
        }
        return VYRC;
    }

    static int MMRC5(String DP1, int VYRC) {
        int VYpRC = 0;
        if (VYRC == 4) {
            DP1 = DP1.substring(2, DP1.length());//обрезаем еденицы от строки
            //System.out.println("6\tНОВАЯ СТРОКА DP1\t" + DP1);
            if (DP1.length() > 0) {
                try {
                    throw new IOException();
                } catch (IOException ioe) {
                    System.err.println("Римское число записано не верно, выходим из приложения");
                    System.exit(0);
                }
            }
            //System.out.println("2\t" + VYRC);
            return VYRC;
        }
        if (VYRC != 4) {
            VYRC = 0;
        }
        VYpRC = Vozvrashchayem_yedenitsyPolovinki_ot_Rimskogo_chisla(DP1);
        if (VYpRC == 5) {
            DP1 = DP1.substring(1, DP1.length());//обрезаем еденицы от строки
            //System.out.println("8\tНОВАЯ СТРОКА DP1\t" + DP1);
            int MRRC = MaksimalnayaRazryadnostRimskogoChisla(DP1);

            if (MRRC == k_5r.razryadnost_knopki) {
                try {
                    throw new IOException();
                } catch (IOException ioe) {
                    System.err.println("Римское число записано не верно, выходим из приложения");
                    System.exit(0);
                }
            }
            if (MRRC == k_1r.razryadnost_knopki) {
                VYRC = Vozvrashchayem_yedenitsy_ot_Rimskogo_chisla(DP1);
                MMRC1(DP1, VYRC);
            }
            //System.out.println("3\t" + VYpRC + "\t" + VYRC);
            return (VYpRC + VYRC);
        }
        if (VYpRC != 5) {
            try {
                throw new IOException();
            } catch (IOException ioe) {
                System.err.println("Римское число записано не верно, выходим из приложения");
                System.exit(0);
            }
        }
        //System.out.println("3\t" + VYpRC + "\t" + VYRC);
        return (VYpRC + VYRC);
    }

    static int MMRC10_09(String DP1, int VYRC) {
        if (VYRC == 9) {
            DP1 = DP1.substring(2, DP1.length());//обрезаем еденицы от строки
            //System.out.println("3\tНОВАЯ СТРОКА DP1\t" + DP1);
            if (DP1.length() > 0) {
                try {
                    throw new IOException();
                } catch (IOException ioe) {
                    System.err.println("Римское число записано не верно, выходим из приложения");
                    System.exit(0);
                }
            }
            //System.out.println("5\t" + VYRC);
            return VYRC;
        }
        if (VYRC != 9) {
            VYRC = 0;
            try {
                throw new IOException();
            } catch (IOException ioe) {
                System.err.println("Римское число записано не верно, выходим из приложения");
                System.exit(0);
            }
        }
        return VYRC;
    }

    static int MMRC10(String DP1, int VDRC) {
        if (VDRC == 10) {
            DP1 = DP1.substring(1, DP1.length());//обрезаем десятки от строки
            //System.out.println("6\tНОВАЯ СТРОКА DP1\t" + DP1);
        }
        if (VDRC == 20) {
            DP1 = DP1.substring(2, DP1.length());//обрезаем десятки от строки
            //System.out.println("7\tНОВАЯ СТРОКА DP1\t" + DP1);
        }
        if (VDRC == 30) {
            DP1 = DP1.substring(3, DP1.length());//обрезаем десятки от строки
            //System.out.println("8\tНОВАЯ СТРОКА DP1\t" + DP1);
        }
        if (VDRC == 9) {
            VDRC = 0;
        }
        Calculator.DP11 = DP1;
        return VDRC;
    }

    //Десятки
    static int Vozvrashchayem_desyatki_ot_Rimskogo_chisla(String P) {
        int Rp = 0;
        if (P.charAt(0) == k_1r.simvol_knopki) {
            //Проверяем на число 9
            if (P.length() > 1) {
                if (P.charAt(1) == k_10r.simvol_knopki) {
                    Rp = 9;
                }
            }
        }
        if (P.charAt(0) == k_10r.simvol_knopki) {
            Rp = 10;
            if (P.length() > 1) {
                if (P.charAt(1) == k_10r.simvol_knopki) {
                    Rp = 20;
                    if (P.length() > 2) {
                        if (P.charAt(2) == k_10r.simvol_knopki) {
                            Rp = 30;
                            if (P.length() > 3) {
                                if (P.charAt(3) == k_10r.simvol_knopki) {
                                    Rp = 0;
                                    try {
                                        throw new IOException();
                                    } catch (IOException ioe) {
                                        System.err.println("Римское число записано не верно, выходим из приложения");
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Rp;
    }

    //ЕДЕНИЦЫ (это Еденицы половинки и Еденицы)
    static int Vozvrashchayem_yedenitsyPolovinki_ot_Rimskogo_chisla(String P) {
        int Rp = 0;
        if (P.charAt(0) == k_1r.simvol_knopki) {
            //Предположительно число 4, поэтому нужно проверить второй символ на число 5
            if (P.length() > 1) {
                if (P.charAt(1) == k_5r.simvol_knopki) {
                    Rp = 4;//Четвёрка подтвердилась
                }
                if (P.charAt(1) != k_5r.simvol_knopki) {
                    try {
                        throw new IOException();
                    } catch (IOException ioe) {
                        System.err.println("Римское число записано не верно, выходим из приложения");
                        System.exit(0);
                    }
                }
            }
        }

        if (P.charAt(0) == k_5r.simvol_knopki) {
            Rp = 5;
        }

        return Rp;
    }

    static int Vozvrashchayem_yedenitsy_ot_Rimskogo_chisla(String P) {
        int Rp = 0;
        if (P.charAt(0) == k_1r.simvol_knopki) {
            Rp = 1;
            if (P.length() > 1) {
                if (P.charAt(1) == k_1r.simvol_knopki) {
                    Rp = 2;
                    if (P.length() > 2) {
                        if (P.charAt(2) == k_1r.simvol_knopki) {
                            Rp = 3;
                            if (P.length() > 3) {
                                if (P.charAt(3) == k_1r.simvol_knopki) {
                                    Rp = 0;
                                    try {
                                        throw new IOException();
                                    } catch (IOException ioe) {
                                        System.err.println("Римское число записано не верно, выходим из приложения");
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Rp;
    }

    static String Konverter_Arabskikh_v_Rimskiye(String Rezultat) {
        String RC = Rezultat;
        String RCDT = "";
        String RCT = "";
        String RCS = "";
        String RCD = "";
        String RCY = "";
        for (int ii = 1; ii < Rezultat.length() + 1; ++ii) {
            for (int i = 0; i < Arab.massiv_knopok_3.length; ++i) {
                if (RC.charAt(0) == Arab.massiv_knopok_3[i].simvol_knopki) {
                    if (RC.length() == 3) {
                        RCS = Arab.massiv_knopok_3[i].arabskoye_znacheniye_knopki;
                        //System.out.println("Конвертертируем. Извлекаем из Арабского числа " + Rezultat + " СОТНИ\t" + RCS);
                        if (RCS.equals(Arab.k_1a.arabskoye_znacheniye_knopki)) {
                            RCS = k_100r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCS);
                        }
                    }
                    if (RC.length() == 2) {
                        RCD = Arab.massiv_knopok_3[i].arabskoye_znacheniye_knopki;
                        //System.out.println("Конвертертируем. Извлекаем из Арабского числа " + Rezultat + " ДЕСЯТКИ\t" + RCD);
                        if (RCD.equals(Arab.k_1a.arabskoye_znacheniye_knopki)) {
                            RCD = k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_2a.arabskoye_znacheniye_knopki)) {
                            RCD = k_10r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_3a.arabskoye_znacheniye_knopki)) {
                            RCD = k_10r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_4a.arabskoye_znacheniye_knopki)) {
                            RCD = k_10r.rimskoye_znacheniye_knopki + k_50r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_5a.arabskoye_znacheniye_knopki)) {
                            RCD = k_50r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_6a.arabskoye_znacheniye_knopki)) {
                            RCD = k_50r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_7a.arabskoye_znacheniye_knopki)) {
                            RCD = k_50r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_8a.arabskoye_znacheniye_knopki)) {
                            RCD = k_50r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                        if (RCD.equals(Arab.k_9a.arabskoye_znacheniye_knopki)) {
                            RCD = k_10r.rimskoye_znacheniye_knopki + k_100r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCD);
                        }
                    }
                    if (RC.length() == 1) {
                        RCY = Arab.massiv_knopok_3[i].arabskoye_znacheniye_knopki;
                        //System.out.println("Конвертертируем. Извлекаем из Арабского числа " + Rezultat + " ЕДЕНИЦЫ\t" + RCY);
                        if (RCY.equals(Arab.k_1a.arabskoye_znacheniye_knopki)) {
                            RCY = k_1r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_2a.arabskoye_znacheniye_knopki)) {
                            RCY = k_1r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_3a.arabskoye_znacheniye_knopki)) {
                            RCY = k_1r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_4a.arabskoye_znacheniye_knopki)) {
                            RCY = k_1r.rimskoye_znacheniye_knopki + k_5r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_5a.arabskoye_znacheniye_knopki)) {
                            RCY = k_5r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_6a.arabskoye_znacheniye_knopki)) {
                            RCY = k_5r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_7a.arabskoye_znacheniye_knopki)) {
                            RCY = k_5r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_8a.arabskoye_znacheniye_knopki)) {
                            RCY = k_5r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki + k_1r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_9a.arabskoye_znacheniye_knopki)) {
                            RCY = k_1r.rimskoye_znacheniye_knopki + k_10r.rimskoye_znacheniye_knopki;
                            //System.out.println(RCY);
                        }
                        if (RCY.equals(Arab.k_0a.arabskoye_znacheniye_knopki)) {
                            RCY = "N";
                            //System.out.println("В системе римских цифр отсутствует ноль, но ранее использовалось обозначение нуля как nulla (нет), nihil (ничто) и N (первая буква этих слов). Я ВЫБРАЛ " + RCY);
                        }
                    }
                }
            }
            RC = Rezultat.substring(ii, Rezultat.length());
        }

        if (Integer.valueOf(Rezultat) < 0) {
            return "-" + RCDT + RCT + RCS + RCD + RCY;
        }
        if (Integer.valueOf(Rezultat) == 0) {
            //System.out.println("В системе римских цифр отсутствует ноль, но ранее использовалось обозначение нуля как nulla (нет), nihil (ничто) и N (первая буква этих слов). Я ВЫБРАЛ " + RCY);
            return "N";
        }
        return RCDT + RCT + RCS + RCD + RCY;
    }

    //РИМСКИЕ КНОПКИ
    public static Button k_1r = new Button("Один", "I", "1", "", 73, 1, "");
    public static Button k_5r = new Button("Пять", "V", "5", "", 86, 2, "половинка");
    public static Button k_10r = new Button("Десять", "X", "10", "", 88, 3, "");
    public static Button k_50r = new Button("Пятьдесят", "L", "50", "", 76, 4, "половинка");
    public static Button k_100r = new Button("Сто", "C", "100", "", 67, 5, "");

    //МАССИВЫ
    public static Button[] massiv_knopok_1 = {k_1r, k_5r, k_10r};
}