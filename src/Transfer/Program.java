package Transfer;

public class Program {


    public static void main(String[] args) {


        BankAccount konto1 = new BankAccount("05832800072002000839570009");
        BankAccount konto2 = new BankAccount("25930829972002450910239909");
        BankAccount konto3 = new BankAccount("56882001394662839123004437");
        BankAccount konto4 = new BankAccount("");
        BankAccount konto5 = new BankAccount("65844003330234588100354390");

        konto1.setOwner("Marian Zielony");
        konto1.setBalance(440.54);

        konto2.setOwner("Sklep spożywczy Atena");
        konto2.setBalance(5400.00);

        konto3.setOwner("Elvis Wiecznieżywy");
        konto3.setBalance(780.21);

        konto4.setOwner("Bankomat");

        konto5.setOwner("ogrodowegadzety.pl");
        konto5.setBalance(143549.48);

        HistoryView historia1 = new HistoryView(); //historia Zielonego
        HistoryView historia3 = new HistoryView(); //historia elvisa

        // operacje

        System.out.println("Stan konta: "+konto1.getBalance());
        System.out.println("");

        historia1.addtransact(new TransferAction("Za żarcie",30.00,"Transfer", "11-04-2016 10:20:56",konto1,konto3,true));
        historia3.addtransact(new TransferAction("Za żarcie",30.00,"Transfer", "11-04-2016 10:20:56",konto1,konto3,false));

        historia1.addtransact(new TransferAction("Artykuły spożywcze",24.78,"Card", "05-03-2017 17:10:43",konto1,konto2,true));
        historia1.addtransact(new TransferAction("Wypłata gotówki",50.00,"ATM", "18-07-2017 09:18:05",konto4,konto1,true));
        historia1.addtransact(new TransferAction("Zamówienie nr 1234/2017",120.00,"Transfer", "16-12-2017 10:20:56",konto1,konto5,true));
        historia1.addtransact(new TransferAction("Zwrot",10.00,"Transfer", "04-02-2018 10:20:56",konto3,konto1,true));

        System.out.println("================Wszystkie===============");
        historia1.allTransacts();

        System.out.println("Stan konta: "+konto1.getBalance());


        System.out.println("================Zakres===============");
        historia1.dateTransacts("05-02-2017 10:00:00","05-08-2017 10:00:00"); // historia - zakres

        historia3.addtransact(new TransferAction("Wypłata gotówki",20.00,"ATM", "12-02-2017 20:45:13",konto4,konto3,false));
        historia3.addtransact(new TransferAction("Artykuły spożywcze",42.15,"Card", "22-04-2017 07:12:33",konto3,konto2,false));

        System.out.println("================Wszystkie===============");
        historia3.allTransacts();

        System.out.println("================Zakres===============");
        historia3.dateTransacts("01-01-2017 10:00:00","01-03-2017 10:00:00");

    }

}
