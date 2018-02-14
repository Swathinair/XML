/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPack;




import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xmlread {

   public static void main(String[] args) {

      try {
         File inputFile = new File("C:\\Users\\HP\\Desktop\\MAIN PROJECT\\xmlwrite.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("patient");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Patient :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Patient id : " 
                  + eElement.getAttribute("pid"));
               System.out.println("First Name : " 
                  + eElement
                  .getElementsByTagName("patientname")
                  .item(0)
                  .getTextContent());
               System.out.println("Last Name : " 
                  + eElement
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
               System.out.println("Date of Birth : " 
                  + eElement
                  .getElementsByTagName("dateofbirth")
                  .item(0)
                  .getTextContent());
               System.out.println("Age : " 
                  + eElement
                  .getElementsByTagName("age")
                  .item(0)
                  .getTextContent());
               System.out.println("Gender : " 
                  + eElement
                  .getElementsByTagName("gender")
                  .item(0)
                  .getTextContent());
               System.out.println("MaritalStatus : " 
                  + eElement
                  .getElementsByTagName("maritalstatus")
                  .item(0)
                  .getTextContent());
               System.out.println("Address : " 
                  + eElement
                  .getElementsByTagName("address")
                  .item(0)
                  .getTextContent());
               System.out.println("Phone : " 
                  + eElement
                  .getElementsByTagName("phone")
                  .item(0)
                  .getTextContent());
               System.out.println("Mail : " 
                  + eElement
                  .getElementsByTagName("mail")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
/**
 * 
 * 
 * 
 *
 * @author HP
 */

