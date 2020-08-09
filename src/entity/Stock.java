package entity;

public class Stock implements  SupperEntity{
    private String itemId;
    private String itemName;
    private int qtyOnHand;

    public Stock() {
    }

    public Stock(String itemId, String itemName, int qtyOnHand) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.qtyOnHand = qtyOnHand;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
