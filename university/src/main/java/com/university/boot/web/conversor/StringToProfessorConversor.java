package com.university.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.university.boot.domain.Professor;
import com.university.boot.service.ProfessorService;



@Component
public class StringToProfessorConversor implements Converter<String, Professor> {

	@Autowired
	private ProfessorService service;
	
	@Override
	public Professor convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
