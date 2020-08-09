package entity;

import java.sql.Date;

public class ReleseCookItemPK implements SupperEntity{
    private String itemId;
    private Date releseDate;

    public ReleseCookItemPK() {
    }

    public ReleseCookItemPK(String itemId, Date releseDate) {
        this.itemId = itemId;
        this.releseDate = releseDate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Date getReleseDate() {
        return releseDate;
    }

    public void setReleseDate(Date releseDate) {
        this.releseDate = releseDate;
    }

    @Override
    public String toString() {
        return "ReleseCookItemPK{" +
                "itemId='" + itemId + '\'' +
                ", releseDate=" + releseDate +
                '}';
    }
}
