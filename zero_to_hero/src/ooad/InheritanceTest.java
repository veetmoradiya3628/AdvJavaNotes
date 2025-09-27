package ooad;

class BaseProduct {
    int productId;

    public BaseProduct(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "productId=" + productId +
                '}';
    }
}

class Phone extends BaseProduct {
    int phoneId;
    String description;

    public Phone(int productId, int phoneId, String description) {
        super(productId);
        this.phoneId = phoneId;
        this.description = description;
    }

    public int getphoneId() {
        return phoneId;
    }

    public void setphoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", description='" + description + '\'' +
                ", productId=" + productId +
                '}';
    }
}

class Tab {
    int tabId;

    public Tab(int tabId) {
        this.tabId = tabId;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    @Override
    public String toString() {
        return "Tab{" +
                "tabId=" + tabId +
                '}';
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        Phone p1 = new Phone(1, 2, "Phone2");
        System.out.println(p1);
        System.out.println(p1 instanceof Phone);
        System.out.println(p1 instanceof BaseProduct);

        BaseProduct p2 = new Phone(1, 3, "Phon3");
        System.out.println(p2);
        System.out.println(p2 instanceof Phone);
        System.out.println(p2 instanceof BaseProduct);

        Tab t1 = new Tab(1);
        System.out.println(t1.tabId);
        System.out.println(t1);
    }
}

// initialization order of classes objects
