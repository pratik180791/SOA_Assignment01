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

public class ExpensesSAX {
	
	String Expense_ID, ExpenseType, PurposeofExpense, Expense_Description, PaymentMethod;
	int AmountSpent, AdvanceAmount;
	Date DatePurchased, DateSubmitted;
	
	public String getEmployee_ID() {
		return Expense_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		Expense_ID = employee_ID;
	}
	public String getExpenseType() {
		return ExpenseType;
	}
	public void setExpenseType(String expenseType) {
		ExpenseType = expenseType;
	}
	public String getPurposeofExpense() {
		return PurposeofExpense;
	}
	public void setPurposeofExpense(String purposeofExpense) {
		PurposeofExpense = purposeofExpense;
	}
	public String getExpense_Description() {
		return Expense_Description;
	}
	public void setExpense_Description(String expense_Description) {
		Expense_Description = expense_Description;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	public int getAmountSpent() {
		return AmountSpent;
	}
	public void setAmountSpent(int amountSpent) {
		AmountSpent = amountSpent;
	}
	public int getAdvanceAmount() {
		return AdvanceAmount;
	}
	public void setAdvanceAmount(int advanceAmount) {
		AdvanceAmount = advanceAmount;
	}
	public Date getDatePurchased() {
		return DatePurchased;
	}
	public void setDatePurchased(Date datePurchased) {
		DatePurchased = datePurchased;
	}
	public Date getDateSubmitted() {
		return DateSubmitted;
	}
	public void setDateSubmitted(Date dateSubmitted) {
		DateSubmitted = dateSubmitted;
	}
	
	public void ExpenseParse() {
		
		 try {
			 
			 
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	        		DefaultHandler handler = new DefaultHandler() {
	        		
	        		boolean bid = false;
	        		boolean bexpense = false;
	        		boolean bpurpose = false;
	        		boolean bamt = false;
	        		boolean bdesc = false;
	        		boolean bdatep = false;
	        		boolean bdates = false;
	        		boolean badvamt = false;
	        		boolean bpay = false;
	        			        		
	        		
	        		
	        	public void startElement(String uri, String localName,String qName,
	                        Attributes attributes) throws SAXException {

	        		System.out.println("Start Element :" + qName);

	        		
	        		if (qName.equalsIgnoreCase("Employee_ID")) {
	        			bid = true;
	        		}

	        		if (qName.equalsIgnoreCase("ExpenseType")) {
	        			bexpense = true;
	        		}

	        		if (qName.equalsIgnoreCase("PurposeofExpense")) {
	        			bpurpose = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("AmountSpent")) {
	        			bamt = true;
	        		}

	        		if (qName.equalsIgnoreCase("Expense_Description")) {
	        			bdesc = true;
	        		}

	        		if (qName.equalsIgnoreCase("DatePurchased")) {
	        			bdatep = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("DateSubmitted")) {
	        			bdates = true;
	        		}

	        		if (qName.equalsIgnoreCase("AdvanceAmount")) {
	        			badvamt = true;
	        		}

	        		if (qName.equalsIgnoreCase("PaymentMethod")) {
	        			bpay = true;
	        		}
	        		
	        		

	        	}

	        	public void endElement(String uri, String localName,
	        		String qName) throws SAXException {

	        		System.out.println("End Element :" + qName);

	        	}

	        	public void characters(char ch[], int start, int length) throws SAXException {
	       
	        		ExpensesSAX ep = new ExpensesSAX(); 	
	        		
	        		DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
	        		
	        		
	        		if (bid) {
	        			System.out.println("Comment ID : " + new String(ch, start, length));
	        			ep.setEmployee_ID(new String(ch, start, length));
	        			bid = false;
	        		}

	        		if (bexpense) {
	        			System.out.println("Expense Type : " + new String(ch, start, length));
	        			ep.setExpenseType((new String(ch, start, length)));
	        			bexpense = false;
	        		}

	        		if (bpurpose) {
	        			System.out.println("Purpose of Expense : " + new String(ch, start, length));
	        			ep.setPurposeofExpense(new String(ch, start, length));
	        			bpurpose = false;
	        		}

	        		if (bamt) {
	        			System.out.println("Amount spend : " + new String(ch, start, length));
	        			ep.setAmountSpent(Integer.parseInt(new String(ch, start, length)));
	        			bamt = false;
	        		}
	        		
	        		if (bdesc) {
	        			System.out.println("Expense Description : " + new String(ch, start, length));
	        			ep.setExpense_Description(new String(ch, start, length));
	        			bdesc = false;
	        		}

	        		if (bdatep) {
	        			System.out.println("Date Purchased : " + new String(ch, start, length));
	        			try {
							ep.setDatePurchased(sdf.parse(new String(ch, start, length)));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			bdatep = false;
	        		}
	        		
	        		if (bdates) {
	        			System.out.println("Date Submitted : " + new String(ch, start, length));
	        			try {
							ep.setDateSubmitted((sdf.parse(new String(ch, start, length))));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			bdates = false;
	        		}
	        		
	        		if (badvamt) {
	        			System.out.println("Advance Amount : " + new String(ch, start, length));
	        			ep.setAdvanceAmount((Integer.parseInt(new String(ch, start, length))));
	        			badvamt = false;
	        		}
	        		
	        		if (bpay) {
	        			System.out.println("Payment Method : " + new String(ch, start, length));
	        			ep.setPaymentMethod((new String(ch, start, length)));
	        			bpay = false;
	        		}
	        		
	        	}

	        	
	        		
	        
	        		};

	             File file = new File("/Users/bhumin/eclipse-workspace/soa/src/SAX/Expenses.xml");
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
	


