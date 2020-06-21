package produtos.dev.objetos;

import java.util.LinkedHashMap;

public class DesenvolvimentoSikuli {
    public static String img1 = "D:\\Projetos\\Java\\fabrica_de_testes_automacao\\src\\test\\resources\\tt.png";
    public static String img2 = "D:\\Projetos\\Java\\fabrica_de_testes_automacao\\src\\test\\resources\\tt2.png";
    public static String img3 = "D:\\Projetos\\Java\\fabrica_de_testes_automacao\\src\\test\\resources\\tt3.png";


    public static LinkedHashMap<String, String> desenvolvimentoSikuli = createData();

    private static LinkedHashMap<String, String> createData() {

        LinkedHashMap<String, String> ret = new LinkedHashMap<>();

        ret.put(img1, "Imagem teste 1");
        ret.put(img2, "Imagem teste 2");
        ret.put(img3, "Imagem teste 3");

        return ret;
    }
}
