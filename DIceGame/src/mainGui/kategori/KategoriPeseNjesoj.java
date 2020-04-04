package mainGui.kategori;

import mainGui.kategori.Kategori;

//te 5 vlerat ne zare duhet te jene te barabarta, e realizon me dy cikle
public class KategoriPeseNjesoj extends Kategori {
  public KategoriPeseNjesoj(int index){
      super("Pese Njesoj",index);
  }

  public int llogaritPiket(int[] zarat) {
      for(int i=0; i<zarat.length; i++){
          int count=0;
          for(int j=0;j<zarat.length;j++){
              if(zarat[i]==zarat[j]) count++;
          }
          if(count>=5) return 50;
      }

      return 0;
  }
}
