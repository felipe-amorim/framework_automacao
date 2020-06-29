package depreciated;

import intern.Instances;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import support.CoreWeb;

import java.util.List;


public class CoreMinTransactionWeb extends CoreWeb {


    protected static void listaIgualLista(List<String> key, String logKey, List<String> value, String logValue) {
        compareListas(key, logKey, value, logValue);
        if (key.size() != value.size()) {
            throw new WebDriverException("A lista '" + logKey + "' possui tamanho '" + key.size() + "' e a lista '" + logValue + "' possui tamanho '" + value.size() + "'.");
        }
    }

    private static void compareListas(List<String> key, String logKey, List<String> value, String logValue) {
        for (String v : value) {
            if (!key.contains(v)) {
                throw new WebDriverException("A lista '" + logValue + "' contém o elemento '" + v + "' que não está presente na lista '" + logKey + "'.");
            }
        }
    }

    protected static void listaContemLista(List<String> key, String logKey, List<String> value, String logValue) {
        compareListas(key, logKey, value, logValue);
    }

    protected static void listaNaoContemLista(List<String> key, String logKey, List<String> value, String logValue) {
        for (String k : key) {
            if (value.contains(k)) {
                throw new WebDriverException("A lista '" + logKey + "' contém o elemento '" + k + "' que está presente na lista '" + logValue + "'.");
            }
        }
    }

    public boolean getApache() {
        return true;
    }

    public void setApache(boolean apache) {

    }

    public void depurarSelenium(String xpath) {

    }

    protected int getTempoMaximoDeEsperaFixo() {
        return 0;
    }

    protected void setTempoMaximoDeEsperaFixo(int tempoMaximoDeEspera) {
        sleep().setMaxTime(tempoMaximoDeEspera);
    }

    public String retornarAtributo(Object xpath, String atributo, String log) {
        Instances.setWebLastLog(log);
        return find(xpath.toString()).get().attribute(atributo).toString();
    }

    public String retornarTexto(Object xpath, String log) {
        Instances.setWebLastLog(log);
        return find(xpath.toString()).get().text().toString();
    }

    //region Terminal //TODO IMPLEMENT INSTANCES
    /*protected  List<String> commandEx(String command) {
        List<String> resp = new ArrayList<String>();
        Process cmdProc = null;
        try {
            cmdProc = Runtime.getRuntime().exec("cmd /c " + command);
            BufferedReader stdoutReader = new BufferedReader(
                    new InputStreamReader(cmdProc.getInputStream()));
            String line;
            while ((line = stdoutReader.readLine()) != null) {
                // process procs standard output here
                System.out.println(line);
                resp.add(line);
            }
            BufferedReader stderrReader = new BufferedReader(
                    new InputStreamReader(cmdProc.getErrorStream()));
            while ((line = stderrReader.readLine()) != null) {
                // process procs standard error here
                resp.add(line);
                System.out.println(line);
            }
            int retValue = cmdProc.exitValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }*/
    //endregion

    protected void novaAbaIE() {
        //DEPRECIATED
    }

    protected void fecharAbaIE() {
        //DEPRECIATED
    }

    protected void createIE(boolean... semLimparSession) {
        if (semLimparSession[0])
            webDriver().set().browser().internetExplorer().cleanSection();
        else
            webDriver().set().browser().internetExplorer();
    }

    protected void setCompatibilidade() {
        webDriver().set().browser().internetExplorer().compability();
    }

    protected void navegar(String url) {
       // webDriver().set().browser().chrome();
       // webDriver().set().options().resolution(1440, 900);
        webDriver().navigate(url);
    }

    protected void click(Object locator, String log, float... precisao) {
        Instances.setWebLastLog(log);
        find(locator.toString()).click();
    }

    protected void selectComboBoxText(String xpath, String text, String log) {
        Instances.setWebLastLog(log);
        find(xpath).comboBox().set().byText(text);
    }

    protected void selectComboBoxValue(String xpath, String text, String log) {
        Instances.setWebLastLog(log);
        find(xpath).comboBox().set().byValue(text);
    }

    protected void selectComboBoxIndex(String xpath, int index, String log) {
        Instances.setWebLastLog(log);
        find(xpath).comboBox().set().byIndex(index);
    }

    protected void validarMensagemDePopUp(Object text, String log) {
        Instances.setWebLastLog(log);
        String msg = find().popUp().get().text();
        assertThat(msg).isEqualTo(text.toString());
    }

    protected void enviarDevagar(Object xpath, String text, String log) {
        Instances.setWebLastLog(log);
        find(xpath.toString()).send().slow().text(text);
    }

    protected void limpar(Object xpath, String log) {
        Instances.setWebLastLog(log);
        find(xpath.toString()).clear();
    }

    protected void validarNaoExistencia(Object xpath, String log) {
        //DEPRECIATED
    }

    protected void setTempoExisteCustom(int tempoExistecustom) {
        sleep().setMaxTime(tempoExistecustom);
    }

    public boolean existe(Object xpath, String log, float... precisao) {
        Instances.setWebLastLog(log);
        return find(xpath.toString()).exists();
    }

    protected void esperarDesaparecer(Object locator, String log, int tempoMaximoDeEspera, float... precisao) {
        Instances.setWebLastLog(log);
        sleep().untilDisapear(locator.toString());
    }

    protected void enviar(Object xpath, Object text, String log, String mascara) {
        Instances.setWebLastLog(log);
        find(xpath.toString()).send().text(text.toString());
    }

    protected void enviar(Object locator, Object... keyModifier) {
        find(locator.toString()).send().text(keyModifier[0].toString());
    }

    protected void enviar(Object locator, Object text, String log, Object... keyModifier) {
        Instances.setWebLastLog(log);
        System.out.println("locator: "+locator.toString());
        System.out.println("text "+text.toString());
        find(locator.toString()).send().text(text.toString());
    }

    protected void mover(Object locator, Object log, float... precisao) {
        Instances.setWebLastLog(log.toString());
        find(locator.toString()).move();
    }

    protected void validarMensagemAtributo(Object xpath, String text, String atributo, String log) {
        Instances.setWebLastLog(log);
        String msg = find(xpath.toString()).get().text().toString();
        assertThat(msg).isEqualTo(xpath.toString());
    }

    protected void validarMensagem(Object xpath, Object text, String log) {
        Instances.setWebLastLog(log);
        String msg = find(xpath.toString()).get().text().toString();
        assertThat(msg).isEqualTo(text.toString());
    }

    protected void falharCT(String erro) {
        error().Environment(erro);
    }

    protected void recusarPopUp() {
        find().popUp().deny();
    }

    protected void aceitarPopUp() {
        find().popUp().accept();
    }

    protected void esperarAguarde() {
        //DEPRECIATED
    }

    protected void fecharNavegador() {
        //DEPRECIATED
    }

    public int getTamanhoCombobox(String xpath, String log) {
        Instances.setWebLastLog(log);
        return find(xpath).comboBox().get().size();
    }

    public List<WebElement> getItensCombobox(String xpath, String log) {
        Instances.setWebLastLog(log);
        return null;
    }

    protected void rolarPaginaJs(int quanto) {
        if (quanto > 0) {
            scroll().up(quanto);
        } else {
            scroll().down(quanto);
        }
    }

    public void esperar(int tempo) {
        sleep().until(tempo);
    }

    protected void definirInteradoresParaBusca(Object proximaPagina, Object pararProximaPagina, String logproximaPagina, String logPararProximaPagina) {
        //DEPRECIATED
    }

    protected void definindoNome(Class classe, String nome) {
        //DEPRECIATED
    }

    protected void definindoNome(String caminho, String nome) {
        //DEPRECIATED
    }

    protected void trocarIFrame(Object xpath) {
        find().frame().navigate(xpath.toString());
    }

    protected void trocarIframeDefault() {
        find().frame().setDefault();
    }

    protected void clearStart() {
        //DEPRECIATED
    }

    public void setServidorApacheAplicacao(String servidorApacheAplicacao) {
        //DEPRECIATED
    }

    public void print() {
        //DEPRECIATED
    }

    protected void checkErros() {
        //DEPRECIATED
    }

    protected void checkErros(Runnable runnable, String log) {
        //DEPRECIATED
    }

    protected void setDepurar() {
        //DEPRECIATED
    }

    void setNomeComplementarDeScreenshotParaErros(String nomeComplementarDeScreenshotParaErros) {
        //DEPRECIATED
    }

    protected int getPaginasAtivas() {
        //DEPRECIATED
        return 0;
    }
}
