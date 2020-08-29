/**
 * Created by zhigan  on 13.08.2020.
 */
public class Button {
    String imya_knopki;
    String rimskoye_znacheniye_knopki;
    String arabskoye_znacheniye_knopki;
    String znacheniye_arifmeticheskoy_operatsii_knopki;
    int simvol_knopki;
    int razryadnost_knopki;
    String status_knopki;
    String Peremennaya_1;
    char ArifmeticheskayaOperatsiya;
    String Peremennaya_2;
    String CalculationA;
    String CalculationR;

    //КОНСТРУКТОРЫ
    Button(){

    }

    Button(String i_k){
        imya_knopki = i_k;
    }

    Button(String i_k, String r_z_k, String a_z_k, String z_a_o_k ){
        imya_knopki = i_k;
        rimskoye_znacheniye_knopki = r_z_k;
        arabskoye_znacheniye_knopki = a_z_k;
        znacheniye_arifmeticheskoy_operatsii_knopki = z_a_o_k;
    }

    Button(String i_k, String r_z_k, String a_z_k, String z_a_o_k, int s_k){
        imya_knopki = i_k;
        rimskoye_znacheniye_knopki = r_z_k;
        arabskoye_znacheniye_knopki = a_z_k;
        znacheniye_arifmeticheskoy_operatsii_knopki = z_a_o_k;
        simvol_knopki = s_k;
    }

    Button(String i_k, String r_z_k, String a_z_k, String z_a_o_k, int s_k, int r_k){
        imya_knopki = i_k;
        rimskoye_znacheniye_knopki = r_z_k;
        arabskoye_znacheniye_knopki = a_z_k;
        znacheniye_arifmeticheskoy_operatsii_knopki = z_a_o_k;
        simvol_knopki = s_k;
        razryadnost_knopki = r_k;
    }

    Button(String i_k, String r_z_k, String a_z_k, String z_a_o_k, int s_k, int r_k, String st_k){
        imya_knopki = i_k;
        rimskoye_znacheniye_knopki = r_z_k;
        arabskoye_znacheniye_knopki = a_z_k;
        znacheniye_arifmeticheskoy_operatsii_knopki = z_a_o_k;
        simvol_knopki = s_k;
        razryadnost_knopki = r_k;
        status_knopki = st_k;
    }

    Button(String i_k, String z_a_o_k, int s_k){
        imya_knopki = i_k;
        znacheniye_arifmeticheskoy_operatsii_knopki = z_a_o_k;
        simvol_knopki = s_k;
    }
}
