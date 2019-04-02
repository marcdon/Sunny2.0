package e.marc.sunny;

import com.time.cat.dragboardview.model.DragItem;

public class Item implements DragItem {
    private final String itemName;
    private int colIndex;
    private int itemIndex;

    public Item(String itemName, int colIndex, int itemIndex) {
        this.itemName = itemName;
        this.colIndex = colIndex;
        this.itemIndex = itemIndex;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public int getColumnIndex() {
        return colIndex;
    }

    @Override
    public int getItemIndex() {
        return itemIndex;
    }

    @Override
    public void setColumnIndex(int columnIndexInHorizontalRecycleView) {
        //save to database here
    }

    @Override
    public void setItemIndex(int itemIndexInVerticalRecycleView) {
        //save to database here
    }
}
