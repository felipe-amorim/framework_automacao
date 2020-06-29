package intern;

import org.openqa.selenium.*;

import java.util.ArrayList;
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
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("--page changed--");
            }
        }
        int tempoDeEspera = Instances.getDefaultWaitMilis();

        if (Instances.getPageLoad()){
            String estadoDaPagina = String.valueOf(((JavascriptExecutor) Instances.getWebDriver()).executeScript("return document.readyState"));
            if(estadoDaPagina.equals("complete")){
                tempoDeEspera = 1000;
            }
        }

        List<WebElement> elements = new ArrayList<>();
        Set<String> windows = Instances.getWebDriver().getWindowHandles();
        System.out.println("Amount of pages found: " + windows.size());
        for (String pagina : windows) {
            System.out.println("Trying the page: " + pagina);
            int localTime = tempoDeEspera;
            while (true) {
                long ti = Calendar.getInstance().getTimeInMillis();
                long tf = Calendar.getInstance().getTimeInMillis();
                int tr = (int) (tf - ti);
                Instances.getWebDriver().switchTo().window(pagina);
                try {
                    if (Instances.getWebLastXpath().startsWith("/") || Instances.getWebLastXpath().startsWith("(")) {
                        elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
                    } else {
                        elements = Instances.getWebDriver().findElements(By.id(Instances.getWebLastXpath()));
                    }
                } catch (IllegalArgumentException e1) {
                    Instances.getWebDriver().switchTo().alert();
                } catch (NoAlertPresentException ignored) {

                }
                tf = Calendar.getInstance().getTimeInMillis();
                tr = (int) (tf - ti);
                localTime = localTime - tr;
                if (localTime <= 0) {
                    break;
                }
                if (elements.size() > 0) {
                    break;
                } else {
                    int quantidadeDeFrames = Instances.getWebDriver().findElements(By.xpath("//frame")).size();
                    quantidadeDeFrames += Instances.getWebDriver().findElements(By.xpath("//iframe")).size();
                    if (quantidadeDeFrames > 0) {
                        for (int i = 0; i < quantidadeDeFrames; i++) {
                            ti = Calendar.getInstance().getTimeInMillis();
                            System.out.println(Instances.getWebLastXpath());
                            try {
                                Instances.getWebDriver().switchTo().frame(i);
                                if (Instances.getWebLastXpath().startsWith("/") || Instances.getWebLastXpath().startsWith("(")) {
                                    elements = Instances.getWebDriver().findElements(By.xpath(Instances.getWebLastXpath()));
                                } else {
                                    elements = Instances.getWebDriver().findElements(By.id(Instances.getWebLastXpath()));
                                }
                                if (elements.size() > 0) {
                                    break;
                                }
                            } catch (IllegalArgumentException e1) {
                                Instances.getWebDriver().switchTo().alert();
                            } catch (NoAlertPresentException ignored) {

                            }
                            tf = Calendar.getInstance().getTimeInMillis();
                            tr = (int) (tf - ti);
                            localTime = localTime - tr;
                            if (localTime <= 0) {
                                break;
                            }
                        }
                    }
                }
                if (elements.size() > 0) {
                    break;
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

        Instances.setLastWindows(Instances.getWebDriver().getWindowHandles());
        Instances.setLastIeratos(Instances.getLastWindows().iterator());

        Instances.setWebLastElements(elements);
    }
}
