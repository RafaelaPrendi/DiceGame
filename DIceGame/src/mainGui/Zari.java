package mainGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
                                                                     //nderfaqja ActionListener ka vetem nje metode ActionPerformed
public class Zari extends JPanel implements ActionListener{     //ndertoj klasen Zari qe eshte event handler dhe qe implementon nderfaqe ActionListener
    private JLabel roundLabel;                                       //Afishohet nr i roundeve                     
    private ZariButon zari1,zari2,zari3,zari4,zari5;                  //fushe e tipit ZariButon qe e kam ndertuar ne nje klase tjeter dhe ja di karakteristikat
    private JButton hidhZarat;                                          // butoni hidh zarat
    private int roundi=1;                                              //raundi 1 eshte raundi fillestar , inicializimi i fushes
    private int noHedhjeve=0;

    public Zari(){                                               //konstruktori i klases
        super();                                                       //konstruktori i Jpanel
 
    //NDRYSHE NGA GRIDLAYOUT , GRIDBACKLAYOUT E NUK E NDAN EKRANIN NE KOLONA DHE RRESHTA TE BARABARTA, KOLONAT APO RRESHTAT MUND TE BEJNE SPAN NDERMJET TYRE 
        
        GridBagConstraints g= new GridBagConstraints();  //krijoj nje objekt g te tipit class gridbaglayout
                                            //GridBagConstraints specifies how to display a specific component.
                                           //GridBagLayout eshte container ashtu si GridLayout
        setLayout(new GridBagLayout());   //Every component added to a GridBagLayout container should have a GridBagConstraints object associated with it.
                                         //Without GridBagConstraints, the GridBagLayout is a blank slate
        
        
        //BEN POZICIONIMIN E JLABEL 
        roundLabel =new JLabel("Roundi: "+roundi);    //vendos nr e roundeve,ndodhet siper zarave
        g.gridx=0;  //Specify the row and column at the upper left of the component. The leftmost column has address gridx=0 and the top row has address gridy=0
        g.gridy=0;                                //fill ->Used when the component's display area is larger than the component's requested size
        g.fill=GridBagConstraints.HORIZONTAL;  //HORIZONTAL (make the component wide enough to fill its display area horizontally, but do not change its height)
        g.insets=new Insets(10,20,10,20); //LARGESIA E JALBEL(RAUNDE) NGA ZARAT  //insets Specifies the external padding of the component -- the minimum amount of space between the component and the edges of its display area.
        add(roundLabel,g);


        zari1=new ZariButon();           //inicializoj nje objekt te tipit class ZariButon
        g.gridy=1;                        //koordinata vetikale
        g.fill=GridBagConstraints.NONE;   //default value
        add(zari1,g);                    //shto zarin e pare

        zari2=new ZariButon();
        g.gridy=2;                     //koordinata vetikale 
        add(zari2,g);                //shto zarin e dyte

        zari3=new ZariButon();
        g.gridy=3;                    // koordinata vetikale duhet te rriten sepse nqs ve dy te njejta do te kem mbivendosje zaresh
        add(zari3,g);

        zari4=new ZariButon();
        g.gridy=4;
        add(zari4,g);

        zari5=new ZariButon();
        g.gridy=5;
        add(zari5,g);

        hidhZarat=new JButton("Hidh Zarat");  //deklaroj nje jbutton me reference hidh zarat   //butoni hidh zarat
        g.gridy=6;
        g.fill=GridBagConstraints.HORIZONTAL;      //mbushe hapesiren horizontalisht
        add(hidhZarat,g);

       
        
        hidhZarat.addActionListener(this);  //FAZA E RREGJISITRIMIT,behet lidhja e klases qe implementoi nderfaqen me butonin qe gjeneroi event
                                            //Merr si parameter objektin e klases ku ndodhemi,this eshte reference ne objektin e klases
    }

    public void actionPerformed(ActionEvent e) { //actionPerformed eshte nje metode qe kthen void dhe merr nje parameter e ne rastin tone dhe eshte e tipit actionevent
    	                                         //brenda kesaj metode vendos ato rreshta kodi qe dua te me ekzekutohen kur te ndodhi ngjarja
    	
    	if(e.getSource()==hidhZarat){             //krahason referencat           //an event object (e) contains a reference to the component that generated the event. To extract that reference form the event object we use getsource()         
                                                // e.getsource() nxjerr reference e komponentit qe gjeneroi ngjarjen.Komponenti eshte butoni Jlabel qe i kam vene referncen hidh zarat 
    		if (noHedhjeve<3){                    //TRE HERE mund ti hedhesh zaret
                if (!zari1.isSelected()){           //nqs nuk kam klikuar mbi zarin1,ke te drejte ta hedhesh,nqs nuk kam klikuar mos e hidh
                    zari1.hidhZarin();                     //metode ne class ZariButon qe gjeneron numrat random
                }
                if (!zari2.isSelected()){
                    zari2.hidhZarin();
                }
                if (!zari3.isSelected()){
                    zari3.hidhZarin();
                }
                if (!zari4.isSelected()){
                    zari4.hidhZarin();
                }
                if (!zari5.isSelected()){
                    zari5.hidhZarin();
                }
                noHedhjeve++;
            }
            if (noHedhjeve>=3){
                hidhZarat.setEnabled(false);     //caktivizo butnonin pas hedhjes se trete
           
            }

        }
    }

    public int[] getKombinimizarave(){              //kombinimet e zarave i vendos ne nje vektor
        int[] zarat=new int[5];                       //deklaroj nje vektor me 5 elemente me reference zarat
        zarat[0]=zari1.getPike();                   //ne pozicionin 0 vendos piket qe mora nga zari i pare
        zarat[1]=zari2.getPike();                   //getpiket() metode e klases ZariButon qe me kthen piket
        zarat[2]=zari3.getPike();
        zarat[3]=zari4.getPike();
        zarat[4]=zari5.getPike();
        return zarat;                               //kthe vektorin
    }

    public void resetZarat(){                   //zarat do behen reset ne momentin qe une do klikoj mbi nje nga kategorite
        zari1.setPike(0);
        zari2.setPike(0);
        zari3.setPike(0);
        zari4.setPike(0);
        zari5.setPike(0);
        zari1.setSelected(false);              //ne momentin qe kam klikuar nje kategori dhe dhe zarat behen reset, ky zar nuk duhet te jete i selektuar
        zari2.setSelected(false);              //nqs e bej true zari do jete i selektuar ne moemntin e reset
        zari3.setSelected(false);
        zari4.setSelected(false);
        zari5.setSelected(false);
        hidhZarat.setEnabled(true);            //pasi jane bere reset zarat aktivizo butonin Hidh Zarat
        noHedhjeve=0;                         //zero nr e hedhjeve pasi ke bere reset,kemi kaluar ne lojtari tjeter
    }

    public void roundiTjeter(){
        roundi++;
        roundLabel.setText("Roundi: "+roundi);           //inkrementoje nr e roundeve
        updateUI();                                      //nqs nuk e ve nuk behet update nr i roundeve
    }
    public int getRoundi(){                            //e kisha fushe private
        return roundi;
    }

}

