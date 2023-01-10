class Phone {

    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    public Phone(String o, String n) {
        ownerName = o;
        number = n;
    }

    public Phone(String o, String c, String ci, String n) {
        this(o, n);
        countryCode = c;
        cityCode = ci;
    }
}