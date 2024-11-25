package utils;

public class CreditCardInfos {
    private String type;
    private String number;
    private String expiration;
    private String owner;

    // Getter ve Setter'lar
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Number: %s, Expiration: %s, Owner: %s", type, number, expiration, owner);
    }
}
