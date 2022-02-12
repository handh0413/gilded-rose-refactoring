package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	private static final String NONAME = "noname";

	@Test
	public void noname_sellin_0_quality_0() {
		// 1. assign
		Item[] items = new Item[]{new Item(NONAME, 0, 0)};
		GildedRose gildedRose = new GildedRose(items);

		// 2. action
		gildedRose.updateQuality();

		// 3. assert
		assertEquals(1, items.length);
		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	// 재고를 업데이트할 때마다 판매 가능 일자(sellin)와 품질(quality)은 1씩 감소한다.
	@Test
	public void noname_sellin_0_quality_1() {
		// 1. assign
		Item[] items = new Item[] { new Item(NONAME, 0, 1) };
		GildedRose gildedRose = new GildedRose(items);

		// 2. action
		gildedRose.updateQuality();

		// 3. assert
		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}



}
