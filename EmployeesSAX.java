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
import java.util.Date;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class EmployeesSAX extends DefaultHandler {
	
	 String empid, fname, Lname, email, title, license, add1, city, state, notes ;
	 int extension, code, sal;
	 long homeno, cellno, SSN;
	 Date bdate, hdate;
	
	 
	 public String getEmpid() {
		return empid;
	}





	public void setEmpid(String empid) {
		this.empid = empid;
	}





	public String getFname() {
		return fname;
	}





	public void setFname(String fname) {
		this.fname = fname;
	}





	public String getLname() {
		return Lname;
	}





	public void setLname(String lname) {
		Lname = lname;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getLicense() {
		return license;
	}





	public void setLicense(String license) {
		this.license = license;
	}





	public String getAdd1() {
		return add1;
	}





	public void setAdd1(String add1) {
		this.add1 = add1;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public String getNotes() {
		return notes;
	}





	public void setNotes(String notes) {
		this.notes = notes;
	}





	public int getExtension() {
		return extension;
	}





	public void setExtension(int extension) {
		this.extension = extension;
	}





	public int getCode() {
		return code;
	}





	public void setCode(int code) {
		this.code = code;
	}





	public int getSal() {
		return sal;
	}





	public void setSal(int sal) {
		this.sal = sal;
	}





	public long getHomeno() {
		return homeno;
	}





	public void setHomeno(long homeno) {
		this.homeno = homeno;
	}





	public long getCellno() {
		return cellno;
	}





	public void setCellno(long cellno) {
		this.cellno = cellno;
	}





	public long getSSN() {
		return SSN;
	}





	public void setSSN(long sSN) {
		SSN = sSN;
	}





	public Date getBdate() {
		return bdate;
	}





	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}





	public Date getHdate() {
		return hdate;
	}





	public void setHdate(Date hdate) {
		this.hdate = hdate;
	}


	public void EmployeeParse() {
		
		 try {
			 
			 
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	        		DefaultHandler handler = new DefaultHandler() {
	        		
	        		boolean bempid = false;
	        		boolean bfname = false;
	        		boolean blname = false;
	        		boolean bemail = false;
	        		boolean bextension = false;
	        		boolean bhphone = false;
	        		boolean bcphone = false;
	        		boolean bjtitle = false;
	        		boolean bssn = false;
	        		boolean bdlicense = false;
	        		boolean badd1 = false;
	        		boolean bcity = false;
	        		boolean bstate = false;
	        		boolean bcode = false;
	        		boolean bdate = false;
	        		boolean bddate = false;
	        		boolean bsal = false;
	        		boolean bnotes = false;
	        		
	        		
	        		
	        	public void startElement(String uri, String localName,String qName,
	                        Attributes attributes) throws SAXException {

	        		System.out.println("Start Element :" + qName);

	        		if (qName.equalsIgnoreCase("EMPID")) {
	        			bempid = true;
	        		}

	        		if (qName.equalsIgnoreCase("FirstName")) {
	        			bfname = true;
	        		}

	        		if (qName.equalsIgnoreCase("LastName")) {
	        			blname = true;
	        		}

	        		if (qName.equalsIgnoreCase("Email")) {
	        			bemail = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Extension")) {
	        			bextension = true;
	        		}

	        		if (qName.equalsIgnoreCase("HomePhone")) {
	        			bhphone = true;
	        		}

	        		if (qName.equalsIgnoreCase("CellPhone")) {
	        			bcphone = true;
	        		}

	        		if (qName.equalsIgnoreCase("JobTitle")) {
	        			bjtitle = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("SocialSecurityNumber")) {
	        			bssn = true;
	        		}

	        		if (qName.equalsIgnoreCase("DriverLicenseNumber")) {
	        			bdlicense = true;
	        		}

	        		if (qName.equalsIgnoreCase("AddressLine1")) {
	        			badd1 = true;
	        		}

	        		if (qName.equalsIgnoreCase("City")) {
	        			bcity = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("State")) {
	        			bstate = true;
	        		}

	        		if (qName.equalsIgnoreCase("PostalCode")) {
	        			bcode = true;
	        		}

	        		if (qName.equalsIgnoreCase("BirthDate")) {
	        			bdate = true;
	        		}

	        		if (qName.equalsIgnoreCase("HiredDate")) {
	        			bddate = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Salary")) {
	        			bsal = true;
	        		}

	        		if (qName.equalsIgnoreCase("Notes")) {
	        			bnotes = true;
	        		}  		

	        	}

	        	public void endElement(String uri, String localName,
	        		String qName) throws SAXException {

	        		System.out.println("End Element :" + qName);

	        	}

	        	public void characters(char ch[], int start, int length) throws SAXException {
	       
	        		EmployeesSAX ep = new EmployeesSAX(); 	
	        		
	        		DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
	        		
	        		
	        		if (bempid) {
	        			System.out.println("Employee ID : " + new String(ch, start, length));
	        			ep.setEmpid((new String(ch, start, length)));
	        			bempid = false;
	        		}

	        		if (bfname) {
	        			System.out.println("First Name : " + new String(ch, start, length));
	        			ep.setFname(new String(ch, start, length));
	        			bfname = false;
	        		}

	        		if (blname) {
	        			System.out.println("Last Name : " + new String(ch, start, length));
	        			ep.setLname(new String(ch, start, length));
	        			blname = false;
	        		}

	        		if (bemail) {
	        			System.out.println("Email Address : " + new String(ch, start, length));
	        			ep.setEmail(new String(ch, start, length));
	        			bemail = false;
	        		}
	        		
	        		if (bextension) {
	        			System.out.println("Extension Number : " + new String(ch, start, length));
	        			ep.setExtension(Integer.parseInt((new String(ch, start, length))));
	        			bextension = false;
	        		}

	        		if (bhphone) {
	        			System.out.println("Home Phoone Number : " + new String(ch, start, length));
	        			ep.setHomeno(Long.parseLong((new String(ch, start, length))));
	        			bhphone = false;
	        		}

	        		if (bcphone) {
	        			System.out.println("Cell Phoone Number : " + new String(ch, start, length));
	        			ep.setCellno(Long.parseLong((new String(ch, start, length))));
	        			bcphone = false;
	        		}

	   
	        		if (bjtitle) {
	        			System.out.println("Job Title : " + new String(ch, start, length));
	        			ep.setTitle(new String(ch, start, length));
	        			bjtitle = false;
	        		}

	        		if (bssn) {
	        			System.out.println("Social Security Number : " + new String(ch, start, length));
	        			ep.setSSN(Long.parseLong((new String(ch, start, length))));
	        			bssn = false;
	        		}

	        		if (bdlicense) {
	        			System.out.println("Driver License Number : " + new String(ch, start, length));
	        			ep.setLicense(new String(ch, start, length));
	        			bdlicense = false;
	        		}

	        		if (badd1) {
	        			System.out.println("Address Line : " + new String(ch, start, length));
	        			ep.setAdd1(new String(ch, start, length));
	        			badd1 = false;
	        		}
	        		if (bcity) {
	        			System.out.println("City : " + new String(ch, start, length));
	        			ep.setCity(new String(ch, start, length));
	        			bcity = false;
	        		}
	        		
	        		
	        		if (bstate) {
	        			System.out.println("State : " + new String(ch, start, length));
	        			ep.setState(new String(ch, start, length));
	        			bstate = false;
	        		}

	        		
	        		if (bcode) {
	        			System.out.println("Postal code : " + new String(ch, start, length));
	        			ep.setCode(Integer.parseInt(new String(ch, start, length)));
	        			bcode = false;
	        		}
	        		
	        		if (bdate) {
	        			System.out.println("Birth date : " + new String(ch, start, length));
	        			try {
							ep.setBdate(sdf.parse(new String(ch, start, length)));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			bdate = false;
	        		}
	        		if (bddate) {
	        			System.out.println("Hired Date : " + new String(ch, start, length));
	        			try {
							ep.setHdate((sdf.parse(new String(ch, start, length))));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			bddate = false;
	        		}

	        		if (bsal) {
	        			System.out.println("Salary : " + new String(ch, start, length));
	        			ep.setSal(Integer.parseInt((new String(ch, start, length))));
	        			bsal = false;
	        		}

	        		if (bnotes) {
	        			System.out.println("Notes : " + new String(ch, start, length));
	        			ep.setNotes(new String(ch, start, length));
	        			bnotes = false;
	        		}


	        	}
	        		
	        
	        		};

	             File file = new File("/Users/bhumin/eclipse-workspace/soa/src/SAX/Employee.xml");
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
