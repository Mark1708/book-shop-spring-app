package bookstore.com.web.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BookRegexValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface HasOneField {
    String message() default "All fields is empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
