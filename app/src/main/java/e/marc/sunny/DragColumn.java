package e.marc.sunny;

    public class Entry implements DragColumn {
        private final String name;
        private int columnIndex;
        private final List<DragItem> itemList;

        public Entry(String name, int columnIndex, List<DragItem> items) {
            this.name = name;
            this.columnIndex = columnIndex;
            this.itemList = items;
        }

        public String getName() {
            return name;
        }

        public List<DragItem> getItemList() {
            return itemList;
        }

        @Override
        public int getColumnIndex() {
            return columnIndex;
        }

        @Override
        public void setColumnIndex(int columnIndexInHorizontalRecycleView) {
            //save to database here
        }
    }

}
