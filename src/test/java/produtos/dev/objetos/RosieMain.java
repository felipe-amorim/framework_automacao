package produtos.dev.objetos;

import java.util.LinkedHashMap;

public class RosieMain {
    public static String rosieTarefasButton = "(//a[@id=\"tab_panel_task\"])[1]";


    public static LinkedHashMap<String, String> rosieMain = createData();

    private static LinkedHashMap<String, String> createData() {

        LinkedHashMap<String, String> ret = new LinkedHashMap<>();

        ret.put(rosieTarefasButton, "Login");

        return ret;
    }
}
