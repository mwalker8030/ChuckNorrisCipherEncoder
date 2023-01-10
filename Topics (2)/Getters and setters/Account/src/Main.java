class Account {

    private long balance;
    private String ownerName;
    private boolean locked;

    public long getBalance() {
        return balance;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public boolean isLocked(){
        return locked;
    }

    public void setBalance(long b){
        balance = b;
    }

    public void setOwnerName(String o){
        ownerName = o;
    }

    public void setLocked(boolean l){
        locked = l;
    }
}