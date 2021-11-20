import java.io.IOException;
import java.util.ArrayList;

public  class Driver implements User {
	public String name = "";
	public String password = "";
	public String email= "";
	public String mobilenum= "";
	public String drivlic= "";
	public String nationalid= "";
	public String fav= "";
	public String verified= "";
	ArrayList<String> favareas  = new ArrayList<String>();
	
	public Driver() {}
	public Driver(String nam,String pass,String mail,String num,String lic, String id, String fava, String verify)
	{
		name=nam;
		password=pass;
		email=mail;
		mobilenum=num;
		drivlic=lic;
		nationalid=id;
		fav=fava;
		verified=verify;
		
		
	}
	@Override
	public void Addfavareass(String fav)
	{
		this.favareas.add(fav);
	}
	@Override
	public void update(Object o) 
	{
		System.out.println("haiii");
		if(o instanceof TransportationApp)
		{
			System.out.println("haii2");
			TransportationApp ta = (TransportationApp) o; //cast el o l transportation app
			ta.getState();
		}
	}

	@Override
	public void setFavareas(String fav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getVerified() {
		// TODO Auto-generated method stub
		return verified;
	}

	@Override
	public void setVerified(String verified) {
		// TODO Auto-generated method stub
		this.verified=verified;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public String getmobilenum() {
		// TODO Auto-generated method stub
		return mobilenum;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
	this.email=email;
	}

	@Override
	public void setmobilenum(String num) {
		// TODO Auto-generated method stub
		mobilenum=num;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	@Override
	public String getdrivlic() {
		// TODO Auto-generated method stub
		return drivlic;
	}

	@Override
	public void setdrivlic(String dl) {
		// TODO Auto-generated method stub
		drivlic = dl;
	}

	@Override
	public String getnationalid() {
		// TODO Auto-generated method stub
		return nationalid;
	}

	@Override
	public void setnationalid(String ni) {
		// TODO Auto-generated method stub
		nationalid = ni;
		
	}


	@Override
	public boolean Login(String username , String Password, String role) {
		Validation vd = new Validation();
		boolean bo = vd.Login(username, Password, role);
		 
			if(bo) {
				  System.out.println("You logged in succesfully");
				  return true;
			}
			else
				System.out.println("Username or password not match");
			return false;
	}

	public boolean Register(String name, String password, String email, String Mobilenum, String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RegisterDriv(String name , String password , String email , String mobilenum, String drivlic, String nationalid) {
		try {	
			Validation vd = new Validation();
			 vd.RegisterDriv(name, password, email, mobilenum, drivlic, nationalid);

			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	@Override
	public String getrole() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setrole(String Role) {
		// TODO Auto-generated method stub
		
	}
	
	

}
