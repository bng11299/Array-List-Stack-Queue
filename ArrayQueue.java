
public class ArrayQueue implements QueueInterface{
	private int[] data;
	private int front;
	private int rear;
	private int size;
	private static final int initialCapacity = 10;
	
	public ArrayQueue() {
		data = new int[initialCapacity];
		front = 0;
		rear = 0;
		size = 0;
	}

	@Override
	public void enqueue(int value) {
		if (size == data.length) {
			resize();
		}
		data[rear] = value;
		rear = (rear+1)%data.length;
		size++;
	}
	
	private void resize() {
		int[] newData  = new int[data.length*2];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(front + i) % data.length];
	    }
	    data = newData;
	    front = 0;
	    rear = size;
	}

	@Override
	public int dequeue() {
		if (size == 0) {
	        return -1;
	    }

	    int value = data[front];
	    front = (front + 1) % data.length;
	    size--;
	    return value;
	}

	@Override
	public int peek() {
		if (size == 0) {
			return -1;
		}
		return data[front];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < data.length; i++) {
	        data[i] = 0;
	    }
	    front = 0;
	    rear = 0;
	    size = 0;
	}
	
	public String toString() {
	    if (size == 0) return "{}";

	    StringBuilder sb = new StringBuilder();
	    sb.append("{");

	    for (int j = 0; j < size; j++) {
	    	int index = (front+j)%data.length;
	        sb.append(data[index]);
	        if (j < size - 1) sb.append(",");
	    }

	    sb.append("}");
	    return sb.toString();
	}
	
	public boolean equals(Object obj) {
		if(obj == null||!(obj instanceof ArrayQueue))return false;
		ArrayQueue other = (ArrayQueue) obj;
		if (this.size != other.size) {
	        return false;
	    }
		for(int i = 0; i < size; i++) {
			int thisIndex = (this.front + i) % this.data.length;
			int otherIndex = (other.front +i) % other.data.length;
			
			if(this.data[thisIndex] != other.data[otherIndex]) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayQueue(ArrayQueue other) {
		this.data = new int[other.data.length];
	    this.size = other.size;
	    this.front = 0;
	    this.rear = size;

	    for (int i = 0; i < other.size; i++) {
	        int index = (other.front + i) % other.data.length;
	        this.data[i] = other.data[index];
	    }
	}	
	
	public static void main(String[] args) {
	    ArrayQueue q = new ArrayQueue();
	    q.enqueue(2);
	    q.enqueue(3);
	    System.out.println(q); // Expect: {2,3}
	    q.dequeue();
	    q.enqueue(4);
	    q.enqueue(6);
	    System.out.println(q); // Expect: {3,4,6}
	}
}
