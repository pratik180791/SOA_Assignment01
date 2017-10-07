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


public class CommentsSAX extends DefaultHandler {
	
	String CommentID, Comment_details, cimment, Customer_ID, Transaction_ID;
	
	LocalDate Time_of_Comment;
	
	
	public String getCommentID() {
		return CommentID;
	}


	public void setCommentID(String commentID) {
		CommentID = commentID;
	}


	public String getComment_details() {
		return Comment_details;
	}


	public void setComment_details(String comment_details) {
		Comment_details = comment_details;
	}


	public String getCimment() {
		return cimment;
	}


	public void setCimment(String cimment) {
		this.cimment = cimment;
	}


	public String getCustomer_ID() {
		return Customer_ID;
	}


	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}


	public String getTransaction_ID() {
		return Transaction_ID;
	}


	public void setTransaction_ID(String transaction_ID) {
		Transaction_ID = transaction_ID;
	}


	public LocalDate getTime_of_Comment() {
		return Time_of_Comment;
	}


	public void setTime_of_Comment(LocalDate time_of_Comment) {
		Time_of_Comment = time_of_Comment;
	}

	
	
	public void CommentsParse() {
		
		 try {
			 
			 
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	        		DefaultHandler handler = new DefaultHandler() {
	        		
	        		boolean bcomID = false;
	        		boolean btimeComment = false;
	        		boolean bcomdetails = false;
	        		boolean bcim = false;
	        		boolean bcustID = false;
	        		boolean btranID = false;
	        			        		
	        		
	        		
	        	public void startElement(String uri, String localName,String qName,
	                        Attributes attributes) throws SAXException {

	        		System.out.println("Start Element :" + qName);

	        		
	        		if (qName.equalsIgnoreCase("CommentID")) {
	        			bcomID = true;
	        		}

	        		if (qName.equalsIgnoreCase("Time_of_Comment")) {
	        			btimeComment = true;
	        		}

	        		if (qName.equalsIgnoreCase("Comment_details")) {
	        			bcomdetails = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("cimment")) {
	        			bcim = true;
	        		}

	        		if (qName.equalsIgnoreCase("Customer_ID")) {
	        			bcustID = true;
	        		}

	        		if (qName.equalsIgnoreCase("Transaction_ID")) {
	        			btranID = true;
	        		}

	        	}

	        	public void endElement(String uri, String localName,
	        		String qName) throws SAXException {

	        		System.out.println("End Element :" + qName);

	        	}

	        	public void characters(char ch[], int start, int length) throws SAXException {
	       
	        		CommentsSAX ep = new CommentsSAX(); 	
	        		
	        		//DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	        		
	        		
	        		if (bcomID) {
	        			System.out.println("Comment ID : " + new String(ch, start, length));
	        			ep.setCommentID(new String(ch, start, length));
	        			bcomID = false;
	        		}

	        		if (btimeComment) {
	        			System.out.println("Time of Comment : " + new String(ch, start, length));
	        			ep.setTime_of_Comment(LocalDate.parse(new String(ch, start, length)));
	        			
	        			btimeComment = false;
	        		}

	        		if (bcomdetails) {
	        			System.out.println("Comment Details : " + new String(ch, start, length));
	        			ep.setComment_details(new String(ch, start, length));
	        			bcomdetails = false;
	        		}

	        		if (bcim) {
	        			System.out.println("Cimment : " + new String(ch, start, length));
	        			ep.setCimment(new String(ch, start, length));
	        			bcim = false;
	        		}
	        		
	        		if (bcustID) {
	        			System.out.println("Customer ID : " + new String(ch, start, length));
	        			ep.setCustomer_ID((new String(ch, start, length)));
	        			bcustID = false;
	        		}

	        		if (btranID) {
	        			System.out.println("Transaction ID : " + new String(ch, start, length));
	        			ep.setTransaction_ID((new String(ch, start, length)));
	        			btranID = false;
	        		}

	        	}
	        		
	        
	        		};

	             File file = new File("/Users/bhumin/eclipse-workspace/soa/src/SAX/Comments.xml");
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
