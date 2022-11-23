package Menu;

public class ReplenishAttachment implements CommandI {
    private MenuReciever menuRec;

    public ReplenishAttachment(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.replenish();
    }
}