class SinglyLinkedList implements LinkedListInterface {
    private Node head;
    private Node tail;
    private int size;

    SinglyLinkedList(){
        head = tail = null;
        size = 0;
    }

    /*
    Method to insert into the back of linklist
    Param data: the integer that is being inserted
    */
    public void addLast(int data){
        Node newNode = new Node(data);
        if(size == 0){
            head = tail = newNode;
            size++;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    /*
    Method to insert into the front of linklist
    Param data: the integer that is being inserted
    */
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        if(size == 0) {
            tail = newNode;
        }
        size++;
    }

    /*
    Method to insert data after a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data after
    */
    public void addAfter(int data, int after){
       Node afterNode = findNode(after);

        if(afterNode == null) {
            System.out.println("After node does not exist, defaulting insertion at rear");
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.setNext(afterNode.getNext());
        afterNode.setNext(newNode);
        size++;
    }

    /*
    Method to find a node that contains the "target" value
    If such node exists, a reference to that node is returned
    Otherwise a null reference is returned
    Param target: the integer we want to find in the list
     */
    private Node findNode(int target){
        Node targetNode = head;

        while(targetNode != null && targetNode.getData()!=target){
            targetNode = targetNode.getNext();
        }

        return targetNode;
    }

    /*
    Method to insert data before a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data before
    */
    public void addBefore(int data, int before){
        Node beforeNode = findNode(before);
        if (beforeNode==null) {
            System.out.println("Before node not found: defaulting add last");
            addLast(data);
            return;
        }

        Node newNode = new Node (data);
        Node afterNode = header;

        while (afterNode.getNext()!=beforeNode){
            afterNode = afterNode.getNext();
        }
        afterNode.setNext(newNode);
        newNode.setNext(beforeNode);
        size++;
        return;
    }

    /*
    Method that checks to see if a given target value is in the list
    Returns true is it exist
    Returns false otherwise
    Param target: the integer we want to find in the list
     */
    public boolean contains(int target){
        /*
        Node targetNode = findNode(target);
        if(targetNode == null) return false;
        else return true;
        */
        return findNode(target) != null;
    }

    /*
    Method that returns the node from the given index
    Return the int stored at the index provided
    If index is not in the list throw a IndexOutOfBounds Exception
    Param index: the position the user wants the data for
    */
    public int get(int index) throws IndexOutOfBoundsException {
        Node targetNode = head;
        int counter=0;

        if (index>=size || index<0) throw new IndexOutOfBoundsException("Method get: Index Out of Bounds Exception");

        while (counter<index){
            targetNode=targetNode.getNext();
            counter++;
        }

        return targetNode.getData();
    }

    /*
    Method removes the head node from the list
    */
    public void removeHead(){
        //consider an empty list
        if (size==0){
            System.out.println("Method removeHead: There is no head to remove");
        }
        //consider a list of size 1
        if (size==1){
            tail=null;
        }
        head=head.getNext();
        size--;
    }

}
