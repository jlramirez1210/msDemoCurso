package com.cursos.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cursos.model.CursoXml;

@RestController
public class CursosControllerXml {
	List<CursoXml> CursoXmls;
	
	@PostConstruct
	public void init() {
		CursoXmls = new ArrayList<>();
		CursoXmls.add(new CursoXml("Spring",25,"tarde"));
		CursoXmls.add(new CursoXml("Spring boot",20,"tarde"));
		CursoXmls.add(new CursoXml("Python",30,"tarde"));
		CursoXmls.add(new CursoXml("Java EE",50,"fin de semana"));
		CursoXmls.add(new CursoXml("Java básico",30,"mañana"));
	}
	
	@GetMapping(value = "cursoxml", produces = MediaType.APPLICATION_XML_VALUE)
	public CursoXml getCursoXml() {
		return new CursoXml("Java", 100, "Mañana");
	}
	
	@GetMapping(value = "cursosxml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<CursoXml> getCursoXmls(){
		return CursoXmls;
	}
	
	@GetMapping(value = "buscarxml/{name}", produces = MediaType.APPLICATION_XML_VALUE)
	public List<CursoXml> buscar(@PathVariable("name") String name){
		List<CursoXml> aux = new ArrayList<>();
		for(CursoXml c:CursoXmls) {
			if(c.getNombre().contains(name)) {
				aux.add(c);
			}
		}
		return aux;
	}
}
