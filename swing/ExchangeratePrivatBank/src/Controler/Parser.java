package Controler;

import exchangerate.Exchangerate;
import static exchangerate.Exchangerate.buyEUR;
import static exchangerate.Exchangerate.buyRUR;
import static exchangerate.Exchangerate.buyUSD;
import static exchangerate.Exchangerate.saleEUR;
import static exchangerate.Exchangerate.saleRUR;
import static exchangerate.Exchangerate.saleUSD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Sergey
 */
public class Parser {
    
    public void parseXML(URL url) throws NumberFormatException, DOMException {
        try {
//            URL url = xmlOrJson();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = (Document) db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("row");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NamedNodeMap attributes = node.getFirstChild().getAttributes();
                double buy = Double.parseDouble(attributes.getNamedItem("buy").getNodeValue());
                double sale = Double.parseDouble(attributes.getNamedItem("sale").getNodeValue());
                String ccy = attributes.getNamedItem("ccy").getNodeValue();
                ccy(ccy, buy, sale);
            }
        } catch (IOException ex) {
            Logger.getLogger(Exchangerate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Exchangerate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Exchangerate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void parseJSON(URL url) throws NumberFormatException {
        //URL url = xmlOrJson();
        JSONParser parser = new JSONParser();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            Object obj = parser.parse(reader);
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jSONArray.get(i);
                String ccy = (String) jsonObject.get("ccy");
                double buy = Double.parseDouble((String) jsonObject.get("buy"));
                double sale = Double.parseDouble((String) jsonObject.get("sale"));
                ccy(ccy, buy, sale);
            }
        } catch (IOException ex) {
            Logger.getLogger(Exchangerate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Exchangerate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ccy(String ccy, double buy, double sale) {
        if (ccy.equals("USD")) {
            buyUSD = buy;
            saleUSD = sale;
        }
        if (ccy.equals("EUR")) {
            buyEUR = buy;
            saleEUR = sale;
        }
        if (ccy.equals("RUR")) {
            buyRUR = buy;
            saleRUR = sale;
        }
    }
}
