package mainGui;

import mainGui.kategori.Kategori;                                     //importon paketen gui.kat perkatesisht Kategori

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import Yahtzee.*;

public class PanelLoja extends JPanel implements ActionListener{
    public static final int NO_ROUNDEVE = 13;                   //finale e pandryshueshme , statike e lidhur me klasen aksesohet para se te ndertohen objekte
    public static final int KUFIRI_BONUS = 63;
    public static final int PIKET_BONUS = 35;
    public JLabel[][] piketLabels;                                           //vektor i tipit JLabel me emer piketLabels

    //private ShembullDatabaze db = null;
    private int lojtariRradhes=0;
    private int numriLojtareve=4;
    private Lojtar lojtaret[];                                                  //krijohet  nje vektor i tipit class lojtari

    Zari zariPanel;                                                       //variabl i tipit Zari(klasa)

    public PanelLoja(){                                                  //konstruktori
        super();
     //   db = new ShembullDatabaze();
        setSize(200,300);
        setLayout(new GridBagLayout());                                   //tipi i layout te faqes
        setBorder(BorderFactory.createTitledBorder("Yahtzeee! Game!"));   //vendos nje border dhe nje titull cepi lart majtas

        GridBagConstraints c = new GridBagConstraints();                  //krijon objektin e tipit class gridbaglayout
        c.fill = GridBagConstraints.BOTH;                                  //kane te bejne kur ben minimize faqen

        c.insets = new Insets(5,20,5,20);                                 //pozicionimi i komponenteve
        c.anchor = GridBagConstraints.CENTER;                            //used when the component is smaller than its display area

        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Lojtaret:"),c);                                 //shton JLabel se bashku me layout c

        try{
            numriLojtareve=Integer.parseInt(JOptionPane.showInputDialog("Jepni numrin e Lojtareve:",4));     //kthen ne integer inputin qe mori nga perdoruesi qe ishte string,4 eshte vlera default
        }catch (NumberFormatException e){
            numriLojtareve=4;                                                   //nqs ndodh perjashtimi automatikisht do kete 4 lojtare // nqs do ndryshe beje System.exit() per te perfundaur prog
        }
        
        JTextField emriField = new JTextField(10);
        JTextField mbiemriField = new JTextField(10);
        JTextField moshaField = new JTextField(3);
        
        JPanel myPanel = new JPanel();
        
        JPanel namePanel = new JPanel();
       namePanel.add(new JLabel("Emri: "));
       namePanel.add(emriField);  
       myPanel.add(namePanel);
       
       myPanel.add(Box.createHorizontalStrut(15));
       JPanel lastnamePanel = new JPanel();
       lastnamePanel.add(new JLabel("Mbiemri: "));
       lastnamePanel.add(mbiemriField);
       myPanel.add(lastnamePanel);
       
       myPanel.add(Box.createHorizontalStrut(15));
       JPanel agePanel = new JPanel();
       agePanel.add(new JLabel("Mosha: "));
       agePanel.add(moshaField);
       myPanel.add(agePanel); 
        
        
        lojtaret=new Lojtar[numriLojtareve+1];                                   //vendose +1 sepse ciklin e nis nga i=1,ndryshe del array out of bound exception
        for(int i=1; i<lojtaret.length; i++){
            c.gridx=i;           
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Ju lutem jepni emrin, mbiemrin dhe moshen tuaj.", JOptionPane.OK_CANCEL_OPTION);
            //emrat e lojtareve do te vendosen lart horizontalisht te spostuara me 1
            String emri = emriField.getText();
            //db.insertIntoDB(emri,mbiemriField.getText(),Integer.parseInt(moshaField.getText()));
            lojtaret[i]=new Lojtar(emri);                                     //emrat e lojtareve i vendos ne vektorin lojtaret[i]   //thirret konstruktori i Lojari (klasa tjeter) nderton kuadratin dhe vendos emrin
            add(lojtaret[i],c);
            emriField.setText("");
            mbiemriField.setText("");
            moshaField.setText("");
        }

        c.gridx=0;
        c.gridy = 1;
        c.gridwidth=1;                                                        //hapesira mes kategorive

       
        
        
        for (int i=1; i<=6; i++){                                         //deri tek index 6 jane piket e siperme
            c.gridy = i;
            add(Kategori.kategorite.get(i), c);                          //ktu ndertohen butonat,aksesohe psh   Kategori.kategori.get(2)==kat.put(DYSHA,new KategoriDysha(DYSHA)) e cila krijon nje objekt te tipit KategoriDysha, konstruktori i te cilir krijon butonin me emrin perkates     
            Kategori.kategorite.get(i).addActionListener(this);          //faza e rregjistrimit behet lidhja
        }                                                                //get(i) kthen vleren e lidhur me celesin e i-te psh i=2 (DYSHA)

       
        
        
        c.gridy = 7;                                       
        add(new JLabel("Piket e Siperme"),c);                            //Thjesht shkruhet Piket e siperme , llogaritjen e kam bere ne lojtari
        c.gridy = 8; 
        add(new JLabel("Bonus"),c);

        
        
        for (int i=9; i<=15; i++){
            c.gridy = i;
            add(Kategori.kategorite.get(i), c);
            Kategori.kategorite.get(i).addActionListener(this);
        }

        
        
        c.gridy = 16;
        add(new JLabel("Piket e Poshtme"),c);
        c.gridy = 17;
        add(new JLabel("TOTAL"),c);


        c.gridx = 0;
        c.gridy = 0;

        
        //BEJ AFISHIMIN E PIKEVE PER SECILIN LOJTAR
       
        piketLabels = new JLabel[numriLojtareve+1][18];                   //fusha e pare e vektorit akseson secilin lojtar specifik sipas rradhes, fusha e dyte ben vendosjen e pikeve sipas kategorive      
        for (int j=1;j<piketLabels.length; j++){                         //j=1 ->Lojtari i pare
            c.gridx=j;                                                  
            for(int i=1; i<18; i++){
                c.gridy=i;
                piketLabels[j][i]=new JLabel(""+lojtaret[j].getPiketKategori(i));          //lojtare[1].getPiketKategori(1)
                add(piketLabels[j][i], c);
            }
        }

        
       
        c.gridx = 6;
        c.gridy = 1;
        c.gridheight = 18;
        zariPanel=new Zari();              //ktu ndertohen objektet e klases Zari()
        add(zariPanel,c);

        lojtariTjeter();                  //metode te cilen e kam te implementuar me poshte
    
   
    
    } //ktu perfundon konstruktori PaneliLojes

    
    
    
    public void actionPerformed(ActionEvent e) { 
        Kategori k = (Kategori) e.getSource();
        k.setEnabled(true);
        if(zariPanel.getRoundi()< NO_ROUNDEVE){                             //deklaroj nje objekt k te tipit kategori i cili merr referencen e komponentit qe gjeneroi ngjarjen(cili nga butonat u shtyp , Njesha ,Dysha etj..
            int pike = k.llogaritPiket(zariPanel.getKombinimizarave()); //k mban referencen e objektit qe gjeneroi ngjarjen dhe ne kte menyre behet llogaritja e duhur e pikeve ne varesi te butoni qe kam shtypur
            if(Kategori.kategoriteExtra.containsKey(k.getText() + lojtariRradhes)) {
            	
            	lojtaret[lojtariRradhes].addPike(k.getIndex(),pike);               //k.getIndex() merr indexin e kategorise(psh DYSHA) dhe shton piket ne ate kategori, addPike eshte metode e Lojtari
            	Kategori.kategoriteExtra.remove(k.getText() + lojtariRradhes);
            	//k.setEnabled(false);
            
            piketLabels[lojtariRradhes][k.getIndex()].setText(""+lojtaret[lojtariRradhes].getPiketKategori(k.getIndex())); //vendosja e pikeve
            zariPanel.resetZarat();             //kur shtyp nje kategori zarat behen reset

 
           
            // bej update labelat e pikeve siperme/poshtme/bonus/total
            int piketSiperme=lojtaret[lojtariRradhes].getPiketSiperme();         //getPiketSiperme() metode e Lojtari
            int pikeBonus=0;
     
            
                  
            //MUND TA FSHISH PJESEN E BONUS KTU , PASI BOUSI SHTOHET VETEM NE FUND TE LOJES
        /*    if(piketSiperme> KUFIRI_BONUS){                                     //nqs plotesohet kushti
                pikeBonus=PIKET_BONUS;
                piketLabels[lojtariRradhes][Kategori.BONUS].setText("" + PIKET_BONUS);           //Vendsoi piket e bonus ne kto koordinata
            }*/
           
            piketLabels[lojtariRradhes][Kategori.PIKET_SIPERME].setText("" + piketSiperme);       //Kategori.PIKET_SIPERME mban indeksin
            
            int piketPoshtme=lojtaret[lojtariRradhes].getPiketPoshtme();                         //ruan piket e poshtme qe i mori nga metoda E Lojtari ne nje variabel int        
            piketLabels[lojtariRradhes][Kategori.PIKET_POSHTME].setText("" + piketPoshtme);     //afishon piket e poshtme
           
            int totaliPikeve=piketSiperme+piketPoshtme+pikeBonus;
            piketLabels[lojtariRradhes][Kategori.TOTALI].setText("" + totaliPikeve);
   
    

           

            lojtariTjeter();
            
        } else {
        	k.setEnabled(false);
        	//JOptionPane.showMessageDialog(this, "Nuk mund te zgjidhni 2 here te njejten kategori!");
        }
        } //mbyllja if
        
        
        
        else {   //nqs eshte plotesuar nr i roundeve llogarit sasine e pikeve
            
        	for (int i=1; i<=numriLojtareve; i++){
                int piketSiperme=lojtaret[i].getPiketSiperme();
                
                if(piketSiperme> KUFIRI_BONUS){                                //shto bonus nqs shuma e pikeve te siperme eshte me madhe se 63                                 
                    piketLabels[i][Kategori.BONUS].setText(""+ PIKET_BONUS);
                    lojtaret[i].addPike(8,35);                                   //shto ne kategoria bonus 35 pike
                }
               
                piketLabels[i][Kategori.PIKET_SIPERME].setText(""+piketSiperme);
                lojtaret[i].addPike(Kategori.PIKET_SIPERME,piketSiperme);
                
                int piketPoshtme=lojtaret[i].getPiketPoshtme();
                piketLabels[i][Kategori.PIKET_POSHTME].setText(""+piketPoshtme);
                lojtaret[i].addPike(Kategori.PIKET_POSHTME,piketPoshtme);
                
                int totaliPikeve=lojtaret[i].getTotaliPikeve();
                piketLabels[i][Kategori.TOTALI].setText(""+totaliPikeve);
                lojtaret[i].addPike(Kategori.TOTALI,totaliPikeve);
            }
        	
        //	for(int i=1; i<=numriLojtareve; i++){
        //		db.insertIntoDBPiket(lojtaret[i].getEmri(),lojtaret[i].getTotaliPikeve());        		System.out.println(lojtaret[i].getEmri());
        //	}
            Lojtar fitues=lojtariFitues();                                //metode e implementuar me poshte
            JOptionPane.showMessageDialog(this,"Lojtari Fitues: "+
                    fitues.getEmri()+"\nPike: "+fitues.getTotaliPikeve());
        }

    }

    private void lojtariTjeter(){
        lojtariRradhes=lojtariRradhes+1;                //inkrementohet lojtari
        if(lojtariRradhes>numriLojtareve){              //pas ka mbaruar lojtari i fundit ndro round
            zariPanel.roundiTjeter();
            lojtariRradhes=1;
        }
        for (int i=1; i<lojtaret.length; i++){
            lojtaret[i].setBackground(Color.red);               //gjithe lojtaret qe nuk kane rradhen ngjyre blu
        }
        lojtaret[lojtariRradhes].setBackground(Color.yellow);     //lojtari qe ka rradhen i vensdosim ngjyre jeshile

    }

    public Lojtar lojtariFitues(){                              //metode e tipit class Lojtari
        int index = 1;
      //  int pike=lojtaret[1].getTotaliPikeve();
        int pike =50;
        for(int i=1; i<=numriLojtareve; i++){
        	if(lojtaret[i].getTotaliPikeve() >=pike) {
            	//return lojtaret[i];
            	
            	JOptionPane.showMessageDialog(this,"Lojtari Fitues: "+
            			lojtaret[i].getEmri()+"\nPike: "+pike );
            	//index=i;
            	//pike=lojtaret[i].getTotaliPikeve();
            	//pike = 50;
            }
        	
//        	else  if (lojtaret[i].getTotaliPikeve()>pike){
//                index=i;
//                pike=lojtaret[i].getTotaliPikeve();
//           }
            
        }

        
        return lojtaret[index];
    }
}
