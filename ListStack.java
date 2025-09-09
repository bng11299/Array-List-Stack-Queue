
public class ListStack implements StackInterface{
	private class Node {
	    int value;
	    Node next;

	    Node(int value) {
	        this.value = value;
	        this.next = null;
	    }
	}
	private Node top;
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}

	@Override
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
		size++;
	}

	@Override
	public int pop() {
		if(top == null) {
			return -1;
		}
		int value = top.value;
		top = top.next;
		size--;
		return value;
	}

	@Override
	public int peek() {
		if(top == null) {
			return -1;
		}
		return top.value;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		top = null;
		size = 0;
	}
	
	public String toString() {
	    if (isEmpty()) return "{}";

	    StringBuilder sb = new StringBuilder();
	    sb.append("{");

	    Node[] nodes = new Node[size];
	    Node current = top;
	    int i = size - 1;
	    while (current != null) {
	        nodes[i--] = current;
	        current = current.next;
	    }

	    for (int j = 0; j < size; j++) {
	        sb.append(nodes[j].value);
	        if (j < size - 1) sb.append(",");
	    }

	    sb.append("}");
	    return sb.toString();
	}

	public boolean equals(Object other) {
		if(this == other) return true;
		if (!(other instanceof ListStack)) return false;

	    ListStack that = (ListStack) other;

	    if (this.size != that.size) return false;

	    Node current1 = this.top;
	    Node current2 = that.top;

	    while (current1 != null && current2 != null) {
	        if (current1.value != current2.value) return false;
	        current1 = current1.next;
	        current2 = current2.next;
	    }

	    return true;
	}
	
	public ListStack(ListStack other) {
	    if (other.top == null) {
	        this.top = null;
	        return;
	    }

	    ListStack temp = new ListStack();
	    Node current = other.top;
	    while (current != null) {
	        temp.push(current.value);
	        current = current.next;
	    }

	    while (!temp.isEmpty()) {
	        this.push(temp.pop());
	    }
	}


}
