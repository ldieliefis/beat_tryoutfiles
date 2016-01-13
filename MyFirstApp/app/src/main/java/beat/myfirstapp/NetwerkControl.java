package beat.myfirstapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * NetwerkControl zorgt ervoor dat een webpagina kan worden opgeroept en het resultaat in één string stopt en returnt;
 */

public class NetwerkControl {

    /**
     * LaadWebpagina maakt de URL compleet en returnt het resultaat of een error.
     *
     * @param BestandAdres
     * @return
     */

    public static String LaadWebpagina(String BestandAdres){

        // De root waar de webpagina's staan.
        String PrefixURL = "http://www.sanderfeenstra.com/beat/tech/";

        // Voeg de prefix en het bestand's adres samen om de URL te maken.
        String URL = PrefixURL + BestandAdres;

        try {

            // Return een string, die gemaakt wordt door loadFromNetwork.
            return loadFromNetwork(URL);

        } catch (IOException e){

            // Return een error string, wanneer loadFromNetwork een IOException geeft.
            return "Kon de data niet ontvangen. Controleer je netwerk verbinding";

        }

    }

    /**
     * loadFromNetwork verkrijgt de webpagina en verandert deze in een string zonder HTML elementen.
     *
     * @param urlString
     * @return
     * @throws IOException
     */

    private static String loadFromNetwork(String urlString) throws IOException {
        InputStream stream = null;
        String finalstring = null;

        try {

            // Sla de InputStream op die downloadUrl teruggeeft.
            stream = downloadUrl(urlString);

            // Maakt de scanner aan.
            Scanner scan = new Scanner(stream,"UTF-8");

            // Sla de string op die in de InputStream staat.
            finalstring = scan.useDelimiter("\\A").next();

            // Sluit de scanner.
            scan.close();

            // Haal alle HTML elementen uit de string, zodat alleen de plaintext overblijft.
            finalstring = finalstring.replaceAll("\\<.*?>","");

        } finally {
            if(stream != null) {
                // Als alles goed is gegaan, sluit dit de stream.
                stream.close();
            }
        }

        // Returnt het resultaat.
        return finalstring;
    }

    // Vraagt de webpagina op van de gegeven URL in string formaat en returned de InputStream

    /**
     * InputStream vraagt de URL en maakt daar een InputStream van.
     *
     * @param urlString
     * @return
     * @throws IOException
     */

    private static InputStream downloadUrl(String urlString) throws IOException {

        // Zet de string om in een URL object.
        URL url = new URL(urlString);

        // Bereid de verbinding voor.
        HttpURLConnection verbinding = (HttpURLConnection) url.openConnection();

        // Zet verschillende variabelen
        verbinding.setReadTimeout(10000 /* milliseconden */);
        verbinding.setConnectTimeout(15000 /* milliseconden */);
        verbinding.setRequestMethod("GET");
        verbinding.setDoInput(true);
        // Start de aanvraag
        verbinding.connect();

        // Sla de stream op
        InputStream stream = verbinding.getInputStream();

        // Verstuur de steam terug.
        return stream;
    }

}
