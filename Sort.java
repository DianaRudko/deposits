package Menu;

public class Sort implements CommandI {
    private MenuReciever menuRec;

    public Sort(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.sort();
    }
}