package demo.demoGraphqlResolver.exception;



import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.GraphQLError;
import graphql.GraphqlErrorException;
@ControllerAdvice
public class GraphqlExceptionHandler {

//  @ExceptionHandler({GraphQLException.class, ConstraintViolationException.class})
//  public ThrowableGraphQLError handle(Exception e) {
//    return new ThrowableGraphQLError(e);
//  }

//	@GraphQlExceptionHandler(GraphqlException.class)
  public GraphQLError handleq(GraphqlException e) {
    return GraphqlErrorException.newErrorException()
            .message(e.getLocalizedMessage())
           // .errorClassification(ErrorType.NOT_FOUND)
            .build();
  }
//
//  @GraphQlExceptionHandler(Exception.class)
//  public Throwable handleq(Exception e) {
//	  return new Throwable("not at all working");  }

}
