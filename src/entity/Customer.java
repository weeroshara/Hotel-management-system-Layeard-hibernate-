package entity;

public class Customer implements SupperEntity {
    private String nic;
    private String name;
    private String phomeNumber;
    private int noOfMembors;

    public Customer() {
    }

    public Customer(String nic, String name, String phomeNumber, int noOfMembors) {
        this.nic = nic;
        this.name = name;
        this.phomeNumber = phomeNumber;
        this.noOfMembors = noOfMembors;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhomeNumber() {
        return phomeNumber;
    }

    public void setPhomeNumber(String phomeNumber) {
        this.phomeNumber = phomeNumber;
    }

    public int getNoOfMembors() {
        return noOfMembors;
    }

    public void setNoOfMembors(int noOfMembors) {
        this.noOfMembors = noOfMembors;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", phomeNumber='" + phomeNumber + '\'' +
                ", noOfMembors=" + noOfMembors +
                '}';
    }
}
