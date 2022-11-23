package Menu;

import Menu.CommandI;
import Menu.MenuReciever;

public class ShowAttachment implements CommandI {
    private MenuReciever menuRec;

    public ShowAttachment(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.showAttachment();
    }
}