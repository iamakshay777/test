package test;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean(name="dash")
@ViewScoped
public class Dashborad  implements Serializable{

public DashboardModel model;	
	
public  Dashborad ()
	{
		
		model =new DefaultDashboardModel();
		DashboardColumn colm1 = new DefaultDashboardColumn();
		DashboardColumn colm2 = new DefaultDashboardColumn();
		DashboardColumn colm3 = new DefaultDashboardColumn();
		
		
			colm1.addWidget("bike");
			colm1.addWidget("car");
			colm2.addWidget("plan");
			colm3.addWidget("cruse");
			
			
			model.addColumn(colm1);
			model.addColumn(colm2);
			model.addColumn(colm3);
			
	}


public String signup()
{
	return "signup.xhtml";
}


public DashboardModel getModel() {
	return model;
}

public void setModel(DashboardModel model) {
	this.model = model;
}
	
}
