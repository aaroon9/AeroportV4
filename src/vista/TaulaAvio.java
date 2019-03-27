package vista;

import controlador.ControladorPrincipal;
import java.util.ArrayList;
import model.Avio;

/**
 *
 * @author root
 */
public class TaulaAvio {
    private final String[] nomsColumnes = {"Codi", "Fabricant", "Model", "Capacitat"};    
    private String[][] avions;

    public TaulaAvio() {
        
       ArrayList<Avio> avionsCompanyia=new ArrayList();
        
        for(int i=0; i<ControladorPrincipal.getCompanyiaActual().getComponents().size(); i++){
            if(ControladorPrincipal.getCompanyiaActual().getComponents().get(i) instanceof Avio){
                avionsCompanyia.add((Avio)ControladorPrincipal.getCompanyiaActual().getComponents().get(i));
            }
        }
        
        avions= new String[avionsCompanyia.size()][4];
        
        int i = 0;
        
        for (Avio avio : avionsCompanyia) {
            if (avio != null) {
                avions[i][0] = avio.getCodi();
                avions[i][1] = avio.getFabricant();
                avions[i][2] = avio.getModel();
                avions[i][3] = String.valueOf(avio.getCapacitat());
                i++;
            }
        }
    }


    public String[] getNomColumnes() {
        return nomsColumnes;
    }

    public String[][] getAvions() {
        return avions;
    }

    public void setCuines(String[][] pAvions) {
        avions = pAvions;
    }
}
