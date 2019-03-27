package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.FormCompanyia;
import vista.LlistatCompanyies;
import vista.MenuCompanyia;

/**
 *
 * @author root
 */
public class ControladorCompanyia implements ActionListener {

    private MenuCompanyia menuCompanyia;
    private FormCompanyia formCompanyia = null;
    private LlistatCompanyies llistatCompanyies = null;
    private int opcioSeleccionada = 0;

    /*  
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    - S'inicialitza l'atribut menuCompanyia (això mostrarà el menú de companyia)
    - Es crida a afegirListenersMenu
     */
    public ControladorCompanyia() {

    }

    /*  
    Paràmetres: cap    
    Acció: A cada botó de la vista del menú companyia se li afegeix el listener 
    tenint en compte què el mètode actionPerformed, està implementat en aquesta classe.        
    Retorn: cap
     */
    private void afegirListenersMenu() {
 
    }

    /*  
    Paràmetres: cap    
    Acció: A cada botó de la vista del formulari de la companyia se li afegeix el listener 
    tenint en compte què el mètode actionPerformed, està implementat en aquesta classe.        
    Retorn: cap
     */
    private void afegirListenersForm() {
      
    }

    /*  
    Paràmetres: cap    
    Acció: Al botó sortir de la vista del llistat de companyies se li afegeix el listener 
    tenint en compte què el mètode actionPerformed, està implementat en aquesta classe.        
    Retorn: cap
     */
    private void afegirListenersLlistat() {
       
    }

    /*  
    Paràmetres: cap    
    
    Acció: 
    - S'ha de mostrar a l'usuari un JPane perquè l'usuari pugui seleccionar una de les companyies
    guardades en el vector de companyies del ControladorPrincipal.
    - Per seleccionar les companyies, l'usuari ha de disposar en el JPane d'un botó amb el codi
    de cadascuna de les companyies, amb el missatge "Selecciona una companyia", el títol "Seleccionar 
    companyia" i la icona de qüestió.
    - Si s'ha seleccionat una companyia, aquesta passarà a ser la companyia actual del ControladorPrincipal.
    
    NOTA: Si abans de seleccionar una companyia tanquem la finestra, el mètode de JPane que heu d'utilitzar,
    retornarà -1.
    
    Retorn: cap
     */
    private void seleccionarCompanyia() {

        
    }

    /*  
    Paràmetres: cap    
    Acció: 
    - Comprova que l'usuari hagi introduït algun valor en el camp de text del nom del formulari
    de la companyia.
    - Si el camp no està buit, retornarà verdader.
    - Si el camp està buit mostrarà a l'usuari una JPane amb el missatge "S'ha d'introduir el nom",
    el títol "ATENCIÓ!!!" i la icona d'avís (warning).
    Retorn: Verdader si s'ha introduït el nom. Fals en cas contrari.
     */
    private Boolean validarCompanyia() {
        
    }

    /*
    Paràmetres: ActionEvent
        
    Nota:    
    Com ControladorCompanyia té els listeners del menú companyia, del formulari i del llistat, llavors en aquest mètode
    actionPerformed heu de controlar si l'usuari ha premut algun botó de qualsevol de les finestres esmentades.
            
    En el cas del formulari i del llistat, com provenen del menú companyia (s'activen des del menú companyia), heu de verificar
    primer que els objectes FormCompanyia o LlistatCompanyia no són nulls, per tal de saber si podeu comparar-los amb
    algun botó d'aquestes finestres.
    
    Accions per al menú:
    
        S'ha de cridar a seleccionarOpcio segons l'opció premuda. Penseu que l'opció es correspon amb
        la posició que el botó ocupa a l'array de botons de menuCompanyia. També, heu d'actualitzar 
        l'atribut opcioSeleccionada amb l'opció que ha premut l'usuari.
        
    Accions per al formulari: (La finestra del formulari està oberta)
            
        ---- DESAR ----
            Si el botó premut per l'usuari és el botó de desar, llavors:
                Si l'opció seleccionada en el menú companyia és 1 (alta), llavors:
                    Es validen les dades mitjançant el mètode validarCompanyia():
                       Si no són correctes, validarCompanyia() mostrarà l'avís corresponent (penseu que no heu de fer res, ja que
                       és el mètode el que mostra l'avis directament)
                       Si són correctes:
                        - Es crea un nou objecte Companyia amb les dades del formulari
                        - S'afegeix la companyia creada al vector companyies del ControladorPrincipal(recordeu actualitzar posicioCompanyes un cop afegida)
                        - S'assigna al camp de text corresponent al codi, el codi de la nova companyia.
                        - S'assigna aquesta companyia, com a companyiaActual (del ControladorPrincipal) i es canvia l'atribut
                          opcioSeleccionada a 2 per seleccionar la companyia actual.
                Si l'opció seleccionada en el menú companyia és 3 (modificar), llavors:
                    Es validen les dades mitjançant el mètode validarCompanyia():
                       Si no són correctes, validarCompanyia() mostrarà un missatge (No heu de fer res, ja ho fa validarCompanyia())
                       Si són correctes:
                        - Es modifica l'objecte companyia amb les dades introduides mitjançant el formulari (penseu que en aquests moments, la companyia és la companyia actual)
        
        ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir del formulari, llavors:
                Heu de tornar al menú companyia i amagar el formulari.
        
    Accions per al llistat:
        
        ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir del llistat, llavors:
                Heu de tornar al menú companyia i amagar el llistat.
        
        Retorn: cap
     */
    public void actionPerformed(ActionEvent e) {
        
    }

    private void seleccionarOpcio(int opcio) {
        switch (opcio) {

            case 0: //sortir
                ControladorPrincipal.getMenuPrincipal().getFrame().setVisible(true);
                break;

            case 1: // alta
                if (ControladorPrincipal.getPosicioCompanyies() < ControladorPrincipal.getMAXCOMPANYIES()) {
                    formCompanyia = new FormCompanyia();
                    afegirListenersForm();
                } else {
                    menuCompanyia.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuCompanyia.getFrame(), "Màxim nombre de companyies assolides.", "Avís", JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case 2: //seleccionar
                menuCompanyia.getFrame().setVisible(true);
                if (ControladorPrincipal.getCompanyies()[0] != null) {
                    seleccionarCompanyia();
                } else {
                    JOptionPane.showMessageDialog(menuCompanyia.getFrame(), "Abans s'ha de crear al menys una companyia", "Avís", JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case 3: //modificar
                if (ControladorPrincipal.getCompanyies()[0] != null) {
                    seleccionarCompanyia();
                    formCompanyia = new FormCompanyia(ControladorPrincipal.getCompanyiaActual().getCodi(), ControladorPrincipal.getCompanyiaActual().getNom());
                    afegirListenersForm();
                } else {
                    menuCompanyia.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuCompanyia.getFrame(), "Abans s'ha de crear al menys una companyia", "Avís", JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case 4: // llistar
                if (ControladorPrincipal.getCompanyies()[0] != null) {
                    llistatCompanyies = new LlistatCompanyies();
                    afegirListenersLlistat();
                } else {
                    menuCompanyia.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuCCompanyia.getFrame(), "Abans s'ha de crear al menys una companyia", "Avís", JOptionPane.PLAIN_MESSAGE);
                }
                break;
            case 5: //Desar contingut
                /*
                 - Es mostra un diàleg (JOptionPane.showOptionDialog) amb un botó, que representa al mètode de persistència del document,
                   en el nostre cas XML o JDBC. El títol de la finestra serà "Desar Contingut" i li demanarem a l'usuari "Com vols desar-ho?". 
                   La icona sera un interrogant.
                 - Un cop escollit el mètode, es desa el contingut de companyia cridant al mètode desarContingut del gestor de persistència i
                   es torna a mostrar el menú de companyia.                
                 - Heu de capturar les excepcions que es puguin produir en el mètode. Un cop capturada heu de mostrar una finestra emergent de
                   tipus showMessageDialog de la classe JPane, que ens mostri el missatge d'error produït amb la icona de error, títol "ERROR" 
                   i un cop acceptat torni a mostrar el menú de companyia.
                
                 NOTA: Recordeu que el contingut, instància d'un objecte del gestor de persistència i tipus de persistències, els teniu en el controlador
                 principal.
             
                 */
                
                break;
            case 6: //Carregar contingut
                /*                    
                 - Es selecciona una companyia mitjançant el mètode seleccionarCompanyia d'aquesta classe.
                 - Si s'ha seleccionat la companyia, es mostra un JPane de tipus showOptionDialog amb botons, on cadascun d'ells és un mètode de càrrega
                   (XML i JDBC. Recordeu que a ControladorPrincipal hi ha un atribut amb els mètodes de càrrega).El títol de la finestra serà 
                   "Carregar Contingut" i li demanarem a l'usuari "D'on vols carregar el contingut?". La icona sera un interrogant. 
                 - Un cop l'usuari ha seleccionat el mètode de càrrega:        
                   - S'actualitza el contingut de Companyia mitjançant el mètode carregarContingut del gestor de persistència.
                   - Es mostra un missatge confirmant que el contingut s'ha modificat(JOptionPane.showMessageDialog) amb títol "Contingut" i cap icona.
                   - Es torna a mostrar el menú de companyia.
                   - Heu de capturar les excepcions que es puguin produir en el mètode. Un cop capturada heu de mostrar una finestra emergent de
                   tipus showMessageDialog de la classe JPane, que ens mostri el missatge d'error produït amb la icona de error, títol "ERROR" 
                   i un cop acceptat torni a mostrar el menú d'adminstrador.
            
                 NOTA: Recordeu que la instància d'un objecte del gestor de persistència, el teniu en el controlador principal.
                 */
                
                break;
        }
    }
}
