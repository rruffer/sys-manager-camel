/*
 * package br.com.sysmanager.treinamento.camel.config;
 * 
 * import org.apache.camel.component.servlet.CamelHttpTransportServlet; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.boot.web.servlet.ServletRegistrationBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * @Configuration public class RestConfig {
 * 
 * @Value("${app.context.path}") private String path;
 * 
 * @Bean
 * 
 * @SuppressWarnings({ "rawtypes", "unchecked" }) public ServletRegistrationBean
 * registrationBean() {
 * 
 * ServletRegistrationBean servletRegistrationBean = new
 * ServletRegistrationBean(new CamelHttpTransportServlet(),
 * String.format("/%s/*", path));
 * servletRegistrationBean.setName("CamelServlet");
 * 
 * return servletRegistrationBean; }
 * 
 * }
 */