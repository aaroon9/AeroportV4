package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author root
 */
public class LlistatAvions {

    private JFrame frame;
    private final int AMPLADA = 600;
    private final int ALCADA = 200;

    private JTable taulaAvions;

    private JButton bSortir;

    /*
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    Heu d'inicialitzar els atributs d'aquesta classe fent el següent (no afegiu cap listener a cap control):
            
    - Heu d'inicialitzar l'objecte JFrame amb títol "Llistat d'avions" i layout Grid d'una columna
    - Heu d'inicialitzar l'objecte Jtable amb un nou objecte de TaulaAvio
    - Heu d'inicialitzar l'objecte JButton amb nom "Sortir".
    - Heu d'afegir-ho tot a l'atribut frame
    - Heu de fer visible el frame amb l'amplada i alçada que proposen els atributs alcada i amplada
    - Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
       
     */
    public LlistatAvions() {

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable getTaulaAvions() {
        return taulaAvions;
    }

    public void setTaulaAvions(JTable pTaulaAvions) {
        taulaAvions = pTaulaAvions;
    }

    public JButton getSortir() {
        return bSortir;
    }

    public void setSortir(JButton bSortir) {
        this.bSortir = bSortir;
    }
}
