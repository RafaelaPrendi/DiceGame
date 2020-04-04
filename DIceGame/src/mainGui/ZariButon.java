package mainGui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ZariButon extends JToggleButton {      //ka dy gjendje si buton , JToggleButton eshte nje buton qe ka 2 gjendje.nqse e shtyp e ben pandryshushme hedhjen e zarin 
    private int pike=0;                              //fishimisht zarat shenojne zero, nqs ve int pike=6 do shenojne 6
    private Random random;                           //perdorim klasen random per te gjeneruar zarat

    public ZariButon(){
        super();                                    //thiret konstruktori pa argumenta i jtoggle
        setPreferredSize(new Dimension(60,60));     //permsat e zarit
        setText("" + pike);                         //do vendosesh nr e pikeve brenda ne zar
        random=new Random();                       //gjenerohen nr radom
    }

    public void hidhZarin(){
        pike=random.nextInt(6)+1;                 //gjeneron nr random nga 1 ne 6, +1 eshte kufiri i poshtem,(6)eshte intervali sa do levize
        setText(""+pike);						 //VENDOS piket ne Jtogglebutton
    }

    public int getPike() {                        //metode get per aksesimin e fushes private pike
        return pike;
    }

    public void setPike(int pike) {              //kte metode e perdor kur tu behet reset zareve pasi ke shtypur nje kategori
        this.pike=pike;                         //fusha pike merr vleren e pike
        setText(""+pike);           
    }
}
