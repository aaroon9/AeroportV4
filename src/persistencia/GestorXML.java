package persistencia;

import model.TCP;
import model.Tripulant;
import model.RutaIntercontinental;
import model.RutaTransoceanica;
import model.Classe;
import model.RutaInternacional;
import model.RutaNacional;
import model.TripulantCabina;
import model.Avio;
import model.Ruta;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import nu.xom.*;
import model.Companyia;
import principal.GestioVolsExcepcio;
import model.Vol;

/**
 *
 * @author cesca
 */
public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private Companyia companyia;

    public Companyia getCompanyia() {
        return companyia;
    }

    public void setCompanyia(Companyia pCompanyia) {
        companyia = pCompanyia;
    }

    public void desarDades(String nomFitxer, Companyia pCompanyia) throws GestioVolsExcepcio {
        construirModel(pCompanyia);
        desarModel(nomFitxer);
    }

    public Companyia carregarDades(String nomFitxer) throws ParseException, GestioVolsExcepcio {
        carregarFitxer(nomFitxer);
        obtenirDades();
        return companyia;
    }

    /*Paràmetres: Companyia a partir de la qual volem construir el model
     *
     *Acció: 
     *Llegir els atributs de l'objecte Companyia passat per paràmetre per construir
     *un model (document XML) sobre el Document doc (atribut de GestorXML).
     *L'arrel del document XML és "companyia" i heu d'afegir-ne els valors de 
     *codi i nom com atributs. Aquesta arrel, l'heu d'afegir a doc.
     *
     *Un cop fet això, heu de recórrer l'ArrayList elements de Companyia i per 
     *a cada element, afegir un fill a doc. Cada fill tindrà com atributs els 
     *atributs de l'objecte (codi, nom, fabricant, …)
     *
     *Si es tracta d'un avio, a més, heu d'afegir fills addicionals amb els 
     *valors de les classes d'aquest avio. 
     *
     *Si es tracta d'un vol, a més, heu d'afegir fills addicionals amb els 
     *valors dels tripulants d'aquest vol. En el cas de l'atribut avio, heu d'assignar-li
     *el codi de l'avio del vol, i en el cas del cap dels TCP, el passport del cap.
     *
     *Retorn: cap
     */
    private void construirModel(Companyia companyia) {
        //Creem l'element arrel contingut
        Element arrel = new Element("companyia");
        Element fill = null, net = null;

        arrel.addAttribute(new Attribute("codi", String.valueOf(companyia.getCodi())));
        arrel.addAttribute(new Attribute("nom", companyia.getNom()));

        for (int i = 0; i < companyia.getComponents().size(); i++) {

            if (companyia.getComponents().get(i) instanceof Avio) {
                //creem avio
                fill = new Element("avio");

                //Afegim atributs a l'avió
                fill.addAttribute(new Attribute("codi", ((Avio) companyia.getComponents().get(i)).getCodi()));
                fill.addAttribute(new Attribute("fabricant", ((Avio) companyia.getComponents().get(i)).getFabricant()));
                fill.addAttribute(new Attribute("model", ((Avio) companyia.getComponents().get(i)).getModel()));
                fill.addAttribute(new Attribute("capacitat", String.valueOf(((Avio) companyia.getComponents().get(i)).getCapacitat())));

                //Afegim les classes a l'avió
                for (int j = 0; j < ((Avio) companyia.getComponents().get(i)).getClasses().size(); j++) {
                    //creem la classe
                    net = new Element("classe");

                    //Afegim els atributs de la classe
                    net.addAttribute(new Attribute("nom", ((Classe) ((Avio) companyia.getComponents().get(i)).getClasses().get(j)).getNom()));
                    net.addAttribute(new Attribute("capacitat", String.valueOf(((Classe) ((Avio) companyia.getComponents().get(i)).getClasses().get(j)).getCapacitat())));

                    //Afegim la classe a l'avió
                    fill.appendChild(net);
                }

                //Afegim avió al contingut
                arrel.appendChild(fill);

            } else if (companyia.getComponents().get(i) instanceof Ruta) {

                Attribute codi = new Attribute("codi", ((Ruta) companyia.getComponents().get(i)).getCodi());
                Attribute aeroportOri = new Attribute("aeroportOri", ((Ruta) companyia.getComponents().get(i)).getAeroportOri());
                Attribute aeroportDes = new Attribute("aeroportDes", ((Ruta) companyia.getComponents().get(i)).getAeroportDes());
                Attribute distancia = new Attribute("distancia", String.valueOf(((Ruta) companyia.getComponents().get(i)).getDistancia()));

                if (companyia.getComponents().get(i) instanceof RutaNacional) {
                    //creem ruta nacional
                    fill = new Element("rutaNacional");

                    //Afegim atributs a la ruta nacional
                    fill.addAttribute(codi);
                    fill.addAttribute(aeroportOri);
                    fill.addAttribute(aeroportDes);
                    fill.addAttribute(distancia);
                    fill.addAttribute(new Attribute("pais", ((RutaNacional) companyia.getComponents().get(i)).getPais()));

                } else if (companyia.getComponents().get(i) instanceof RutaInternacional) {

                    Attribute paisOri = new Attribute("paisOri", ((RutaInternacional) companyia.getComponents().get(i)).getPaisOri());
                    Attribute paisDes = new Attribute("paisDes", ((RutaInternacional) companyia.getComponents().get(i)).getPaisDes());

                    //creem ruta internacional
                    fill = new Element("rutaInternacional");

                    //Afegim atributs a la ruta internacional
                    fill.addAttribute(codi);
                    fill.addAttribute(aeroportOri);
                    fill.addAttribute(aeroportDes);
                    fill.addAttribute(distancia);
                    fill.addAttribute(paisOri);
                    fill.addAttribute(paisDes);

                    if (companyia.getComponents().get(i) instanceof RutaIntercontinental) {

                        Attribute continentOri = new Attribute("continentOri", ((RutaIntercontinental) companyia.getComponents().get(i)).getContinentOri());
                        Attribute continentDes = new Attribute("continentDes", ((RutaIntercontinental) companyia.getComponents().get(i)).getContinentDes());

                        //creem ruta intercontinental
                        fill = new Element("rutaIntercontinental");

                        //Afegim atributs a la ruta intercontinental
                        fill.addAttribute(codi);
                        fill.addAttribute(aeroportOri);
                        fill.addAttribute(aeroportDes);
                        fill.addAttribute(distancia);
                        fill.addAttribute(paisOri);
                        fill.addAttribute(paisDes);
                        fill.addAttribute(continentOri);
                        fill.addAttribute(continentDes);

                        if (companyia.getComponents().get(i) instanceof RutaTransoceanica) {

                            //creem ruta intercontinental
                            fill = new Element("rutaTransoceanica");

                            //Afegim atributs a la ruta intercontinental
                            fill.addAttribute(codi);
                            fill.addAttribute(aeroportOri);
                            fill.addAttribute(aeroportDes);
                            fill.addAttribute(distancia);
                            fill.addAttribute(paisOri);
                            fill.addAttribute(paisDes);
                            fill.addAttribute(continentOri);
                            fill.addAttribute(continentDes);
                            fill.addAttribute(new Attribute("ocea", ((RutaTransoceanica) companyia.getComponents().get(i)).getOcea()));

                        }

                    }
                }

                //Afegim ruta a companyia
                arrel.appendChild(fill);

            } else if (companyia.getComponents().get(i) instanceof Tripulant) {

                Attribute passaport = new Attribute("passaport", ((Tripulant) companyia.getComponents().get(i)).getPassaport());
                Attribute nom = new Attribute("nom", ((Tripulant) companyia.getComponents().get(i)).getPassaport());
                Attribute edat = new Attribute("edat", String.valueOf(((Tripulant) companyia.getComponents().get(i)).getEdat()));
                Attribute dataAlta = new Attribute("dataAlta", String.valueOf(((Tripulant) companyia.getComponents().get(i)).getDataAlta()));
                Attribute horesVol = new Attribute("horesVol", String.valueOf(((Tripulant) companyia.getComponents().get(i)).getHoresVol()));
                Attribute rang = new Attribute("rang", ((Tripulant) companyia.getComponents().get(i)).getRang());

                if (companyia.getComponents().get(i) instanceof TCP) {
                    //creem TCP
                    fill = new Element("TCP");

                    //Afegim atributs a TCP
                    fill.addAttribute(passaport);
                    fill.addAttribute(nom);
                    fill.addAttribute(edat);
                    fill.addAttribute(dataAlta);
                    fill.addAttribute(horesVol);
                    fill.addAttribute(rang);

                } else if (companyia.getComponents().get(i) instanceof TripulantCabina) {

                    //creem tripulant de cabina
                    fill = new Element("tripulantCabina");

                    //Afegim atributs al tripulant de cabina 
                    fill.addAttribute(passaport);
                    fill.addAttribute(nom);
                    fill.addAttribute(edat);
                    fill.addAttribute(dataAlta);
                    fill.addAttribute(horesVol);
                    fill.addAttribute(rang);
                    fill.addAttribute(new Attribute("barres", String.valueOf(((TripulantCabina) companyia.getComponents().get(i)).getBarres())));
                }

                //Afegim tripulant a companyia
                arrel.appendChild(fill);

            } else if (companyia.getComponents().get(i) instanceof Vol) {
                //creem vol
                fill = new Element("vol");

                //Afegim atributs a l'avió
                fill.addAttribute(new Attribute("codi", ((Vol) companyia.getComponents().get(i)).getCodi()));
                fill.addAttribute(new Attribute("ruta", ((Vol) companyia.getComponents().get(i)).getRuta().getCodi()));
                fill.addAttribute(new Attribute("avio", ((Vol) companyia.getComponents().get(i)).getAvio().getCodi()));
                fill.addAttribute(new Attribute("dataSortida", String.valueOf(((Vol) companyia.getComponents().get(i)).getDataSortida())));
                fill.addAttribute(new Attribute("dataArribada", String.valueOf(((Vol) companyia.getComponents().get(i)).getDataArribada())));
                fill.addAttribute(new Attribute("horaSortida", String.valueOf(((Vol) companyia.getComponents().get(i)).getHoraSortida())));
                fill.addAttribute(new Attribute("horaArribada", String.valueOf(((Vol) companyia.getComponents().get(i)).getHoraArribada())));
                fill.addAttribute(new Attribute("durada", String.valueOf(((Vol) companyia.getComponents().get(i)).getDurada())));

                Iterator punter = ((Vol) companyia.getComponents().get(i)).getTripulacio().keySet().iterator();

                //Afegim els tripulants al vol
                while (punter.hasNext()) {

                    Object clau = punter.next();

                    Attribute passaport = new Attribute("passaport", String.valueOf(clau));
                    Attribute nom = new Attribute("nom", ((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau)).getNom());
                    Attribute edat = new Attribute("edat", String.valueOf(((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau)).getEdat()));
                    Attribute dataAlta = new Attribute("dataAlta", String.valueOf(((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau)).getDataAlta()));
                    Attribute horesVol = new Attribute("horesVol", String.valueOf(((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau)).getHoresVol()));
                    Attribute rang = new Attribute("rang", ((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau)).getRang());

                    if ((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau) instanceof TCP) {
                        //creem TCP
                        net = new Element("TCP");

                        //Afegim atributs a TCP
                        net.addAttribute(passaport);
                        net.addAttribute(nom);
                        net.addAttribute(edat);
                        net.addAttribute(dataAlta);
                        net.addAttribute(horesVol);
                        net.addAttribute(rang);

                    } else if ((Tripulant) ((Vol) companyia.getComponents().get(i)).getTripulacio().get(clau) instanceof TripulantCabina) {

                        //creem tripulant de cabina
                        net = new Element("tripulantCabina");

                        //Afegim atributs al tripulant cabina
                        net.addAttribute(passaport);
                        net.addAttribute(nom);
                        net.addAttribute(edat);
                        net.addAttribute(dataAlta);
                        net.addAttribute(horesVol);
                        net.addAttribute(rang);
                        net.addAttribute(new Attribute("barres", String.valueOf(((TripulantCabina) companyia.getComponents().get(i)).getBarres())));
                    }

                    //Afegim tripulant a companyia
                    fill.appendChild(net);
                }

                //Afegim avió al contingut
                arrel.appendChild(fill);
            }

            //Creem nou document XML amb tot l'arbre XML creat
            doc = new Document(arrel);
        }
    }

    private void desarModel(String rutaFitxer) throws GestioVolsExcepcio {
        try {
            FileWriter fitxer = new FileWriter(rutaFitxer, false); //Obrim fitxer per sobreescriure
            fitxer.write(doc.toXML());
            fitxer.close();
        } catch (Exception e) {
            throw new GestioVolsExcepcio("GestorXML.desar");
        }
    }

    private void carregarFitxer(String rutaFitxer) throws GestioVolsExcepcio {
        Builder builder = new Builder();
        try {
            doc = builder.build("/home/cesca/NetBeansProjects/ControlPlatsV4Solucio/" + rutaFitxer);
            System.out.println(doc.toXML());
        } catch (Exception e) {
            throw new GestioVolsExcepcio("GestorXML.carregar");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     *El mètode obtenirDades llegeix el fitxer del disc i el carrega sobre l'atribut 
     *doc de GestorXML.
     *
     *L'objectiu és llegir el document per assignar valors als atributs de Companyia
     *(i la resta d'objectes). Per llegir els valors dels atributs del document 
     *XML, heu de fer servir el mètode getAtributeValue(). 
     *Penseu que l'arrel conté els atributs de la companyia, per tant, al accedir 
     *a l'arrel del document ja podeu crear l'objecte Companyia amb el mètode constructor 
     *escaient de la classe companyia (fixeu-vos que s’ha afgeit un de nou).
     *
     *Un cop fet això, heu de recòrrer el document i per cada fill, haureu d'afegir un
     *element a l'ArrayList components de Companyia (nouXXX(.....)). Penseu que 
     *els mètodes de la classe companyia per afegir components, els hem modificat
     *perquè es pugui afegir un component passat er paràmetre.
     *
     *Si el fill (del document) que s'ha llegit és un avió o un vol, recordeu que a més
     *d'afegir-los a la companyia, també haureu d'afegir en el l'avió les seves classes
     *i en el vol la seva tripulació.
     *
     *Retorn: cap
     */
    private void obtenirDades() throws ParseException, GestioVolsExcepcio {

        Element arrel = doc.getRootElement();

        //Es crea l'objecte Companyia
        Companyia companyia = new Companyia(Integer.parseInt(arrel.getAttributeValue("codi")), arrel.getAttributeValue("nom"));

        Elements elements, fills; //Elements del document xml.

        //Recorregut dels avions    
        elements = arrel.getChildElements("avio");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim l'avió actual a la companyia
            companyia.afegirAvio(new Avio(elements.get(i).getAttributeValue("codi"), elements.get(i).getAttributeValue("fabricant"), elements.get(i).getAttributeValue("model"), Integer.parseInt(elements.get(i).getAttributeValue("capacitat"))));

            //Recorregut de les classes de l'avió
            fills = elements.get(i).getChildElements("classe");

            for (int j = 0; j < fills.size(); j++) {
                ((Avio) companyia.getComponents().get(companyia.getComponents().size() - 1)).afegirClasse(new Classe(fills.get(i).getAttributeValue("nom"), Integer.parseInt(fills.get(i).getAttributeValue("capacitat"))));
            }

        }

        //Recorregut de les rutes nacionals
        elements = arrel.getChildElements("rutaNacional");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim la ruta nacional actual a la companyia
            companyia.afegirRutaNacional(new RutaNacional(elements.get(i).getAttributeValue("codi"), elements.get(i).getAttributeValue("pais"), elements.get(i).getAttributeValue("aeroportOri"), elements.get(i).getAttributeValue("aeroportDes"), Double.parseDouble(elements.get(i).getAttributeValue("distancia"))));
        }

        //Recorregut de les rutes internacionals
        elements = arrel.getChildElements("rutaInternacional");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim la ruta internacional actual a la companyia
            companyia.afegirRutaInternacional(new RutaInternacional(elements.get(i).getAttributeValue("codi"), elements.get(i).getAttributeValue("aeroportOri"), elements.get(i).getAttributeValue("aeroportDes"), elements.get(i).getAttributeValue("paisOri"), elements.get(i).getAttributeValue("paisDes"), Double.parseDouble(elements.get(i).getAttributeValue("distancia"))));
        }
        
         //Recorregut de les rutes intercontinentals
        elements = arrel.getChildElements("rutaIntercontinental");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim la ruta intercontinental actual a la companyia
            companyia.afegirRutaIntercontinental(new RutaIntercontinental(elements.get(i).getAttributeValue("codi"), elements.get(i).getAttributeValue("aeroportOri"), elements.get(i).getAttributeValue("aeroportDes"), elements.get(i).getAttributeValue("paisOri"), elements.get(i).getAttributeValue("paisDes"), elements.get(i).getAttributeValue("continentOri"), elements.get(i).getAttributeValue("continentDes"), Double.parseDouble(elements.get(i).getAttributeValue("distancia"))));
        }
        
         //Recorregut de les rutes transoceanica
        elements = arrel.getChildElements("rutaTransoceanica");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim la ruta transoceanica actual a la companyia
            companyia.afegirRutaTransoceanica(new RutaTransoceanica(elements.get(i).getAttributeValue("codi"), elements.get(i).getAttributeValue("aeroportOri"), elements.get(i).getAttributeValue("aeroportDes"), elements.get(i).getAttributeValue("paisOri"), elements.get(i).getAttributeValue("paisDes"), elements.get(i).getAttributeValue("continentOri"), elements.get(i).getAttributeValue("continentDes"), elements.get(i).getAttributeValue("ocea"), Double.parseDouble(elements.get(i).getAttributeValue("distancia"))));
        }

        //Recorregut dels TCP
        elements = arrel.getChildElements("TCP");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim el TCP actual a la companyia
            companyia.afegirTCP(new TCP(elements.get(i).getAttributeValue("passaport"), elements.get(i).getAttributeValue("nom"), Integer.parseInt(elements.get(i).getAttributeValue("edat")), Integer.parseInt(elements.get(i).getAttributeValue("horesVol"))));
        }
        
         //Recorregut dels tripulants de cabina
        elements = arrel.getChildElements("tripulantCabina");

        for (int i = 0; i < elements.size(); i++) {

            //Afegim el tripulant de cabina actual a la companyia
            companyia.afegirTripulantCabina(new TripulantCabina(elements.get(i).getAttributeValue("passaport"), elements.get(i).getAttributeValue("nom"), Integer.parseInt(elements.get(i).getAttributeValue("edat")), Integer.parseInt(elements.get(i).getAttributeValue("horesVol")), elements.get(i).getAttributeValue("rang")));
        }

        //Recorregut dels vols  
        for (int i = 0; i < elements.size(); i++) {

            SimpleDateFormat formatData= new SimpleDateFormat("dd-MM-yyyy");
            
            //Afegim l'avió actual a la companyia
            companyia.afegirVol(new Vol(elements.get(i).getAttributeValue("codi"), formatData.parse(elements.get(i).getAttributeValue("dataSortida")), formatData.parse(elements.get(i).getAttributeValue("dataArribada")),LocalTime.parse(elements.get(i).getAttributeValue("horaArribada"),DateTimeFormatter.ofPattern("HH:mm:ss")),LocalTime.parse(elements.get(i).getAttributeValue("horaSortida"),DateTimeFormatter.ofPattern("HH:mm:ss"))));

            //Recorregut de les classes de l'avió
            fills = elements.get(i).getChildElements("classe");

            for (int j = 0; j < fills.size(); j++) {
                ((Avio) companyia.getComponents().get(companyia.getComponents().size() - 1)).afegirClasse(new Classe(fills.get(i).getAttributeValue("nom"), Integer.parseInt(fills.get(i).getAttributeValue("capacitat"))));
            }

        }

        setCompanyia(companyia);//Actualitzem el contingut de Companyia
    }
}
