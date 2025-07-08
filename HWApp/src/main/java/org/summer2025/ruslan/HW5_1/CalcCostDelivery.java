package org.summer2025.ruslan.HW5_1;

// Клас розрахунку вартості товару,
// враховуючи вартість доставки
// Клас успадковує клас CalcCostBase.
public class CalcCostDelivery extends CalcCostBase {

        // Вартість доставки
        private final static double deliveryPrice = 7.0;

        // Розрахунок вартості товару,
        // з урахуванням вартості доставки
        @Override
        public double calcCost(Product product) {
            return product.getQuota() * product.getPrice()
                    + deliveryPrice;
        }
    }
