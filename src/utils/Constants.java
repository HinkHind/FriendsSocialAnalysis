package utils;

public class Constants {
	private static final String USER_ID = "userId";
	private static final String SIGN_IN_VIEW = "signIn.jsp";
	

	private static final String[] DICT_FILE_SET 
		= {		"art",
			"cultural",
			"engineering",
			"entertainment",
			"game",
			"living",
			"medicine",
			"science",
			"social",
			"sports"};

	public static String[] getDictFileSet() {
		return DICT_FILE_SET;
	}
	public static String getUserId() {
		return USER_ID;
	}

	public static String getSignInView() {
		return SIGN_IN_VIEW;
	}

}
