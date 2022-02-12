package com.gildedrose;

public class BackstagePassItem {
    private Item item;

    public BackstagePassItem(Item item) {
        this.item = item;
    }

    void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 1) {
                item.quality = item.quality - item.quality;
            }
        }
    }
}
