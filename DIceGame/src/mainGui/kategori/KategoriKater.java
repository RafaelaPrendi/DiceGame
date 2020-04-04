package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriKater extends Kategori {
    public KategoriKater(int index){
        super("Katra",index);
    }

    public int llogaritPiket(int[] zarat) {
        int sum=0;
        for(int i=0; i<zarat.length; i++){
            if(zarat[i]==4) sum+=4;
        }
        return sum;
    }
}

