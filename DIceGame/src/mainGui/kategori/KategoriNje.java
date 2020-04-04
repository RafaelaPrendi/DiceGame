package mainGui.kategori;
//piket e fituara jane sa shuma e gjithe njeshave ne 5 zarat

import mainGui.kategori.Kategori;

public class KategoriNje extends Kategori{
  public KategoriNje(int index){                 //konstruktori i kesaj klase merr nje parameter vetem
      super("Njesha",index);                     //thirret konstruktori i kategorise
  }

  public int llogaritPiket(int[] zarat) {
      int sum=0;
      for(int i=0; i<zarat.length; i++){                     //zarat.length eshte 5 ne kete rast pasi kemi 5 zare
          if(zarat[i]==1) sum+=1;
      }
      return sum;
  }
}
