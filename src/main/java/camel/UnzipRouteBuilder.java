package camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.PredicateBuilder;
import org.apache.camel.builder.RouteBuilder;

public class UnzipRouteBuilder extends RouteBuilder {

	public void configure() {
		from("file:data/inbox?noop=true")
		.setHeader("johnny", simple("${file:name.ext.single}"))
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("Headers:" + exchange.getIn().getHeader("johnny"));
			}
		})
		.choice()
		.when(PredicateBuilder.and(simple("${file:name.ext.single} == 'zip'")))
			.unmarshal().zipFile()
			.to("direct:processPerson")
		.when(PredicateBuilder.and(simple("${file:name.ext.single} == 'gz'")))
			.unmarshal().gzip()
			.to("direct:processPerson");
	}

}
