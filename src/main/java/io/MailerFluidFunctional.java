package io;

import java.util.function.Consumer;

class MailerV3 {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public MailerV3 from(String addr) {
        System.out.printf("from: %s %n", addr);
        return this;
    }

    public MailerV3 to(String addr) {
        System.out.printf("to: %s %n", addr);
        return this;
    }

    public MailerV3 subject(String subject) {
        System.out.printf("subject: %s %n", subject);
        return this;
    }

    public MailerV3 body(String body) {
        System.out.printf("body: %s %n", body);
        return this;
    }

    public static void send(Consumer<MailerV3> mailerTransform) {
        MailerV3 mailer = new MailerV3();
        mailerTransform.accept(mailer);
        System.out.println("... Sending ... ");
    }
}

public class MailerFluidFunctional {
    public static void main(String[] args) {
        MailerV3.send(mailer ->
                        mailer
                            .from("mike@ioindustres")
                            .to("sarah@ioindustres")
                            .subject("Your code really sucks")
                            .body("sucks... sucks... sucks... "));


        System.out.println();
        System.out.println(">>>> Now, we as users, don't have to care about reusing or not the mailer... it is .send responsibility");

    }
}
