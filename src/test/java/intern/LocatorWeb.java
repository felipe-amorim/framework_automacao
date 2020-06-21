package intern;

import org.openqa.selenium.*;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class LocatorWeb {
    void locate() {
        JavascriptExecutor js = (JavascriptExecutor) Instances.getWebDriver();
        if (Instances.getWebLastElements() != null) {
            try {
                for (WebElement element : Instances.getWebLastElements()) {
                    js.executeScript("arguments[0].style.border='1px solid orange'", element);
                }
            }catch (org.openqa.selenium.StaleElementReferenceException e){
                System.out.println("--page changed--");
            }
        }
        int tempoDeEspera = Instances.getDefaultWaitMilis();
        String estadoDaPagina = String.valueOf(((JavascriptExecutor) Instances.getWebDriver()).executeScript("return document.readyState"));

        if(estadoDaPagina.equals("complete")){
            tempoDeEspera = 1000;
        }

        List<WebElement> elements = null;
        Set<String> windows = Instances.getWebDriver().getWindowHandles();
        System.out.println("Amount of pages found: " + windows.size());
        for (String pagina : windows) {
            System.out.println("Trying the page: " + pagina);
            int localTime = tempoDeEspera;
            while (true) {
                long ti = Calendar.getInstance().getTimeInMillis();
                try {
                    Instances.getWebDriver().switchTo().window(pagina);
                    int quantidadeDeFrames = Instances.getWebDriver().findElements(By.xpath("//frame")).size();
                    if (quantidadeDeFrames > 0) {
                        //System.out.println("Amount of frames found: " + quantidadeDeFrames + "");
                        for (int i = 0; i < quantidadeDeFrames; i++) {
                            Instances.getWebDriver().switchTo().frame(i);
                            //System.out.println("Trying on the frame: "+i);
                            try {
                                if(Instances.getWebLastXpath().startsWith("/")||Instances.getWebLastXpath().startsWith("(")) {
                                    elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
                                }else{
                                    elements = Instances.getWebDriver().findElements(By.id(Instances.getWebLastXpath()));
                                }
                                //elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
                                break;
                            } catch (IllegalArgumentException e1) {
                                Instances.getWebDriver().switchTo().alert();
                            } catch (WebDriverException ex) {
                                System.out.println("frame: " + i);
                            }
                        }
                    } else {
                        if(Instances.getWebLastXpath().startsWith("/")||Instances.getWebLastXpath().startsWith("(")) {
                            elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
                        }else{
                            elements = Instances.getWebDriver().findElements(By.id(Instances.getWebLastXpath()));
                        }
                        //elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
                        break;
                    }
                    //localTime = localTime - 100;
                    //Instances.getSleepWebClassInstance().until(100);
                    long tf = Calendar.getInstance().getTimeInMillis();
                    int tr = (int) (tf - ti);
                    localTime = localTime - tr;
                    System.out.println("Tempo restante para a localização: " + localTime);
                    if (localTime <= 0) {
                        break;
                    }
                } catch (InvalidSelectorException e) {
                    System.out.println("The xpath '" + Instances.getWebLastXpath() + "' is not valid");
                } catch (IllegalArgumentException e1) {
                    Instances.getWebDriver().switchTo().alert();
                } catch (WebDriverException ex) {
                    System.out.println("Could not be found on page: '" + pagina + "'");
                    if (ex.getMessage().contains("ocalhost/0:0:0:0:0:")) {
                        Instances.getReportClassInstance().stepFatal(ex);
                    }
                }
            }
            if (elements.size() > 0) {
                break;
            }
        }

        int count = elements.size();
        if (count > 1) {
            System.out.println("The xpath '" + Instances.getWebLastXpath() + "' returned " + count + " elements");
        } else if (count == 1) {
            System.out.println("The xpath '" + Instances.getWebLastXpath() + "' returned one element");
        } else {
            System.out.println("The xpath '" + Instances.getWebLastXpath() + "' returned no elements");
        }

        for (WebElement element : elements) {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        }

        //try {
        //    int localTime = Instances.getDefaultWaitMilis();
        //    System.out.println("Tempo inicial de localização: "+ Instances.getDefaultWaitMilis());
        //    while (true) {
        //        if(Instances.getWebLastXpath().startsWith("/")||Instances.getWebLastXpath().startsWith("(")) {
        //            elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
        //        }else{
        //            elements = Instances.getWebDriver().findElements(By.id(Instances.getWebLastXpath()));
        //        }
        //        if(elements.size()>0){
        //            break;
        //        }
        //        localTime = localTime - 100;
        //        Instances.getSleepWebClassInstance().until(100);
        //        System.out.println("Tempo restante para a localização: "+localTime);
        //        if(localTime<=0){
        //            break;
        //        }
        //    }
        //    int count = elements.size();
        //    if (count > 1) {
        //        System.out.println("The xpath '" + Instances.getWebLastXpath() + "' returned " + count + " elements");
        //    } else if (count == 1) {
        //        System.out.println("The xpath '" + Instances.getWebLastXpath() + "' returned one element");
        //    } else {
        //        System.out.println("The xpath '" + Instances.getWebLastXpath() + "' returned no elements");
        //    }
        //} catch (InvalidSelectorException e) {
        //    System.out.println("The xpath '" + Instances.getWebLastXpath() + "' is not valid");
        //}catch (WebDriverException e){
        //    if(e.getMessage().contains("ocalhost/0:0:0:0:0:")){
        //        Instances.getReportClassInstance().stepFatal(e);
        //    }
        //}
        Instances.setLastWindows(Instances.getWebDriver().getWindowHandles());
        Instances.setLastIeratos(Instances.getLastWindows().iterator());

        Instances.setWebLastElements(elements);
    }
}
