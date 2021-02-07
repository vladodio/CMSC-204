
public class InvalidSequenceException extends RuntimeException {
	public InvalidSequenceException() {
		super("The password must not have that many characters in a row");
	}
}
