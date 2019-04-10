package controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Avio;
import vista.FormAvio;
import vista.LlistatAvions;
import vista.MenuAvio;
import principal.Component;

import javax.swing.*;
import principal.GestioVolsExcepcio;

/**
 *
 * @author root
 */
public class ControladorAvio implements ActionListener {
    private MenuAvio menuAvio;
    private FormAvio formAvio = null;
    private LlistatAvions llistatAvions = null;
    private Avio avio = null;
    private int opcioSeleccionada = 0;

    /*  
    CONSTRUCTOR
    Paràmetres:cap
    Accions:
    - S'inicialitza l'atribut menuAvio (això mostrarà el menú d'avions)
    - Es crida a afegirListenersMenu
     */
    public ControladorAvio() {
        menuAvio = new MenuAvio();
        afegirListenersMenu();
    }

    /*  
    Paràmetres: cap    
    Acció: A cada botó de la vista del menú avió se li afegeix el listener 
    tenint en compte què el mètode actionPerformed, està implementat en aquesta classe.        
    Retorn: cap
     */
    private void afegirListenersMenu() {
        for (int i = 0; i < menuAvio.getMenuButtons().length; i++) {
            menuAvio.getMenuButtons()[i].addActionListener(this);
        }
        
    }

    /*  
    Paràmetres: cap    
    Acció: A cada botó de la vista del formulari de l'avió se li afegeix el listener 
    tenint en compte què el mètode actionPerformed, està implementat en aquesta classe.        
    Retorn: cap
     */
    private void afegirListenersForm() {
        formAvio.getDesar().addActionListener(this);
        formAvio.getSortir().addActionListener(this);
    }

    /*  
    Paràmetres: cap    
    Acció: Al botó sortir de la vista del llistat d'avions se li afegeix el listener 
    tenint en compte què el mètode actionPerformed, està implementat en aquesta classe.        
    Retorn: cap
     */
    private void afegirListenersLlistat() {
        llistatAvions.getSortir().addActionListener(this);
    }

    /*  
    Paràmetres: cap    
    
    Acció: 
    - S'ha de mostrar a l'usuari un JPane perquè l'usuari pugui seleccionar un dels avions
    de la companyia actual del controlador principal.
    - Per seleccionar els avions, l'usuari ha de disposar en el JPane d'un botó per cada avió
    amb el seu codi, amb el missatge "Selecciona un avió", el títol "Seleccionar avió" i la 
    icona de qüestió.
    
    NOTA: Si abans de seleccionar un avió tanquem la finestra, el mètode de JPane que heu d'utilitzar,
    retornarà -1.
    
    Retorn: avió seleccionat de la companyia actual.
     */
    private Avio seleccionarAvio() {
        ArrayList <Avio> llistatAvions = new ArrayList<Avio>();
        for(Component compo : ControladorPrincipal.getCompanyiaActual().getComponents()){
            if(compo instanceof Avio){
                llistatAvions = (ArrayList<Avio>) compo;
            }
        }
        
        Avio[] objArray = (Avio[]) llistatAvions.toArray();
         
        int opcio = JOptionPane.showOptionDialog(null,"Seleccionar avió","Seleccionar avió!",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, objArray,-1);
        
        if (opcio == -1){
            return null;
        }else{
            return (Avio) ControladorPrincipal.getCompanyiaActual().getComponents().get(opcio);
        }
    }

    /*  
    Paràmetres: cap    
    Acció: 
    - Comprova que l'usuari hagi introduït algun valor en els camps de text del formulari.
    - Si no hi ha cap buit, retornarà verdader.
    - Si hi ha algun camp buit, mostrarà a l'usuari una JPane amb el missatge "S'han d'introduir dades a tots els camps",
    el títol "ATENCIÓ!!!" i la icona d'avís (warning).
    Retorn: Verdader si s'han introduït totes les dades. Fals en cas contrari.
     */
    private Boolean validarAvio() {
        if(formAvio.getCodi() == null || formAvio.gettFabricant() == null || formAvio.gettModel() == null || formAvio.gettCapacitat() == null){
           
           JOptionPane.showMessageDialog(null, "S'han d'introduir dades a tots els camps", "ATENCIÓ!!!", JOptionPane.WARNING_MESSAGE);
           return false;
           
        }else{
            
            return true;
            
        }
        
    }

    /*
    Paràmetres: ActionEvent
        
    Nota:    
    Com ControladorAvio té els listeners del menú, del formulari i del llistat d'avió, llavors en aquest mètode
    actionPerformed heu de controlar si l'usuari ha premut algun botó de qualsevol de les finestres esmentades.
            
    En el cas del formulari i del llistat, com provenen del menú avió (s'activen des del menú avió), heu de verificar
    primer que els objectes FormAvio o LlistatAvio no són nulls, per tal de saber si podeu comparar-los amb
    algun botó d'aquestes finestres.
    
    Accions per al menú:
    
        S'ha de cridar a seleccionarOpcio segons l'opció premuda. Penseu que l'opció es correspon amb
        la posició que el botó ocupa a l'array de botons de menuPrincipal. També, heu d'actualitzar 
        l'atribut opcioSeleccionada amb l'opció que ha premut l'usuari.
        
    Accions per al formulari: (La finestra del formulari està oberta)
            
        ---- DESAR ----
            Si el botó premut per l'usuari és el botó de desar, llavors:
                Si l'opció seleccionada en el menú avió és 1 (alta), llavors:
                    Es validen les dades mitjançant el mètode validarAvio():
                       Si no són correctes, validarAvio() mostrarà l'avís corresponent (penseu que no heu de fer res, ja que
                       és el mètode el que mostra l'avis directament)
                       Si són correctes:
                        - Es crea un nou objecte Avio amb les dades del formulari
                        - S'afegeix l'avió creat a la companyia actual del ControladorPrincipal mitjançant el mètode escaient de la classe Companyia.
                       Si es produeix alguna excepció, s'ha de capturar i mostrar en un JPane, amb el missatge corresponent al codi de l'excepció,
                       el títol "EXCEPCIÓ!!!" i la icona d'avís (warning).
                Si l'opció seleccionada en el menú avió és 2 (modificar), llavors:
                    Es validen les dades mitjançant el mètode validarAvio():
                       Si no són correctes, validarAvio() mostrarà un missatge (No heu de fer res, ja ho fa validarAvio())
                       Si són correctes:
                        - Es modifica l'objecte Avio amb les dades introduides mitjançant el formulari.
        
        ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir del formulari, llavors:
                Heu de tornar al menú avió i amagar el formulari.
        
    Accions per al llistat:
        
        ---- SORTIR ----
            Si el botó premut per l'usuari és el botó de sortir del llistat, llavors:
                Heu de tornar al menú avió i amagar el llistat.
        
        Retorn: cap
     */
    public void actionPerformed(ActionEvent e) {
        Object gestor = e.getSource();
        
        if (gestor.equals(menuAvio.getMenuButtons()[0])){//Premen el botto sortir
            opcioSeleccionada = 0;
            seleccionarOpcio(opcioSeleccionada);
        }else if(gestor.equals(menuAvio.getMenuButtons()[1])){ //botto Alta
            opcioSeleccionada = 1;
            seleccionarOpcio(opcioSeleccionada);
        }else if(gestor.equals(menuAvio.getMenuButtons()[2])){ //botto modd
            opcioSeleccionada = 2;
            seleccionarOpcio(opcioSeleccionada);
        }else if(gestor.equals(menuAvio.getMenuButtons()[3])){
            opcioSeleccionada = 3;
            seleccionarOpcio(opcioSeleccionada);
        }
        
        if(formAvio != null){
            if(gestor.equals(formAvio.getDesar())){
                switch(opcioSeleccionada){
                    case 1:
                        if(validarAvio()){
                            try {
                                avio = new Avio (formAvio.getCodi().getText(), formAvio.gettFabricant().getText(), formAvio.gettModel().getText(), Integer.parseInt(formAvio.gettCapacitat().getText()));
                                ControladorPrincipal.getCompanyiaActual().afegirAvio(avio);
                            } catch (GestioVolsExcepcio exc) {
                                JOptionPane.showMessageDialog(null, exc, "EXCEPCIÓ!!!", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    break;
                    
                    case 2:
                        if(validarAvio()){
                            //Agafem el avio actual
                            int opcio = ControladorPrincipal.getCompanyiaActual().seleccionarComponent(1, formAvio.getCodi().getText());
                            avio = (Avio) ControladorPrincipal.getCompanyiaActual().getComponents().get(opcio);
                            //modifiquem l'avio actual amb les dades del formulari
                            avio.setModel(formAvio.gettModel().getText());
                            avio.setFabricant(formAvio.gettFabricant().getText());
                            avio.setCapacitat(Integer.parseInt(formAvio.gettCapacitat().getText()));
                        }
                    break;
                }
            }else if(gestor.equals(formAvio.getSortir())){
                formAvio.getFrame().setVisible(false);
                menuAvio.getFrame().setVisible(true);
            }
        }
        if(llistatAvions != null){
            if(gestor.equals(llistatAvions.getSortir())){
                llistatAvions.getFrame().setVisible(false);
                menuAvio.getFrame().setVisible(true);
            }
        }
       
    }

    private void seleccionarOpcio(int opcio) {
        switch (opcio) {

            case 0: //sortir
                ControladorPrincipal.getMenuPrincipal().getFrame().setVisible(true);
                break;

            case 1: // alta
                formAvio = new FormAvio();
                afegirListenersForm();
                break;

            case 2: //modificar
                avio = seleccionarAvio();
                formAvio = new FormAvio(avio.getCodi(), avio.getFabricant(), avio.getModel(), avio.getCapacitat());
                afegirListenersForm();
                break;

            case 3: // llistar
                llistatAvions = new LlistatAvions();
                afegirListenersLlistat();
                break;
        }
    }
}
