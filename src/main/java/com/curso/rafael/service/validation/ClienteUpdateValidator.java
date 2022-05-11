package com.curso.rafael.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.curso.rafael.domain.Cliente;
import com.curso.rafael.dto.ClienteDTO;
import com.curso.rafael.repositories.ClienteRepository;
import com.curso.rafael.resource.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository clieRepository;
	
	@Override
	public void initialize(ClienteUpdate ann)  {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer urild = Integer.parseInt(map.get("id"));	
		
		List<FieldMessage> list = new ArrayList<>();
				
		Cliente aux = clieRepository.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(urild)) {
			list.add(new FieldMessage("email" ,"email ja existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessege()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
