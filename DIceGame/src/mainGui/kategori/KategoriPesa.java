package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriPesa extends Kategori{
    public KategoriPesa(int index){
        super("Pesa",index);
    }

    public int llogaritPiket(int[] zarat) {
        int sum=0;
        for(int i=0; i<zarat.length; i++){
            if(zarat[i]==5) sum+=5;
        }
        return sum;
    }
}

