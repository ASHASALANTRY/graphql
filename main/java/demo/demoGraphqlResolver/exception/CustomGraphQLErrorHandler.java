package demo.demoGraphqlResolver.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler{

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> list) {
		
        return list.stream().map(this::getNested).collect(Collectors.toList());
	}
	private GraphQLError getNested(GraphQLError error) {
       // log.error(error.getMessage(), error);
        
        if (error instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof GraphQLError) {
                return new GraphqlDremioClientException(exceptionError.getMessage(), false);
            }
        }
        return error;
    }
}
