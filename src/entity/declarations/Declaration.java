package entity.declarations;

import java.util.Date;

public abstract class Declaration {
	
	private Date heureD;

	
	public  Declaration(Date heureD) {
		this.heureD = heureD;
	}

	public Date getHeureD() {
		return heureD;
	}

	public void setHeureD(Date heureD) {
		this.heureD = heureD;
	}
	
	
}
