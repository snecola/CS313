class ArrayStack implements StackInterface {
    private int[] stack;
    private int size;
    private int capacity;

    ArrayStack(){
        stack= new int[10];
        capacity=10;
        size=0;
    }

    ArrayStack(int initialSize){
        stack = new int[initialSize];
        capacity = initialSize;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public boolean isFull(){
        return size==capacity;
    }

    void pop() {
        if (isEmpty){
            throw new Exception("Stack Empty");
        }
        size--;
    }
    void push(int data){
        if(isFull()){
            throw new Exception("Stack Full");
        }
        stack[size]=data;
        size++;
    }
    int peek(){
        if(isEmpty()){
            throw new Exception("Stack empty exception");
        }
        return stack[size-1];
    }
}
