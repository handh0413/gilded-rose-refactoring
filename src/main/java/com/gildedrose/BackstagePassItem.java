package com.gildedrose;

public class BackstagePassItem extends GildedRoseItem {

    public BackstagePassItem(Item item) {
        super(item);
    }

    @Override
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
