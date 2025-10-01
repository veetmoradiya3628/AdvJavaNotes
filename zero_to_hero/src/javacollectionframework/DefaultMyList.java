package javacollectionframework;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList implements MyList {

    /**
     * An iterator over a collection.
     *
     */

    private class IteratorImpl implements Iterator<Object> {
        int cursor = 0;
        int lastRet = -1;
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            Object next = getNodeByIndex(cursor);
            if (next == null) throw new NoSuchElementException();
            lastRet = cursor;
            cursor += 1;
            return next;
        }

        @Override
        public void remove() {
            if(lastRet < 0) throw new IllegalStateException();
            DefaultMyList.this.removeNodeByIndex(lastRet);
            if (lastRet < cursor){
                cursor--;
            }
            lastRet = -1;
        }
    }

    /**
     * Pointer to first node.
     */
    private Node first;

    /**
     * Pointer to last node.
     */
    private Node last;

    /**
     * Total amount of elements in object of MyListImpl.
     */
    private int size;


    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * @param e element to be appended to this list
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     */

    @Override
    public void add(Object element) {
        final Node lastNode = last;
        final Node newNode = new Node(lastNode, element, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        last = null;
        first = null;
        size = 0;

    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain
     * the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     */

    @Override
    public boolean remove(Object obj) {
        if (obj == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (x.data.equals(obj)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes object from MyListImpl by its own index.
     * <p>
     * Uses unlink method to change references in nodes.
     *
     * @param index of the element.
     * @return Object that had been removed.
     */


    public Object removeNodeByIndex(int index) {
        return unlink(getNodeByIndex(index));

    }

    /**
     * Unlinks element from the MyListImpl and set new values of first and last element.
     * <p>
     * Changes references in the nodes.
     * <p>
     * Returns data (object) which had been removed recently.
     *
     * @param element to remove.
     * @return Object that had been removed.
     */

    Object unlink(Node element) {
        Object obj = element.data;
        Node next = element.next;
        Node previous = element.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            element.previous = null;
        }
        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            element.next = null;
        }

        element.data = null;
        size--;
        return obj;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     * <p>
     * This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            result[index++] = x.data;
        }
        return result;
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than Integer.MAX_VALUE elements, returns
     * Integer.MAX_VALUE.
     *
     * @return the number of elements in this list
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains
     * at least one element e such that.
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     */

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.data == null) {
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if this list contains all of the elements of the
     * specified collection.
     *
     * @param c object that implements MyList to be checked for containment in this list
     * @return true if this list contains all of the elements of the
     * specified collection
     * @throws NullPointerException if the specified collection contains one
     *                              or more null elements and this list does not permit null
     *                              elements
     */
    @Override
    public boolean containsAll(MyList c) {
        Object[] array = c.toArray();
        for (int i = 0; i < array.length; i++) {
            if (!contains(array[i])) {
                return false;
            }
            ;
        }
        return true;
    }

    /**
     * Overrides toString method so result would be in the format
     * {[result of the toString method for element #1], [result of the toString method for element #2], ... }
     *
     * @return formatted String.
     */

    @Override
    public String toString() {
        if (first == null) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('{');

        for (Node x = first; x != null; x = x.next) {
            sb.append('[')
                    .append(x.data);

            if (x.next == null) {
                break;
            }
            sb.append(']')
                    .append(',')
                    .append(' ');
        }

        return sb.append(']')
                .append('}')
                .toString();
    }

    /**
     * Returns an iterator over the elements in this list (in proper
     * sequence).
     * <p>
     * This implementation merely returns a list iterator over the list.
     *
     * @return an iterator over the elements in this list (in proper sequence)
     */

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    /**
     * Returns Node by its own index.
     * <p>
     * If index more than half of total amount of elements method
     * starts searching from the end and vice versa.
     *
     * @param index of the element.
     * @return Node
     */

    public Node getNodeByIndex(int index) {
        if (index > (size - 1)) {
            return null;
        }

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.previous;
            }
            return x;
        }
    }


    /**
     * Nested class which store information about next
     * and previous elements in container MyList and data of
     * this Node
     */

    private static class Node {
        private Object data;
        private Node next;
        private Node previous;

        public Node(Node previous, Object data, Node next) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
