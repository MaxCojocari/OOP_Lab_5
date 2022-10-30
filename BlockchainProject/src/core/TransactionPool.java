package core;

import java.util.*;

public class TransactionPool {
    private ArrayList<Object> T = new ArrayList<Object>();
    private int maxPoolSize;

    public void setPoolSize(int size) {
        maxPoolSize = size;
    }

    public Object getTransaction(int i) {
        return T.get(i);
    }

    public int getNrTransactions() {
        return T.size();
    }

    public void addTransaction(Object t) {
        ((Transaction) t).setChecked();
        if (isPoolFull()) T.clear();
        T.add(t);
    }

    public boolean isPoolFull() {
        return T.size() >= maxPoolSize;
    }

    public ArrayList<Object> getPool() {
        return T;
    }
}
