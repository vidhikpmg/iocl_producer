package in.kpmg.iocl.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs // enable web service
public class IoclWsdlConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/iocl/*");
	}

	@Bean
	public XsdSchema exchangeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/iocl.xsd"));
	}

	@Bean(name = "allExchange")
	public DefaultWsdl11Definition wsdlForExchangeData(XsdSchema exchangeSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("ExchangeData");
		defaultWsdl11Definition.setLocationUri("/iocl/allExchange");
		defaultWsdl11Definition.setTargetNamespace("http://www.kpmg.in/iocl/api");
		defaultWsdl11Definition.setSchema(exchangeSchema);
		return defaultWsdl11Definition;
	}

	@Bean
	public XsdSchema skuSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/skuAltConv.xsd"));
	}

	@Bean(name = "viewSkuAltConv")
	public DefaultWsdl11Definition wsdlForViewAll(XsdSchema skuSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("ViewSkuAltConvPort");
		defaultWsdl11Definition.setLocationUri("/iocl/viewSkuAltConv");
		defaultWsdl11Definition.setTargetNamespace("http://www.kpmg.in/iocl/SKUapi");
		defaultWsdl11Definition.setSchema(skuSchema);
		return defaultWsdl11Definition;
	}

}
