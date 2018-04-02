package Transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class HistoryView {

    private List<TransferAction> account_history = new ArrayList<>();

    public void addtransact(TransferAction addition) {
        this.account_history.add(addition);
    }

    public void allTransacts() {
        for(TransferAction transaction : account_history) {
            transaction.showTransfer();
        }
    }

    public void dateTransacts(String begining, String end) {
        for(TransferAction transaction : account_history) {
            if(transaction.date.after(transaction.changeDate(begining)) && transaction.date.before(transaction.changeDate(end))) {
                transaction.showTransfer();
            }
        }
    }

}
