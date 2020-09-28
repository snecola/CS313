class DNode {
    private int data;
    private DNode next;
    private DNode prev;

    DNode(){
        next = prev = null;
        data = -1;
    }

    DNode(int data){
        this.data = data;
        next = null;
        prev = null;
    }

    DNode(int data, DNode next){
        this.data = data;
        this.next = next;
    }

    public int getData(){
        return data;
    }

    public DNode getNext(){
        return next;
    }

    public DNode getPrev(){
        return prev;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setPrev(DNode prev) {
        this.prev=prev;
    }
    public void setData(int d){
        this.data=d;
    }

}
