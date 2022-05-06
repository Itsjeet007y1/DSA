package practice.doublecircularlinkedlist;

public class DoubleNode {
	
	int value;
	DoubleNode next;
	DoubleNode prev;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	public DoubleNode getPrev() {
		return prev;
	}
	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubleNode [value=").append(value).append(", next=").append(next).append(", prev=").append(prev)
				.append("]");
		return builder.toString();
	}
	
}
