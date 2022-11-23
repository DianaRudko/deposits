package Menu;

public class ShowMyAttachmentsMenu implements CommandI {
    private MenuReciever menuRec;
    public ShowMyAttachmentsMenu(MenuReciever menuRec){
        this.menuRec = menuRec;
    }
    public void execute(){
        menuRec.showMy();
    }
}