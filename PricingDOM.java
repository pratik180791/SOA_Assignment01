package source;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class PricingDOM {


	String Pricing_ID, Loc_ID_To, Loc_ID_From, Loc_Code_To, Loc_Code_From, Loc_Name_To, Loc_Name_From, Cust_ID;

	float Price;
	
	public String getPricing_ID() {
		return Pricing_ID;
	}

	public void setPricing_ID(String pricing_ID) {
		Pricing_ID = pricing_ID;
	}

	public String getLoc_ID_To() {
		return Loc_ID_To;
	}

	public void setLoc_ID_To(String loc_ID_To) {
		Loc_ID_To = loc_ID_To;
	}

	public String getLoc_ID_From() {
		return Loc_ID_From;
	}

	public void setLoc_ID_From(String loc_ID_From) {
		Loc_ID_From = loc_ID_From;
	}

	public String getLoc_Code_To() {
		return Loc_Code_To;
	}

	public void setLoc_Code_To(String loc_Code_To) {
		Loc_Code_To = loc_Code_To;
	}

	public String getLoc_Code_From() {
		return Loc_Code_From;
	}

	public void setLoc_Code_From(String loc_Code_From) {
		Loc_Code_From = loc_Code_From;
	}

	public String getLoc_Name_To() {
		return Loc_Name_To;
	}

	public void setLoc_Name_To(String loc_Name_To) {
		Loc_Name_To = loc_Name_To;
	}

	public String getLoc_Name_From() {
		return Loc_Name_From;
	}

	public void setLoc_Name_From(String loc_Name_From) {
		Loc_Name_From = loc_Name_From;
	}

	public String getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

		
	

	public void pricingInsert()
    {
        try {
        	System.out.println("Pricing Parsing & Inserting Begins");
        	PricingDOM e=new PricingDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Pricing.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Pricing");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Pricing");
                  
             e.setPricing_ID((eElement.getElementsByTagName("Price_ID").item(0).getTextContent())); 
             e.setPrice(Float.parseFloat(eElement.getElementsByTagName("Price").item(0).getTextContent()));
             e.setLoc_ID_From(((eElement.getElementsByTagName("LocationIDFrom").item(0).getTextContent())));
             e.setLoc_ID_To((eElement.getElementsByTagName("LocationIDTo").item(0).getTextContent()));
             e.setLoc_Code_From((eElement.getElementsByTagName("LocationCodeFrom").item(0).getTextContent()));
             e.setLoc_Code_To(((eElement.getElementsByTagName("LocationCodeTo").item(0).getTextContent())));
             e.setLoc_Name_From((eElement.getElementsByTagName("LocationNameFrom").item(0).getTextContent()));
             e.setLoc_Name_To((eElement.getElementsByTagName("LocationNameTo").item(0).getTextContent()));
         
             
          //  System.out.println(e.getPricing_ID());
                    
                    

   PreparedStatement ps=conn.prepareStatement("insert into Location(Pricing_ID,Price,Loc_ID_To,Loc_ID_From,Loc_Code_To,Loc_Code_From,Loc_Name_To,Loc_Name_From,Cust_ID) values (?,?,?,?,?,?,?,?,?,?)");              
                    ps.setString(1,e.getPricing_ID());
                    ps.setFloat(2, e.getPrice());
                    ps.setString(3,e.getLoc_ID_From());
                    ps.setString(4,e.getLoc_ID_To());
                    ps.setString(5, e.getLoc_Code_From());
                    ps.setString(6,e.getLoc_Code_To());
                    ps.setString(7, e.getLoc_Name_From());
                    ps.setString(8, e.getLoc_Name_To());
             
               
                    
                   ps.execute();
                    System.out.println("Pricing Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
