import java.util.ArrayList;

public class PasswordCheckerUtility {

	
		public static void comparePasswords(String password, String passwordConfirm)  throws UnmatchedException{
			if(comparePasswordsWithReturn(password, passwordConfirm)) {
				 throw new UnmatchedException();
			}
		}
	
		public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
			return password.equals(passwordConfirm);
		}
		
		public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
			ArrayList<String> output = new ArrayList<String>();
			for(String password: passwords) {
				try {
					isValidPassword(password);
				}
				catch(RuntimeException e){
					output.add(password);
				}
			}
			return output;
		}
		
		public static boolean hasBetweenSixAndNineChars(String password) {
			return (password.length() >= 6) && (9 >= password.length());
		}
		
		public static boolean hasDigit(String password) throws NoDigitException{
			if(!password.matches(".*\\d.*")) {
				throw new NoDigitException();
			}
			return true;
		}
		
		public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
			if(!password.matches(".*[a-z].*")) {
				throw new NoLowerAlphaException();
			}
			return true;
		}
		
		public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
			boolean duplicatesFound = false;
			// regex not working here for some reason, java regex different from python2.7?
			//duplicatesFound = password.matches("(.)\1");
			for(int i = 0; i < password.length()-2; i++) {
				if((password.charAt(i) == password.charAt(i+1)) && (password.charAt(i+1) == password.charAt(i+2))) {
					duplicatesFound=true;
					break;
				}
			}
			
			if(duplicatesFound) {
				throw new InvalidSequenceException();
			}
			return true;
		}
		
		public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
			if(!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
				throw new NoSpecialCharacterException();
			}
			return true;
		}
		
		
		static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
			if(!password.matches(".*[A-Z].*")) {
				throw new NoUpperAlphaException();
			}
			return true;
		}
		
		
		static boolean isValidLength(String password) throws LengthException{
			if(password.length() < 6) {
				throw new LengthException();
			}
			return true;
		}
		
		static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
			return isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && hasSameCharInSequence(password);
		}
		
		static boolean isWeakPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
			return isValidPassword(password) && hasBetweenSixAndNineChars(password);
		}
		
}

