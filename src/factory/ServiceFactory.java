package factory;

import service.ClassementService;

public class ServiceFactory {

	static ClassementService  classement;
	
	public static ClassementService getClassementService() {

		if(classement == null) {
			classement = new ClassementService();
		}
		return classement;
	}
	
}
