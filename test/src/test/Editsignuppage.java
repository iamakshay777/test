package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="edit")
@ViewScoped
public class Editsignuppage implements Serializable  {
	
	String name,mobile,fathername,mothername,gendar,address;
	Date dob;
	int id;
	ArrayList<signupbeenfile>list;
	 signupbeenfile select;
	 
	
	 public String back()
	{
		return "signuplist.xhtml";
	}
	

	public Editsignuppage()
	{
		
		HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		select =  (signupbeenfile) ss.getAttribute("go");
		
		
	}
	
	
	public String update()
	{
		
		String aa =  new signupcontorller().update(select);
		  
		   System.out.println("inner upadte");
		   
		   if(aa.equals("1"))
		   {
			  
			   System.out.println("check update");
			   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entry update"));
			   return "signuplist.xhtml";
			   
		   }
		   return "";
	}
	

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getGendar() {
		return gendar;
	}

	public void setGendar(String gendar) {
		this.gendar = gendar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public ArrayList<signupbeenfile> getList() {
		return list;
	}

	public void setList(ArrayList<signupbeenfile> list) {
		this.list = list;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public signupbeenfile getSelect() {
		return select;
	}


	public void setSelect(signupbeenfile select) {
		this.select = select;
	}


}
