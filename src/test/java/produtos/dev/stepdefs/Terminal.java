package produtos.dev.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import intern.Instances;
import support.CoreWeb;

import java.util.List;

public class Terminal extends CoreWeb {
    private static String localBranch = "";

    @Given("O usuario esta na brach {string}")
    public void oUsuarioEstaNaBrach(String arg0) {
        localBranch = arg0;
        String localPath = System.getProperty("user.dir");
        if(!localPath.startsWith("c")){
            Instances.commandEx(localPath.charAt(0)+":");
        }
        Instances.commandEx("cd "+localPath);
        List<String> response = Instances.commandEx("git status");
        if(!response.get(0).contains("On branch "+arg0)){
            System.out.println("Não estava na branch "+arg0+", alterando branch");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            Instances.commandEx("git checkout "+arg0);
            response = Instances.commandEx("git status");
            if(!response.get(0).contains("On branch "+arg0)){
                System.out.println("Foi encontrado um problema ao dar checkout, processo de merge abortado!");
                System.out.println("---------------------------------------------------");
                System.out.println(response);
                System.out.println("---------------------------------------------------");
                throw new NullPointerException("Foi encontrado um problema ao dar checkout, processo de merge abortado!");
            }
        }
    }

    @When("O usuario faz merge com a branch {string}")
    public void oUsuarioFazMergeComABranch(String arg0) {
        List<String> response = Instances.commandEx("git merge "+arg0);
        boolean conflitoDesconhecido = false;
        for (String linhaResposta:response) {
            if(linhaResposta.contains("CONFLICT")){
                conflitoDesconhecido = !linhaResposta.contains("src/test/resources/jenkins_old");
            }
        }
        if(!conflitoDesconhecido){
            System.out.println("Os conflitos encontrados estavam previamente mapeados para serem ignorados, realizando um commit");
            Instances.commandEx("git commit -am \"problema de relatório\"");
        }else
        {
            System.out.println("Foi encontrado um problema não mapeado ao dar merge, processo abortado!");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            throw new NullPointerException("Foi encontrado um problema não mapeado ao dar merge, processo abortado!");
        }
    }

    @Then("O usuario atualiza a branch remota master")
    public void oUsuarioAtualizaABranchMaster() {
        Instances.commandEx("git checkout master");
        List<String> response = Instances.commandEx("git pull");
        if(!response.get(0).contains("Already up to date")){
            System.out.println("A branch master local não estava atualizada com a remota, abortando processo!");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            throw new NullPointerException("A branch master local não estava atualizada com a remota, abortando processo!");
        }
        response = Instances.commandEx("git merge "+localBranch);
        boolean conflitoDesconhecido = false;
        for (String linhaResposta:response) {
            if(linhaResposta.contains("CONFLICT")){
                conflitoDesconhecido = !linhaResposta.contains("src/test/resources/jenkins_old");
            }
        }
        if(!conflitoDesconhecido){
            System.out.println("Os conflitos encontrados estavam previamente mapeados para serem ignorados, realizando um commit");
            Instances.commandEx("git commit -am \"problema de relatório\"");
        }else
        {
            System.out.println("Foi encontrado um problema não mapeado ao dar merge, processo abortado!");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            throw new NullPointerException("Foi encontrado um problema não mapeado ao dar merge, processo abortado!");
        }
        Instances.commandEx("git push");
        Instances.commandEx("git checkout "+localBranch);
    }

    @And("O usuario atualiza a branch remota {string}")
    public void oUsuarioAtualizaABranch(String arg0) {
        Instances.commandEx("git checkout "+arg0);
        List<String> response = Instances.commandEx("git merge "+localBranch);
        boolean conflitoDesconhecido = false;
        for (String linhaResposta:response) {
            if(linhaResposta.contains("CONFLICT")){
                conflitoDesconhecido = !linhaResposta.contains("src/test/resources/jenkins_old");
            }
        }
        if(!conflitoDesconhecido){
            System.out.println("Os conflitos encontrados estavam previamente mapeados para serem ignorados, realizando um commit");
            Instances.commandEx("git commit -am \"problema de relatório\"");
        }else
        {
            System.out.println("Foi encontrado um problema não mapeado ao dar merge, processo abortado!");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            throw new NullPointerException("Foi encontrado um problema não mapeado ao dar merge, processo abortado!");
        }
        Instances.commandEx("git push");
        Instances.commandEx("git checkout "+localBranch);
    }

    @Then("O usuario atualiza a branch remota corrente")
    public void oUsuarioAtualizaABranchCorrente() {
        List<String> response = Instances.commandEx("git status");
        if(!response.get(0).contains("On branch "+localBranch)){
            System.out.println("Não estava na branch "+localBranch+", alterando branch");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            Instances.commandEx("git checkout "+localBranch);
            response = Instances.commandEx("git status");
            if(!response.get(0).contains("On branch "+localBranch)){
                System.out.println("Foi encontrado um problema ao dar checkout, processo de merge abortado!");
                System.out.println("---------------------------------------------------");
                System.out.println(response);
                System.out.println("---------------------------------------------------");
                throw new NullPointerException("Foi encontrado um problema ao dar checkout, processo de merge abortado!");
            }
        }
        Instances.commandEx("git push");
    }

    @And("O usuario atualiza a branch local {string}")
    public void oUsuarioAtualizaABranchLocal(String arg0) {
        Instances.commandEx("git checkout "+arg0);
        List<String> response = Instances.commandEx("git pull");
        boolean conflitoDesconhecido = false;
        for (String linhaResposta:response) {
            if(linhaResposta.contains("CONFLICT")){
                conflitoDesconhecido = !linhaResposta.contains("src/test/resources/jenkins_old");
            }
            if(linhaResposta.contains("overwritten")){
                conflitoDesconhecido = true;
            }
        }
        if(!conflitoDesconhecido){
            System.out.println("Os conflitos encontrados estavam previamente mapeados para serem ignorados, realizando um commit");
            Instances.commandEx("git commit -am \"problema de relatório\"");
        }else
        {
            System.out.println("Foi encontrado um problema não mapeado ao dar pull, processo abortado!");
            System.out.println("---------------------------------------------------");
            System.out.println(response);
            System.out.println("---------------------------------------------------");
            throw new NullPointerException("Foi encontrado um problema não mapeado ao dar pull, processo abortado!");
        }

        Instances.commandEx("git checkout "+localBranch);
    }
}
