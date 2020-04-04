package mainGui;
//EMRI I LOJTARIT DHE PIKET PER CDO KATEGORI	
import javax.swing.*;
import java.awt.*;

public class Lojtar extends JPanel {        //krijoj klasen lijtari me dy atribute , emri dhe piketkategori , klase e cila ka dissa metoda
  private JLabel emri;                    //ne kte jlabel do vendoset emri i lojtarit
  private int[] piketKategori;           //piket e ne secilien kategori , iniciliazimi i nje vektori

  public Lojtar(String name){   //nderton objekte te klases lojtar , konstruktori
      super();
      setBorder(BorderFactory.createEtchedBorder());  //vendosja e vijave anesore tek emrat e lojtareve lart qe jane me ngjyra
      piketKategori=new int[18];                     //per kategorite e pikeve inicializoj nje vektor me 18 elemente
      emri=new JLabel(name);                        //bej inicializimin e fushes emri
      setPreferredSize(new Dimension(100,71));     //permasat e kuadratit ku vendoset emri i lojtarit
      add(emri);                                   //shtohet emri ne kuadrat
  }

  public int getPiketKategori(int kategori){ //fushe private perdor metoden get
      return piketKategori[kategori];       //kategori brenda kllapave eshte indeksi i vektorit
  }

  public void addPike(int kategoria, int pike){  //shton piket ne kategorite perkaatese si metode    
      piketKategori[kategoria]+=pike;  //piket=piket+piketKategori[kategori]       //piketKategori[0]==njesha
  }

  public int getPiketSiperme(){
      int piket=0;
      for(int i=1; i<=6; i++){                       //deri ne index 6 jane kategorite e para
          piket+=piketKategori[i];      //piket=piket+piketKategori[i]   //realizon shume e pikeve te 6 kategorive te para
      }
      return piket;   //kthe nr e pikeve
  }

  public int getPiketPoshtme(){                  //realizon shume pikeve te poshtme
      int piket=0;
      for(int i=9; i<=15; i++){
          piket+=piketKategori[i];
      }
      return piket;
  }

  public int getTotaliPikeve(){
      return piketKategori[7]+piketKategori[8]+piketKategori[16];  //piket e siperme , bonusi , piket e poshtme
  }

  public String getEmri(){    //emri eshte fushe private
      return emri.getText();   //merr tekstin nga labeli
  }
}
