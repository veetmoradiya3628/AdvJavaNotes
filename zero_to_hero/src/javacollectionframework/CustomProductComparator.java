package javacollectionframework;

import java.util.Comparator;

public class CustomProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getCategoryName().equals(o2.getCategoryName())) {
            if (o1.getPrice() == o2.getPrice()) {
                return o1.getProductName().compareTo(o2.getProductName());
            } else {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        } else {
            return o1.getCategoryName().compareTo(o2.getCategoryName());
        }
    }
}
