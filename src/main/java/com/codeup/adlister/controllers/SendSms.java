package com.codeup.adlister.controllers;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC9f523bbfe2104922f3240e8a59101514";
  public static final String AUTH_TOKEN = "2dc431ccdc755c34b6a2214f75337b1f";

  public static void main(String[] args) {

    String phoneNumber = "5129633276";

      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

      Message message = Message.creator(new PhoneNumber("+1" + phoneNumber),
              new PhoneNumber("+17377779078"),
              "This is a message from Chase and Erik's List Application!").create();
      System.out.println("Sending Twilio Message: ");
      System.out.println(message.getSid());
    }



}