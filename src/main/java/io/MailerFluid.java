package io;

class MailerV2 {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public MailerV2 from(String addr) {
        System.out.printf("from: %s %n", addr);
        return this;
    }

    public MailerV2 to(String addr) {
        System.out.printf("to: %s %n", addr);
        return this;
    }

    public MailerV2 subject(String subject) {
        System.out.printf("subject: %s %n", subject);
        return this;
    }

    public MailerV2 body(String body) {
        System.out.printf("body: %s %n", body);
        return this;
    }

    public MailerV2 send() {
        System.out.println("... Sending ... ");
        return this;
    }
}

public class MailerFluid {
    public static void main(String[] args) {
        new MailerV2()
                .from("mike@ioindustres")
                .to("sarah@ioindustres")
                .subject("Your code really sucks")
                .body("sucks... sucks... sucks... ")
                .send();

        System.out.println();
        System.out.println(">>>> We eliminated the repetition and noise in the code, but we still do not know if we can reuse mailer objects");

    }
}