package Client;

import Server.Dao;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        int opc;

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        XmlRpcClient client = new XmlRpcClient();
        config.setServerURL(new URL("http://localhost:1200"));
        client.setConfig(config);

        System.out.println("Que desea realizar");
        System.out.println("1.- Registrar a una persona");
        System.out.println("2.- Consultar una persona");
        opc = scn.nextInt();
        switch (opc){
            case 1:
                String name, lastname, surname, sex, state, date;
                System.out.println("Por favor ingrese los datos como se le piden");
                System.out.println("Ingrese el nombre");
                name = scn.next();
                System.out.println("Ingrese el Apellido Paterno");
                lastname = scn.next();
                System.out.println("Ingrese el Apellido Materno");
                surname = scn.next();
                System.out.println("Ingrese su Sexo Hombre o Mujer");
                sex = scn.next();
                System.out.println("Ingrese el Estado de Nacimiento");
                state = scn.next();
                System.out.println("Ingrese la Fecha de Nacimiento");
                date = scn.next();

                Object [] data = {name, lastname, surname, sex, state, date};
                String response = (String) client.execute("Methods.generateCurp", data);
                System.out.println(response);

                Dao dao = new Dao();

                dao.save(name, lastname, surname, sex, state, date);

                break;
            case 2:
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
    }
}
