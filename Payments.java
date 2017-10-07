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
import java.util.Date;



public class PaymentsDOM {


	String Payment_ID,Order_ID,Payment_Method,CardholdersName,CardExpDate;
	
	int Payment_Amount,CardAuthorizationNumber;
	
	long CardNumber;
	
	Date Payment_Date;

	public Date getPayment_Date() {
		return Payment_Date;
	}




	public void setPayment_Date(Date payment_Date) {
		Payment_Date = payment_Date;
	}




	public String getPayment_ID() {
		return Payment_ID;
	}




	public void setPayment_ID(String payment_ID) {
		Payment_ID = payment_ID;
	}




	public String getOrder_ID() {
		return Order_ID;
	}




	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}




	public String getPayment_Method() {
		return Payment_Method;
	}




	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}

	public String getCardholdersName() {
		return CardholdersName;
	}




	public void setCardholdersName(String cardholdersName) {
		CardholdersName = cardholdersName;
	}




	public String getCardExpDate() {
		return CardExpDate;
	}




	public void setCardExpDate(String cardExpDate) {
		CardExpDate = cardExpDate;
	}




	public int getPayment_Amount() {
		return Payment_Amount;
	}




	public void setPayment_Amount(int payment_Amount) {
		Payment_Amount = payment_Amount;
	}




	public int getCardAuthorizationNumber() {
		return CardAuthorizationNumber;
	}




	public void setCardAuthorizationNumber(int cardAuthorizationNumber) {
		CardAuthorizationNumber = cardAuthorizationNumber;
	}




	public long getCardNumber() {
		return CardNumber;
	}




	public void setCardNumber(long cardNumber) {
		CardNumber = cardNumber;
	}

	

	public void PaymentsInsert()
    {
        try {
        	System.out.println("Payments Parsing & Inserting Begins");
        	PaymentsDOM e=new PaymentsDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Payments.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Payment");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Payment_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Payment");
					
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    
             e.setPayment_ID((eElement.getElementsByTagName("Payment_ID").item(0).getTextContent()));
             e.setOrder_ID((eElement.getElementsByTagName("Order_ID").item(0).getTextContent()));
			 e.setPayment_Method((eElement.getElementsByTagName("Payment_Method").item(0).getTextContent()));
			 e.setPayment_Date(sdf.parse((eElement.getElementsByTagName("Payment_Date").item(0).getTextContent())));
			 e.setCardholdersName((eElement.getElementsByTagName("CardholdersName").item(0).getTextContent()));
			 e.setCardExpDate((eElement.getElementsByTagName("CardExpDate").item(0).getTextContent()));
             e.setPayment_Amount(Integer.parseInt((eElement.getElementsByTagName("Payment_Amount").item(0).getTextContent())));
			 e.setCardNumber((Long.parseLong((eElement.getElementsByTagName("CardNumber").item(0).getTextContent()))));
             e.setCardAuthorizationNumber(Integer.parseInt((eElement.getElementsByTagName("CardAuthorizationNumber").item(0).getTextContent())));
   
   PreparedStatement ps=conn.prepareStatement("insert into Payments(Payment_ID,Order_ID,Payment_Method,Payment_Date,CardholdersName,CardExpDate,Payment_Amount,CardNumber,CardAuthorizationNumber) values (?,?,?,?,?,?,?,?,?)");              
                    
						
					ps.setString(1,e.getPayment_ID());
					ps.setString(2,e.getOrder_ID());
					ps.setString(3,e.getPayment_Method());
					ps.setDate(4,(java.sql.Date)e.getPayment_Date());
					ps.setString(5,e.getCardholdersName());
					ps.setString(6,e.getCardExpDate());
                    ps.setInt(7, e.getPayment_Amount());
					ps.setLong(8, e.getCardNumber());
					ps.setInt(9, e.getCardAuthorizationNumber());
					
                    
               
                    
                   ps.execute();
                    System.out.println("Payments Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
