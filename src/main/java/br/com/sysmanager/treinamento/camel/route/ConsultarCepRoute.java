package br.com.sysmanager.treinamento.camel.route;

import javax.ws.rs.core.MediaType;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsultarCepRoute extends RouteBuilder{

	@Value("${route.consultar.cep}")
	private String rotaConsultarCep;
	
	@Override
	public void configure() throws Exception {

		from(rotaConsultarCep)
		.id("consultar-cep")
		.to("velocity:consultar-cep-soap.vm")
		.setHeader(Exchange.CONTENT_TYPE, constant(MediaType.TEXT_XML))
		.to("http4://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente")
		.log("${body}")
		.to("mock:test");
		
	}

}
