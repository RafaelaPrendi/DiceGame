package mainGui.kategori;

import mainGui.kategori.Kategori;

//te pakten tre nga zarat duhet te kene te njejten vlere
public class KategoriTreNjesoj extends Kategori {
  public KategoriTreNjesoj(int index){
      super("Tre Njesoj",index);
  }

  public int llogaritPiket(int[] zarat) {
      int sum=0;
      for(int s=0;s<zarat.length;s++){
          sum+=zarat[s];                     //logaritet shuma e gjithe zarave , qe ne rast se plotesohen kushtet e meposhtme te kthehet kjo shume
      }
      for(int i=0; i<zarat.length; i++){
          int count=0;
          for(int j=0;j<zarat.length;j++){
              if(zarat[i]==zarat[j]) count++;
          }
          if(count>=3) return sum;
      }

      return 0;
  }
}
