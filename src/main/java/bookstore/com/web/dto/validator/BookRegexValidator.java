package bookstore.com.web.dto.validator;

import bookstore.com.web.dto.BookRegex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookRegexValidator implements ConstraintValidator<HasOneField, BookRegex> {
    @Override
    public void initialize(HasOneField constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BookRegex bookRegex, ConstraintValidatorContext ctx) {
        return !(bookRegex.getAuthor().equals("") && bookRegex.getTitle().equals("") && bookRegex.getSize() == null);
    }
}
