
public class Bill {
    int billid;
    String datetime;
    int gtotal;
    String adminemail;
    String pno;
    String paymenttype;

    public Bill(int billid, String datetime, int gtotal, String adminemail, String pno, String paymenttype) {
        this.billid = billid;
        this.datetime = datetime;
        this.gtotal = gtotal;
        this.adminemail = adminemail;
        this.pno = pno;
        this.paymenttype = paymenttype;
    }
    
    
    
}
