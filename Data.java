package File;

import Attachment.Attachment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Data {
    private Attachment att;
    private Scanner scan;
    private SimpleDateFormat form;

    private GregorianCalendar DateStrFromFile(Scanner scan) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.clear();
        Date dt = new Date();
        cal.set(GregorianCalendar.YEAR, scan.nextInt());
        cal.set(GregorianCalendar.MONTH, scan.nextInt());
        cal.set(GregorianCalendar.DATE, scan.nextInt());
        cal.set(Calendar.HOUR, scan.nextInt());
        cal.set(Calendar.MINUTE, scan.nextInt());
        cal.set(Calendar.SECOND, scan.nextInt());
        return cal;
    }

    public Data() {}

    public void getAttachments(ArrayList<Attachment> attachments) {
        try(FileReader reader = new FileReader("./src/main/java/Resources/attachments.txt"))
        {
            scan = new Scanner(reader);
            while(scan.hasNextInt()){
                att = new Attachment();
                att.setOfferId(scan.nextInt());
                if(scan.hasNextDouble())
                    att.setPercent(scan.nextDouble());
                att.setMonthCount(scan.nextInt());
                attachments.add(att);
                reader.close();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getCustomerAttachments(ArrayList<Attachment> customerAttachments) {
        try(FileReader reader = new FileReader("./src/main/java/Resources/customerAttachments.txt"))
        {
            scan = new Scanner(reader);
            while(scan.hasNextInt()){
                att = new Attachment();
                att.setId(scan.nextInt());
                att.setOfferId(scan.nextInt());
                if(scan.hasNextDouble())
                    att.setPercent(scan.nextDouble());
                att.setAheadOfSchedule(scan.nextInt() == 1);
                att.setCreatedAttachmentDate(DateStrFromFile(scan));
                att.setCurrMoney(scan.nextDouble());
                att.setMoneyAmount(scan.nextDouble());
                att.setMonthCount(scan.nextInt());
                customerAttachments.add(att);
                reader.close();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void writeCustomerAttachments(ArrayList<Attachment> customerAttachments) {
        try(FileWriter writer = new FileWriter("./src/main/java/Resources/customerAttachments.txt"))
        {
            for (Attachment customerAttachment : customerAttachments) {
                writer.write(customerAttachment.getId() + " ");
                writer.write(customerAttachment.getOfferId() + " ");
                writer.write(String.valueOf(customerAttachment.getPercent()).replace(".", ",") + " ");
                writer.write((customerAttachment.isAheadOfSchedule() ? 1 : 0) + " ");
                form = new SimpleDateFormat("yyyy MM dd HH mm ss ");
                form.setCalendar(customerAttachment.getCreatedAttachmentDate());
                String dateFormatted = form.format(customerAttachment.getCreatedAttachmentDate().getTime());
                writer.write(dateFormatted);
                writer.write(String.valueOf(customerAttachment.getCurrMoney()).replace(".", ",") + " ");
                writer.write(String.valueOf(customerAttachment.getMoneyAmount()).replace(".", ",") + " ");
                writer.write(customerAttachment.getMonthCount() + " ");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}