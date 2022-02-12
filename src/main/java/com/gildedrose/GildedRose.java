package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.name.equals(AGED_BRIE)) {
                AgedBrieItem agedBrieItem = new AgedBrieItem(item);
                agedBrieItem.updateQualityForAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE_PASS)) {
                BackstagePassItem backstagePassItem = new BackstagePassItem(item);
                backstagePassItem.updateQualityForBackstagePasses(item);
            } else if (item.name.equals(SULFURAS)) {
                SulfurasItem sulfurasItem = new SulfurasItem(item);
                sulfurasItem.updateQualityForSulfuras(item);
            } else {
                updateQualityForNormalItem(item);
            }

            updateSellIn(item);
        }
    }

    private void updateQualityForNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        if (item.sellIn < 1) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }
}