package Menu;

import Attachment.Attachment;
import File.Data;
import Bank.*;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.*;

public class MenuReciever {
    private ArrayList<Attachment> attachments;
    private ArrayList<Bank> banks;
    private ArrayList<Attachment> customerAttachments;
    private Scanner scan;
    private Data data;
    private int idGiver;
    public MenuReciever() {
        data = new Data();
        this.banks = new ArrayList<Bank>();
        this.attachments = new ArrayList<Attachment>();
        this.customerAttachments = new ArrayList<Attachment>();
        ArrayList<Attachment> completeAttachments = new ArrayList<Attachment>();
        data.getCustomerAttachments(this.customerAttachments);
        data.getAttachments(this.attachments);
        idGiver = customerAttachments.size();
        banks.add(new Private(this.attachments));
        banks.add(new Mono(this.attachments));
        banks.add(new Oschad(this.attachments));
        AttachmentReadyCheck(customerAttachments, completeAttachments);
        if(completeAttachments.size() > 0){
            System.out.println("\tThis attachments is ready :");
            for (Attachment att:completeAttachments) {
                System.out.println(att.toStringRes());
            }
            while(true) {
                System.out.print("Give your attachments back ? (Yes/No) : ");
                scan = new Scanner(System.in);
                String str = scan.nextLine();
                if(str.equals("Yes")) {
                    for (Attachment att:customerAttachments)
                        for (Attachment att2 : completeAttachments)
                            if (att.getId() == att2.getId()) {
                                System.out.println("Attachment with ID " + att.getId() + " was take back successfully");
                                customerAttachments.remove(att);
                            }
                    break;
                }
                else if(str.equals("No"))
                    break;
            }
        }
    }

    private void AttachmentReadyCheck(ArrayList<Attachment> customerAttachments, ArrayList<Attachment> completeAttachments) {
        GregorianCalendar now = new GregorianCalendar();
        for (Attachment att: customerAttachments) {
            GregorianCalendar tmp = (GregorianCalendar) (att.getCreatedAttachmentDate().clone());
            tmp.add(GregorianCalendar.MONTH, att.getMonthCount());
            if(tmp.compareTo(now) < 0) {
                completeAttachments.add(att);
            }
        }
    }

    private Attachment _ctrAttFunc() {
        boolean exitFlag = false;
        Attachment att = new Attachment();
        this.scan = new Scanner(System.in);
        while(true) {
            while (true) {
                System.out.print("Enter offer id : ");
                att.setOfferId(scan.nextInt());
                System.out.print("\n");
                for (Attachment obj: attachments) {
                    if(obj.getOfferId() == att.getOfferId()) {
                        att.setPercent(obj.getPercent());
                        att.setMonthCount(obj.getMonthCount());
                        att.setId((customerAttachments.size() > 0 ? customerAttachments.get(customerAttachments.size() - 1).getId() + 1 : 1));
                    }
                }
                if(att.getPercent() != 0)
                    break;
                else
                    System.out.print("\tOffer ID not found\n");
            }
            System.out.print("Enter money amount : ");
            att.setCurrMoney(scan.nextDouble());
            System.out.print("\n");
            while(!exitFlag) {
                System.out.print("You will remove the attachment early, percents will be reduced by 20% (Yes/No) : ");
                scan.nextLine();
                if(scan.nextLine().equals("Yes")) {
                    att.setAheadOfSchedule(true);
                    att.setPercent(att.getPercent() * 0.8);
                    exitFlag = true;
                }
                else if(scan.nextLine().equals("No")) {
                    att.setAheadOfSchedule(false);
                    exitFlag = true;
                }
            }
            exitFlag = false;
            System.out.println("\n\tCurrent Attachment Info : ");
            att.setCreatedAttachmentDate(new GregorianCalendar());
            System.out.println(att.toStringRes());
            while(!exitFlag) {
                System.out.print("Do the conditions satisfy you? (Yes/No) : ");
                if(scan.nextLine().equals("Yes")) {
                    att.setCreatedAttachmentDate(new GregorianCalendar());
                    exitFlag = true;
                }
                else if(scan.nextLine().equals("No")) {
                    exitFlag = true;
                    return null;
                }
                if(exitFlag)
                    break;
            }
            return att;
        }
    }

    public void createAttachment() {
        Attachment tmp = _ctrAttFunc();
        if(tmp == null)
            System.out.println("Back you to Menu...");
        else {
            customerAttachments.add(tmp);
            System.out.println("\tYour attachment was created successfully");
        }
    }

    public void deleteAttachment() {
        System.out.print("Enter attachment ID : ");
        scan = new Scanner(System.in);
        int id = scan.nextInt();
        for (int i = 0; i < customerAttachments.size(); i++) {
                if(customerAttachments.get(i).getId() == id)
                    if(customerAttachments.get(i).isAheadOfSchedule()) {
                        customerAttachments.remove(customerAttachments.get(i));
                        System.out.println("Attachment with ID " + id + " was deleted successfully");
                    }
                    else
                        System.out.println("This attachment can`t be closed before the schedule");
        }
    }

    public void showAttachment() {
        for (Bank bank: banks)
            bank.showAttachments();
    }

    public void help() {
        System.out.println("\tCommand List : ");
        System.out.println("\t\thelp - show all commands");
        System.out.println("\t\tcreate - create attachment");
        System.out.println("\t\tdelete - delete created attachment (if you can get attachment ahead of schedule)");
        System.out.println("\t\tshow - show available offers");
        System.out.println("\t\tshowMy - show my attachments");
        System.out.println("\t\treplenish - replenish your attachments");
        System.out.println("\t\tsearchOffer - search offer by ID");
        System.out.println("\t\tsearch - search attachment by ID");
        System.out.println("\t\tsortOffers - sort offers");
        System.out.println("\t\tsort - sort attachments");
        System.out.println("\t\texit - exit program");
    }

    public void showMy() {
        System.out.println("\tYour attachments : ");
        if(customerAttachments.isEmpty())
            System.out.println("\tYou haven`t any attachment, for create use \"command\" create at Menu");
        else
            for (Attachment att:customerAttachments) {
                System.out.println(att.toStringRes());
            }
    }

    public void replenish() {
        scan = new Scanner(System.in);
        Attachment attachment = null;
        double money = 0;
        System.out.print("Enter attachment ID : ");
        int id = scan.nextInt();
        for (Attachment att:customerAttachments) {
            if(att.getId() == id)
               attachment = att;
        }
        if(attachment == null)
            System.out.println("\tWrong attachment ID");
        else {
            System.out.println("You can replenish this attachment on " + attachment.getMoneyAmount() + "");
            System.out.print("Enter money amount : ");
            money = scan.nextDouble();
            if(money > attachment.getMoneyAmount())
                System.out.println("Money amount bigger then can be");
            else {
                attachment.setMoneyAmount(attachment.getMoneyAmount() - money);
                attachment.setCurrMoney(attachment.getCurrMoney() + money);
                System.out.println("Attachment with ID " + attachment.getId() + " was replenished successfully");
            }
        }
    }

    public void searchOfferById() {
        scan = new Scanner(System.in);
        Attachment attachment = null;
        System.out.print("Enter offer ID : ");
        int id = scan.nextInt();
        for (Attachment att:attachments) {
            if (att.getOfferId() == id)
                attachment = att;
        }
        if(attachment == null)
            System.out.println("\tWrong offer ID");
        else
            System.out.println(attachment.toString());
    }

    public void searchById() {
        scan = new Scanner(System.in);
        Attachment attachment = null;
        System.out.print("Enter attachment ID : ");
        int id = scan.nextInt();
        for (Attachment att:customerAttachments) {
            if (att.getId() == id)
                attachment = att;
        }
        if(attachment == null)
            System.out.println("\tWrong attachment ID");
        else
            System.out.println(attachment.toStringRes());
    }

    public void sortOffers() {
        System.out.print("Sort by (percents, monthCount) : ");
        scan = new Scanner(System.in);
        String sortBy = scan.nextLine();
        ArrayList<Attachment> tmp = attachments;
        switch(sortBy) {
            case "percents" -> tmp.sort(Comparator.comparing(Attachment::getPercent));
            case "monthCount" -> tmp.sort(Comparator.comparing(Attachment::getMonthCount));
        }
        for (Attachment att:tmp)
            System.out.println(att.toString());
    }

    public void sort() {
        System.out.print("Sort by (percents, monthCount, money, date) : ");
        String sortBy = scan.nextLine();
        ArrayList<Attachment> tmp = customerAttachments;
        switch(sortBy) {
            case "percents" -> tmp.sort(Comparator.comparing(Attachment::getPercent));
            case "monthCount" -> tmp.sort(Comparator.comparing(Attachment::getMonthCount));
            case "money" -> tmp.sort(Comparator.comparing(Attachment::getCurrMoney));
            case "date" -> tmp.sort(Comparator.comparing(Attachment::getCreatedAttachmentDate));
        }
        for (Attachment att:tmp)
            System.out.println(att.toStringRes());
    }

    public void exit() {
        data.writeCustomerAttachments(customerAttachments);
    }
}