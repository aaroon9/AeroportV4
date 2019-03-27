package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Companyia;
import persistencia.GestorPersistencia;
import vista.MenuPrincipal;

/**
 *
 * @author root
 */
public class ControladorPrincipal implements ActionListener {

    private static MenuPrincipal menuPrincipal;
    private static final String FITXER = "companyia.xml";
    private static final int MAXCOMPANYIES = 3;
    private static Companyia[] companyies = new Companyia[MAXCOMPANYIES];
    private static int posicioCompanyies = 0;
    private static Companyia companyiaActual = null;
    private static int tipusElement = 0;
    static private GestorPersistencia gp = new GestorPersistencia();
    static private final String[] METODEPERSISTENCIA = {"XML", "JDBC"};

    /*  
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    - S'inicialitza l'atribut menuPrincipal (això mostrarà el menú principal)
    - A cada botó del menú principal se li afegeix el listener tenint en compte què el
    mètode actionPerformed, està implementat en aquesta classe.
     */
    public ControladorPrincipal() {

    }

    /*  
    Paràmetres: ActionEvent    
    Acció: S'ha de cridar a seleccionarOpcio segons l'opció premuda. Penseu que l'opció es correspon amb
    la posició que el botó ocupa a l'array de botons de menuPrincipal.        
    Retorn: cap
     */
    public void actionPerformed(ActionEvent e) {

    }

    private void seleccionarOpcio(int opcio) {
        switch (opcio) {
            case 0: //Sortir
                System.exit(0);
                break;
            case 1: //Gestió companyia
                menuPrincipal.getFrame().setVisible(false);
                ControladorCompanyia controladorCompanyia = new ControladorCompanyia();
                break;
            case 2: //Gestió avió
                if (companyiaActual != null) {
                    menuPrincipal.getFrame().setVisible(false);
                    ControladorAvio controladorAvio = new ControladorAvio();
                } else {
                    JOptionPane.showMessageDialog(null, "Has de seleccionar una companyia al menu companyia.", "Avís", JOptionPane.PLAIN_MESSAGE);
                }
                break;
        }
    }

    public static String getFITXER() {
        return FITXER;
    }

    public static int getMAXCOMPANYIES() {
        return MAXCOMPANYIES;
    }

    public static String[] getMETODEPERSISTENCIA() {
        return METODEPERSISTENCIA;
    }

    public static MenuPrincipal getMenuPrincipal() {
        return menuPrincipal;
    }

    public static void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        ControladorPrincipal.menuPrincipal = menuPrincipal;
    }

    public static Companyia[] getCompanyies() {
        return companyies;
    }

    public static void setCompanyies(Companyia[] companyies) {
        ControladorPrincipal.companyies = companyies;
    }

    public static int getPosicioCompanyies() {
        return posicioCompanyies;
    }

    public static void setPosicioCompanyies(int posicioCompanyies) {
        ControladorPrincipal.posicioCompanyies = posicioCompanyies;
    }

    public static Companyia getCompanyiaActual() {
        return companyiaActual;
    }

    public static void setCompanyiaActual(Companyia companyiaActual) {
        ControladorPrincipal.companyiaActual = companyiaActual;
    }

    public static int getTipusElement() {
        return tipusElement;
    }

    public static void setTipusElement(int tipusElement) {
        ControladorPrincipal.tipusElement = tipusElement;
    }

    public static GestorPersistencia getGp() {
        return gp;
    }

    public static void setGp(GestorPersistencia gp) {
        ControladorPrincipal.gp = gp;
    }

}
