package Menu;

public class SortOffers implements CommandI {
    private MenuReciever menuRec;

    public SortOffers(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.sortOffers();
    }
}