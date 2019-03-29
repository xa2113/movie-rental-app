package com.eileen.presentation;

import com.eileen.logic.token.TokenInvalidException;
import com.eileen.logic.user.UserInvalidException;
import com.eileen.presentation.web.SearchRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("searchRequest", new SearchRequest());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Token credential incorrect.")
    @ExceptionHandler(TokenInvalidException.class)
    public String handleTokenInvalidException(){
        return "fdsafsad";
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User credential incorrect.")
    @ExceptionHandler(UserInvalidException.class)
    public void handleUserInvalidException(){}
}
