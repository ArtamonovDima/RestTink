package Helpers;

import java.util.Random;

public class GenerateOrderId {


    public static String createOrder(int length)
    {
        String validChars = "abcdefghijklmnopqrstuvwxyz";
        String resChars = "";
        Random rnd = new Random();
        while (0 < length--){ resChars += validChars.charAt(rnd.nextInt(validChars.length()));}
            int i = rnd.nextInt(10);
        return resChars + i;
    }




}
