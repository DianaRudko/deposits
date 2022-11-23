package Attachment;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Attachment {
    private double moneyAmount;
    private double currMoney;
    private double percent;
    private int montCount;
    private boolean isAheadOfSchedule;
    private int offerId;
    private int id;
    private GregorianCalendar createdAttachmentDate;
    public Attachment() {}
    public Attachment(int offerId, double percent, int montCount) {
        this.id = offerId;
        this.percent = percent;
        this.montCount = montCount;
        this.moneyAmount = 0;
        this.isAheadOfSchedule = false;
        this.currMoney = 0;

    }
    public Attachment(int offerId, double percent, int montCount, boolean isAheadOfSchedule, double moneyAmount) {
        this.moneyAmount = moneyAmount;
        this.percent = percent;
        this.montCount = montCount;
        this.isAheadOfSchedule = isAheadOfSchedule;
        this.currMoney = moneyAmount;
        this.offerId = offerId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public GregorianCalendar getCreatedAttachmentDate() {
        return createdAttachmentDate;
    }

    public double getCurrMoney() {
        return currMoney;
    }

    public int getOfferId() {
        return offerId;
    }

    public double getPercent() {
        return percent;
    }

    public int getMonthCount() {
        return montCount;
    }

    public int getId() {return id;}

    public boolean isAheadOfSchedule() {
        return isAheadOfSchedule;
    }


    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setCurrMoney(double currMoney) {
        this.currMoney = currMoney;
    }

    public void setMonthCount(int montCount) {
        this.montCount = montCount;
    }

    public void setAheadOfSchedule(boolean isAheadOfSchedule) {
        this.isAheadOfSchedule = isAheadOfSchedule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setCreatedAttachmentDate(GregorianCalendar createdAttachmentDate) {
        this.createdAttachmentDate = createdAttachmentDate;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String toString() {
        return "Offer ID : " + this.offerId + ", percents : " + this.percent + "%, Month Count : " + this.montCount;
    }

    public String toStringRes() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        fmt.setCalendar(this.createdAttachmentDate);
        String dateFormatted = fmt.format(this.createdAttachmentDate.getTime());
        return "ID : " + this.id +  " " + this.toString() + ", Creation Date : " + dateFormatted  + ", Money Amount : " + this.currMoney + ", Ahead Of Schedule : " + (this.isAheadOfSchedule ? "Yes" : "No") + ", Will Accrued : " + (this.currMoney / 100 * this.percent) / 12 * this.montCount;
    }
}