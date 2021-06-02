package org.example.sourceClass;

public class Money {
    private int summ;
    private  String owner;
    public Money(int sum, String _owner){this.summ=sum;
    this.owner=_owner;}
    public void set_owner(String owner) {this.owner = owner; }
    public int get_summ() {return summ; }
}
