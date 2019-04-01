package  vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class MenuPrincipal {
    private JFrame frame;
    private JPanel panell;

    private JButton[] menuButtons = new JButton[3];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    /* 
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    Heu d'inicialitzar els atributs d'aquesta classe fent el següent (no afegiu cap listener a cap control):
            
     - Heu d'inicialitzar l'objecte JFrame amb títol "Menú Principal" i layout Grid d'una columna
     - Heu de crear els botons del formulari. Cada botó serà un element de l'array menuBotons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Menú Companyia"
                        "2. Menú Avio"
     - Heu d'afegir-ho tot a l'atribut frame
     - Heu de fer visible el frame amb l'amplada i alçada que proposen els atributs amplada i alcada
     - Heu de fer que la finestra es tanqui quan l'usuari ho fa amb el control "X" de la finestra
        
    */ 
    public MenuPrincipal() {
        frame = new JFrame("Menu Principal");
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        frame.setLayout(new GridLayout(3, 1, 10, 10));
        
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Menú Companyia");
        menuButtons[2] = new JButton("2. Menú Avio");
        
        frame.add(menuButtons[0]);
        frame.add(menuButtons[1]);
        frame.add(menuButtons[2]);
        
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }
}
