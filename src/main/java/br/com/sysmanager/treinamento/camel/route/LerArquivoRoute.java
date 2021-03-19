package br.com.sysmanager.treinamento.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.sysmanager.treinamento.camel.dto.PacienteDTO;

@Component
public class LerArquivoRoute extends RouteBuilder {

	@Value("${route.ler-arquivo.id}")
	private String id;
	
	@Value("${diretorio.arquivos}")
	private String diretorioArquivos;
	
	@Value("${nome.arquivo}")
	private String nomeArquivo;
	
	@Value("${route.consultar.cep}")
	private String rotaConsultarCep;

	@Override
	public void configure() throws Exception {

		final String URI = String.format("file:%s?filename=%s&noop=true", diretorioArquivos, nomeArquivo);
	
		from(URI)
		.routeId(id)
		.split()
		.jsonpath("$.*[?(@.idade > 1)]")
		.marshal()
		.json()
		.convertBodyTo(String.class)
		//.log("${body}")
		//.setProperty("cep").jsonpath("$.cep")
		//.setHeader("cep")
		//.setBody().jsonpath("$.cep")
		.setHeader("cep").jsonpath("$.cep")
		.log("${headers.cep}")
		//.log("${properties.cep}")
		
		//.log("${property.cep}")
		//.log("Executando a leitura de arquivos de clientes")
		//.log(">> body: \n${body}")
		//.log(">> cabeçalho: ${headers}")
		//.log(">> última modificação: ${headers.CamelFileLastModified}")
		//.process("testeProcessor")
		.to(rotaConsultarCep)
		.end();
		
		/*from(URI)
		.routeId(id)
		.convertBodyTo(String.class)
		.unmarshal(new ListJacksonDataFormat(PacienteDTO.class))
		//.log(">> body: \n${body}")
		.split(body())
		.process(exchange -> {
			System.out.println(((PacienteDTO) exchange.getIn().getBody()).getCep());
			exchange.setProperty("cep", ((PacienteDTO) exchange.getIn().getBody()).getCep());
			
		})
		.log("${body}")
		.log("Executando a leitura de arquivos de clientes")
		//.log(">> body: \n${body}")
		//.log(">> cabeçalho: ${headers}")
		//.log(">> última modificação: ${headers.CamelFileLastModified}")
		//.process("testeProcessor")
		//.to(rotaConsultarCep)
		.end();*/
		
		

	}

}
