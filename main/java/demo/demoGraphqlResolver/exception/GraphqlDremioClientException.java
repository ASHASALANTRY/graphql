package demo.demoGraphqlResolver.exception;

import java.util.List;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class GraphqlDremioClientException extends RuntimeException implements GraphQLError {

    private static final long serialVersionUID = 1L;
    
    private final String message;
    
    private boolean writeStacktrace = false;

    @Override
    public String getMessage() {
        return message;
    }
    /* other constructors */
        
    public GraphqlDremioClientException(String message, boolean writeStacktrace) {
        super(message, null, false, writeStacktrace);
        this.writeStacktrace = writeStacktrace;
        this.message = message;
    }
    
    public GraphqlDremioClientException(String message, Exception ex) {
        super();
        this.message = message;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }       
}
