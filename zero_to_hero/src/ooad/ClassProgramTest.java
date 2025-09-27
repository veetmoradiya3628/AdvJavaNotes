package ooad;

class Cart {
    int cartId;

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                '}';
    }

    public static class Tax {
        private String taxType;

        public Tax(String taxType) {
            this.taxType = taxType;
        }

        public String getTaxType() {
            return taxType;
        }

        public void setTaxType(String taxType) {
            this.taxType = taxType;
        }

        @Override
        public String toString() {
            return "Tax{" +
                    "taxType='" + taxType + '\'' +
                    '}';
        }
    }
}

//can not be extended or abstracted
final class FinalClass {
    String proper1;
    String proper2;

    public FinalClass(String proper1, String proper2) {
        this.proper1 = proper1;
        this.proper2 = proper2;
    }
}

abstract class Product {
    private int id;
    private String name;
    private int quantity;

    public abstract boolean isAvailable();
}

class MasterProduct extends Product {
    private int masterProductId;

    public MasterProduct(int masterProductId) {
        this.masterProductId = masterProductId;
    }

    public int getMasterProductId() {
        return masterProductId;
    }

    public void setMasterProductId(int masterProductId) {
        this.masterProductId = masterProductId;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public String toString() {
        return "MasterProduct{" +
                "masterProductId=" + masterProductId +
                '}';
    }
}

public class ClassProgramTest {
    public static void main(String[] args) {
        Cart.Tax t1 = new Cart.Tax("GST Tax");
        System.out.println(t1);

        Cart c1 = new Cart(1);
        System.out.println(c1);

        MasterProduct masterProduct = new MasterProduct(1);
        System.out.println(masterProduct);
    }
}
