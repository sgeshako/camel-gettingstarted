//package camel;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.spring.Main;
//
//public class MyRouteBuilder extends RouteBuilder {
//    public static void main(String[] args) throws Exception {
//        new Main().run(args);
//    }
// 
//    public void configure() {
//        // set up a listener on the file component
//        from("file://target/test?noop=true").beanRef("myProcessor", "process");
//    }
//}
