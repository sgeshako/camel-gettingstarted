package camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class MyProcessor {
    public void process(Exchange exchange) {
        try {
            System.out.println("process");
            Message in = exchange.getIn();
            byte[] file = in.getBody(byte[].class);
            System.out.println("bytes found:" + file.length);
        } catch (Exception e) {
            System.out.println("could not read file: " + e.getMessage());
        }
    }
}