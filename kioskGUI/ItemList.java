import java.util.ArrayList;
import java.util.List;

public abstract class ItemList<T extends Item> {
    protected List<T> itemList;

    public ItemList() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(T item) {
        itemList.add(item);
    }

    public T getItem(String id) {
        return itemList.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public T getItemByName(String name) {
        return itemList.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);
    }
}
