package inputoutputstreams;

class Inner implements Cloneable {
    int value;

    public Inner(int value) {
        this.value = value;
    }

    @Override
    protected Inner clone() throws CloneNotSupportedException {
        return (Inner) super.clone();
    }

    @Override
    public String toString() {
        return "Inner{" + "value=" + value + '}';
    }
}

// Deep copy class
class Test implements Cloneable {
    int x;
    Inner inner;

    public Test(int x, int val) {
        this.x = x;
        this.inner = new Inner(val);
    }

    @Override
    protected Test clone() throws CloneNotSupportedException {
        try {
            Test cloned = (Test) super.clone();
            // Deep copy of inner object
            cloned.inner = this.inner.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Test{" + "x=" + x + ", inner=" + inner + '}';
    }
}

// Shallow copy class
class TestShallow implements Cloneable {
    int x;
    Inner inner;

    public TestShallow(int x, int val) {
        this.x = x;
        this.inner = new Inner(val);
    }

    @Override
    protected TestShallow clone() throws CloneNotSupportedException {
        // Shallow copy just clones this object, not inner
        return (TestShallow) super.clone();
    }

    @Override
    public String toString() {
        return "TestShallow{" + "x=" + x + ", inner=" + inner + '}';
    }
}

public class CloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== Shallow Copy Demo ===");
        TestShallow ts1 = new TestShallow(1, 2);
        TestShallow ts2 = ts1.clone();

        System.out.println(ts1);
        System.out.println(ts2);

        ts2.x = 10;
        ts2.inner.value = 20; // changes affect ts1 as well
        System.out.println("After modification:");
        System.out.println(ts1);
        System.out.println(ts2);

        System.out.println("\n=== Deep Copy Demo ===");
        Test t1 = new Test(1, 2);
        Test t2 = t1.clone();

        System.out.println(t1);
        System.out.println(t2);

        t2.x = 10;
        t2.inner.value = 20; // changes do NOT affect t1
        System.out.println("After modification:");
        System.out.println(t1);
        System.out.println(t2);
    }
}
