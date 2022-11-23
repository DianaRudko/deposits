package Bank;

import Attachment.Attachment;
import java.util.ArrayList;

public abstract class Bank {
    public abstract void showAttachments();
    public abstract void setAttachments(ArrayList<Attachment> attachments);
    public abstract ArrayList<Attachment> getAttachments();
}