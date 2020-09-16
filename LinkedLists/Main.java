

class Main {
    public static void main (String[] args){
      LL l = new LL();
      l.addFirst(1);
      l.addLast(2);
      l.addLast(3);
      l.addAfter(5,5);
      l.addAfter(6,2);
    }
}

class LL {
    private Node head;
    private Node tail;
    private int size;


    //Default Constructor
    LL(){
        head=tail=null;
        size=0;
    }

    /*
    Method to add a node to the front of the linked list
    */
    public void addFirst (int data){
      Node newNode = new Node(data);
      newNode.setNext(head);
      head=newNode;
      if (size==0){
        tail=newNode;
      }
      size++;
    }

    /*
    Method to add a node to the back of the linked List
    */
    public void addLast (int data){
      Node newNode = new Node(data);
      if (size==0) {
        head=tail=newNode;
        size++;
        return;
      }
      tail.setNext(newNode);
      tail=newNode;
      size++;
    }

    /*
    Mathod to insert a node into the linked list after a node containing
    the designated data.
    param data: the integer that is being inserted
    param after: the integer we want to place the data after
    */
    public void addAfter (int data, int after){
      Node afterNode = findNode(after);

      if (afterNode==null){
        System.out.println("After node does not exist, adding node to rear");
        addLast(data);
        return;
      }

      Node newNode = new Node (data);
      newNode.setNext(afterNode.getNext());
      afterNode.setNext(newNode);
      size++;
    }

    /*
    Mathod to insert a node into the linked list before a node containing
    the designated data.
    param data: the integer that is being inserted
    param before: the integer we want to place the data before
    */
//    public void addBefore (int data, int before){
//
//    }

    //Helper Function: Finds a target node
    private Node findNode (int target) {
      Node targetNode = head;

      while (targetNode!=null && targetNode.getData()!=after){
          targetNode = targetNode.getNext();
      }
    }

    public boolean contains (int target) {
      /*
      Node targetNode = findNode(target);
      if (targetNode==null) return false;
      else return true;
      */
      return findNode(target) != null;
    }

    /*
    Method that returns the node from the given index
    Return the int stored at the index provided
    If index is not in the list throw a IndexOutOfBounds Exception
    param index: the position the user wants the data for
    */
    public int get (int index) throws Exception {
      if (index>size) throw new IndexOutOfBounds ("Index Out Of Bounds");
    }

    /*
    This method removes head node from the
    */
    public void removeHead (){
      if (size==0) {

      }
      if (size==1) {

      }
      head=head.getNext();
      size--;
    }


}

class Node {
    private int data;
    private Node next;

    Node (int d, Node n){
      data=d;
      next=n;
    }

    Node (int d) {
      data=d;
      next=null;
    }

    public void setNext (Node n){
      next = n;
    }

    public void setData (int d){
      data=d;
    }

    public Node getNext (){
      return next;
    }
    public int getData (){
      return data;
    }
}

class IndexOutOfBounds extends Exception {
  public IndexOutOfBounds (String message){
    super (message);
  }
}
