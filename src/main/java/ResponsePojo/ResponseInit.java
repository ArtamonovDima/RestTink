package ResponsePojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseInit {

    @JsonProperty ("Success")
    private boolean success;
    @JsonProperty ("ErrorCode")
    private String errorCode;
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
    @JsonProperty ("PaymentURL")
    private String paymentUrl;
    @JsonProperty ("Message")
    private String message;
    @JsonProperty ("Details")
    private String details;


    public boolean getSuccess() {
        return success;
    }

    public String getErrorCode() {
        return errorCode;
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

    public String getPaymentUrl() {
        return paymentUrl;
    }

    @Override
    public String toString() {
        return "ResponseInit{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", terminalKey='" + terminalKey + '\'' +
                ", status='" + status + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount='" + amount + '\'' +
                ", paymentUrl='" + paymentUrl + '\'' +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
