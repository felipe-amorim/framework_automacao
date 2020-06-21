package produtos.dev.objetos;

import java.util.LinkedHashMap;

public class RosieTarefas {
    public static String rosieQuadroMarabuButton = "//div[text()=\"FT - Automação Marabu - KanBan\"]";
    public static String rosieQuadroOjiButton = "//div[text()=\"FT - Automação Oji - KanBan\"]";
    public static String rosieQuadroIssuesButton = "//div[text()=\"FT - Automação Outros / Issues - Kanban\"]";
    public static String rosieAdicionarTarefaTodoButton = "//div[@id=\"column-to-do\"]//a[text()=\"Adicionar Tarefa...\"]";
    public static String rosieTagsInput = "//div[@class=\"tagsinput\"]//input";
    public static String rosieDescricaoInput = "//div[@id=\"cke_descricao\"]//div[@role=\"textbox\"]";
    public static String rosieTituloInput = "//input[@id=\"titleModal\"]";
    public static String rosieSalvarButton = "//button[@id=\"saveModal\"]";
    public static String rosieBoldButton = "(//div[@id=\"cke_descricao\"]//span[contains(@class, \"button__bold\")])[1]";
    public static String rosieWaitImage = "//div[@id=\"newTask\"]//img[@src=\"/assets/loader.gif\"]";
    public static String rosieTagsList = "//span[@class=\"task-tags-list\"]";


    public static LinkedHashMap<String, String> rosieTarefas = createData();

    private static LinkedHashMap<String, String> createData() {

        LinkedHashMap<String, String> ret = new LinkedHashMap<>();

        ret.put(rosieQuadroOjiButton, "Quadro Oji");
        ret.put(rosieQuadroMarabuButton, "Quadro Marabu");
        ret.put(rosieQuadroIssuesButton, "Quadro Issues");
        ret.put(rosieAdicionarTarefaTodoButton, "Adicionar Tarefa To Do");
        ret.put(rosieTagsInput, "tags");
        ret.put(rosieDescricaoInput, "descrição");
        ret.put(rosieTituloInput, "titulo");
        ret.put(rosieSalvarButton, "salvar");
        ret.put(rosieBoldButton, "bold");
        ret.put(rosieWaitImage, "wait");
        ret.put(rosieTagsList, "tags");

        return ret;
    }
}

