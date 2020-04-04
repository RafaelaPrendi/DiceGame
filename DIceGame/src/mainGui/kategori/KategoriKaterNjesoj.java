package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriKaterNjesoj extends Kategori {
    public KategoriKaterNjesoj(int index){
        super("Kater Njesoj",index);
    }

    public int llogaritPiket(int[] zarat) {
        int sum=0;
        for(int s=0;s<zarat.length;s++){
            sum+=zarat[s];
        }
        for(int i=0; i<zarat.length; i++){
            int count=0;
            for(int j=0;j<zarat.length;j++){
                if(zarat[i]==zarat[j]) count++;
            }
            if(count>=4) return sum;
        }

        return 0;
    }
}

