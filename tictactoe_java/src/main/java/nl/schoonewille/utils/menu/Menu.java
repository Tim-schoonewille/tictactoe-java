package nl.schoonewille.utils.menu;

import java.util.List;

import nl.schoonewille.exceptions.InvalidMenuItemException;
import nl.schoonewille.interfaces.IMenu;

public class Menu implements IMenu {

    private List<MenuItem> menuItems;
    private String name;

    public Menu(String name, MenuItem... items) {
        this.name = name;
        menuItems = List.of(items);
    }

    @Override
    public void displayMenu() {
        System.out.println(name);
        System.out.println();
        menuItems.forEach(i -> System.out.println(i.getDisplay()));
    }

    @Override
    public void executeMenuItem(char menuKey) throws InvalidMenuItemException {
        for (var item : menuItems) {
            if (item.getKey() == menuKey) {
                item.execute();
                return;
            }
        }
        throw new InvalidMenuItemException("No menu item found.");
    }

}
