package Menu;

public class MenuInvoker {
    private CommandI createAttachment;
    private CommandI deleteAttachment;
    private CommandI showAttachment;
    private CommandI exit;
    private CommandI help;
    private CommandI showMy;
    private CommandI replenish;
    private CommandI searchOfferById;
    private CommandI searchById;
    private CommandI sortOffers;
    private CommandI sort;
    public MenuInvoker(CommandI createAttachment, CommandI deleteAttachment, CommandI showAttachment,
                       CommandI help, CommandI showMy, CommandI replenish, CommandI searchOfferById,
                       CommandI searchById, CommandI sortOffers, CommandI sort, CommandI exit) {
        this.createAttachment = createAttachment;
        this.deleteAttachment = deleteAttachment;
        this.showAttachment = showAttachment;
        this.exit = exit;
        this.help = help;
        this.showMy = showMy;
        this.replenish = replenish;
        this.searchOfferById = searchOfferById;
        this.searchById = searchById;
        this.sortOffers = sortOffers;
        this.sort = sort;
    }
    public void createAttachment() {
        createAttachment.execute();
    }
    public void deleteAttachment() {
        deleteAttachment.execute();
    }
    public void showAttachment() {showAttachment.execute();}
    public void exit() {exit.execute();}
    public void help() {help.execute();}
    public void showMy() {showMy.execute();}
    public void replenish() {replenish.execute();}
    public void searchOfferById() {searchOfferById.execute();}
    public void searchById() {searchById.execute();}
    public void sortOffers() {sortOffers.execute();}
    public void sort() {sort.execute();}
}