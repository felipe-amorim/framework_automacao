package support.rest;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import intern.Instances;
import org.json.JSONObject;

public class ResponseBodyREST {
    public void mustBe(JSONObject json){
        if(Instances.getRestLastResponse().size()>0){
            JSONObject jsono = Instances.getRestLastResponse().get(0);
            if(json.toString().equals(jsono.toString())){
                Instances.getReportClassInstance().stepPass(Instances.getMessageRESTResponseEquals());
                Instances.getReportClassInstance().stepMarkUp(MarkupHelper.createCodeBlock(String.valueOf(Instances.getRestLastResponse().get(0))));
            }else {
                Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals());
                Instances.getReportClassInstance().stepMarkUp(MarkupHelper.createCodeBlock(String.valueOf(json)));
                Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals2());
                Instances.getReportClassInstance().stepMarkUp(MarkupHelper.createCodeBlock(String.valueOf(Instances.getRestLastResponse().get(0))));
                Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNotEqualsMessage()));
            }
        }else {
            Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals2());
            Instances.getReportClassInstance().stepInfo(Instances.getRestLastResponse().toString());
            Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNull()));
        }
    }

    public void mustHave(String key){
        if(Instances.getRestLastResponse().size()>0){
            JSONObject json = Instances.getRestLastResponse().get(0);
            if(json.has(key) || json.toString().contains("\""+key+"\":")){
                Instances.getReportClassInstance().stepPass(Instances.getMessageRESTResponseContains().replace("arg0", key));
            }else {
                Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals2());
                Instances.getReportClassInstance().stepInfo(Instances.getRestLastResponse().toString());
                Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNotContains().replace("arg0", key)));
            }
        }else {
            Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals2());
            Instances.getReportClassInstance().stepInfo(Instances.getRestLastResponse().toString());
            Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNull()));
        }
    }

    public void mustHave(String key, String value){
        if(Instances.getRestLastResponse().size()>0){
            JSONObject json = Instances.getRestLastResponse().get(0);
            if(json.toString().contains("\""+key+"\":\""+value+"\"")){
                Instances.getReportClassInstance().stepPass(Instances.getMessageRESTResponseContainsKeyAndValue().replace("arg0", key).replace("arg1", value));
            }else {
                Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals2());
                Instances.getReportClassInstance().stepInfo(Instances.getRestLastResponse().toString());
                Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNotContainsKeyAndValue().replace("arg0", key).replace("arg1", value)));
            }
        }else {
            Instances.getReportClassInstance().stepInfo(Instances.getMessageRESTResponseNotEquals2());
            Instances.getReportClassInstance().stepInfo(Instances.getRestLastResponse().toString());
            Instances.getReportClassInstance().stepFail(new Throwable(Instances.getMessageRESTResponseNull()));
        }
    }
}
