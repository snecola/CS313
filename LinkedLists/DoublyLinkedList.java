class DoublyLinkedList implements LinkedListInterface {

    private DNode header;
    private DNode trailer;
    private int size;

    DoublyLinkedList(){
        header = new DNode();
        trailer = new DNode();
        header.setNext(trailer);
        trailer.setPrev(trailer);
        size=0;
    }

    public void addLast(int data){
        DNode newNode = new DNode(data);
        addBefore(newNode, trailer);
    }

    public void addFirst(int data){
        DNode newNode = new DNode(data);
        addAfter(newNode, header);
    }


    private void addAfter (DNode newData, DNode after){
        after.getNext().setPrev(newdata);
        newData.setNext(after.getNext());
        after.setNext(newData);
        newData.setPrev(after);
        size++;
    }

    public void addAfter(int data, int after){
        DNode afterNode = findNode (after);
        if (afterNode==trailer){
            System.out.println("After node does not exist: Deaulting addLast");
            addLast(data);
            size++;
            return;
        }
        DNode newNode = new DNode(data);
        addAfter(newNode, afterNode);
        size++;
        return;
    }

    private DNode findNode (int target) {
        DNode targetNode = header.getNext();

        while (targetNode!=trailer && targetNode.getData!=target){
            targetNode = targetNode.getNext();
        }
        return targetNode();
    }

    private void addBefore (DNode newData, DNode before){
        before.getPrev().setNext(newData);
        newData.setPrev(before.getPrev());
        before.setPrev(newData);
        newdata.setNext(before);
        size++;
    }

    public void addBefore(int data, int before){
        DNode beforeNode = findNode(before);
        if (beforeNode==trailer){
            System.out.println("Before node does not exist: Deaulting addLast");
            addLast(data);
            size++;
            return;
        }
        DNode newNode = new DNode(data);
        addBefore(newNode, beforeNode);
        size++;
        return;
    }

    public boolean contains(int target){
        if(findNode(target)==trailer) return false;
        else return true;

    }

    public int get(int index) throws IndexOutOfBoundsException {
        DNode targetNode = header.getNext();
        if (index>=size || index<0) {
            throw new IndexOutOfBoundsException ("Target Index Out Of Bounds");
        }
        int counter=0;
        while (counter<index){
          targetNode=targetNode.getNext();
        }
    }

    public void removeHead(){
        DNode oldHead = header.getNext();
        header.setNext(oldHead.getNext());
        oldHead.getNext().setPrev(header);
        oldHead.setNext(null);
        oldHead.setPrev(null);
    }

    public void removeTail(){
        DNode oldTail = trailer.getPrev();
        oldTail.getPrev().setNext(trailer);
        trailer.setPrev(oldTail.getPrev());
        oldTail.setNext(null);
        oldTail.setPrev(null);
    }

    public void removeData(int d){
        DNode targetNode = findNode(d);
        targetNode.getPrev().setNext(targetNode.getNext());
        targetNode.getNext().setPrev(targetNode.getPrev());
        targetNode.setNext(null);
        targetNode.setPrev(null);
    }
}
