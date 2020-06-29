package support.rest;

import intern.Instances;
import org.json.JSONObject;

public class ResponseBodyREST {
    public void mustBe(JSONObject json){

    }

    public void mustHave(String key){
        if(Instances.getRestLastResponse().size()>0){
            JSONObject json = Instances.getRestLastResponse().get(0);
            if(json.has(key) || json.toString().contains("\""+key+"\":")){
                Instances.getReportClassInstance().stepPass(Instances.getMessageRESTResponseContains().replace("arg0", key));
            }else {
                Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNotContains().replace("arg0", key)));
            }
        }else {
            Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNull()));
        }
    }

    public void mustHave(String key, String value){

    }
}
