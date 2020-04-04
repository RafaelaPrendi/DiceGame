package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriTjeter extends Kategori{
    public KategoriTjeter(int index){
        super("Cdo Rast",index);
    }

    public int llogaritPiket(int[] zarat) {    //realizon thjesht shumen e zarave
        int sum=0;
        for(int s=0;s<zarat.length;s++){
            sum+=zarat[s];
        }
        return sum;
    }
}

