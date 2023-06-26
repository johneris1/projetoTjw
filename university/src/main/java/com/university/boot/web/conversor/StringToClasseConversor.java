package com.university.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;

import com.university.boot.domain.Classe;
import com.university.boot.service.ClasseService;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToClasseConversor implements Converter<String, Classe>  {
	@Autowired
	private ClasseService service;

	@Override
	public Classe convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
