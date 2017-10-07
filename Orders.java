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
import java.util.Date;



public class OrdersDOM {


	String Order_ID, Cust_ID, Emp_ID, Truck_ID;
	
	Date Order_Date;
	
	int Purchase_Order_No, Order_Total_Amount;

	public String getOrder_ID() {
		return Order_ID;
	}


	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}


	public String getCust_ID() {
		return Cust_ID;
	}


	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}


	public String getEmp_ID() {
		return Emp_ID;
	}


	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}


	public String getTruck_ID() {
		return Truck_ID;
	}


	public void setTruck_ID(String truck_ID) {
		Truck_ID = truck_ID;
	}


	public Date getOrder_Date() {
		return Order_Date;
	}


	public void setOrder_Date(Date order_Date) {
		Order_Date = order_Date;
	}


	public int getPurchase_Order_No() {
		return Purchase_Order_No;
	}


	public void setPurchase_Order_No(int purchase_Order_No) {
		Purchase_Order_No = purchase_Order_No;
	}


	public int getOrder_Total_Amount() {
		return Order_Total_Amount;
	}


	public void setOrder_Total_Amount(int order_Total_Amount) {
		Order_Total_Amount = order_Total_Amount;
	}
	

	public void OrdersInsert()
    {
        try {
        	System.out.println("Orders Parsing & Inserting Begins");
        	OrdersDOM e=new OrdersDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Orders.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Orders");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Orders");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

             e.setOrder_ID((eElement.getElementsByTagName("Order_ID").item(0).getTextContent())); 
             e.setOrder_Date(sdf.parse((eElement.getElementsByTagName("Order_Date").item(0).getTextContent())));
             e.setCust_ID(((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent())));
             e.setEmp_ID((eElement.getElementsByTagName("Employee_ID").item(0).getTextContent()));
             e.setTruck_ID((eElement.getElementsByTagName("Truck_ID").item(0).getTextContent()));
             e.setPurchase_Order_No(Integer.parseInt((eElement.getElementsByTagName("PurchaseOrderNumber").item(0).getTextContent())));
             e.setOrder_Total_Amount(Integer.parseInt((eElement.getElementsByTagName("OrderTotalAmount").item(0).getTextContent())));
            
         
             
          //  System.out.println(e.getPricing_ID());
                    
                    

   PreparedStatement ps=conn.prepareStatement("insert into Location(Order_ID,Price,Loc_ID_To,Loc_ID_From,Loc_Code_To,Loc_Code_From,Loc_Name_To,Loc_Name_From,Cust_ID) values (?,?,?,?,?,?,?,?,?,?)");              
                    ps.setString(1,e.getOrder_ID());
                    ps.setDate(2, (java.sql.Date) e.getOrder_Date());
                    ps.setString(3,e.getCust_ID());
                    ps.setString(4,e.getEmp_ID());
                    ps.setString(5, e.getTruck_ID());
                    ps.setInt(6,e.getPurchase_Order_No());
                    ps.setInt(7, e.getOrder_Total_Amount());
            
             
               
                    
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
