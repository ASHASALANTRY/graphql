package demo.demoGraphqlResolver.exception;

public class GraphqlException extends RuntimeException{
	public GraphqlException(String message){
		super(message);
	}
	public GraphqlException(String message, Throwable cause) {
		super(message, cause);
	}
	public GraphqlException(Throwable cause) {
		super(cause);
	}
}
