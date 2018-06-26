package ApiMethods;

import Helpers.GenerateToSHA256;
import RequestPojo.*;
import RequestPojo.initValues.Items;
import RequestPojo.initValues.Receipt;
import ResponsePojo.ResponseConfirm;
import ResponsePojo.ResponseInit;
import ResponsePojo.ResponseState;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


public class ApiMethods {


        public static ResponseInit responseInit;// = initMethod();
        public static ResponseInit responseInit2;// = initMethod2();
        public static ResponseState responseState;// = getState();
        public static ResponseState responseState2;// = getState2();
        public static ResponseConfirm responseConfirm;// = confirm();
        public static RequestAuthorize requestAuthorize;
        public static RequestState requestState;
        public static Response resp;// = finishAuthorize("testRegressBank", responseInit);
        public static Response resp2;// = finishAuthorize("testRegressTwoFiscalCPBank", responseInit2);


    public static ResponseInit initMethod(){

        RequestInitForTestClass requestInit = new RequestInitForTestClass("testRegressBank", "2000", "ch22" );
        return
                given().
                        contentType(ContentType.JSON).
                        body(requestInit)

                        .when().post("https://rest-api-test.tcsbank.ru/v2/Init")
                        .then().extract().body().as(ResponseInit.class);

    }
    public static ResponseState getState(ResponseInit responseInit){
        requestState = new RequestState
                ("testRegressBank", responseInit.getPaymentId(), GenerateToSHA256.getSha256("12345678"+responseInit.getPaymentId()+"testRegressBank"));
        return
                given().
                        contentType(ContentType.JSON).
                        body(requestState)

                        .when().post("https://rest-api-test.tcsbank.ru/v2/GetState")
                        .then().extract().body().as(ResponseState.class);
    }

    public static ResponseState getState2(ResponseInit responseInit){
        requestState = new RequestState
                ("testRegressTwoFiscalCPBank", /*responseInit2*/responseInit.getPaymentId(), GenerateToSHA256.getSha256("12345678"+responseInit.getPaymentId()+"testRegressTwoFiscalCPBank"));
        return
                given().
                        contentType(ContentType.JSON).
                        body(requestState)

                        .when().post("https://rest-api-test.tcsbank.ru/v2/GetState")
                        .then().extract().body().as(ResponseState.class);
    }

    public static Response finishAuthorize(String terminalKey, ResponseInit responseInit) {
        System.out.println("asd");
        requestAuthorize = new RequestAuthorize(terminalKey, responseInit.getPaymentId(), "PAN=4300000000000777;ExpDate=0723;CVV=428");
        return
                given().contentType(ContentType.JSON).
                        body(requestAuthorize)

                        .when().post("https://rest-api-test.tcsbank.ru/v2/FinishAuthorize")
                        .then().extract().response();
    }

    public static ResponseInit initMethod2(String orderId){

        ArrayList<Items> arr = new ArrayList<Items>();
        arr.add(new Items("Название товара 1", "100", "1.0", "500", "vat10"));
        arr.add(new Items("Название товара 1", "100", "1.0", "500", "vat10"));
        Receipt receipt = new Receipt("e.a.menkin@tinkoff.ru", "osn", arr );
        RequestInit requestInit2 = new RequestInit("testRegressTwoFiscalCPBank", "1000", orderId, receipt);
        return
                given().
                        contentType(ContentType.JSON).
                        body(requestInit2)

                        .when().post("https://rest-api-test.tcsbank.ru/v2/Init")
                        .then().extract().body().as(ResponseInit.class);
    }

    public static ResponseConfirm confirm(ResponseInit responseInit){
        RequestConfirm requestConfirm = new RequestConfirm(
                "testRegressTwoFiscalCPBank", responseInit.getPaymentId(), "1000", GenerateToSHA256.getSha256(
                        "100012345678"+responseInit.getPaymentId()+"testRegressTwoFiscalCPBank"));
        return
                given().
                        contentType(ContentType.JSON).
                        body(requestConfirm)

                        .when().post("https://rest-api-test.tcsbank.ru/v2/Confirm")
                        .then().extract().body().as(ResponseConfirm.class);
    }
}
