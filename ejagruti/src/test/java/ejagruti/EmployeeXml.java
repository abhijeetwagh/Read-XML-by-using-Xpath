package ejagruti;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmployeeXml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		File xmlfile = new File("C:\\Users\\Lenovo\\Desktop\\Employee.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		   DocumentBuilder builder = factory.newDocumentBuilder(); 
		   org.w3c.dom.Document doc = builder.parse(xmlfile);
		   
		 //Create XPath
		   
		 XPathFactory xpfactory = XPathFactory.newInstance();
		 
		 XPath xpath = xpfactory.newXPath();
		 
		 
		 System.out.println("Get all employee names" + "\n----------------------------------------");
		  
		 //Get all employee names /employees/employee/firstName/text()
		 
		 XPathExpression expr = xpath.compile("/employees/employee/firstName/text()");
		 Object Res = expr.evaluate(doc, XPathConstants.NODESET);
		 NodeList nodes = (NodeList) Res;
	        for (int i = 0; i < nodes.getLength(); i++) {
	            System.out.println(nodes.item(i).getNodeValue());
	}
	       
	      //Get all department names /employees/employee/department/name/text()	
	      System.out.println("Get all department names" + "\n====================================================");  
	      expr = xpath.compile("/employees/employee/department/name/text()");
	      Res = expr.evaluate(doc, XPathConstants.NODESET);
	      NodeList nodes1 = (NodeList) Res;
	        for (int i=0; i < nodes1.getLength(); i++){
	        	System.out.println(nodes1.item(i).getNodeValue());
	        }
	      
	     //Get all employees in IT /employees/employee[department/name='IT']/firstName/text()
	     System.out.println("//Get all employees in IT//" + "\n.............................................");
	     expr = xpath.compile("/employees/employee[department/name='IT']/firstName/text()");
	     Res = expr.evaluate(doc, XPathConstants.NODESET);
	     NodeList nodes2 = (NodeList) Res;
	     for (int i=0; i < nodes2.getLength();i++){
	    	 System.out.println(nodes2.item(i).getNodeValue());
	     }
	    
         //Get employee by id /employees/employee[@id=4]/firstName/text()	
	     System.out.println("//Get employee by id" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	     expr = xpath.compile("/employees/employee[@id=4]/firstName/text()");
	     Res = expr.evaluate(doc, XPathConstants.NODESET);
	     NodeList nodes3 = (NodeList) Res;
	     for (int i=0; i < nodes3.getLength();i++){
	    	 System.out.println(nodes3.item(i).getNodeValue());
	     }
	     
	     //
}
}