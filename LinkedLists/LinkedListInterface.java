interface LinkedListInterface {
  public void addFirst(int data);
  public void addLast(int data);
  public void addAfter(int data, int after);
  public void addBefore(int data, int before);
  public boolean contains(int target);
  public int get(int index);
  public void removeHead();
}
