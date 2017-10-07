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



public class CommentsDOM {


	String Comment_ID, Comment_Detail, Cust_ID, Cimment, Trans_ID;

	Date Time_Of_Comment;
	
	public String getTrans_ID() {
		return Trans_ID;
	}

	public void setTrans_ID(String trans_ID) {
		Trans_ID = trans_ID;
	}
	
	public String getCimment() {
		return Cimment;
	}

	public void setCimment(String cimment) {
		Cimment = cimment;
	}
	
	public String getComment_ID() {
		return Comment_ID;
	}

	public void setComment_ID(String comment_ID) {
		Comment_ID = comment_ID;
	}

	public String getComment_Detail() {
		return Comment_Detail;
	}

	public void setComment_Detail(String comment_Detail) {
		Comment_Detail = comment_Detail;
	}

	public String getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}

	public Date getTime_Of_Comment() {
		return Time_Of_Comment;
	}

	public void setTime_Of_Comment(Date time_Of_Comment) {
		Time_Of_Comment = time_Of_Comment;
	}

		
	public void CommentInsert()
    {
        try {
        	System.out.println("Comments Parsing & Inserting Begins");
        	CommentsDOM e=new CommentsDOM();
            Connection conn = ConnectionClass.getConnection();
            File file = new File("src/Comments.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Comments");

            System.out.println("----------------------------------------------");

            for(int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                System.out.println("\nCurrent element :" + nNode.getNodeName());

                if(nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	System.out.println("In if");

                    Element eElement = (Element) nNode;
                    
                //	System.out.println(Long.parseLong((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent())));
                    
                    eElement.getAttribute("Comments");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

             e.setComment_ID((eElement.getElementsByTagName("CommentID").item(0).getTextContent())); 
             e.setTime_Of_Comment(sdf.parse((eElement.getElementsByTagName("Time_of_Comment").item(0).getTextContent())));
             e.setComment_Detail(((eElement.getElementsByTagName("Comment_details").item(0).getTextContent())));
             e.setCimment((eElement.getElementsByTagName("cimment").item(0).getTextContent()));
             e.setCust_ID((eElement.getElementsByTagName("Customer_ID").item(0).getTextContent()));
             e.setTrans_ID((eElement.getElementsByTagName("Transaction_ID").item(0).getTextContent()));
            
             
           
            
         
             
          //  System.out.println(e.getPricing_ID());
                    
                    

   PreparedStatement ps=conn.prepareStatement("insert into Comments(Comment_ID, Time_Of_Comment, Comment_Details, Cimment, Cust_ID, Trans_ID) values (?,?,?,?,?,?,?,?,?,?)");              
                    ps.setString(1,e.getComment_ID());
                    ps.setDate(2, (java.sql.Date) e.getTime_Of_Comment());
                    ps.setString(3,e.getComment_Detail());
                    ps.setString(4,e.getCimment());
                    ps.setString(5, e.getCust_ID());
                    ps.setString(6,e.getTrans_ID());
                    
            
             
               
                    
                   ps.execute();
                    System.out.println("Comment Parsing Ends");
                }

            }

        } catch (Exception e1) {
          e1.printStackTrace();
            System.out.println("In Exception");
        }

    }


}
