package listexceptions;

public class NoStudentsInGroupException extends Exception {
    public NoStudentsInGroupException(String message) {
        super(message);
    }
}
