package HW5_1;

// Клас розрахунку базової вартості товару
public class CalcCostBase {

        // Базовий розрахунок вартості товару
        public double calcCost(Product product) {
            return product.getQuota() * product.getPrice();
        }

}
