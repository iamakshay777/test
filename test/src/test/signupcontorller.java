package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@SuppressWarnings("serial")
public class signupcontorller implements Serializable {
	
			//insert
			public String insert(String name, String mobile,String fathername,
					String mothername, String gendar, String address, Date dob) {
				Timestamp tt = new Timestamp(dob.getTime());
			
				System.out.println(tt);
				Connection cnt = DataBaseConnection.javaConnection();
				try {
					
					String qq="insert into register(name,mobile,fathername,mothername,gendar,address,Dob)value(?,?,?,?,?,?,?)";
					PreparedStatement 	stt = cnt.prepareStatement(qq);
					stt.setString(1, name);
					stt.setString(2, mobile);
					stt.setString(3, fathername);
					stt.setString(4, mothername);
					stt.setString(5, gendar);
					stt.setString(6, address);
					stt.setTimestamp(7, tt);

					
					int x =stt.executeUpdate();
			    
					System.out.println("hhh"+x);
					
					if(x>0)
			    {
			    	System.out.println("in");
			    	return "1";
			    }
			    else{
			    	System.out.println("Error");
			    	
			    }
					
			    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("344");
					e.printStackTrace();
				}
				return "";
			}

//view list
public ArrayList<signupbeenfile> getdata() {

	ArrayList<signupbeenfile> list = new ArrayList<>();
	int count=1;
	
	Connection cnt = DataBaseConnection.javaConnection();
	
	try{
		
		Statement ss=cnt.createStatement();
		String qq="Select * from register";
		ResultSet rr =ss.executeQuery(qq);
		while(rr.next())
		{
			
			signupbeenfile r = new signupbeenfile();
			r.setSno(count++);
			r.setId(rr.getInt("id"));
			r.setName(rr.getString("name"));
			r.setMobile(rr.getString("mobile"));
			r.setFathername(rr.getString("fathername"));
			r.setMothername(rr.getString("mothername"));
			r.setGendar(rr.getString("gendar"));
			r.setAddress(rr.getString("address"));
			r.setDob(rr.getDate("Dob"));
			
		
			list.add(r);
			
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return list;
}

//update
public String delete(int id) {
	
	
	System.out.println("in editq");
	Connection cnt=DataBaseConnection.javaConnection();
try {
		
	System.out.println("123");
	Statement stt=cnt.createStatement();
		
	String qqqq= "DELETE FROM register WHERE id='"+id+"' ";
		
		System.out.println("sksk"+qqqq);
		
		int  i=stt.executeUpdate(qqqq);
		
		if(i>0)
		{
		return "1";
		}
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
	
	
}

public String update(signupbeenfile select) {
	Timestamp tt = new Timestamp(select.dob.getTime());

int x=0;

Connection cnt = DataBaseConnection.javaConnection(); 
try {
		
	Statement stt=cnt.createStatement();
	
	String qq=" UPDATE register SET name='"+select.name+"',mobile='"+select.mobile+"', fathername='"+select.fathername+"',mothername='"+select.mothername+"',"
			+ "gendar='"+select.gendar+"',address='"+select.address+"',Dob='"+tt+"'  WHERE  id= '"+select.id+"' ";

	
 x=stt.executeUpdate(qq);
 
	System.out.println("sjaksakjsajsjkas"+qq);		
	
	if(x>0)
	{
	  return "1";
			
	}
	else
	{
	   	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error"));

	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
	return "";
}
}



