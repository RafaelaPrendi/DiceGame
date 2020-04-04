package mainGui.kategori;

import mainGui.kategori.Kategori;

public class KategoriTreDheDy extends Kategori {
    public KategoriTreDheDy(int index){
        super("Tre dhe Dy",index);
    }

    public int llogaritPiket(int[] zarat) {
        int count[]=new int[7];                //krijohet nje vektor qe do mbaje  7 elemente int , me emrin count

        for(int i=0; i<zarat.length;i++){
            count[zarat[i]]++;                   //psh count[3] fillimisht eshte zero sepse eshte e painicializuar , ++ e kthen 1 , kur haset prape ne vektor coun[3] ,do inkrementohet perseri dhe do marre vleren 2
        }

        if(contains(count,2) && contains(count,3)) return 25;    //count  = komplet vektori count

        return 0;
    }

    private boolean contains(int[] piket,int vlera){     //krahason elementet e vektorit me nje vlere te caktuar
        for(int i=0; i<piket.length; i++){
            if(piket[i]==vlera) return true;            //eshte metode booleane spese kthen true ose false ne menyre qe te plotesohet if me lart
        }
        return false;
    }
}
