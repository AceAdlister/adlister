package com.codeup.adlister.util;

        import com.twilio.Twilio;
        import com.twilio.rest.api.v2010.account.IncomingPhoneNumber;
        import com.twilio.type.PhoneNumber;

public class PhoneCall {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC9f523bbfe2104922f3240e8a59101514";
  public static final String AUTH_TOKEN = "2dc431ccdc755c34b6a2214f75337b1f";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    IncomingPhoneNumber number = IncomingPhoneNumber
            .creator(new PhoneNumber("+15005550006"))
            .setVoiceUrl("http://demo.twilio.com/docs/voice.xml")
            .create();

    System.out.println(number.getSid());
  }
}