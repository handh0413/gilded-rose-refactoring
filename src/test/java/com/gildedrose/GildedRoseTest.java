package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	private static final String NONAME = "noname";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";

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

	// Sulfuras는 전설의 아이템이다. 절대 팔지도 않고 품질이 떨어지지도 않는다.(판매 가능 날짜도 감소하지 않는다.)
	@Test
	public void sulfuras_sellin_0_quality_1() {
		// 1. assign
		Item[] items = new Item[] { new Item(SULFURAS, 0, 1) };
		GildedRose gildedRose = new GildedRose(items);

		// 2. action
		gildedRose.updateQuality();

		// 3. assert
		assertEquals(0, items[0].sellIn);
		assertEquals(1, items[0].quality);
	}

	// Aged Brie는 시간이 지날수록 품질이 증가한다. (판매 가능 날짜가 끝나면 +1 추가 증가한다.)
	@Test
	public void agedBrie_sellin_0_quality_0() {
		// 1. assign
		Item[] items = new Item[] { new Item(AGED_BRIE, 0, 0) };
		GildedRose gildedRose = new GildedRose(items);

		// 2. action
		gildedRose.updateQuality();

		// 3. assert
		assertEquals(-1, items[0].sellIn);
		assertEquals(2, items[0].quality);
	}

}
