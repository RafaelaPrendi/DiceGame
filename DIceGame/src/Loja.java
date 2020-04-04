
import mainGui.PaneliKryesor;

import javax.swing.*;

public class Loja extends JFrame{

    public Loja(){
        super();
        setTitle("Yatzee");                          //krijon titullin lart
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new PaneliKryesor());                       //objekti MainPanel
        setVisible(true);
    }

    public static void main(String args[]){
        new Loja();
    }
}
