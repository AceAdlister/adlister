package com.codeup.adlister.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC9f523bbfe2104922f3240e8a59101514";
  public static final String AUTH_TOKEN = "2dc431ccdc755c34b6a2214f75337b1f";

  public static void sendTxt(String phoneNumber, String textMessage) {

      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

      Message message = Message.creator(new PhoneNumber("+1" + phoneNumber),
              new PhoneNumber("+17377779078"),
              textMessage).create();
      System.out.println("Sending Twilio Message: ");
      System.out.println(message.getSid());
    }

  public static void main(String[] args) {

    /*sendTxt("5124609103", "Test message from Chase's Java App");*/

  }

}