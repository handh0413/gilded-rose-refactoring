package com.gildedrose;

public class AgedBrieItem {
    private Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
