package vista;

import controlador.ControladorPrincipal;
import model.Companyia;

/**
 *
 * @author root
 */
public class TaulaCompanyia {
    private final String[] nomsColumnes = {"Codi", "Nom"};

    private String[][] companyies = new String[ControladorPrincipal.getMAXCOMPANYIES()][2];

    public TaulaCompanyia() {
        
        int i = 0;
        for (Companyia companyia : ControladorPrincipal.getCompanyies()) {
            if (companyia != null) {
                companyies[i][0] = String.valueOf(companyia.getCodi());
                companyies[i][1] = companyia.getNom();
                i++;
            }
        }
    }


    public String[] getNomColumnes() {
        return nomsColumnes;
    }

    public String[][] getCompanyes() {
        return companyies;
    }

    public void setCuines(String[][] pCompanyies) {
        companyies = pCompanyies;
    } 
}
