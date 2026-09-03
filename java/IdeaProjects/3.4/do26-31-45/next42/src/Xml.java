import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.util.List;

public class Xml {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        InputSource is = new InputSource("C:\\Users\\seto\\IdeaProjects\\3.4\\do26-31-45\\next42\\src\\a.xml");
        try{
            Document document=reader.read(is);
            Element root=document.getRootElement();
            String tagName=root.getQualifiedName();
            System.out.println(tagName);
            List<Element> elements=root.elements();
            for(Element e:elements){
                System.out.println(e.getQualifiedName());
                List<Attribute> attributes=e.attributes();
                for(Attribute a:attributes){
                    System.out.println(a.getName());
                    System.out.println(a.getValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
