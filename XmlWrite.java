/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPack;

/**
 *
 * @author HP
 */
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XmlWrite {

   public static void main(String argv[]) throws SQLException {

       
       
        
                                                       
       
       
      try {
         DocumentBuilderFactory dbFactory =
         DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
          // root element
         Element rootElement = doc.createElement("Patients");
         doc.appendChild(rootElement);
        MyConnectivity obj=new MyConnectivity();
          
            String qry1 = "select * from patient_record";
            
             ResultSet rs1=obj.getTable(qry1);
                 
         while(rs1.next())
                                                        {
                                                            
                                                    
                                                        
							
                                                          
								String pid=rs1.getString("patient_id");
                                                               String name= rs1.getString("first_name");
                                                               String lname= rs1.getString("last_name");
                                                               String dob=rs1.getString("date_of_birth");
								String age1=rs1.getString("age");
                                                                String gender1=rs1.getString("gender");
                                                                String marital1=rs1.getString("marital_status");
                                                                String add=rs1.getString("address");
                                                               String phone1= rs1.getString("phone");
								String mail1=rs1.getString("mail");            
                                                               
                                                        
       
        
        

         // supercars element
         Element patient = doc.createElement("patient");
         rootElement.appendChild(patient);

         // setting attribute to element
         Attr attr = doc.createAttribute("patient_id");
         attr.setValue(pid);
         patient.setAttributeNode(attr);

         // carname element
         Element patientname = doc.createElement("patientname");
        patientname.appendChild(doc.createTextNode(name));
         patient.appendChild(patientname);
         
         
          Element lastname = doc.createElement("lastname");
        lastname.appendChild(doc.createTextNode(lname));
         patient.appendChild(lastname);
         
         Element dateofbirth = doc.createElement("dateofbirth");
        dateofbirth.appendChild(doc.createTextNode(dob));
         patient.appendChild(dateofbirth);
         
          Element age = doc.createElement("age");
        age.appendChild(doc.createTextNode(age1));
         patient.appendChild(age);
         
          Element gender = doc.createElement("gender");
        gender.appendChild(doc.createTextNode(gender1));
         patient.appendChild(gender);
         
          Element marital = doc.createElement("maritalstatus");
        marital.appendChild(doc.createTextNode(marital1));
         patient.appendChild(marital);
         
          Element address = doc.createElement("address");
        address.appendChild(doc.createTextNode(add));
         patient.appendChild(address);
         
          Element phone = doc.createElement("phone");
        phone.appendChild(doc.createTextNode(phone1));
         patient.appendChild(phone);
         
          Element mail = doc.createElement("mail");
        mail.appendChild(doc.createTextNode(mail1));
         patient.appendChild(mail);
//         Element carname1 = doc.createElement("carname");
//         Attr attrType1 = doc.createAttribute("type");
//         attrType1.setValue("sports");
//         carname1.setAttributeNode(attrType1);
//         carname1.appendChild(doc.createTextNode("Ferrari 202"));
//         supercar.appendChild(carname1);

         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("C:\\Users\\HP\\Desktop\\MAIN PROJECT\\xmlwrite.xml"));
         transformer.transform(source, result);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
       }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
