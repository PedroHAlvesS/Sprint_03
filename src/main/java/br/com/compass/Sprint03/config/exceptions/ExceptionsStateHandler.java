package br.com.compass.Sprint03.config.exceptions;

import br.com.compass.Sprint03.models.dto.ExceptionDto;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionsStateHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(PersistenceException.class)
    public ExceptionDto handleUniqueError(PersistenceException exception) {
        String message = exception.getMessage();
        return new ExceptionDto(message, "duplicate value at name state");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ExceptionDto> handleInvalidArgument(MethodArgumentNotValidException exception) {
        List<ExceptionDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ExceptionDto error = new ExceptionDto(e.getField(), message);
            dto.add(error);
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionDto handleIllegalArgument(IllegalArgumentException exception) {
        String message = "Region not Found";
        return new ExceptionDto(message, "Invalid Region");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyReferenceException.class)
    public ExceptionDto handlePropertyReferenceException(PropertyReferenceException exception) {
        String message = exception.getMessage();
        return new ExceptionDto(message, "Invalid Property");
    }
}
