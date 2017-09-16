package camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ProcessingRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		onException(Exception.class)
		.handled(true)
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				Throwable t = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
				t.printStackTrace();
			}
		});
		
		from("direct:processPerson")
			.split(body().tokenize("(?<=\\G.{30})")).streaming() // Split every 30 chars (fixed-length)
			.parallelProcessing()
			.bean(MessageToPersonBean.class)
			.process(new Processor() {
				public void process(Exchange exchange) throws Exception {
					System.out.println("Body:" + exchange.getIn().getBody());
				}
			})
			.to("jpa:camel.Person");
			//.to("file:data/outbox?fileName=zipfile.txt");
			//.to("file:data/outbox?fileName=gzipfile.txt");
	}

}
