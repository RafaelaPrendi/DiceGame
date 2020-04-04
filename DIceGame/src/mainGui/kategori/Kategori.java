package mainGui.kategori;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Kategori extends JButton{     //kategorite brenda butonave
    private int index;                              //fushe
    public Kategori(String emri,int index){          //konstruktori i klases kategori me dy parametra
        super();                                  //konstrktori pa argumanta i prindit
        setText(emri);
        setSize(80,40);
        this.index=index;
    }

    public abstract int llogaritPiket(int zarat[]);  //metode abstrakte qe nuk ka nevoje per implementim , e kam implementuar ne klasat e tjera 

    public static final int NJESHA = 1;              //final tregon qe fusha duhet te jete e pandryshueshme
    public static final int DYSHA = 2;               //e barazoj me 2(me nje integer) sepse do e aksesoj nepermjet i-se ne nje cikel ne PanleiLojes
    public static final int TRESHA = 3;
    public static final int KATRA = 4;
    public static final int PESA = 5;
    public static final int GJASHTA = 6;
    public static final int PIKET_SIPERME = 7;
    public static final int BONUS = 8;
    public static final int TRE_NJESOJ = 9;
    public static final int KATER_NJESOJ = 10;
    public static final int TRE_DHE_DY = 11;
    public static final int KATER_TE_NJEPASNJESHME=12;
    public static final int PESE_TE_NJEPASNJESHME=13;
    public static final int PESE_NJESOJ=14;
    public static final int CDO_RAST=15;
    public static final int PIKET_POSHTME=16;
    public static final int TOTALI=17;



    public static final Map<Integer,Kategori> kategorite=createMap();        //Map eshte nje objekt qe lidh celesin me vleren 

    public static final Map<String,Boolean> kategoriteExtra=createMapStringKeys();
    
    private static Map<Integer,Kategori> createMap(){                     //Hashmap eshte nje implementim i Map
        HashMap<Integer,Kategori> kat=new HashMap<Integer, Kategori>(); //krijohet objekti hashmap
        kat.put(NJESHA,new KategoriNje(NJESHA));                     //new KategoriNjesha(NJESHA=INDEX)
        kat.put(DYSHA,new KategoriDy(DYSHA));                        
        kat.put(TRESHA,new KategoriTresha(TRESHA));
        kat.put(KATRA,new KategoriKater(KATRA));
        kat.put(PESA,new KategoriPesa(PESA));
        kat.put(GJASHTA,new KategoriGjashta(GJASHTA));
        kat.put(TRE_NJESOJ,new KategoriTreNjesoj(TRE_NJESOJ));
        kat.put(KATER_NJESOJ,new KategoriKaterNjesoj(KATER_NJESOJ));
        kat.put(TRE_DHE_DY,new KategoriTreDheDy(TRE_DHE_DY));
        kat.put(KATER_TE_NJEPASNJESHME,new KategoriKaterNjepasnjeshme(KATER_TE_NJEPASNJESHME));
        kat.put(PESE_TE_NJEPASNJESHME,new KategoriPeseNjepasnjeshme(PESE_TE_NJEPASNJESHME));
        kat.put(PESE_NJESOJ,new KategoriPeseNjesoj(PESE_NJESOJ));
        kat.put(CDO_RAST,new KategoriTjeter(CDO_RAST));
        return kat;
    }

    private static Map<String,Boolean> createMapStringKeys(){             
    	HashMap<String,Boolean> kat=new HashMap<String, Boolean>(); 
        kat.put("Njesha1",true);
        kat.put("Njesha2",true);
        kat.put("Njesha3",true);
        kat.put("Njesha4",true);
        kat.put("Dysha1",true); 
        kat.put("Dysha2",true);
        kat.put("Dysha3",true);
        kat.put("Dysha4",true);                       
        kat.put("Tresha1",true);                      
        kat.put("Tresha2",true);                      
        kat.put("Tresha3",true);                      
        kat.put("Tresha4",true);
        kat.put("Katra1",true);
        kat.put("Katra2",true);
        kat.put("Katra3",true);
        kat.put("Katra4",true);
        kat.put("Pesa1",true);
        kat.put("Pesa2",true);
        kat.put("Pesa3",true);
        kat.put("Pesa4",true);
        kat.put("Gjashta1",true);
        kat.put("Gjashta2",true);
        kat.put("Gjashta3",true);
        kat.put("Gjashta4",true);
        kat.put("Tre Njesoj1",true);
        kat.put("Tre Njesoj2",true);
        kat.put("Tre Njesoj3",true);
        kat.put("Tre Njesoj4",true);
        kat.put("Kater Njesoj1",true);
        kat.put("Kater Njesoj2",true);
        kat.put("Kater Njesoj3",true);
        kat.put("Kater Njesoj4",true);
        kat.put("Tre dhe Dy1",true);
        kat.put("Tre dhe Dy2",true);
        kat.put("Tre dhe Dy3",true);
        kat.put("Tre dhe Dy4",true);
        kat.put("Kater te Njepasnjeshme1",true);
        kat.put("Kater te Njepasnjeshme2",true);
        kat.put("Kater te Njepasnjeshme3",true);
        kat.put("Kater te Njepasnjeshme4",true);
        kat.put("Pese te Njepasnjeshme1",true);
        kat.put("Pese te Njepasnjeshme2",true);
        kat.put("Pese te Njepasnjeshme3",true);
        kat.put("Pese te Njepasnjeshme4",true);
        kat.put("Pese Njesoj1",true);
        kat.put("Pese Njesoj2",true);
        kat.put("Pese Njesoj3",true);
        kat.put("Pese Njesoj4",true);
        kat.put("Cdo Rast1",true);
        kat.put("Cdo Rast2",true);
        kat.put("Cdo Rast3",true);
        kat.put("Cdo Rast4",true);
        return kat;
    }

    public int getIndex() {
        return index;
    }
}

