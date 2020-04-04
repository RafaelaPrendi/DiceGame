package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriPeseNjepasnjeshme extends Kategori {
    public KategoriPeseNjepasnjeshme(int index){
        super("Pese te Njepasnjeshme",index);
    }

    public int llogaritPiket(int[] zarat) {
        if(contains(zarat,1) && contains(zarat,2) && contains(zarat,3) && contains(zarat,4) && contains(zarat,5)) return 40;
        if(contains(zarat,2) && contains(zarat,3) && contains(zarat,4) && contains(zarat,5) && contains(zarat,6)) return 40;
        return 0;
    }

    private boolean contains(int[] zarat,int vlera){
        for(int i=0; i<zarat.length; i++){
            if(zarat[i]==vlera) return true;
        }
        return false;
    }
}
