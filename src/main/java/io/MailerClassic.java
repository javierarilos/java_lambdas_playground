package io;

public class MailerClassic {
    public static void main(String[] args) {
        Mailer mailer = new Mailer();

        mailer.from("mike@ioindustres");
        mailer.to("sarah@ioindustres");
        mailer.subject("Your code really sucks");
        mailer.body("sucks... sucks... sucks... ");

        mailer.send();

        System.out.println(">>>> this code has two problems");
        System.out.println(">>>> first, there is a lot of noise... mailer, mailer, mailer, mailer");
        System.out.println(">>>> second, we don't know if we can reuse the mailer object (bug vs resource wasting)");
    }
}

class Mailer {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public void from(String addr){
        System.out.printf("from: %s %n", addr);
    }

    public void to(String addr){
        System.out.printf("to: %s %n", addr);
    }

    public void subject(String subject){
        System.out.printf("subject: %s %n", subject);
    }

    public void body(String body){
        System.out.printf("body: %s %n", body);
    }

    public void send(){
        System.out.println("... Sending ... ");
    }
}
