package produtos.dev.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import intern.Instances;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import support.CoreWeb;

import java.io.FileInputStream;
import java.util.*;

import static produtos.dev.objetos.RosieLogin.*;
import static produtos.dev.objetos.RosieMain.rosieMain;
import static produtos.dev.objetos.RosieMain.rosieTarefasButton;
import static produtos.dev.objetos.RosieTarefas.*;
import static produtos.dev.objetos.RosieTarefas.rosieQuadroIssuesButton;

public class RosieTarefas extends CoreWeb {
    @Given("O usuario esta na pagina {string}")
    public void oUsuarioEstaNaPagina(String arg0) {
        //webDriver().set().browser().chrome().headless();
        webDriver().navigate(arg0);
    }

    @And("O usuario realiza o login")
    public void oUsuarioRealizaOLogin() {
        log().setLocator(rosieLogin);
        find(rosieUserInput).send().text("dlcastro");
        find(rosiePasswordInput).send().text("");
        find(rosieLoginButton).click();
    }

    @And("O usuario acessa a aba tarefas")
    public void oUsuarioAcessaAAbaTarefas() {
        log().setLocator(rosieMain);
        find(rosieTarefasButton).click();
    }

    @And("O usuario acessa o quadro de tarefas do projeto Marabu")
    public void oUsuarioAcessaOQuadroDeTarefasDoProjetoMarabu() {
        log().setLocator(rosieTarefas);
        find(rosieQuadroMarabuButton).click();
    }

    @And("O usuario le o arquivo excel com todos os casos de teste e cria tarefas no quadro")
    public void oUsuarioLeOArquivoExcelComTodosOsCasosDeTesteECriaTarefasNoQuadro() {
        List<List<String>> linhas = lerMaisDeUmaLinhaExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\ART_Acompanhamento_Testes_proj_02453_bussola_Regressivo_v11_subir_rosie.xlsx", "MRME", 1, 1);
        //System.out.println("linhas: "+linhas);
        List<List<String>> casosFiltrados = new ArrayList<>();
        String ct = "";
        String titulo = "";
        String preCondicao = "";
        String descricao = "";
        String resultadoEsperado = "";
        String analistaDeTesteResponsavel = "";
        String status = "";

        for (List<String> linha:linhas
             ) {
            System.out.println("-----------");
            //System.out.println(linha);
            //System.out.println("<=====================>");
            int contadorDeCelula = 0;
            for (String celula:linha) {
                contadorDeCelula++;
                //System.out.println(">--------------------<");

                switch (contadorDeCelula){
                    case 1:
                        ct = celula;
                        System.out.println("ct: "+celula);
                        break;
                    case 5:
                        System.out.println("preCondicao: "+celula);
                        preCondicao = celula;
                        break;
                    case 6:
                        System.out.println("titulo: "+celula);
                        titulo = celula;
                        break;
                    case 7:
                        System.out.println("descricao: "+celula);
                        descricao = celula;
                        break;
                    case 8:
                        System.out.println("resultadoEsperado: "+celula);
                        resultadoEsperado = celula;
                        break;
                    case 9:
                        System.out.println("analistaDeTesteResponsavel: "+celula);
                        analistaDeTesteResponsavel = celula;
                        break;
                    case 11:
                        System.out.println("status "+status);
                        status = celula;
                    break;
                }
                String[] celulaQuebrada = celula.split("\n");
                for (String linhaDaCelula:celulaQuebrada
                     ) {
                    //System.out.println("~~~~~~~~~~~~");
                    //System.out.println(linhaDaCelula);
                    //System.out.println("~~~~~~~~~~~~");
                }
                //System.out.println(">--------------------<");
            }
            if(status.toLowerCase().trim().equals("sucesso")){
                List<String> casoCorreto = new ArrayList<>();
                casoCorreto.add(ct);
                casoCorreto.add("Pré condição:\n"+preCondicao+"\n");
                casoCorreto.add(titulo);
                casoCorreto.add("Descrição:\n"+descricao+"\n");
                casoCorreto.add("Resultado esperado:\n"+resultadoEsperado+"\n");
                casoCorreto.add("Analista de teste responsável:\n"+analistaDeTesteResponsavel+"\n");
                casosFiltrados.add(casoCorreto);
            }
            //System.out.println("<=====================>");
        }
        System.out.println("filtrados: "+casosFiltrados);

        for (List<String> casoCorreto:casosFiltrados
             ) {
            //System.out.println("<=====================>");
            int contadorDeCelula = 0;
            find(rosieAdicionarTarefaTodoButton).click();

            for (String celula:casoCorreto) {
                contadorDeCelula++;
                String[] celulaQuebrada = celula.split("\n");
                for (String linhaCelula:celulaQuebrada) {
                    switch (contadorDeCelula){
                        case 1:
                            find(rosieTagsInput).send().text(linhaCelula);
                            find(rosieTagsInput).send().enter();
                            break;
                        case 2:
                            if(linhaCelula.trim().equals("Pré condição:")){
                                find(rosieBoldButton).click();
                            }
                            find(rosieDescricaoInput).send().text(linhaCelula);
                            find(rosieDescricaoInput).send().enter();
                            if(linhaCelula.trim().equals("Pré condição:")){
                                find(rosieBoldButton).click();
                            }
                            break;
                        case 3:
                            find(rosieTituloInput).send().text(linhaCelula);
                            break;
                        case 4:
                            if(linhaCelula.trim().equals("Descrição:")){
                                find(rosieBoldButton).click();
                            }
                            find(rosieDescricaoInput).send().text(linhaCelula);
                            find(rosieDescricaoInput).send().enter();
                            if(linhaCelula.trim().equals("Descrição:")){
                                find(rosieBoldButton).click();
                            }
                            break;
                        case 5:
                            if(linhaCelula.trim().equals("Resultado esperado:")){
                                find(rosieBoldButton).click();
                            }
                            find(rosieDescricaoInput).send().text(linhaCelula);
                            find(rosieDescricaoInput).send().enter();
                            if(linhaCelula.trim().equals("Resultado esperado:")){
                                find(rosieBoldButton).click();
                            }
                            break;
                        case 6:
                            if(linhaCelula.trim().equals("Analista de teste responsável:")){
                                find(rosieBoldButton).click();
                            }
                            find(rosieDescricaoInput).send().text(linhaCelula);
                            find(rosieDescricaoInput).send().enter();
                            if(linhaCelula.trim().equals("Analista de teste responsável:")){
                                find(rosieBoldButton).click();
                            }
                            break;
                    }
                }
            }
            find(rosieSalvarButton).click();
            sleep().untilDisapear(rosieWaitImage);
            //System.out.println(casoCorreto);
            //System.out.println("<=====================>");
        }
    }

    public List<List<String>> lerMaisDeUmaLinhaExcel(String path, String sheetName, int linhaI, int linhaF) {
        List<List<String>> linhas = new ArrayList<>();

        int linhaCount = 0;
        try {
            FileInputStream file = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            for (Row cells : sheet) {
                List<String> celulas = new ArrayList<>();
                linhaCount++;
                Iterator<Cell> cellIterator = cells.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            if (String.valueOf(cell.getNumericCellValue()).length() > 0) {
                                //if (linhaCount >= linhaI && linhaCount <= linhaF) {
                                    celulas.add(String.valueOf(cell.getNumericCellValue()));
                                //}
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            if (cell.getStringCellValue().length() > 0) {
                                //if (linhaCount >= linhaI && linhaCount <= linhaF) {
                                    celulas.add(cell.getStringCellValue());
                                //}
                            }
                            break;
                    }
                }
                linhas.add(celulas);
            }
            file.close();
        } catch (Exception e) {
            Instances.getReportClassInstance().stepFail(e);
            e.printStackTrace();
        }
        return linhas;
    }

    @And("O usuario le todas as tarefas do marabu")
    public void oUsuarioLeTodasAsTarefasDoMarabu() {
        String listaEmString = find(rosieTagsList).each().get().text().toString();
        List<Object> lista = convert().stringToList(listaEmString);
        List<String> singulares = new ArrayList<>();
        List<String> duplicatas = new ArrayList<>();
        for (Object o:lista) {
            if(singulares.contains(o.toString())){
                duplicatas.add(o.toString());
                System.out.println(o);
            }
            singulares.add(o.toString());
        }
    }

    @And("O usuario acessa o quadro de tarefas de issues")
    public void oUsuarioAcessaOQuadroDeTarefasDeIssues() {
        log().setLocator(rosieTarefas);
        find(rosieQuadroIssuesButton).click();
    }


    String[][] issues = {
            {"spacely","spacely_fase1_administrador.CT_63 - Validar colunas da tabela de grupos de acesso"," acesso ao banco"},
            {"spacely","spacely_fase1_criterio.CT_56 - Validar colunas da tabela de criterios"," acesso ao banco"},
            {"spacely","spacely_fase1_criterio.CT_57 - Validar a não duplicidade do identificador na tabela criterios"," acesso ao banco"},
            {"spacely","spacely_fase1_criterio.CT_14 - Validar busca de critério por paginação"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase1_criterio.CT_25 - Validar exibição de questões"," outro elemento estava na frente"},
            {"spacely","spacely_fase1_executar.CT_60 - Validar colunas da tabela de auditorias realizadas"," acesso ao banco"},
            {"spacely","spacely_fase1_executar.CT_61 - Validar colunas da tabela de auditorias resultados"," acesso ao banco"},
            {"spacely","spacely_fase1_executar.CT_30 - Validar o combo Auditoria"," revisar sql/tabelas"},
            {"spacely","spacely_fase1_executar.CT_31 - Validar o combo Questionário"," revisar sql/tabelas"},
            {"spacely","spacely_fase1_executar.CT_32 - Validar o combo Versão do Questionário"," revisar sql/tabelas"},
            {"spacely","spacely_fase1_importar_usuario_do_AD.CT_62 - Validar colunas da tabela de usuários ativos do AD"," acesso ao banco"},
            {"spacely","spacely_fase1_login.CT_47 - Validar 1º login de usuário sem acesso a nenhum grupo"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase1_nao_conformidade.CT_45 - Validar emissão de relatórios de NC's"," localhost"},
            {"spacely","spacely_fase1_processo.CT_52 - Validar colunas da tabela de processos"," acesso ao banco"},
            {"spacely","spacely_fase1_processo.CT_53 - Validar a não duplicidade do identificador na tabela processos"," acesso ao banco"},
            {"spacely","spacely_fase1_processo.CT_02 - Validar busca de processo por paginação"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase1_processo.CT_08 - Validar busca de questionário por paginação"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase1_questoes.CT_58 - Validar colunas da tabela de questionamentos"," acesso ao banco"},
            {"spacely","spacely_fase1_questoes.CT_59 - Validar a não duplicidade do identificador na tabela de questoes"," acesso ao banco"},
            {"spacely","spacely_fase1_questoes.CT_18 - Validar busca de questão por paginação"," localhost"},
            {"spacely","spacely_fase1_versao.CT_28 - Validar questões de versão finalizada"," localhost"},
            {"spacely","spacely_fase1_vizualizar_auditoria.CT_42 - Validar combo de auditorias em Visualizar Auditoria"," revisar sql/tabelas"},
            {"spacely","spacely_fase1_vizualizar_auditoria.CT_44 - Acesso à Visulização de Auditoria por grupo padrão"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_enviar_notificacoes.CT_13 - Validar colunas da tabela de notificações"," acesso ao banco"},
            {"spacely","spacely_fase2_executar.CT_07 - Validar os status Aberto e Encerrado"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_executar.CT_08 - Validar o filtro por qualquer campo da tabela"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_executar.CT_10 - Validar edição de plano de ação"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_executar.CT_13 - Validar a substituição dos botões Salvar e Cancelar pelo Voltar"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_executar.CT_01 - Encerrar auditoria com questões respondidas"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_executar.CT_04 - Encerrar auditoria com todas questões C"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_executar.CT_05 - Encerrar auditoria com todas questões NC"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_executar.CT_06 - Encerrar auditoria com todas questões NA"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_executar.CT_10 - Alterar auditor de auditoria não encerrada"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_executar.CT_24 - Validar a exibição dos comboboxes"," revisar sql/tabelas"},
            {"spacely","spacely_fase2_executar.CT_41 - Validar colunas da tabela de adp"," acesso ao banco"},
            {"spacely","spacely_fase2_gerar_grafico.CT_42 - Validar exibição de auditorias realizadas com status A e adp gerado"," revisar sql/tabelas"},
            {"spacely","spacely_fase2_gerar_grafico.CT_46 - Validar geração de gráfico com uma auditoria"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_47 - Validar geração de gráfico com mais de uma auditoria"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_48 - Validar geração de gráfico com mais de uma barra verde"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_49 - Validar geração de gráfico com uma barra amarela"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_50 - Validar geração de gráfico com mais de uma barra amarela"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_51 - Validar geração de gráfico com uma barra vermelha"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_52 - Validar geração de gráfico com mais de uma barra vermelha"," acionamento do jrobot"},
            {"spacely","spacely_fase2_gerar_grafico.CT_53 - Validar geração de gráfico com uma barra verde uma amarela e uma vermelha"," acionamento do jrobot"},
            {"spacely","spacely_fase2_importar_usuarios_do_AD.CT_12 - Validar a coluna status do usuario no banco"," acesso ao banco"},
            {"spacely","spacely_fase2_plano_de_acao.CT_06 - Validar cadastro de plano de ação com NC"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_plano_de_acao.CT_14 - Validar plano de ação com várias NCs"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_plano_de_acao.CT_15 - Validar NC vinculada a várias ações"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_visualizar_NCs_em_atraso.CT_26 - Validar a exibição de auditorias com NCs em atraso"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_visualizar_NCs_em_atraso.CT_37 - Validar o campo CC do email de escalar auditoria com uma NC em atraso"," revisar passos/xpath/sql"},
            {"spacely","spacely_fase2_visualizar_NCs_em_atraso.CT_38 - Validar as variáveis do email de escalar auditoria com uma NC em atraso"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_visualizar_auditoria.CT_38 - Executar auditoria sem marco com fase e 1 auditoria"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_visualizar_auditoria.CT_39 - Executar auditoria sem marco com fase e 2 auditorias"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_visualizar_auditoria.CT_40 - Executar auditoria sem marco sem fase e 1 auditoria"," não retornou nenhum elemento/revisar xpath"},
            {"spacely","spacely_fase2_visualizar_auditoria.CT_41 - Executar auditoria sem marco sem fase e 2 auditorias"," não retornou nenhum elemento/revisar xpath"}
    };


    @And("O usuario insere todos os issues pendentes")
    public void oUsuarioInsereTodosOsIssuesPendentes() {
        for (String[] issue:issues
        ) {
            //System.out.println("<=====================>");
            int contadorDeCelula = 0;
            find(rosieAdicionarTarefaTodoButton).click();

            for (String celula:issue) {
                contadorDeCelula++;
                String[] celulaQuebrada = celula.split("\n");
                for (String linhaCelula:celulaQuebrada) {
                    switch (contadorDeCelula){
                        case 1:
                            find(rosieTagsInput).send().text(linhaCelula);
                            find(rosieTagsInput).send().enter();
                            break;
                        case 2:
                            find(rosieTituloInput).send().text(linhaCelula);
                            find(rosieTagsInput).send().text(linhaCelula);
                            find(rosieTagsInput).send().enter();
                            break;
                        case 3:
                            find(rosieDescricaoInput).send().text(linhaCelula);
                            find(rosieDescricaoInput).send().enter();
                            break;
                    }
                }
            }
            find(rosieSalvarButton).click();
            sleep().untilDisapear(rosieWaitImage);
            //System.out.println(casoCorreto);
            //System.out.println("<=====================>");
        }
    }

    @And("O usuario testa o banco postgres")
    public void oUsuarioTestaOBancoPostgres() {

        db().set().type().postgres();
        db().set().adress("10.230.231.37");
        db().set().port("5432");
        db().set().name("marabu_desenv");
        db().set().user("msoliveira");
        db().set().password("art123");
        db().execute("select * from marabu_desenv.public.os o");

    }

    @And("O usuario acessa o quadro de tarefas do projeto Oji")
    public void oUsuarioAcessaOQuadroDeTarefasDoProjetoOji() {
        log().setLocator(rosieTarefas);
        find(rosieQuadroOjiButton).click();
    }
}
