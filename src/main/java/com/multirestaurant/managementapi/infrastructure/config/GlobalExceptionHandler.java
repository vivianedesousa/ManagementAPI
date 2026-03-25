package com.multirestaurant.managementapi.infrastructure.config;
import com.multirestaurant.managementapi.domain.exception.user.EmailAlreadyExistsException;
import com.multirestaurant.managementapi.domain.exception.user.InvalidUserException;
import com.multirestaurant.managementapi.domain.exception.user.UserNotFoundException;
import com.multirestaurant.managementapi.domain.exception.usertype.UserTypeNotFoundException;
import com.multirestaurant.managementapi.domain.exception.usertype.InvalidUserTypeNameException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
@RestControllerAdvice
// Usei um padrão simples de resposta para facilitar entendimento e manutençao
// Implementei tratamento de erro usando ProblemDetail seguindo o padrão RFC 7807,
// com mensagens dinâmicas definidas no UseCase DA CAMADA DE APLICACAO
//este sera o fluxo de exercucao
//UseCase → define mensagem
///Exception → carrega mensagem
//Handler → pega ex.getMessage()
//API retorna JSON correto
  //"OGlobalExceptionHandler centraliza o tratamento de exceções utilizando"
  //      " ProblemDetail, garantindo ""respostas padronizadas conforme o padrão RFC 7807."

public class GlobalExceptionHandler {
    // ===============================
    // 404 - USER TYPE NOT FOUND
    // ===============================
    @ExceptionHandler(UserTypeNotFoundException.class)
    public ProblemDetail handleUserTypeNotFound(
            UserTypeNotFoundException userTypeNotFoundException,
            HttpServletRequest httpRequest
    ) {
        ProblemDetail errorResponse  = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        errorResponse .setTitle("User type not found");
        errorResponse.setType(URI.create("https://multirestaurant/errors/user-type-not-found"));
        errorResponse.setDetail(userTypeNotFoundException.getMessage());
        errorResponse.setInstance(URI.create(httpRequest.getRequestURI()));
        return errorResponse;
    }

    // ===============================
    // 400 - INVALID NAME
    // ===============================
    @ExceptionHandler(InvalidUserTypeNameException.class)
    public ProblemDetail handleInvalidName(
            InvalidUserTypeNameException invalidUserTypeNameException,
            HttpServletRequest httpRequest
    ) {
        ProblemDetail errorResponse  = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        errorResponse .setTitle("Invalid user type name");
        errorResponse .setType(URI.create("https://multirestaurant/errors/invalid-user-type-name"));
        errorResponse .setDetail(invalidUserTypeNameException.getMessage());
        errorResponse .setInstance(URI.create(httpRequest.getRequestURI()));
        return errorResponse ;
    }
    // ===============================
    // 500 - GENERIC ERRO@ExceptionHandler(UserTypeNotFoundException.class)
    //public ProblemDetail handleUserTypeNotFound(...) { ... }
    //
    //@ExceptionHandler(UserTypeNotFoundException.class)
    //public ProblemDetail handleUserTypeNotFound(...) { ... } ❌R
    // ===============================
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneric(
            Exception exception,
            HttpServletRequest httpRequest
    ) {
        ProblemDetail internalServerErrorResponse  = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        internalServerErrorResponse.setTitle("Internal server error");
        internalServerErrorResponse.setType(URI.create("https://multirestaurant/errors/internal-error"));
        internalServerErrorResponse.setDetail("Unexpected error occurred");
        internalServerErrorResponse.setInstance(URI.create(httpRequest.getRequestURI()));
        return internalServerErrorResponse;
    }
    // ===============================
    // 404 - USER NOT FOUND
    // ===============================
    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(
            UserNotFoundException ex,
            HttpServletRequest request
    ) {
        ProblemDetail errorResponse = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        errorResponse.setTitle("User not found");
        errorResponse.setType(URI.create("https://multirestaurant/errors/user-not-found"));
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setInstance(URI.create(request.getRequestURI()));
        return errorResponse;
    }

    // ===============================
    // 400 - EMAIL ALREADY EXISTS
    // ===============================
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ProblemDetail handleEmailExists(
            EmailAlreadyExistsException ex,
            HttpServletRequest request
    ) {
        ProblemDetail errorResponse = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setTitle("Email already exists");
        errorResponse.setType(URI.create("https://multirestaurant/errors/email-already-exists"));
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setInstance(URI.create(request.getRequestURI()));
        return errorResponse;
    }

    // ===============================
    // 400 - INVALID USER
    // ===============================
    @ExceptionHandler(InvalidUserException.class)
    public ProblemDetail handleInvalidUser(
            InvalidUserException ex,
            HttpServletRequest request
    ) {
        ProblemDetail errorResponse = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setTitle("Invalid user");
        errorResponse.setType(URI.create("https://multirestaurant/errors/invalid-user"));
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setInstance(URI.create(request.getRequestURI()));
        return errorResponse;
    }

    // ===============================
    // 404 - USER TYPE NOT FOUND
    // ===============================

    // ===============================
    // 400 - INVALID USER TYPE
    // ===============================
    @ExceptionHandler(InvalidUserTypeNameException.class)
    public ProblemDetail handleInvalidUserType(
            InvalidUserTypeNameException ex,
            HttpServletRequest request
    ) {
        ProblemDetail errorResponse = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setTitle("Invalid user type name");
        errorResponse.setType(URI.create("https://multirestaurant/errors/invalid-user-type"));
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setInstance(URI.create(request.getRequestURI()));
        return errorResponse;
    }

    // ===============================
    // 500 - GENERIC ERROR
    // ===============================
    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleGeneric(
            RuntimeException ex,
            HttpServletRequest request
    ) {
        ProblemDetail errorResponse = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponse.setTitle("Internal server error");
        errorResponse.setType(URI.create("https://multirestaurant/errors/internal-error"));
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setInstance(URI.create(request.getRequestURI()));
        return errorResponse;
    }

}
