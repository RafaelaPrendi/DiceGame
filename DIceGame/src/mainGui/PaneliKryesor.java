package mainGui;

import javax.swing.*;
import java.awt.*;

public class PaneliKryesor extends JPanel {
    private PanelLoja paneliLojes;   //fushe
    public PaneliKryesor(){
        super();
        setLayout(new BorderLayout());   //paneli i ljoes do te jete borderlayout

        paneliLojes = new PanelLoja();
        paneliLojes.setBackground(Color.pink);//krijohet objekti i tipit PaneliLojes
        add(paneliLojes,BorderLayout.CENTER);   

    }
}
