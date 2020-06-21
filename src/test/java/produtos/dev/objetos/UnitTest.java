package produtos.dev.objetos;

import java.util.LinkedHashMap;

public class UnitTest {
    public static String unitTestSearchInput = "//input[@title=\"Pesquisar\"]";
    public static String unitTestSearchButton = "//div[not(@style=\"display:none\")]/div/div/center/input[@aria-label=\"Pesquisa Google\"]";


    public static LinkedHashMap<String, String> unitTest = createData();

    private static LinkedHashMap<String, String> createData() {

        LinkedHashMap<String, String> ret = new LinkedHashMap<>();
        ret.put(unitTestSearchInput, "Barra de busca");
        ret.put(unitTestSearchButton, "Pesquisar");

        return ret;
    }
}

