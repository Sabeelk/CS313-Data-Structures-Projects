public class LinkedList<E> implements List<E>, Stack<E> {
  private Node<E> first, last;
  private int size = 0;

  // Construct a new empty list.
  public LinkedList() {
    first = last = new Node<>(null, null);
  }

  // Adds element e to the end of the list.
  public void add(E e) {
    last.next = new Node<>(e, null);
    last = last.next;
    ++size;
  }

  // Returns the element at the specified index,
  // or throws an IndexOutOfBoundsException if the index is out of range.
  public E get(int index) {
    if (index < 0 || index >= size){
       throw new IndexOutOfBoundsException();
    }
    Node<E> t = first.next;
    for (int i = 0; i < index; ++i)
       t = t.next;
    return t.data;
  }

  // Removes and returns the element at the specified index,
  // or throws an IndexOutOfBoundsException if the index is out of range.
  public E remove(int index) {
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    Node<E> t = first;                      //starts at dummy node
    if (index+1 == size){                   //case for last element
      for (int i = 0; i < index; i++){      //find node before last node
        t = t.next;
      }
      last = t;                             //update tail pointer
      Node<E> element = t.next;             //element stores last node
      t.next = null;                        //update pointer of new last node
      size--;
      return element.data;
    }
    else{                                   //case for any other element
      for (int  i = 0; i < index; i++){     //find node before desired index
        t = t.next;
      }
      Node<E> element = t.next;             //element stores index node
      t.next = element.next;                //links node before index to node after
      element.next = null;                  //points index to null to be removed
      size--;
      return element.data;
    }
  }

  // Adds element e to the top of the stack.
  public void push(E e) {
    if(size == 0){                        //if list is empty call the add method
      this.add(e);
    }
    else {
      Node<E> push = new Node<E>(e, null);//create new node to push in
      push.next = first.next;             //new node points to first node
      first.next = push;                  //dummy node points to new node
      size++;
    }
  }

  // Removes and returns the top element of the stack, or returns null if the stack is empty.
  public E pop() {
    if(size == 0){
      return null;
    }
    Node<E> element = first.next;         //make node to store top of stack
    first.next = first.next.next;         //link dummy node to node after stack top
    element.next = null;                  //unlink stack node from list
    size--;
    return element.data;
  }

  // Returns but does not remove the top element of the stack, or returns null if the stack is empty.
  public E top() {
    if(size == 0){
      return null;
    }
    return first.next.data;
  }

  // Reverses the order of all the elements of the stack.
  public void reverse() {
    if(size==0 | size==1){                //if empty or 1 node, no need to reverse
      return;
    }
    Node<E> current = first.next;         //needed for reversing list
    Node<E> prev = null;
    Node<E> after;

    Node<E> temp = last;                  //reverses last and first pointers
    last = first.next;
    first.next = temp;

    while(current != null){               //goes through list and reverses order
      after = current.next;
      current.next = prev;
      prev = current;
      current = after;
    }
  }

  // Returns a string representation of the linked list.
  public String toString() {
    String list = "[ ";
    if(size == 0){                        //if list is empty return empty string
      list += "]";
      return list;
    }
    Node<E> t = first.next;
    while(t != null){                     //concatenates each object in list to string
      list += t.data + " ";
      t = t.next;
    }
    list += "]";
    return list;
  }

  // Returns the number of elements.
  public int size() {
    return size;
  }

  private static class Node<E> {
    E data;
    Node<E> next;
    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }
}
