import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                DBConnection.countVoter(attributes.getValue("name"), attributes.getValue("birthDay"));
                DBConnection.increaseCount();
                if (DBConnection.getCount() % 100_000 == 0) {
                    System.out.println("Есть сто тысяч вставок " + DBConnection.getCount());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
