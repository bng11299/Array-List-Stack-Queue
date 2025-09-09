
public class ArrayStack implements StackInterface{
	private int[] data;
	private int top;
	private static final int initialCapacity = 10;
	
	public ArrayStack() {
		data = new int[initialCapacity];
		top = 0;
	}

	@Override
	public void push(int value) {
		if(top == data.length) {
			resize();
		}
		data[top] = value;
		
		top++;
	}
	
	private void resize() {
		int[] newData  = new int[data.length*2];
		for (int i = 0; i < data.length; i++) {
	        newData[i] = data[i];
	    }
	    data = newData;
	}

	@Override
	public int pop() {
		if(top == 0) {
			return -1;
		}
		top--;
		return data[top];
	}

	@Override
	public int peek() {
	    if (top == 0) {
	        return -1;
	    }
	    return data[top - 1];
	}

	@Override
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public void clear() {
		top = 0;
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("{");

	    for (int i = 0; i < top; i++) {
	        sb.append(data[i]);
	        if (i < top - 1) {
	            sb.append(",");
	        }
	    }

	    sb.append("}");
	    return sb.toString();
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof ArrayStack)) {
			return false;
		}
		ArrayStack other = (ArrayStack) o;
		if(this.top!= other.top) {
			return false;
		}
		for(int i = 0; i < top; i++) {
			if(this.data[i] != other.data[i]) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayStack(ArrayStack other) {
		this.top = other.top;
		this.data = new int[other.data.length];
		for (int i = 0; i < top; i++) {
	        this.data[i] = other.data[i];
	    }
	}
	
}
