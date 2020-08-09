package entity;

import java.sql.Date;

public class ReleseCookItem implements  SupperEntity{
    private ReleseCookItemPK releseCookItemPK;
    private String itemName;
    private int qtyOnRand;

    public ReleseCookItem() {
    }

    public ReleseCookItem(ReleseCookItemPK releseCookItemPK, String itemName, int qtyOnRand) {
        this.releseCookItemPK = releseCookItemPK;
        this.itemName = itemName;
        this.qtyOnRand = qtyOnRand;
    }

    public ReleseCookItem(String itemId, Date releseDate, String itemName, int qtyOnRand) {
        this.releseCookItemPK = new ReleseCookItemPK(itemId,releseDate);
        this.itemName = itemName;
        this.qtyOnRand = qtyOnRand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQtyOnRand() {
        return qtyOnRand;
    }

    public void setQtyOnRand(int qtyOnRand) {
        this.qtyOnRand = qtyOnRand;
    }

    public ReleseCookItemPK getReleseCookItemPK() {
        return releseCookItemPK;
    }

    public void setReleseCookItemPK(ReleseCookItemPK releseCookItemPK) {
        this.releseCookItemPK = releseCookItemPK;
    }

    @Override
    public String toString() {
        return "ReleseCookItem{" +
                ", itemName='" + itemName + '\'' +
                ", qtyOnRand=" + qtyOnRand +
                '}';
    }
}
