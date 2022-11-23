package Menu;

public class DeleteAttachment implements CommandI {
    private MenuReciever menuRec;

    public DeleteAttachment(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.deleteAttachment();
    }
}