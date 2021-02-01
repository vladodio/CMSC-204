
public class InvalidSequenceException extends RuntimeException {
	public InvalidSequenceException() {
		super("Too many duplicate characters in a row!");
	}
}
