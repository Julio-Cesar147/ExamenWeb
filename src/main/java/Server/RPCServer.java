package Server;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class RPCServer {
    public static void main(String[] args) throws XmlRpcException, IOException {
        System.out.println("Initialize server...");
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        WebServer server = new WebServer(1200);
        mapping.addHandler("Methods", Methods.class);
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Waiting Request...");
    }
}
