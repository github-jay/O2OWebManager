package com.o2oweb.util;

import java.util.List;

import com.o2oweb.entity.OrderItem;

public class PriceUtil {
	public static float getTotal(List<OrderItem> list) {
		float total = 0;
		for (OrderItem oi : list) {
			total += oi.getItemPrice() * oi.getItemNum();
		}

		// 不足100加5元快递费
		if (total < 100) {
			total += 5;
		}

		return total;
	}
}
