package Menu;

public class HelpMenu implements CommandI {
    private MenuReciever menuRec;

    public HelpMenu(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.help();
    }
}