
public class NoSpecialCharacterException extends RuntimeException {
	public NoSpecialCharacterException() {
		super("Password does not contain a special character!");
	}
}
