package javacollectionframework.parameterizedcustomlist;

public interface ListIterableParameterized<T> {

    /**
     * Returns object of ListIterator.
     *
     * @return object of ListIterator
     */
    ListIteratorParameterized<T> listIterator();
}