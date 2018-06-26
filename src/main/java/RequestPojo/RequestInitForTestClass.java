package RequestPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestInitForTestClass {

    @JsonProperty("TerminalKey")
    private String terminalKey;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("OrderId")
    private String orderId;


    public RequestInitForTestClass (String terminalKey, String amount, String orderId){
        this.terminalKey=terminalKey;
        this.amount=amount;
        this.orderId=orderId;
    }
}
