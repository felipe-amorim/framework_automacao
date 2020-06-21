package produtos.dev.objetos;

import java.util.LinkedHashMap;

public class RosieLogin {
    public static String rosieUserInput = "//input[@id=\"username\"]";
    public static String rosiePasswordInput = "//input[@id=\"password\"]";
    public static String rosieLoginButton = "//button";


    public static LinkedHashMap<String, String> rosieLogin = createData();

    private static LinkedHashMap<String, String> createData() {

        LinkedHashMap<String, String> ret = new LinkedHashMap<>();

        ret.put(rosieUserInput, "Usuario");
        ret.put(rosiePasswordInput, "Senha");
        ret.put(rosieLoginButton, "Login");

        return ret;
    }
}
