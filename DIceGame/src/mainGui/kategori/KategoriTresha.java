package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriTresha extends Kategori {
    public KategoriTresha(int index){
        super("Tresha",index);
    }

    public int llogaritPiket(int[] zarat) {
        int sum=0;
        for(int i=0; i<zarat.length; i++){
            if(zarat[i]==3) sum+=3;
        }
        return sum;
    }
}
