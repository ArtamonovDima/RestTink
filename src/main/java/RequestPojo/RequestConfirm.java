package RequestPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestConfirm {

    @JsonProperty ("TerminalKey")
    private String terminalKey;
    @JsonProperty ("PaymentId")
    private String paymentId;
    @JsonProperty ("Amount")
    private String amount;
    @JsonProperty ("Token")
    private String token;

    public RequestConfirm(String terminalKey, String paymentId, String amount, String token){
        this.terminalKey = terminalKey;
        this.paymentId = paymentId;
        this.amount = amount;
        this.token = token;
    }
}
