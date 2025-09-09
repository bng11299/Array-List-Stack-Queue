public class ListQueue implements QueueInterface{
	private class Node {
	    int value;
	    Node next;

	    Node(int value) {
	        this.value = value;
	        this.next = null;
	    }
	}
	private Node front;
	private Node back;
	private int size;
	
	public ListQueue() {
		front = null;
		back = null;
		size = 0;
	}
	
	public void enqueue(int value) {
	    Node newNode = new Node(value);

	    if (front == null) {
	        front = newNode;
	        back = newNode;
	    } else {
	        back.next = newNode;
	        back = newNode;
	    }
	    size++;
	}

	@Override
	public int dequeue() {
		if (front == null) {
	        return -1;
	    }

	    int value = front.value;
	    front = front.next;

	    if (front == null) {
	        back = null;
	    }

	    size--;
	    return value;
	}

	@Override
	public int peek() {
		if(front == null) {
			return -1;
		}
		return front.value;
	}

	@Override
	public boolean isEmpty() {
		if(front == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		front = null;
		back = null;
		size = 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("{");
	    Node current = front;
	    while (current != null) {
	        sb.append(current.value);
	        if (current.next != null) {
	            sb.append(",");
	        }
	        current = current.next;
	    }
	    sb.append("}");
	    return sb.toString();
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    ListQueue other = (ListQueue) obj;
	    if (this.size != other.size) return false;

	    Node currentThis = this.front;
	    Node currentOther = other.front;

	    while (currentThis != null) {
	        if (currentThis.value != currentOther.value) {
	            return false;
	        }
	        currentThis = currentThis.next;
	        currentOther = currentOther.next;
	    }

	    return true;
	}
	
	public ListQueue(ListQueue other) {
	    if (other.front == null) {
	        this.front = null;
	        this.back = null;
	        return;
	    }

	    this.front = new Node(other.front.value);
	    Node currentThis = this.front;
	    Node currentOther = other.front.next;
	
	    while (currentOther != null) {
	        currentThis.next = new Node(currentOther.value);
	        currentThis = currentThis.next;
	        currentOther = currentOther.next;
	    }

	    this.back = currentThis;
	    this.size = other.size;
	}
}
