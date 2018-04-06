public interface List<E> {
   // Adds the specified element to the end of the list.
   void add(E e);

   // Returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   E get(int index);

   // Removes and returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   E remove(int index);

   // Returns the number of elements.
   int size();
}
