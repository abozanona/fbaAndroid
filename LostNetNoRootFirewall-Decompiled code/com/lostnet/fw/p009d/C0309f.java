package com.lostnet.fw.p009d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.vending.licensing.Policy;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class C0309f {
    private static ArrayList f1406a;
    private static HashMap f1407b;
    private static ArrayList f1408c;
    private static HashMap f1409d;
    private static HashMap f1410e;
    private static Drawable f1411f;
    private static Boolean f1412g = Boolean.valueOf(false);
    private static HashMap f1413h;

    public static String m1974a(int i) {
        String str = (String) f1410e.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        char c = (char) (i >> 8);
        str = new String(new char[]{(char) (i % Policy.LICENSED), c});
        f1410e.put(Integer.valueOf(i), str);
        return str;
    }

    public static String m1975a(String str) {
        return (String) f1413h.get(str);
    }

    public static ArrayList m1976a() {
        return f1406a;
    }

    public static void m1977a(Context context) {
        f1411f = context.getPackageManager().getDefaultActivityIcon();
        f1413h = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        arrayList.add("DZ");
        arrayList.add("AO");
        arrayList.add("BJ");
        arrayList.add("BW");
        arrayList.add("BF");
        arrayList.add("BI");
        arrayList.add("CM");
        arrayList.add("CF");
        arrayList.add("TD");
        arrayList.add("KM");
        arrayList.add("CG");
        arrayList.add("CD");
        arrayList.add("CI");
        arrayList.add("DJ");
        arrayList.add("EG");
        arrayList.add("GQ");
        arrayList.add("ER");
        arrayList.add("ET");
        arrayList.add("GA");
        arrayList.add("GM");
        arrayList.add("GH");
        arrayList.add("GI");
        arrayList.add("GN");
        arrayList.add("GW");
        arrayList.add("KE");
        arrayList.add("LY");
        arrayList.add("LR");
        arrayList.add("MG");
        arrayList.add("LS");
        arrayList.add("MW");
        arrayList.add("ML");
        arrayList.add("MR");
        arrayList.add("MU");
        arrayList.add("YT");
        arrayList.add("MA");
        arrayList.add("MZ");
        arrayList.add("NA");
        arrayList.add("NE");
        arrayList.add("NG");
        arrayList.add("RW");
        arrayList.add("ST");
        arrayList.add("SN");
        arrayList.add("SL");
        arrayList.add("SO");
        arrayList.add("ZA");
        arrayList.add("SS");
        arrayList.add("SD");
        arrayList.add("SZ");
        arrayList.add("TZ");
        arrayList.add("TG");
        arrayList.add("TN");
        arrayList.add("UG");
        arrayList.add("EH");
        arrayList.add("ZM");
        arrayList.add("ZW");
        arrayList2.add("BD");
        arrayList2.add("BT");
        arrayList2.add("BN");
        arrayList2.add("KH");
        arrayList2.add("CN");
        arrayList2.add("HK");
        arrayList2.add("IN");
        arrayList2.add("JP");
        arrayList2.add("KZ");
        arrayList2.add("KP");
        arrayList2.add("KR");
        arrayList2.add("KG");
        arrayList2.add("LA");
        arrayList2.add("MO");
        arrayList2.add("MY");
        arrayList2.add("MN");
        arrayList2.add("MM");
        arrayList2.add("NP");
        arrayList2.add("SG");
        arrayList2.add("LK");
        arrayList2.add("TW");
        arrayList2.add("TJ");
        arrayList2.add("TH");
        arrayList2.add("TM");
        arrayList2.add("UZ");
        arrayList2.add("VN");
        arrayList2.add("ID");
        arrayList2.add("PW");
        arrayList2.add("PG");
        arrayList2.add("PH");
        arrayList6.add("AS");
        arrayList6.add("CK");
        arrayList6.add("PF");
        arrayList6.add("FJ");
        arrayList6.add("GU");
        arrayList6.add("KI");
        arrayList6.add("MH");
        arrayList6.add("FM");
        arrayList6.add("NR");
        arrayList6.add("NC");
        arrayList6.add("NU");
        arrayList6.add("NF");
        arrayList6.add("MP");
        arrayList6.add("PN");
        arrayList6.add("WS");
        arrayList6.add("SB");
        arrayList6.add("TL");
        arrayList6.add("TK");
        arrayList6.add("TO");
        arrayList6.add("TV");
        arrayList6.add("VU");
        arrayList6.add("WF");
        arrayList3.add("AF");
        arrayList3.add("AM");
        arrayList3.add("AZ");
        arrayList3.add("BH");
        arrayList3.add("GE");
        arrayList3.add("IR");
        arrayList3.add("IQ");
        arrayList3.add("IL");
        arrayList3.add("JO");
        arrayList3.add("KW");
        arrayList3.add("LB");
        arrayList3.add("OM");
        arrayList3.add("PK");
        arrayList3.add("PS");
        arrayList3.add("QA");
        arrayList3.add("SA");
        arrayList3.add("SY");
        arrayList3.add("TR");
        arrayList3.add("AE");
        arrayList3.add("YE");
        arrayList4.add("AL");
        arrayList4.add("BY");
        arrayList4.add("BA");
        arrayList4.add("BG");
        arrayList4.add("EE");
        arrayList4.add("LV");
        arrayList4.add("LT");
        arrayList4.add("MK");
        arrayList4.add("MD");
        arrayList4.add("ME");
        arrayList4.add("PL");
        arrayList4.add("RO");
        arrayList4.add("RU");
        arrayList4.add("UA");
        arrayList5.add("AI");
        arrayList5.add("AG");
        arrayList5.add("AR");
        arrayList5.add("AW");
        arrayList5.add("BB");
        arrayList5.add("BZ");
        arrayList5.add("BO");
        arrayList5.add("BQ");
        arrayList5.add("BR");
        arrayList5.add("KY");
        arrayList5.add("CL");
        arrayList5.add("CO");
        arrayList5.add("CR");
        arrayList5.add("CU");
        arrayList5.add("CW");
        arrayList5.add("DM");
        arrayList5.add("DO");
        arrayList5.add("EC");
        arrayList5.add("SV");
        arrayList5.add("FK");
        arrayList5.add("GF");
        arrayList5.add("GD");
        arrayList5.add("GP");
        arrayList5.add("GT");
        arrayList5.add("GY");
        arrayList5.add("HT");
        arrayList5.add("HN");
        arrayList5.add("JM");
        arrayList5.add("MQ");
        arrayList5.add("MS");
        arrayList5.add("NI");
        arrayList5.add("PA");
        arrayList5.add("PY");
        arrayList5.add("PE");
        arrayList5.add("PR");
        arrayList5.add("BL");
        arrayList5.add("KN");
        arrayList5.add("LC");
        arrayList5.add("MF");
        arrayList5.add("VC");
        arrayList5.add("SX");
        arrayList5.add("SR");
        arrayList5.add("TT");
        arrayList5.add("TC");
        arrayList5.add("UY");
        arrayList5.add("VE");
        arrayList5.add("VG");
        arrayList5.add("VI");
        arrayList6.add("AQ");
        arrayList6.add("BV");
        arrayList6.add("IO");
        arrayList6.add("CV");
        arrayList6.add("CX");
        arrayList6.add("CC");
        arrayList6.add("TF");
        arrayList6.add("GL");
        arrayList6.add("HM");
        arrayList6.add("MV");
        arrayList6.add("RE");
        arrayList6.add("SH");
        arrayList6.add("SC");
        arrayList6.add("GS");
        arrayList6.add("SJ");
        arrayList7.add("AD");
        arrayList7.add("AX");
        arrayList7.add("AT");
        arrayList7.add("BE");
        arrayList7.add("HR");
        arrayList7.add("CY");
        arrayList7.add("CZ");
        arrayList7.add("DK");
        arrayList7.add("FO");
        arrayList7.add("FI");
        arrayList7.add("FR");
        arrayList7.add("DE");
        arrayList7.add("GR");
        arrayList7.add("GG");
        arrayList7.add("VA");
        arrayList7.add("HU");
        arrayList7.add("IS");
        arrayList7.add("IE");
        arrayList7.add("IM");
        arrayList7.add("IT");
        arrayList7.add("JE");
        arrayList7.add("LI");
        arrayList7.add("LU");
        arrayList7.add("MT");
        arrayList7.add("MC");
        arrayList7.add("NL");
        arrayList7.add("NO");
        arrayList7.add("PT");
        arrayList7.add("SM");
        arrayList7.add("RS");
        arrayList7.add("SK");
        arrayList7.add("SI");
        arrayList7.add("ES");
        arrayList7.add("SE");
        arrayList7.add("CH");
        arrayList7.add("GB");
        arrayList8.add("BS");
        arrayList8.add("BM");
        arrayList8.add("CA");
        arrayList8.add("MX");
        arrayList8.add("PM");
        arrayList8.add("US");
        arrayList8.add("UM");
        arrayList9.add("NZ");
        arrayList9.add("AU");
        f1410e = new HashMap();
        f1406a = new ArrayList();
        f1407b = new HashMap();
        String string = context.getResources().getString(C0330m.regionAfrica);
        f1406a.add(string);
        f1407b.put(string, arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f1413h.put((String) it.next(), string);
        }
        string = context.getResources().getString(C0330m.regionMiddleEast);
        f1406a.add(string);
        f1407b.put(string, arrayList3);
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            f1413h.put((String) it2.next(), string);
        }
        String string2 = context.getResources().getString(C0330m.regionEasternEurope);
        f1406a.add(string2);
        f1407b.put(string2, arrayList4);
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            f1413h.put((String) it3.next(), string2);
        }
        string2 = context.getResources().getString(C0330m.regionNowhere);
        f1406a.add(string2);
        f1407b.put(string2, arrayList6);
        it3 = arrayList6.iterator();
        while (it3.hasNext()) {
            f1413h.put((String) it3.next(), string2);
        }
        string2 = context.getResources().getString(C0330m.regionLatin);
        f1406a.add(string2);
        f1407b.put(string2, arrayList5);
        it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            f1413h.put((String) it3.next(), string2);
        }
        string2 = context.getResources().getString(C0330m.regionAsia);
        f1406a.add(string2);
        f1407b.put(string2, arrayList2);
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            f1413h.put((String) it4.next(), string2);
        }
        String string3 = context.getResources().getString(C0330m.regionEurope);
        f1406a.add(string3);
        f1407b.put(string3, arrayList7);
        it2 = arrayList7.iterator();
        while (it2.hasNext()) {
            f1413h.put((String) it2.next(), string3);
        }
        string3 = context.getResources().getString(C0330m.regionNorth);
        f1406a.add(string3);
        f1407b.put(string3, arrayList8);
        it2 = arrayList8.iterator();
        while (it2.hasNext()) {
            f1413h.put((String) it2.next(), string3);
        }
        string3 = context.getResources().getString(C0330m.regionAustralia);
        f1406a.add(string3);
        f1407b.put(string3, arrayList9);
        it2 = arrayList9.iterator();
        while (it2.hasNext()) {
            f1413h.put((String) it2.next(), string3);
        }
        f1409d = new HashMap();
        f1409d.put("XX", context.getResources().getString(C0330m.countryXX));
        f1409d.put("AF", context.getResources().getString(C0330m.countryAF));
        f1409d.put("AX", context.getResources().getString(C0330m.countryAX));
        f1409d.put("AL", context.getResources().getString(C0330m.countryAL));
        f1409d.put("DZ", context.getResources().getString(C0330m.countryDZ));
        f1409d.put("AS", context.getResources().getString(C0330m.countryAS));
        f1409d.put("AD", context.getResources().getString(C0330m.countryAD));
        f1409d.put("AO", context.getResources().getString(C0330m.countryAO));
        f1409d.put("AI", context.getResources().getString(C0330m.countryAI));
        f1409d.put("AQ", context.getResources().getString(C0330m.countryAQ));
        f1409d.put("AG", context.getResources().getString(C0330m.countryAG));
        f1409d.put("AR", context.getResources().getString(C0330m.countryAR));
        f1409d.put("AM", context.getResources().getString(C0330m.countryAM));
        f1409d.put("AW", context.getResources().getString(C0330m.countryAW));
        f1409d.put("AU", context.getResources().getString(C0330m.countryAU));
        f1409d.put("AT", context.getResources().getString(C0330m.countryAT));
        f1409d.put("AZ", context.getResources().getString(C0330m.countryAZ));
        f1409d.put("BS", context.getResources().getString(C0330m.countryBS));
        f1409d.put("BH", context.getResources().getString(C0330m.countryBH));
        f1409d.put("BD", context.getResources().getString(C0330m.countryBD));
        f1409d.put("BB", context.getResources().getString(C0330m.countryBB));
        f1409d.put("BY", context.getResources().getString(C0330m.countryBY));
        f1409d.put("BE", context.getResources().getString(C0330m.countryBE));
        f1409d.put("BZ", context.getResources().getString(C0330m.countryBZ));
        f1409d.put("BJ", context.getResources().getString(C0330m.countryBJ));
        f1409d.put("BM", context.getResources().getString(C0330m.countryBM));
        f1409d.put("BT", context.getResources().getString(C0330m.countryBT));
        f1409d.put("BO", context.getResources().getString(C0330m.countryBO));
        f1409d.put("BQ", context.getResources().getString(C0330m.countryBQ));
        f1409d.put("BA", context.getResources().getString(C0330m.countryBA));
        f1409d.put("BW", context.getResources().getString(C0330m.countryBW));
        f1409d.put("BV", context.getResources().getString(C0330m.countryBV));
        f1409d.put("BR", context.getResources().getString(C0330m.countryBR));
        f1409d.put("IO", context.getResources().getString(C0330m.countryIO));
        f1409d.put("BN", context.getResources().getString(C0330m.countryBN));
        f1409d.put("BG", context.getResources().getString(C0330m.countryBG));
        f1409d.put("BF", context.getResources().getString(C0330m.countryBF));
        f1409d.put("BI", context.getResources().getString(C0330m.countryBI));
        f1409d.put("KH", context.getResources().getString(C0330m.countryKH));
        f1409d.put("CM", context.getResources().getString(C0330m.countryCM));
        f1409d.put("CA", context.getResources().getString(C0330m.countryCA));
        f1409d.put("CV", context.getResources().getString(C0330m.countryCV));
        f1409d.put("KY", context.getResources().getString(C0330m.countryKY));
        f1409d.put("CF", context.getResources().getString(C0330m.countryCF));
        f1409d.put("TD", context.getResources().getString(C0330m.countryTD));
        f1409d.put("CL", context.getResources().getString(C0330m.countryCL));
        f1409d.put("CN", context.getResources().getString(C0330m.countryCN));
        f1409d.put("CX", context.getResources().getString(C0330m.countryCX));
        f1409d.put("CC", context.getResources().getString(C0330m.countryCC));
        f1409d.put("CO", context.getResources().getString(C0330m.countryCO));
        f1409d.put("KM", context.getResources().getString(C0330m.countryKM));
        f1409d.put("CG", context.getResources().getString(C0330m.countryCG));
        f1409d.put("CD", context.getResources().getString(C0330m.countryCD));
        f1409d.put("CK", context.getResources().getString(C0330m.countryCK));
        f1409d.put("CR", context.getResources().getString(C0330m.countryCR));
        f1409d.put("CI", context.getResources().getString(C0330m.countryCI));
        f1409d.put("HR", context.getResources().getString(C0330m.countryHR));
        f1409d.put("CU", context.getResources().getString(C0330m.countryCU));
        f1409d.put("CW", context.getResources().getString(C0330m.countryCW));
        f1409d.put("CY", context.getResources().getString(C0330m.countryCY));
        f1409d.put("CZ", context.getResources().getString(C0330m.countryCZ));
        f1409d.put("DK", context.getResources().getString(C0330m.countryDK));
        f1409d.put("DJ", context.getResources().getString(C0330m.countryDJ));
        f1409d.put("DM", context.getResources().getString(C0330m.countryDM));
        f1409d.put("DO", context.getResources().getString(C0330m.countryDO));
        f1409d.put("EC", context.getResources().getString(C0330m.countryEC));
        f1409d.put("EG", context.getResources().getString(C0330m.countryEG));
        f1409d.put("SV", context.getResources().getString(C0330m.countrySV));
        f1409d.put("GQ", context.getResources().getString(C0330m.countryGQ));
        f1409d.put("ER", context.getResources().getString(C0330m.countryER));
        f1409d.put("EE", context.getResources().getString(C0330m.countryEE));
        f1409d.put("ET", context.getResources().getString(C0330m.countryET));
        f1409d.put("FK", context.getResources().getString(C0330m.countryFK));
        f1409d.put("FO", context.getResources().getString(C0330m.countryFO));
        f1409d.put("FJ", context.getResources().getString(C0330m.countryFJ));
        f1409d.put("FI", context.getResources().getString(C0330m.countryFI));
        f1409d.put("FR", context.getResources().getString(C0330m.countryFR));
        f1409d.put("GF", context.getResources().getString(C0330m.countryGF));
        f1409d.put("PF", context.getResources().getString(C0330m.countryPF));
        f1409d.put("TF", context.getResources().getString(C0330m.countryTF));
        f1409d.put("GA", context.getResources().getString(C0330m.countryGA));
        f1409d.put("GM", context.getResources().getString(C0330m.countryGM));
        f1409d.put("GE", context.getResources().getString(C0330m.countryGE));
        f1409d.put("DE", context.getResources().getString(C0330m.countryDE));
        f1409d.put("GH", context.getResources().getString(C0330m.countryGH));
        f1409d.put("GI", context.getResources().getString(C0330m.countryGI));
        f1409d.put("GR", context.getResources().getString(C0330m.countryGR));
        f1409d.put("GL", context.getResources().getString(C0330m.countryGL));
        f1409d.put("GD", context.getResources().getString(C0330m.countryGD));
        f1409d.put("GP", context.getResources().getString(C0330m.countryGP));
        f1409d.put("GU", context.getResources().getString(C0330m.countryGU));
        f1409d.put("GT", context.getResources().getString(C0330m.countryGT));
        f1409d.put("GG", context.getResources().getString(C0330m.countryGG));
        f1409d.put("GN", context.getResources().getString(C0330m.countryGN));
        f1409d.put("GW", context.getResources().getString(C0330m.countryGW));
        f1409d.put("GY", context.getResources().getString(C0330m.countryGY));
        f1409d.put("HT", context.getResources().getString(C0330m.countryHT));
        f1409d.put("HM", context.getResources().getString(C0330m.countryHM));
        f1409d.put("VA", context.getResources().getString(C0330m.countryVA));
        f1409d.put("HN", context.getResources().getString(C0330m.countryHN));
        f1409d.put("HK", context.getResources().getString(C0330m.countryHK));
        f1409d.put("HU", context.getResources().getString(C0330m.countryHU));
        f1409d.put("IS", context.getResources().getString(C0330m.countryIS));
        f1409d.put("IN", context.getResources().getString(C0330m.countryIN));
        f1409d.put("ID", context.getResources().getString(C0330m.countryID));
        f1409d.put("IR", context.getResources().getString(C0330m.countryIR));
        f1409d.put("IQ", context.getResources().getString(C0330m.countryIQ));
        f1409d.put("IE", context.getResources().getString(C0330m.countryIE));
        f1409d.put("IM", context.getResources().getString(C0330m.countryIM));
        f1409d.put("IL", context.getResources().getString(C0330m.countryIL));
        f1409d.put("IT", context.getResources().getString(C0330m.countryIT));
        f1409d.put("JM", context.getResources().getString(C0330m.countryJM));
        f1409d.put("JP", context.getResources().getString(C0330m.countryJP));
        f1409d.put("JE", context.getResources().getString(C0330m.countryJE));
        f1409d.put("JO", context.getResources().getString(C0330m.countryJO));
        f1409d.put("KZ", context.getResources().getString(C0330m.countryKZ));
        f1409d.put("KE", context.getResources().getString(C0330m.countryKE));
        f1409d.put("KI", context.getResources().getString(C0330m.countryKI));
        f1409d.put("KP", context.getResources().getString(C0330m.countryKP));
        f1409d.put("KR", context.getResources().getString(C0330m.countryKR));
        f1409d.put("KW", context.getResources().getString(C0330m.countryKW));
        f1409d.put("KG", context.getResources().getString(C0330m.countryKG));
        f1409d.put("LA", context.getResources().getString(C0330m.countryLA));
        f1409d.put("LV", context.getResources().getString(C0330m.countryLV));
        f1409d.put("LB", context.getResources().getString(C0330m.countryLB));
        f1409d.put("LS", context.getResources().getString(C0330m.countryLS));
        f1409d.put("LR", context.getResources().getString(C0330m.countryLR));
        f1409d.put("LY", context.getResources().getString(C0330m.countryLY));
        f1409d.put("LI", context.getResources().getString(C0330m.countryLI));
        f1409d.put("LT", context.getResources().getString(C0330m.countryLT));
        f1409d.put("LU", context.getResources().getString(C0330m.countryLU));
        f1409d.put("MO", context.getResources().getString(C0330m.countryMO));
        f1409d.put("MK", context.getResources().getString(C0330m.countryMK));
        f1409d.put("MG", context.getResources().getString(C0330m.countryMG));
        f1409d.put("MW", context.getResources().getString(C0330m.countryMW));
        f1409d.put("MY", context.getResources().getString(C0330m.countryMY));
        f1409d.put("MV", context.getResources().getString(C0330m.countryMV));
        f1409d.put("ML", context.getResources().getString(C0330m.countryML));
        f1409d.put("MT", context.getResources().getString(C0330m.countryMT));
        f1409d.put("MH", context.getResources().getString(C0330m.countryMH));
        f1409d.put("MQ", context.getResources().getString(C0330m.countryMQ));
        f1409d.put("MR", context.getResources().getString(C0330m.countryMR));
        f1409d.put("MU", context.getResources().getString(C0330m.countryMU));
        f1409d.put("YT", context.getResources().getString(C0330m.countryYT));
        f1409d.put("MX", context.getResources().getString(C0330m.countryMX));
        f1409d.put("FM", context.getResources().getString(C0330m.countryFM));
        f1409d.put("MD", context.getResources().getString(C0330m.countryMD));
        f1409d.put("MC", context.getResources().getString(C0330m.countryMC));
        f1409d.put("MN", context.getResources().getString(C0330m.countryMN));
        f1409d.put("ME", context.getResources().getString(C0330m.countryME));
        f1409d.put("MS", context.getResources().getString(C0330m.countryMS));
        f1409d.put("MA", context.getResources().getString(C0330m.countryMA));
        f1409d.put("MZ", context.getResources().getString(C0330m.countryMZ));
        f1409d.put("MM", context.getResources().getString(C0330m.countryMM));
        f1409d.put("NA", context.getResources().getString(C0330m.countryNA));
        f1409d.put("NR", context.getResources().getString(C0330m.countryNR));
        f1409d.put("NP", context.getResources().getString(C0330m.countryNP));
        f1409d.put("NL", context.getResources().getString(C0330m.countryNL));
        f1409d.put("NC", context.getResources().getString(C0330m.countryNC));
        f1409d.put("NZ", context.getResources().getString(C0330m.countryNZ));
        f1409d.put("NI", context.getResources().getString(C0330m.countryNI));
        f1409d.put("NE", context.getResources().getString(C0330m.countryNE));
        f1409d.put("NG", context.getResources().getString(C0330m.countryNG));
        f1409d.put("NU", context.getResources().getString(C0330m.countryNU));
        f1409d.put("NF", context.getResources().getString(C0330m.countryNF));
        f1409d.put("MP", context.getResources().getString(C0330m.countryMP));
        f1409d.put("NO", context.getResources().getString(C0330m.countryNO));
        f1409d.put("OM", context.getResources().getString(C0330m.countryOM));
        f1409d.put("PK", context.getResources().getString(C0330m.countryPK));
        f1409d.put("PW", context.getResources().getString(C0330m.countryPW));
        f1409d.put("PS", context.getResources().getString(C0330m.countryPS));
        f1409d.put("PA", context.getResources().getString(C0330m.countryPA));
        f1409d.put("PG", context.getResources().getString(C0330m.countryPG));
        f1409d.put("PY", context.getResources().getString(C0330m.countryPY));
        f1409d.put("PE", context.getResources().getString(C0330m.countryPE));
        f1409d.put("PH", context.getResources().getString(C0330m.countryPH));
        f1409d.put("PN", context.getResources().getString(C0330m.countryPN));
        f1409d.put("PL", context.getResources().getString(C0330m.countryPL));
        f1409d.put("PT", context.getResources().getString(C0330m.countryPT));
        f1409d.put("PR", context.getResources().getString(C0330m.countryPR));
        f1409d.put("QA", context.getResources().getString(C0330m.countryQA));
        f1409d.put("RE", context.getResources().getString(C0330m.countryRE));
        f1409d.put("RO", context.getResources().getString(C0330m.countryRO));
        f1409d.put("RU", context.getResources().getString(C0330m.countryRU));
        f1409d.put("RW", context.getResources().getString(C0330m.countryRW));
        f1409d.put("BL", context.getResources().getString(C0330m.countryBL));
        f1409d.put("SH", context.getResources().getString(C0330m.countrySH));
        f1409d.put("KN", context.getResources().getString(C0330m.countryKN));
        f1409d.put("LC", context.getResources().getString(C0330m.countryLC));
        f1409d.put("MF", context.getResources().getString(C0330m.countryMF));
        f1409d.put("PM", context.getResources().getString(C0330m.countryPM));
        f1409d.put("VC", context.getResources().getString(C0330m.countryVC));
        f1409d.put("WS", context.getResources().getString(C0330m.countryWS));
        f1409d.put("SM", context.getResources().getString(C0330m.countrySM));
        f1409d.put("ST", context.getResources().getString(C0330m.countryST));
        f1409d.put("SA", context.getResources().getString(C0330m.countrySA));
        f1409d.put("SN", context.getResources().getString(C0330m.countrySN));
        f1409d.put("RS", context.getResources().getString(C0330m.countryRS));
        f1409d.put("SC", context.getResources().getString(C0330m.countrySC));
        f1409d.put("SL", context.getResources().getString(C0330m.countrySL));
        f1409d.put("SG", context.getResources().getString(C0330m.countrySG));
        f1409d.put("SX", context.getResources().getString(C0330m.countrySX));
        f1409d.put("SK", context.getResources().getString(C0330m.countrySK));
        f1409d.put("SI", context.getResources().getString(C0330m.countrySI));
        f1409d.put("SB", context.getResources().getString(C0330m.countrySB));
        f1409d.put("SO", context.getResources().getString(C0330m.countrySO));
        f1409d.put("ZA", context.getResources().getString(C0330m.countryZA));
        f1409d.put("GS", context.getResources().getString(C0330m.countryGS));
        f1409d.put("SS", context.getResources().getString(C0330m.countrySS));
        f1409d.put("ES", context.getResources().getString(C0330m.countryES));
        f1409d.put("LK", context.getResources().getString(C0330m.countryLK));
        f1409d.put("SD", context.getResources().getString(C0330m.countrySD));
        f1409d.put("SR", context.getResources().getString(C0330m.countrySR));
        f1409d.put("SJ", context.getResources().getString(C0330m.countrySJ));
        f1409d.put("SZ", context.getResources().getString(C0330m.countrySZ));
        f1409d.put("SE", context.getResources().getString(C0330m.countrySE));
        f1409d.put("CH", context.getResources().getString(C0330m.countryCH));
        f1409d.put("SY", context.getResources().getString(C0330m.countrySY));
        f1409d.put("TW", context.getResources().getString(C0330m.countryTW));
        f1409d.put("TJ", context.getResources().getString(C0330m.countryTJ));
        f1409d.put("TZ", context.getResources().getString(C0330m.countryTZ));
        f1409d.put("TH", context.getResources().getString(C0330m.countryTH));
        f1409d.put("TL", context.getResources().getString(C0330m.countryTL));
        f1409d.put("TG", context.getResources().getString(C0330m.countryTG));
        f1409d.put("TK", context.getResources().getString(C0330m.countryTK));
        f1409d.put("TO", context.getResources().getString(C0330m.countryTO));
        f1409d.put("TT", context.getResources().getString(C0330m.countryTT));
        f1409d.put("TN", context.getResources().getString(C0330m.countryTN));
        f1409d.put("TR", context.getResources().getString(C0330m.countryTR));
        f1409d.put("TM", context.getResources().getString(C0330m.countryTM));
        f1409d.put("TC", context.getResources().getString(C0330m.countryTC));
        f1409d.put("TV", context.getResources().getString(C0330m.countryTV));
        f1409d.put("UG", context.getResources().getString(C0330m.countryUG));
        f1409d.put("UA", context.getResources().getString(C0330m.countryUA));
        f1409d.put("AE", context.getResources().getString(C0330m.countryAE));
        f1409d.put("GB", context.getResources().getString(C0330m.countryGB));
        f1409d.put("US", context.getResources().getString(C0330m.countryUS));
        f1409d.put("UM", context.getResources().getString(C0330m.countryUM));
        f1409d.put("UY", context.getResources().getString(C0330m.countryUY));
        f1409d.put("UZ", context.getResources().getString(C0330m.countryUZ));
        f1409d.put("VU", context.getResources().getString(C0330m.countryVU));
        f1409d.put("VE", context.getResources().getString(C0330m.countryVE));
        f1409d.put("VN", context.getResources().getString(C0330m.countryVN));
        f1409d.put("VG", context.getResources().getString(C0330m.countryVG));
        f1409d.put("VI", context.getResources().getString(C0330m.countryVI));
        f1409d.put("WF", context.getResources().getString(C0330m.countryWF));
        f1409d.put("EH", context.getResources().getString(C0330m.countryEH));
        f1409d.put("YE", context.getResources().getString(C0330m.countryYE));
        f1409d.put("ZM", context.getResources().getString(C0330m.countryZM));
        f1409d.put("ZW", context.getResources().getString(C0330m.countryZW));
        f1408c = new ArrayList();
        f1408c.add("RU");
        f1408c.add("UA");
        f1408c.add("RO");
        f1408c.add("CN");
        f1408c.add("IR");
        f1408c.add("KP");
        f1408c.add("US");
        f1408c.add("IE");
    }

    public static ArrayList m1978b(String str) {
        return (ArrayList) f1407b.get(str);
    }

    public static Set m1979b() {
        return f1409d.keySet();
    }

    public static String m1980c(String str) {
        return (String) f1409d.get(str);
    }

    public static ArrayList m1981c() {
        return f1408c;
    }

    public static int m1982d(String str) {
        if (str == null || str.length() != 2) {
            return 0;
        }
        char[] toCharArray = str.toCharArray();
        return (0 + toCharArray[0]) + (toCharArray[1] << 8);
    }

    public static void m1983d() {
        synchronized (f1412g) {
            if (f1412g.booleanValue()) {
                return;
            }
            f1412g = Boolean.valueOf(true);
        }
    }

    public static Drawable m1984e(String str) {
        Drawable drawable = null;
        try {
            drawable = Drawable.createFromStream(FirewallApplication.m1851a().getAssets().open("flags_iso/64/" + str.toLowerCase(Locale.US) + ".png"), null);
        } catch (Exception e) {
        } catch (OutOfMemoryError e2) {
        }
        return drawable == null ? f1411f : drawable;
    }

    public static void m1985e() {
        f1412g = Boolean.valueOf(false);
    }
}
