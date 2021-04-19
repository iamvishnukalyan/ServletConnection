package demo.project.businesslogic;

import demo.project.dao.DbConnect;

public class LoginValidation {

	public int validateUser(String userid, String password) {

		DbConnect d = new DbConnect();

		int val = d.dbRetreive(userid, password);
		if (val == 1) {
			return 1;
		}

		return 0;

	}

}
