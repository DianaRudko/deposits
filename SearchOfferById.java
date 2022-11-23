package Menu;

public class SearchOfferById implements CommandI {
    private MenuReciever menuRec;

    public SearchOfferById(MenuReciever menuRec){
        this.menuRec = menuRec;
    }

    public void execute(){
        menuRec.searchOfferById();
    }
}