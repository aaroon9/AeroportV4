package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class FormCompanyia {
    private JFrame frame;
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lCodi;
    private JTextField tCodi;
    private JLabel lNom;
    private JTextField tNom;

    private JButton bDesar;
    private JButton bSortir;

    /* 
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    Heu d'inicialitzar els atributs d'aquesta classe fent el següent (no afegiu cap listener a cap control):
            
     - Heu d'inicialitzar l'objecte JFrame amb títol "Formulari Companyia" i layout Grid d'una columna
     - Heu d'inicialitzar els objectes JLabel amb el nom corresponent segons l'atribut de companyia que representen.
     - Heu d'inicialitzar els objectes JTextField amb una longitud de 20 caràcters.
     - Heu de desactivar JTextField de codi perquè l'usuari no pugui afegir, ni modificar el codi de la companyia,
       ja que ja sabeu que aquest es genera de manera automàtica en donar d'alta una companyia. Es desahabilita el 
       codi del formulari mitjançant el mètode setEnabled(false) de la classe JTextField que desahabilita l'input
       de text quan li passem el paràmetre false.
     - Heu d'inicialitzar els objectes JButton amb els noms "Desar" i "Sortir" respectivament.
     - Heu d'afegir-ho tot a l'atribut frame
     - Heu de fer visible el frame amb l'amplada i alçada que proposen els atributs alcada i amplada
     - Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
        
     */
    public FormCompanyia() {
        
    }

     /*
     CONSTRUCTOR
     Paràmetres: valors del codi de la companyia i el nom
     Accions:
     - Crear un formulari amb l'atra constructor d'aquesta classe FormCompanyia().
     - Mostrar els valors passats per paràmetre en els camps de text pertinents del formulari.
     */
    public FormCompanyia(int codi, String adreca) {
        
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

    public JLabel getlNom() {
        return lNom;
    }

    public void setlNom(JLabel lNom) {
        this.lNom = lNom;
    }

    public JTextField gettNom() {
        return tNom;
    }

    public void settNom(JTextField tNom) {
        this.tNom = tNom;
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
