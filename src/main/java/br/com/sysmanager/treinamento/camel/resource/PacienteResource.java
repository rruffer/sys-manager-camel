package br.com.sysmanager.treinamento.camel.resource;

import javax.ws.rs.core.MediaType;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class PacienteResource extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
		.component("servlet")
		  .enableCORS(true)
		  .apiContextPath("/api-doc")
		  .apiProperty("api.title", "Test REST API")
		  .apiProperty("api.version", "v1")
		  .apiContextRouteId("doc-api")
		.bindingMode(RestBindingMode.auto);
		
		rest("/pacientes")
		.id("api-pacientes")
		.description("api de pacientes")
		.consumes(MediaType.APPLICATION_JSON)
		.produces(MediaType.APPLICATION_JSON)
		
		.get()
		.description("Consultar Pacientes")
		/*.param()
		.name("cidade")
		.type(RestParamType.query)
		.dataType("string")
		.required(true)
		.endParam()*/
		.responseMessage()
		.code(200)
		.message("Ok...processamento recebido!")
		.endResponseMessage()
		//.post()
		.route()
		.id("get-api-pacientes")
		.log("Entrou na rota clientes")
		.endRest();
		
	}

}
