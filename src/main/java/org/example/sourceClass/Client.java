package org.example.sourceClass;

public class Client {
    private String name;
    private Money money;
    public Client(){name = "";};
    public Client(String n){name = n;}
    public String get_name(){return name;}
    public Money get_money(){return money;}
    public void get_cash(String name, int cash){
        this.name = name;
        ATM atm=new ATM();
        money= atm.callPassword(cash, name);
    }

}
