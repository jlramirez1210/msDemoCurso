package com.cursos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CursosControllerXmlTests {
	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Order(0)
	void buscarCurso() throws Exception {
		mockMvc.perform(get("/buscarxml/Python")).andDo(print());
	}	

	@Test
	@Order(1)
	void eliminarCurso() throws Exception {
		mockMvc.perform(delete("/cursoxml/Python")).andDo(print());
	}
	
	@Test
	@Order(2)
	void testCurso() throws Exception {
		mockMvc.perform(get("/cursosxml")).andDo(print());
	}
	
	@Test
	@Order(3)
	void testAlta() throws Exception{
		mockMvc.perform(post("/cursoxml")
				.contentType(MediaType.APPLICATION_XML)
				.content("<List><item><nombre>PHP 8</nombre><duracion>49</duracion><horario>tarde</horario></item></List>")
				).andDo(print());
	}
	
	@Test
	@Order(4)
	void testActualizacion() throws Exception{
		mockMvc.perform(put("/cursoxml")
				.contentType(MediaType.APPLICATION_XML)
				.content("<List><item><nombre>Spring ok</nombre><duracion>25ok</duracion><horario>tardeok</horario></item>")
				).andDo(print());
	}		
}
