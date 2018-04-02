package Transfer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransferAction {
    public String title; //tytuł operacji
    public String sender; // nadawca - nazwa
    public String recipient; // odbiorca - nazwa
    public String saccount; // numer rachunku nadawcy
    public String raccount; // numer rachunku obiorcy
    public double amount; // kwota transakcji
    public String operation; // rodzaj operacji - CARD, TRANSFER, ATM
    public String datehuman; // łańcuch z datą
    public Date date; // data operacji
    public boolean action; // zmiana stanu kont + log lub sam log


    public TransferAction(String title, double amount, String operation, String datehuman, BankAccount sender, BankAccount recipient, boolean action) {

        this.title = title;
        this.amount = amount;
        this.operation = operation;
        this.date = this.changeDate(datehuman);

        this.sender = sender.getOwner();
        this.recipient = recipient.getOwner();
        this.saccount = sender.getAccount_nr();
        this.raccount = recipient.getAccount_nr();

        if(action == true) {
            if (this.operation == "ATM") {
                recipient.changeBalance(amount * (-1));
            } else {
                sender.changeBalance(amount * (-1));
                recipient.changeBalance(amount);
            }
        }
    }

    public Date changeDate(String humanchange) {

        SimpleDateFormat curdate = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        Date date = null;
        try {
            date = curdate.parse(humanchange);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void showTransfer() {
        System.out.println("Tytuł przelewu: "+this.title);
        System.out.println("Nadawca: "+this.sender+" Numer konta: "+this.saccount);
        System.out.println("===================================================");
        System.out.println("Odbiorca: "+this.recipient+" Numer konta: "+this.raccount);
        System.out.println("===================================================");
        System.out.println("Kwota transakcji: "+this.amount+" Rodzaj operacji: "+this.operation);
        System.out.println(this.date);
        System.out.println("");
    }
}
