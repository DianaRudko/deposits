package Bank;

import Attachment.Attachment;

import java.util.ArrayList;

public class Mono extends Bank {
    private ArrayList<Attachment> attachments;
    public Mono(ArrayList<Attachment> attachments) {
        this.attachments = new ArrayList<Attachment>();
        setAttachments(attachments);
    }
    @Override
    public void showAttachments() {
        System.out.println("\n\tMonoBank Attachments : \n");
        for (Attachment att: attachments) {
            System.out.println(att.toString());
        }
    }
    @Override
    public void setAttachments(ArrayList<Attachment> attachments) {
        for (Attachment att: attachments) {
            if(att.getOfferId() / 10 == 2)
                this.attachments.add(att);
        }
    }

    @Override
    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }
}