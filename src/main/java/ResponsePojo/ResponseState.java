package ResponsePojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseState {

    @JsonProperty("Success")
    private boolean success;
    @JsonProperty ("ErrorCode")
    private String errorCode;
    @JsonProperty ("Message")
    private String message;
    @JsonProperty ("TerminalKey")
    private String terminalKey;
    @JsonProperty ("Status")
    private String status;
    @JsonProperty ("PaymentId")
    private String paymentId;
    @JsonProperty ("OrderId")
    private String orderId;
    @JsonProperty ("Amount")
    private String amount;
    @JsonProperty ("Details")
    private String details;

    public boolean getSuccess() {
        return success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getTerminalKey() {
        return terminalKey;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getAmount() {
        return amount;
    }
}
