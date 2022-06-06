package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



    public class Infografika{
        public String tytul;
        public String AdresStrony;
        public String adresMiniaturki;
        public String adresStrony;
        public String adresGrafiki;

        public Infografika(String tekst){

        String tytul;
        String adresStrony;
        int szerokosc;

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);

    if (m.find())
        tytul = m.group(1);
    else
        tytul = "";

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
    if (m.find())
        adresStrony = m.group(1);
    else
        adresStrony = "";

        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(tekst);
    if (m.find())
        szerokosc = Integer.parseInt(m.group(1));
    else
        szerokosc = 0;



    }

        public void print() {
        }
    }


