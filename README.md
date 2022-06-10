# Api_spring 
## CRUD

Iniciando </br>
git clone https://github.com/rafaelmarcolino22/Api_spring.git </br>
cd Api_spring </br>
git remote set-url origin https://github.com/rafaelmarcolino22/backend-Spring-crud.git </br>
$ git push -u origin main


## Validation


import javax.validation.constraints.NotEmpty;</br>


		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>6.0.13.Final</version>
		</dependency>

		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>2.0.1.Final</version>
		</dependency>



## Pagination URL
````
http://localhost:8080/categorias/page?linesPerPage=3&page=0

````
** Create Validaion CPF CNPJ

````

path(\services.validation)

clienteInsert

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
@Constraint(validatedBy = NomeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)


public @interface Nome {
 String message() default "Erro de validação";
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
}


ClienteInsertValidation

Validator:
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NomeValidator implements ConstraintValidator<Nome, Tipo> {
 @Override
 public void initialize(Nome ann) {
 }
 @Override
 public boolean isValid(Tipo objDto, ConstraintValidatorContext context) {
 List<FieldMessage> list = new ArrayList<>();
 
 // inclua os testes aqui, inserindo erros na lista
 
 for (FieldMessage e : list) {
 context.disableDefaultConstraintViolation();
 context.buildConstraintViolationWithTemplate(e.getMessage())
 .addPropertyNode(e.getFieldName()).addConstraintViolation();
 }
 return list.isEmpty();
 }
}

````
