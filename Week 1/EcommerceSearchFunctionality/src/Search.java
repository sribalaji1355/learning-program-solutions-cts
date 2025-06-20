public class Search {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Heater", "Appliances"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Pen", "Stationery")
        };

        System.out.println("Linear Search:");
        Product result1 = LinearSearch.linearSearch(products, "Watch");
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println();
        System.out.println("Binary Search:");
        Product result2 = BinarySearch.binarySearch(products, "Watch");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
