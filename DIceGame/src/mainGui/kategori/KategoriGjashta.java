package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriGjashta extends Kategori {
    public KategoriGjashta(int index){
        super("Gjashta",index);
    }

    public int llogaritPiket(int[] zarat) {
        int sum=0;
        for(int i=0; i<zarat.length; i++){
            if(zarat[i]==6) sum+=6;
        }
        return sum;
    }
}

