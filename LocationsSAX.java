package SAX;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LocationsSAX {

	String Location_ID, Location_Name, Loc_address_line1, Loc_City, Loc_State, Loc_email_address;
	int Location_Code, Loc_ZipCode;
	long Loc_phone_number, Loc_fax_number;
	
	public String getLocation_ID() {
		return Location_ID;
	}
	public void setLocation_ID(String location_ID) {
		Location_ID = location_ID;
	}
	public String getLocation_Name() {
		return Location_Name;
	}
	public void setLocation_Name(String location_Name) {
		Location_Name = location_Name;
	}
	public String getLoc_address_line1() {
		return Loc_address_line1;
	}
	public void setLoc_address_line1(String loc_address_line1) {
		Loc_address_line1 = loc_address_line1;
	}
	public String getLoc_City() {
		return Loc_City;
	}
	public void setLoc_City(String loc_City) {
		Loc_City = loc_City;
	}
	public String getLoc_State() {
		return Loc_State;
	}
	public void setLoc_State(String loc_State) {
		Loc_State = loc_State;
	}
	public String getLoc_email_address() {
		return Loc_email_address;
	}
	public void setLoc_email_address(String loc_email_address) {
		Loc_email_address = loc_email_address;
	}
	public int getLocation_Code() {
		return Location_Code;
	}
	public void setLocation_Code(int location_Code) {
		Location_Code = location_Code;
	}
	public int getLoc_ZipCode() {
		return Loc_ZipCode;
	}
	public void setLoc_ZipCode(int loc_ZipCode) {
		Loc_ZipCode = loc_ZipCode;
	}
	public long getLoc_phone_number() {
		return Loc_phone_number;
	}
	public void setLoc_phone_number(long loc_phone_number) {
		Loc_phone_number = loc_phone_number;
	}
	public long getLoc_fax_number() {
		return Loc_fax_number;
	}
	public void setLoc_fax_number(long loc_fax_number) {
		Loc_fax_number = loc_fax_number;
	}

	public void LocationsParse() {
		
		 try {
			 
			 
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	        		DefaultHandler handler = new DefaultHandler() {
	        		
	        		boolean bid = false;
	        		boolean bname = false;
	        		boolean bcode = false;
	        		boolean badd = false;
	        		boolean bcity = false;
	        		boolean bstate = false;
	        		boolean bzip = false;
	        		boolean bphone = false;
	        		boolean bfax = false;
	        		boolean bemail = false;
	     
	        		
	        	public void startElement(String uri, String localName,String qName,
	                        Attributes attributes) throws SAXException {

	        		System.out.println("Start Element :" + qName);

	        		
	        		if (qName.equalsIgnoreCase("Location_ID")) {
	        			bid = true;
	        		}

	        		if (qName.equalsIgnoreCase("Location_Name")) {
	        			bname = true;
	        		}

	        		if (qName.equalsIgnoreCase("Location_Code")) {
	        			bcode = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Loc_address_line1")) {
	        			badd = true;
	        		}

	        		if (qName.equalsIgnoreCase("Loc_City")) {
	        			bcity = true;
	        		}

	        		if (qName.equalsIgnoreCase("Loc_State")) {
	        			bstate = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Loc_ZipCode")) {
	        			bzip = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Loc_phone_number")) {
	        			bphone = true;
	        		}

	        		if (qName.equalsIgnoreCase("Loc_fax_number")) {
	        			bfax = true;
	        		}

	        		if (qName.equalsIgnoreCase("Loc_email_address")) {
	        			bemail = true;
	        		}

	        	}

	        	public void endElement(String uri, String localName,
	        		String qName) throws SAXException {

	        		System.out.println("End Element :" + qName);

	        	}

	        	public void characters(char ch[], int start, int length) throws SAXException {
	       
	        		LocationsSAX ep = new LocationsSAX(); 	
	        		
	        		//DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	        		
	        		
	        		if (bid) {
	        			System.out.println("Location ID : " + new String(ch, start, length));
	        			ep.setLocation_ID(new String(ch, start, length));
	        			bid = false;
	        		}

	        		if (bname) {
	        			System.out.println("Location Name : " + new String(ch, start, length));
	        			ep.setLocation_Name((new String(ch, start, length)));
	        			bname = false;
	        		}

	        		if (bcode) {
	        			System.out.println("Location code : " + new String(ch, start, length));
	        			ep.setLocation_Code(Integer.parseInt((new String(ch, start, length))));
	        			bcode = false;
	        		}

	        		if (badd) {
	        			System.out.println("Address Line 1 : " + new String(ch, start, length));
	        			ep.setLoc_address_line1((new String(ch, start, length)));
	        			badd = false;
	        		}
	        		
	        		if (bcity) {
	        			System.out.println("City: " + new String(ch, start, length));
	        			ep.setLoc_City((new String(ch, start, length)));
	        			bcity = false;
	        		}

	        		if (bstate) {
	        			System.out.println("State : " + new String(ch, start, length));
	        			ep.setLoc_State((new String(ch, start, length)));
	        			bstate = false;
	        		}
	        		
	        		if (bzip) {
	        			System.out.println("Postal Code : " + new String(ch, start, length));
	        			ep.setLoc_ZipCode(Integer.parseInt(new String(ch, start, length)));
	        			bzip = false;
	        		}
	        		
	        		if (bphone) {
	        			System.out.println("Phone number : " + new String(ch, start, length));
	        			ep.setLoc_phone_number(Long.parseLong(new String(ch, start, length)));
	        			bphone = false;
	        		}
	        		
	        		if (bfax) {
	        			System.out.println("Fax number : " + new String(ch, start, length));
	        			ep.setLoc_fax_number(Long.parseLong(new String(ch, start, length)));
	        			bfax = false;
	        		}
	        		
	        		if (bemail) {
	        			System.out.println("Email address : " + new String(ch, start, length));
	        			ep.setLoc_email_address(new String(ch, start, length));
	        			bemail = false;
	        		}


	        	}
	        		
	        
	        		};

	             File file = new File("/Users/bhumin/eclipse-workspace/soa/src/SAX/Location.xml");
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
