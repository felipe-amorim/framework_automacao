package depreciated;

import intern.Instances;
import org.openqa.selenium.WebDriverException;
import support.CoreScreen;

import java.io.File;

public class CoreMinTransactionScreen extends CoreScreen {


    protected int getTempoMaximoDeEsperaFixo() {
        return 0;
    }

    protected void setTempoMaximoDeEsperaFixo(int tempoMaximoDeEspera) {
        //sleep().setMaxTime(tempoMaximoDeEspera);
        sleep().setMaxTime(tempoMaximoDeEspera);
    }

    protected void instanciarTela(int width, int height) {
        //screen().set().dimension(width, height);
    }

    //region Terminal //TODO INCLUE INSTANCES
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

    protected void click(Object locator, String log) {//todo done
        Instances.setScreenLastLog(log);
        find(locator.toString()).click();
        //find(locator.toString()).click();
    }

    protected void checkErros(Runnable runnable, String log){
        //Instances.setScreenLastLog(log);

    }

    public static void click() {//todo done
        //IMPLEMENTS ROBOT CLICK
        support.CoreScreen.click();
    }

    protected void click(Object locator, String log, float... precisao) {//todo done
        Instances.setScreenLastLog(log);
        find(locator.toString()).precision(precisao[0]).click();
        //screen().set().defaultPrecision(precisao[0]);
        //find(locator.toString()).click();
    }

    protected  void enviarDevagar(Object xpath, String text, String log) {//todo done
        Instances.setScreenLastLog(log);
        send().slow().text(xpath.toString());
        //send().slow().text(text);
    }

    protected  void validarNaoExistencia(Object xpath, String log) {
        if (find(xpath.toString()).exists()) throw new WebDriverException("O elemento: '" + log + "' não deveria existir");
    }


    protected  void setTempoExisteCustom(int tempoExistecustom) {
        //sleep().setMaxTime(tempoExistecustom);
    }

    public  boolean existe(Object xpath, String log, float... precisao) { //todo done
        Instances.setScreenLastLog(log);

        //find(xpath.toString());
        return find(xpath.toString()).exists();
    }


    protected  void esperarDesaparecer(Object locator, String log, int tempoMaximoDeEspera, float... precisao) {
        Instances.setScreenLastLog(log);

        //sleep().setMaxTime(tempoMaximoDeEspera);
        Instances.setScreenLastPrecision(precisao[0]);
        //screen().set().defaultPrecision(precisao[0]);
        sleep().untilDisapear(locator.toString());
    }

    protected  void enviar(Object locator, Object... keyModifier) {//todo done
        //send().keys(Integer.parseInt(keyModifier[0].toString()));
        send().keys(locator);
    }

    protected  void enviar(Object locator, Object text, String log, Object... keyModifier) {//todo done
        //Instances.setScreenLastLog(log);
        send().keys(locator, text);
        //send().text(text.toString());
    }

    protected  void mover(Object locator, Object log, float... precisao) {//todo done
        try {
            move().relative((int) locator, (int) log);
        }catch (java.lang.ClassCastException e){
            try{
                float p = precisao[0];
                Instances.setScreenLastLog(String.valueOf(log));
                find(locator.toString()).precision(p).move();
            }catch (ArrayIndexOutOfBoundsException e1){
                Instances.setScreenLastLog(String.valueOf(log));
                find(locator.toString()).move();
            }
        }
        //if(locator.toString().startsWith("/")){
        //    //move().toImage(locator.toString());
        //}else {
        //    //move().relative(Integer.parseInt(locator.toString()), Integer.parseInt(locator.toString()));
        //}
    }


    protected  void falharCT(String erro) {
        error().Environment(erro);
    }


    public  void esperar(int tempo) {
        //sleep().until(tempo);
        sleep().until(tempo);
    }

    public  void print() {

    }

    protected void setDepurar() {

    }

    public  boolean validarSeImagensSaoIguais(File ultimaImagem, File screenshot) {
        //assertThat().imageEqualsImage(ultimaImagem, screenshot);
        return false;
    }

}
