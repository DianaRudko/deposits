package Menu;

public class SearchById implements CommandI {
    private MenuReciever menuRec;

    public SearchById(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.searchById();
    }
}