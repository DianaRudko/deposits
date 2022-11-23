package Main;

import Menu.*;
import java.util.Scanner;

public class Main {
    private static boolean exitFlag;
    public static void main(String[] args) {
        exitFlag = false;
        Scanner scan = new Scanner(System.in);
        MenuReciever menuRec = new MenuReciever();

        CommandI createAttachment = new CreateAttachment(menuRec);
        CommandI deleteAttachment = new DeleteAttachment(menuRec);
        CommandI showAttachment = new ShowAttachment(menuRec);
        CommandI help = new HelpMenu(menuRec);
        CommandI showMy = new ShowMyAttachmentsMenu(menuRec);
        CommandI exit = new ExitMenu(menuRec);
        CommandI replenish = new ReplenishAttachment(menuRec);
        CommandI searchOfferById = new SearchOfferById(menuRec);
        CommandI searchById = new SearchById(menuRec);
        CommandI sortOffers = new SortOffers(menuRec);
        CommandI sort = new Sort(menuRec);

        MenuInvoker menuInv = new MenuInvoker(createAttachment,deleteAttachment, showAttachment,
                help, showMy, replenish, searchOfferById, searchById, sortOffers, sort, exit);

        System.out.println("\tWelcome to attachment system");
        menuInv.help();
        while(!exitFlag) {
            System.out.print("Menu : ");
            switch (scan.nextLine()) {
                case "help" -> menuInv.help();
                case "create" -> menuInv.createAttachment();
                case "delete" -> menuInv.deleteAttachment();
                case "show" -> menuInv.showAttachment();
                case "showMy" -> menuInv.showMy();
                case "replenish" -> menuInv.replenish();
                case "searchOffer" -> menuInv.searchOfferById();
                case "search" -> menuInv.searchById();
                case "sortOffers" -> menuInv.sortOffers();
                case "sort" -> menuInv.sort();
                case "exit" -> {
                    exitFlag = !exitFlag;
                    menuInv.exit();
                }
            }
        }
    }
}