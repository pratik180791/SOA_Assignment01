package SAX;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OrdersSAX {

	String Order_ID, Customer_ID, Employee_ID, Truck_ID;
	int PurchaseOrderNumber, OrderTotalAmount;
	Date Order_Date;
	
	public String getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}
	public String getCustomer_ID() {
		return Customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
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
	public int getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(int purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}
	public int getOrderTotalAmount() {
		return OrderTotalAmount;
	}
	public void setOrderTotalAmount(int orderTotalAmount) {
		OrderTotalAmount = orderTotalAmount;
	}
	public Date getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(Date order_Date) {
		Order_Date = order_Date;
	}
	
	public void OrdersParse() {
		
		 try {
			 
			 
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	        		DefaultHandler handler = new DefaultHandler() {
	        		
	        		boolean bid = false;
	        		boolean bdate = false;
	        		boolean bcustid = false;
	        		boolean bempid = false;
	        		boolean btruck = false;
	        		boolean bonum = false;
	        		boolean boamt = false;
	        			        		
	        		
	        		
	        	public void startElement(String uri, String localName,String qName,
	                        Attributes attributes) throws SAXException {

	        		System.out.println("Start Element :" + qName);

	        		
	        		if (qName.equalsIgnoreCase("Order_ID")) {
	        			bid = true;
	        		}

	        		if (qName.equalsIgnoreCase("Order_Date")) {
	        			bdate = true;
	        		}

	        		if (qName.equalsIgnoreCase("Customer_ID")) {
	        			bcustid = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Employee_ID")) {
	        			bempid = true;
	        		}

	        		if (qName.equalsIgnoreCase("Truck_ID")) {
	        			btruck = true;
	        		}

	        		if (qName.equalsIgnoreCase("PurchaseOrderNumber")) {
	        			bonum = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("OrderTotalAmount")) {
	        			boamt = true;
	        		}

	        	}

	        	public void endElement(String uri, String localName,
	        		String qName) throws SAXException {

	        		System.out.println("End Element :" + qName);

	        	}

	        	public void characters(char ch[], int start, int length) throws SAXException {
	       
	        		OrdersSAX ep = new OrdersSAX(); 	
	        		
	        		DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	        		
	        		
	        		if (bid) {
	        			System.out.println("Order ID : " + new String(ch, start, length));
	        			ep.setOrder_ID((new String(ch, start, length)));
	        			bid = false;
	        		}

	        		if (bdate) {
	        			System.out.println("Order Date : " + new String(ch, start, length));
	        			try {
							ep.setOrder_Date(df.parse(new String(ch, start, length)));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			bdate = false;
	        		}

	        		if (bcustid) {
	        			System.out.println("Customer ID : " + new String(ch, start, length));
	        			ep.setCustomer_ID(new String(ch, start, length));
	        			bcustid = false;
	        		}

	        		if (bempid) {
	        			System.out.println("Employee ID : " + new String(ch, start, length));
	        			ep.setEmployee_ID(new String(ch, start, length));
	        			bempid = false;
	        		}
	        		
	        		if (btruck) {
	        			System.out.println("Truck ID : " + new String(ch, start, length));
	        			ep.setTruck_ID(new String(ch, start, length));
	        			btruck = false;
	        		}

	        		if (bonum) {
	        			System.out.println("PurchaseOrderNumber : " + new String(ch, start, length));
	        			ep.setPurchaseOrderNumber(Integer.parseInt(new String(ch, start, length)));
	        			bonum = false;
	        		}
	        		
	        		if (boamt) {
	        			System.out.println("PurchaseOrderNumber : " + new String(ch, start, length));
	        			ep.setOrderTotalAmount(Integer.parseInt(new String(ch, start, length)));
	        			boamt = false;
	        		}

	        	}
	        		
	        
	        		};

	             File file = new File("/Users/bhumin/eclipse-workspace/soa/src/SAX/Orders.xml");
	             InputStream inputStream= new FileInputStream(file);
	     	     Reader reader = new InputStreamReader(inputStream,"UTF-8");

	     	     InputSource is = new InputSource(reader);
	     	     is.setEncoding("UTF-8");

	     	     saxParser.parse(is, handler);
		
		 }
	            catch(Exception e) {
	            	System.out.println(e);
	            }

}

	
	
	
}
