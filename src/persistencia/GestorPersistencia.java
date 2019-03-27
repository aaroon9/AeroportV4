package persistencia;

import java.text.ParseException;
import model.Companyia;
import principal.GestioVolsExcepcio;

/**
 *
 * @author cesca
 */
public class GestorPersistencia {
     private ProveedorPersistencia gestor;

    public ProveedorPersistencia getGestor() {
        return gestor;
    }

    public void setGestor(ProveedorPersistencia pGestor) {
        gestor = pGestor;
    }

    public void desarCompanyia(String tipusPersistencia, String nomFitxer, Companyia companyia) throws GestioVolsExcepcio {

        switch (tipusPersistencia) {

            case "XML":
                gestor = new GestorXML();
                break;
            default:
                 gestor = new GestorJDBC();
                break;
        }

        gestor.desarDades(nomFitxer, companyia);
    }

    public void carregarRestaurant(String tipusPersistencia, String nomFitxer) throws ParseException, GestioVolsExcepcio {

        switch (tipusPersistencia) {

            case "XML":
                gestor = new GestorXML();
                break;
            default:
                gestor = new GestorJDBC();
                break;

        }

        gestor.carregarDades(nomFitxer);
    }
}
