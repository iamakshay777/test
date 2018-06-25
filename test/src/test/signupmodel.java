package test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean (name="test")
@ViewScoped
public class signupmodel implements Serializable {

String name,mobile,fathername,mothername,gendar,address,password1;
Date dob=new Date();
int id;
signupbeenfile selected;
ArrayList<signupbeenfile>select;
 ArrayList<signupbeenfile> list = new ArrayList<>();

 
		 
 	public String welcome()
 	{
 		return "Dashboard.xhtml";
 	}
 
 
		 public signupmodel() 
		{
			list = new signupcontorller().getdata();
		
		}
		

		public String delete(){
			
			{
				
				System.out.println("welcome"+selected.id);
				
				String aa =	new signupcontorller().delete(selected.id); 
			
				if(aa.equals("1"))
				{
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entry deleted"));
						return "signuplist.xhtml";

				}
				else{
					System.out.println("error");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error"));
				}
				return "";
			}
		}

		 
		
		public String back()
		{
			return "signup.xhtml";
		}
		
		
		//insert
		public String submit()
		{	  
		System.out.println(dob);	
		String aa =	new signupcontorller().insert(name,mobile,fathername,mothername,gendar,address,dob);
		
		if (aa.equals("1"))
			
		{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" THANK-YOU for registe sir"));
			return "signuplist.xhtml";	
			
			
		}
		
			return "";
		  }
		
		public String session()
		{	  
			  
			  HttpSession ss =(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				ss.setAttribute("go", selected);
				
				RequestContext.getCurrentInstance().execute("window.open('signupeditlist.xhtml')");
				
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
		
		
		
		
		public void setDob(Date dob) {
			this.dob = dob;
		}
		
		
		
		
		public signupbeenfile getSelected() {
			return selected;
		}
		
		
		
		
		public void setSelected(signupbeenfile selected) {
			this.selected = selected;
		}
		
		
		
		
		public Date getDob() {
			return dob;
		}


		public ArrayList<signupbeenfile> getSelect() {
			return select;
		}


		public void setSelect(ArrayList<signupbeenfile> select) {
			this.select = select;
		}


		public String getPassword1() {
			return password1;
		}


		public void setPassword1(String password1) {
			this.password1 = password1;
		}


	


		
		}
