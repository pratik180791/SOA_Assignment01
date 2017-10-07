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



public class InvoicesDOM {


	String Invoice_ID,Invoice_To,Employee_ID,Customer_ID,Order_ID;
	int Invoice_Amount;

	public String getInvoice_ID() {
		return Invoice_ID;
	}


	public void setInvoice_ID(String invoice_ID) {
		Invoice_ID = invoice_ID;
	}


	public String getInvoice_To() {
		return Invoice_To;
	}


	public void setInvoice_To(String invoice_To) {
		Invoice_To = invoice_To;
	}


	public String getEmployee_ID() {
		return Employee_ID;
	}


	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}


	public String getCustomer_ID() {
		return Customer_ID;
	}


	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}


	public String getOrder_ID() {
		return Order_ID;
	}


	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}


	public int getInvoice_Amount() {
		return Invoice_Amount;
	}


	public void setInvoice_Amount(int invoice_Amount) {
		Invoice_Amount = invoice_Amount;
	}

	

	public void invoiceInsert()
    {
        try {
        	System.out.println("Invoice Parsing & Inserting Begins");
        	InvoicesDOM e=new InvoicesDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Invoice.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Invoices");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Invoice_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Invoices");
                  
             e.setInvoice_ID((eElement.getElementsByTagName("Invoice_ID").item(0).getTextContent()));
             e.setInvoice_To((eElement.getElementsByTagName("Invoice_To").item(0).getTextContent()));
             e.setEmployee_ID(((eElement.getElementsByTagName("Employee_ID").item(0).getTextContent())));
             e.setCustomer_ID((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent()));
             e.setOrder_ID((eElement.getElementsByTagName("Order_ID").item(0).getTextContent()));
             e.setInvoice_Amount(Integer.parseInt((eElement.getElementsByTagName("Invoice_Amount").item(0).getTextContent())));
   
   PreparedStatement ps=conn.prepareStatement("insert into Invoice(Invoice_ID,Invoice_To,Employee_ID,Customer_ID,Order_ID,Invoice_Amount) values (?,?,?,?,?,?)");              
                    ps.setString(1,e.getInvoice_ID());
                    ps.setString(2, e.getInvoice_To());
                    ps.setString(3,e.getEmployee_ID());
                    ps.setString(4,e.getCustomer_ID());
                    ps.setString(5, e.getOrder_ID());
                    ps.setInt(6, e.getInvoice_Amount());
                    
                    
                   ps.execute();
                    System.out.println("Invoice Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
