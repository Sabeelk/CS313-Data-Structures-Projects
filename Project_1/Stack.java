public interface Stack<E> {
   // Adds element e to the top of the stack.
   void push(E e);

   // Removes and returns the top element of the stack, or returns null if the stack is empty.
   E pop();

   // Returns but does not remove the top element of the stack, or returns null if the stack is empty.
   E top();

   // Reverses the order of all the elements of the stack.
   void reverse();

   // Returns the number of elements.
   int size();
}
