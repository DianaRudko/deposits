package Menu;

public class ExitMenu implements CommandI {
    private MenuReciever menuRec;

    public ExitMenu(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.exit();
    }
}