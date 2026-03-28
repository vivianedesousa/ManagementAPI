package com.multirestaurant.managementapi.infrastructure.config.GlobalExceptionHandler;
import com.multirestaurant.managementapi.domain.exception.menuItem.InvalidProductException;
import com.multirestaurant.managementapi.domain.exception.menuItem.MenuItemNotFoundException;
import com.multirestaurant.managementapi.domain.exception.menuItem.RestaurantMenuItemNotFoundException;
import com.multirestaurant.managementapi.domain.exception.user.*;
import com.multirestaurant.managementapi.domain.exception.usertype.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.net.URI;
@RestControllerAdvice
public class GlobalExceptionHandler {
    // USER
    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        error.setTitle("User not found");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/user-not-found"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }
    @ExceptionHandler(InvalidUserException.class)
    public ProblemDetail handleInvalidUser(InvalidUserException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        error.setTitle("Invalid user");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/invalid-user"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ProblemDetail handleEmailAlreadyExists(EmailAlreadyExistsException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        error.setTitle("Email already exists");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/email-already-exists"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }

    // USER TYPE
    @ExceptionHandler(UserTypeNotFoundException.class)
    public ProblemDetail handleUserTypeNotFound(UserTypeNotFoundException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        error.setTitle("User type not found");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/user-type-not-found"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }

    @ExceptionHandler(InvalidUserTypeNameException.class)
    public ProblemDetail handleInvalidUserTypeName(InvalidUserTypeNameException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        error.setTitle("Invalid user type name");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/invalid-user-type-name"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }

    @ExceptionHandler(UserTypeAlreadyExistsException.class)
    public ProblemDetail handleUserTypeAlreadyExists(UserTypeAlreadyExistsException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        error.setTitle("User type already exists");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/user-type-already-exists"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }

    // MENU ITEM / RESTAURANT

    @ExceptionHandler(MenuItemNotFoundException.class)
    public ProblemDetail handleMenuItemNotFound(MenuItemNotFoundException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        error.setTitle("Menu item not found");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/menu-item-not-found"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }

    @ExceptionHandler(RestaurantMenuItemNotFoundException.class)
    public ProblemDetail handleRestaurantMenuItemNotFound(RestaurantMenuItemNotFoundException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        error.setTitle("Restaurant not found for menu item");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/restaurant-menu-item-not-found"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }

    @ExceptionHandler(InvalidProductException.class)
    public ProblemDetail handleInvalidProduct(InvalidProductException ex, HttpServletRequest request) {
        ProblemDetail error = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        error.setTitle("Invalid menu item");
        error.setType(URI.create("https://multirestaurant/api/v1/errors/invalid-menu-item"));
        error.setDetail(ex.getMessage());
        error.setInstance(URI.create(request.getRequestURI()));
        return error;
    }
}









