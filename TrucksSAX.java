package SAX;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TrucksSAX {
	
	String Truck_ID, Make_Year, Make_Model, License_Plate_No, Emp_ID, Truck_Color, Truck_VIN;

	public String getTruck_ID() {
		return Truck_ID;
	}

	public void setTruck_ID(String truck_ID) {
		Truck_ID = truck_ID;
	}

	public String getMake_Year() {
		return Make_Year;
	}

	public void setMake_Year(String make_Year) {
		Make_Year = make_Year;
	}

	public String getMake_Model() {
		return Make_Model;
	}

	public void setMake_Model(String make_Model) {
		Make_Model = make_Model;
	}

	public String getLicense_Plate_No() {
		return License_Plate_No;
	}

	public void setLicense_Plate_No(String license_Plate_No) {
		License_Plate_No = license_Plate_No;
	}

	public String getEmp_ID() {
		return Emp_ID;
	}

	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}

	public String getTruck_Color() {
		return Truck_Color;
	}

	public void setTruck_Color(String truck_Color) {
		Truck_Color = truck_Color;
	}

	public String getTruck_VIN() {
		return Truck_VIN;
	}

	public void setTruck_VIN(String truck_VIN) {
		Truck_VIN = truck_VIN;
	}
	
	
	
	public void TrucksParser() {
		
		 try {
			 
			 
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	        		DefaultHandler handler = new DefaultHandler() {
	        		
	        		boolean bid = false;
	        		boolean byear = false;
	        		boolean bmodel = false;
	        		boolean blicense = false;
	        		boolean bemp_id = false;
	        		boolean bcolor = false;
	        		boolean bvin = false;
	        		
	        		
	        	public void startElement(String uri, String localName,String qName,
	                        Attributes attributes) throws SAXException {

	        		System.out.println("Start Element :" + qName);

	        		if (qName.equalsIgnoreCase("Truck_ID")) {
	        			bid = true;
	        		}

	        		if (qName.equalsIgnoreCase("Year")) {
	        			byear = true;
	        		}

	        		if (qName.equalsIgnoreCase("Model")) {
	        			bmodel = true;
	        		}

	        		if (qName.equalsIgnoreCase("LicensePlateNo")) {
	        			blicense = true;
	        		}
	        		
	        		if (qName.equalsIgnoreCase("Employee_ID")) {
	        			bemp_id = true;
	        		}

	        		if (qName.equalsIgnoreCase("Color")) {
	        			bcolor = true;
	        		}

	        		if (qName.equalsIgnoreCase("VIN")) {
	        			bvin = true;
	        		}

	        	}

	        	public void endElement(String uri, String localName,
	        		String qName) throws SAXException {

	        		System.out.println("End Element :" + qName);

	        	}

	        	public void characters(char ch[], int start, int length) throws SAXException {
	       
	        		TrucksSAX ep = new TrucksSAX(); 	
	        		
	        		DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	        		
	        		
	        		if (bid) {
	        			System.out.println("Truck ID : " + new String(ch, start, length));
	        			ep.setTruck_ID((new String(ch, start, length)));
	        			bid = false;
	        		}

	        		if (byear) {
	        			System.out.println("Make Year : " + new String(ch, start, length));
	        			ep.setMake_Year(new String(ch, start, length));
	        			byear = false;
	        		}

	        		if (bmodel) {
	        			System.out.println("Make Model: " + new String(ch, start, length));
	        			ep.setMake_Model(new String(ch, start, length));
	        			bmodel = false;
	        		}

	        		if (blicense) {
	        			System.out.println("License Plate Number : " + new String(ch, start, length));
	        			ep.setLicense_Plate_No (new String(ch, start, length));
	        			blicense = false;
	        		}
	        		
	        		if (bemp_id) {
	        			System.out.println("Employee ID : " + new String(ch, start, length));
	        			ep.setEmp_ID(new String(ch, start, length));
	        			bemp_id = false;
	        		}

	        		if (bcolor) {
	        			System.out.println("Truck Color : " + new String(ch, start, length));
	        			ep.setTruck_Color((new String(ch, start, length)));
	        			bcolor = false;
	        		}

	        		if (bvin) {
	        			System.out.println("Cell Phoone Number : " + new String(ch, start, length));
	        			ep.setTruck_VIN((new String(ch, start, length)));
	        			bvin = false;
	        		}
	        	}
	        		};

	             File file = new File("/Users/bhumin/eclipse-workspace/soa/src/SAX/Trucks.xml");
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
	

