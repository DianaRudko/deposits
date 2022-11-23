package Menu;

public class CreateAttachment implements CommandI {
    private MenuReciever menuRec;

    public CreateAttachment(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.createAttachment();
    }
}