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



public class ExpensesDOM {


	String Expense_ID, Emp_ID, ExpenseType,PurposeofExpense,Expense_Description,PaymentMethod;
	
	int AmountSpent,AdvanceAmount;
	
	Date DatePurchased, DateSubmitted;

	public String getExpense_ID() {
		return Expense_ID;
	}



	public void setExpense_ID(String expense_ID) {
		Expense_ID = expense_ID;
	}



	public String getEmp_ID() {
		return Emp_ID;
	}



	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
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




	public int getAmountSpent() {
		return AmountSpent;
	}



	public void setAmountSpent(int amountSpent) {
		AmountSpent = amountSpent;
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
	
	


	public int getAdvanceAmount() {
		return AdvanceAmount;
	}



	public void setAdvanceAmount(int advanceAmount) {
		AdvanceAmount = advanceAmount;
	}






	public void ExpensesInsert()
    {
        try {
        	System.out.println("Expenses Parsing & Inserting Begins");
        	ExpensesDOM e=new ExpensesDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Expenses.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Expense");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Employee_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Expense");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	                  
             e.setExpense_ID((eElement.getElementsByTagName("Employee_ID").item(0).getTextContent()));
             e.setEmp_ID((eElement.getElementsByTagName("Emp_ID").item(0).getTextContent()));
			 e.setExpenseType((eElement.getElementsByTagName("ExpenseType").item(0).getTextContent()));
			 e.setPurposeofExpense((eElement.getElementsByTagName("PurposeofExpense").item(0).getTextContent()));
			 e.setAmountSpent(Integer.parseInt(eElement.getElementsByTagName("AmountSpent").item(0).getTextContent()));
			 e.setExpense_Description((eElement.getElementsByTagName("Expense_Description").item(0).getTextContent()));
			 e.setDatePurchased(sdf.parse((eElement.getElementsByTagName("DatePurchased").item(0).getTextContent())));
			 e.setDateSubmitted(sdf.parse((eElement.getElementsByTagName("DateSubmitted").item(0).getTextContent())));
			 e.setAdvanceAmount(Integer.parseInt((eElement.getElementsByTagName("AdvanceAmount").item(0).getTextContent())));
			 e.setPaymentMethod((eElement.getElementsByTagName("PaymentMethod").item(0).getTextContent()));
                        

   PreparedStatement ps=conn.prepareStatement("insert into Expenses(Expense_ID,Emp_ID, Expense_Type,Purpose_Of_Expense,Amount_Spend, Expense_Description,Date_Purchased,Date_Submitted,Advance_Amt,Payment_Method) values (?,?,?,?,?,?,?,?,?)");    

   
                    ps.setString(1,e.getExpense_ID());
                    ps.setString(2, e.getEmp_ID());
                    ps.setString(3, e.getExpenseType());
                    ps.setString(4,e.getPurposeofExpense());
                    ps.setInt(5, e.getAmountSpent());
                    ps.setString(6,e.getExpense_Description());
                    ps.setDate(7,(java.sql.Date) e.getDatePurchased());
                    ps.setDate(8,(java.sql.Date) e.getDateSubmitted());
					ps.setInt(9, e.getAdvanceAmount());
					ps.setString(7,e.getPaymentMethod());
                    
                    
                   ps.execute();
                    System.out.println("Expenses Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
