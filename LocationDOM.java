package soa2;
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



public class LocationDOM {


	String Loc_Id, Loc_Name, Loc_Add, Loc_City, Loc_State, Loc_Email_Add;

	int Loc_Code, Loc_ZipCode;
	
	long Loc_Phone_No,Loc_Fax_No;
	
	public String getLoc_Id() {
		return Loc_Id;
	}

	public void setLoc_Id(String loc_Id) {
		Loc_Id = loc_Id;
	}

	public String getLoc_Name() {
		return Loc_Name;
	}

	public void setLoc_Name(String loc_Name) {
		Loc_Name = loc_Name;
	}

	public String getLoc_Add() {
		return Loc_Add;
	}

	public void setLoc_Add(String loc_Add) {
		Loc_Add = loc_Add;
	}

	public String getLoc_City() {
		return Loc_City;
	}

	public void setLoc_City(String loc_City) {
		Loc_City = loc_City;
	}

	public String getLoc_State() {
		return Loc_State;
	}

	public void setLoc_State(String loc_State) {
		Loc_State = loc_State;
	}

	public String getLoc_Email_Add() {
		return Loc_Email_Add;
	}

	public void setLoc_Email_Add(String loc_Email_Add) {
		Loc_Email_Add = loc_Email_Add;
	}

	public int getLoc_Code() {
		return Loc_Code;
	}

	public void setLoc_Code(int loc_Code) {
		Loc_Code = loc_Code;
	}

	public int getLoc_ZipCode() {
		return Loc_ZipCode;
	}

	public void setLoc_ZipCode(int loc_ZipCode) {
		Loc_ZipCode = loc_ZipCode;
	}

	public long getLoc_Phone_No() {
		return Loc_Phone_No;
	}

	public void setLoc_Phone_No(long loc_Phone_No) {
		Loc_Phone_No = loc_Phone_No;
	}

	public long getLoc_Fax_No() {
		return Loc_Fax_No;
	}

	public void setLoc_Fax_No(long loc_Fax_No) {
		Loc_Fax_No = loc_Fax_No;
	}


	public void locationInsert()
    {
        try {
        	System.out.println("Locations Parsing & Inserting Begins");
        	LocationDOM e=new LocationDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Location.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Locations");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Locations");
                  
             e.setLoc_Id((eElement.getElementsByTagName("Location_ID").item(0).getTextContent())); 
             e.setLoc_Name((eElement.getElementsByTagName("Location_Name").item(0).getTextContent()));
             e.setLoc_Code(((eElement.getElementsByTagName("Location_Code").item(0).getTextContent())));
             e.setLoc_Add((eElement.getElementsByTagName("Loc_address_line1").item(0).getTextContent()));
             e.setLoc_City((eElement.getElementsByTagName("Loc_City").item(0).getTextContent()));
             e.setLoc_State(((eElement.getElementsByTagName("Loc_State").item(0).getTextContent())));
             e.setLoc_ZipCode(Integer.parseInt((eElement.getElementsByTagName("Loc_ZipCode").item(0).getTextContent())));
             e.setLoc_Phone_No((Long.parseLong((eElement.getElementsByTagName("Loc_phone_number").item(0).getTextContent()))));
             e.setLoc_Fax_No((Long.parseLong(eElement.getElementsByTagName("Loc_fax_number").item(0).getTextContent())));
             e.setLoc_Email_Add(eElement.getElementsByTagName("Loc_email_address").item(0).getTextContent());
             
            System.out.println(e.getCustomer_Id());
                    
                    

   PreparedStatement ps=conn.prepareStatement("insert into Location(Loc_ID,Loc_Name,Loc_Code,Loc_Add,Loc_City,Loc_State,Loc_ZipCode,Loc_Phone_No,Loc_Fax_No,Loc_Email_Add) values (?,?,?,?,?,?,?,?,?,?)");              
                    ps.setString(1,e.getLoc_Id());
                    ps.setString(2, e.getLoc_Name());
                    ps.setString(3,e.getLoc_Code());
                    ps.setString(4,e.getLoc_Add());
                    ps.setString(5, e.getLoc_City());
                    ps.setString(6,e.getLoc_State());
                    ps.setInt(7, e.getLoc_ZipCode());
                    ps.setLong(8, e.getLoc_Phone_No());
                    ps.setLong(9, e.getLoc_Fax_No());
                    ps.setString(10, e.getLoc_Email_Add());
               
                    
                   ps.execute();
                    System.out.println("Location Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
