package Server;

public class Methods {

    public String generateCurp (String name, String lastname, String surname, String sexo, String state, String date){
        String lt = lastname.substring(0,2);
        String sur = surname.substring(0,1);
        String na = name.substring(0,1);
        String bt = date.substring(2,8);
        String sx = sexo.substring(0,1);
        String st = state.substring(0,1);
        String lt1 = lastname.substring(2,3);
        String sur1 = surname.substring(1,2);
        String na1 = name.substring(1,2);

        return lt+sur+na+bt+sx+st+lt1+sur1+na1;
    }

}
