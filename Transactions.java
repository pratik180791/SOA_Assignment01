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



public class TransactionsDOM {


	String Transaction_ID,Order_ID,Price_ID,DateOfTransaction,Transaction_details,Model,Employee_ID,Truck_ID,VIN;

	int Transaction_Amount,Year,Discount,Quantity,UnitPrice,DriverPrice,SpecialRate,Surcharge;

	
	public String getTransaction_ID() {
		return Transaction_ID;
	}


	public void setTransaction_ID(String transaction_ID) {
		Transaction_ID = transaction_ID;
	}


	public String getOrder_ID() {
		return Order_ID;
	}


	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}


	public String getPrice_ID() {
		return Price_ID;
	}


	public void setPrice_ID(String price_ID) {
		Price_ID = price_ID;
	}


	public String getDateOfTransaction() {
		return DateOfTransaction;
	}


	public void setDateOfTransaction(String dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}


	public String getTransaction_details() {
		return Transaction_details;
	}


	public void setTransaction_details(String transaction_details) {
		Transaction_details = transaction_details;
	}


	public String getModel() {
		return Model;
	}


	public void setModel(String model) {
		Model = model;
	}


	public String getEmployee_ID() {
		return Employee_ID;
	}


	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}


	public String getTruck_ID() {
		return Truck_ID;
	}


	public void setTruck_ID(String truck_ID) {
		Truck_ID = truck_ID;
	}


	public String getVIN() {
		return VIN;
	}


	public void setVIN(String vIN) {
		VIN = vIN;
	}


	public int getTransaction_Amount() {
		return Transaction_Amount;
	}


	public void setTransaction_Amount(int transaction_Amount) {
		Transaction_Amount = transaction_Amount;
	}


	public int getYear() {
		return Year;
	}


	public void setYear(int year) {
		Year = year;
	}


	public int getDiscount() {
		return Discount;
	}


	public void setDiscount(int discount) {
		Discount = discount;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public int getUnitPrice() {
		return UnitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}


	public int getDriverPrice() {
		return DriverPrice;
	}


	public void setDriverPrice(int driverPrice) {
		DriverPrice = driverPrice;
	}


	public int getSpecialRate() {
		return SpecialRate;
	}


	public void setSpecialRate(int specialRate) {
		SpecialRate = specialRate;
	}


	public int getSurcharge() {
		return Surcharge;
	}


	public void setSurcharge(int surcharge) {
		Surcharge = surcharge;
	}

	
	public void TransactionsInsert()
    {
        try {
        	System.out.println("Transactions Parsing & Inserting Begins");
        	TransactionsDOM e=new TransactionsDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Transactions.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Transactions");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Transaction_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Transactions");
                  
             e.setTransaction_ID((eElement.getElementsByTagName("Transaction_ID").item(0).getTextContent())); 
             e.setOrder_ID((eElement.getElementsByTagName("Order_ID").item(0).getTextContent()));
			 e.setPrice_ID((eElement.getElementsByTagName("Price_ID").item(0).getTextContent()));
			 e.setDateOfTransaction((eElement.getElementsByTagName("DateOfTransaction").item(0).getTextContent()));
			 e.setTransaction_details((eElement.getElementsByTagName("Transaction_details").item(0).getTextContent()));
			 e.setModel((eElement.getElementsByTagName("Model").item(0).getTextContent()));
			 e.setEmployee_ID((eElement.getElementsByTagName("Employee_ID").item(0).getTextContent()));
			 e.setTruck_ID((eElement.getElementsByTagName("Truck_ID").item(0).getTextContent()));
			 e.setVIN((eElement.getElementsByTagName("VIN").item(0).getTextContent()));
             e.setTransaction_Amount(Integer.parseInt((eElement.getElementsByTagName("Transaction_Amount").item(0).getTextContent())));
             e.setYear(Integer.parseInt((eElement.getElementsByTagName("Year").item(0).getTextContent())));
             e.setDiscount(Integer.parseInt((eElement.getElementsByTagName("Discount").item(0).getTextContent())));
             e.setQuantity(Integer.parseInt((eElement.getElementsByTagName("Quantity").item(0).getTextContent())));
             e.setUnitPrice(Integer.parseInt((eElement.getElementsByTagName("UnitPrice").item(0).getTextContent())));
             e.setDriverPrice(Integer.parseInt((eElement.getElementsByTagName("DriverPrice").item(0).getTextContent())));
             e.setSpecialRate(Integer.parseInt((eElement.getElementsByTagName("SpecialRate").item(0).getTextContent())));
             e.setSurcharge(Integer.parseInt((eElement.getElementsByTagName("Surcharge").item(0).getTextContent())));
             
              

   PreparedStatement ps=conn.prepareStatement("insert into Transactions(Transaction_ID,Order_ID,Price_ID,DateOfTransaction,Transaction_details,Model,Employee_ID,Truck_ID,VIN,Transaction_Amount,Year,Discount,Quantity,UnitPrice,DriverPrice,SpecialRate,Surcharge) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");              
                    ps.setString(1,e.getTransaction_ID());
					ps.setString(2,e.getOrder_ID());
					ps.setString(3,e.getPrice_ID());
					ps.setString(4,e.getDateOfTransaction());
					ps.setString(5,e.getTransaction_details());
					ps.setString(6,e.getModel());
					ps.setString(7,e.getEmployee_ID());
					ps.setString(8,e.getTruck_ID());
					ps.setString(9,e.getVIN());
					ps.setInt(10, e.getTransaction_Amount());
					ps.setInt(11, e.getYear());
					ps.setInt(12, e.getDiscount());
					ps.setInt(13, e.getQuantity());
					ps.setInt(14, e.getUnitPrice());
					ps.setInt(15, e.getDriverPrice());
					ps.setInt(16, e.getSpecialRate());
					ps.setInt(17, e.getSurcharge());
                    
               
                    
                   ps.execute();
                    System.out.println("Transactions Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
