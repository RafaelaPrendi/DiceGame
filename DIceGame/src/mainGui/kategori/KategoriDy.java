package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriDy extends Kategori {

    public KategoriDy(int index){
        super("Dysha",index);             //thirret konstruktori i prindit, vendoset emri deh index
    }

    public int llogaritPiket(int[] zarat) {
        int sum=0;
        for(int i=0; i<zarat.length; i++){
            if(zarat[i]==2) sum+=2;                     //nqs zare i i-te eshte 2 shtoje shumen
        }
        return sum;
    }
}