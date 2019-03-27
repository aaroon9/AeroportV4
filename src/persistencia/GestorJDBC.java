package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import model.Companyia;
import principal.GestioVolsExcepcio;

/**
 *
 * @author root
 */
public class GestorJDBC implements ProveedorPersistencia {
    private Companyia companyia;

    private Connection conn; //Connexió a la base de dades

    public Companyia getCompanyia() {
        return companyia;
    }

    public void setCompanyia(Companyia companyia) {
        this.companyia = companyia;
    }

    /*
     *TODO
     * 
     *Paràmetres: cap
     *
     *Acció:
     * - Heu d'establir la connexio JDBC amb la base de dades GestorVols
     * - Heu de fer el catch de les possibles excepcions SQL mostrant el missatge
     *   de l'excepció capturada mitjançant getMessage().
     * - Si es produeix una excepció a l'establir la connexió, assignareu el 
     *   valor null a l'atribut conn.
     *
     *Retorn: cap
     *
     */
    public void estableixConnexio() throws SQLException {

    }

   /*
     * Heu de tancar la connexió i assignar-li el valor null a l'atribut conn, es 
     * produeixi o no una excepció.
     *
     */
    public void tancaConnexio() throws SQLException {
  
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer i la companyia a desar
     *
     *Acció:
     * Heu de desar la companyia passada com a paràmetre en la base de dades:
     *   - S'ha de desar en la taula companyes (nomFitxer és el codi de la companyia)
     *   - Cada avió de la companyia, s'ha de desar com registre de la taula avions
     *   - Heu de tenir en compte que si la companyia ja existeix a la base de 
     *     dades, aleshores heu de fer el següent:
     *        - Actualitzar la companyia ja existent
     *        - Eliminar totes els avions d'aquesta companyia de la taula avions i 
     *          després insertar els avions de la companyia.
     *   - Si al fer qualsevol operació es produeix una excepció, llavors heu de 
     *     llançar l'excepció GestioVolsExcepcio amb codi "GestorJDBC.desar"
     *
     *Retorn: cap
     *
     */
    @Override
    public void desarDades(String nomFitxer, Companyia companyia) throws GestioVolsExcepcio {

    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer de la companyia
     *
     *Acció:
     * Heu de carregar la companyia des de la base de dades (nomFitxer és el codi 
     * de la companyia). Per fer això, heu de:
     *   - Cercar el registre companyia de la taula companyies amb codi = nomFitxer. 
     *   - Heu d'afegir els avions al vector de components de la companyia a partir de 
     *     la taula avions.
     *   - Si al fer qualsevol operació es produeix una excepció, llavors heu de 
     *     llançar l'excepció GestioVolsExcepcio amb codi "GestorJDBC.carrega"
     *   - Si el nomFitxer donat no existeix a la taula companyies (és a dir, el 
     *     codi = nomFitxer no existeix), aleshores heu de llançar l'excepció 
     *     GestioVolsExcepcio amb codi "GestorJDBC.noexist"
     *
     *Retorn: cap
     *
     */
    @Override
    public Companyia carregarDades(String nomFitxer) throws ParseException, GestioVolsExcepcio {

    
    }
}