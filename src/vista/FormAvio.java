package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class FormAvio {

    private JFrame frame;
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lCodi;
    private JTextField tCodi;
    private JLabel lFabricant;
    private JTextField tFabricant;
    private JLabel lModel;
    private JTextField tModel;
    private JLabel lCapacitat;
    private JTextField tCapacitat;

    private JButton bDesar;
    private JButton bSortir;

    /* 
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    Heu d'inicialitzar els atributs d'aquesta classe fent el següent (no afegiu cap listener a cap control):
            
     - Heu d'inicialitzar l'objecte JFrame amb títol "Formulari Avió" i layout Grid d'una columna
     - Heu d'inicialitzar els objectes JLabel amb el nom corresponent segons l'atribut de l'avió que representen.
     - Heu d'inicialitzar els objectes JTextField amb una longitud de 20 caràcters.
     - Heu d'inicialitzar els objectes JButton amb els noms "Desar" i "Sortir" respectivament.
     - Heu d'afegir-ho tot a l'atribut frame
     - Heu de fer visible el frame amb l'amplada i alçada que proposen els atributs alcada i amplada
     - Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
        
     */
    public FormAvio() {

    }

    /*
     CONSTRUCTOR
     Paràmetres: valors del codi, fabricant, model i capacitat
     Accions:
     - Crear un formulari amb l'atra constructor d'aquesta classe FormAvio().
     - Mostrar els valors passats per paràmetre en els camps de text pertinents del formulari.
     */
    public FormAvio(String codi, String fabricant, String model, int capacitat) {

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getCodi() {
        return tCodi;
    }

    public void setCodi(JTextField tCodi) {
        this.tCodi = tCodi;
    }

    public JTextField gettFabricant() {
        return tFabricant;
    }

    public void settFabricant(JTextField tFabricant) {
        this.tFabricant = tFabricant;
    }

    public JTextField gettModel() {
        return tModel;
    }

    public void settModel(JTextField tModel) {
        this.tModel = tModel;
    }

    public JTextField gettCapacitat() {
        return tCapacitat;
    }

    public void settCapacitat(JTextField tCapacitat) {
        this.tCapacitat = tCapacitat;
    }

    public JButton getDesar() {
        return bDesar;
    }

    public void setDesar(JButton bDesar) {
        this.bDesar = bDesar;
    }

    public JButton getSortir() {
        return bSortir;
    }

    public void setSortir(JButton bSortir) {
        this.bSortir = bSortir;
    }
}
