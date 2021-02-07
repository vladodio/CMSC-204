
public class NoUpperAlphaException extends RuntimeException {
	public NoUpperAlphaException() {
		super("The password must contain at least one upper case alphabetic character");
	}
}
