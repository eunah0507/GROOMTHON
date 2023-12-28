public class Subject_LinkedList {

	public static class MyLinkedList<T> {
		public Node<T> head = null;
		public Node<T> tail = null;
		private int size;

		public MyLinkedList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		private static class Node<T> {
			private T item;
			private Node<T> next;

			// 생성자
			Node(T item, Node<T> next) {
				this.item = item;
				this.next = next;
			}
		}

		public T get(int index) {
			Node<T> n = head;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			return n.item;
		}
		
		public Node<T> search(int index) {
			Node<T> n = head;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}

			return n;
		}

		public void add(T data) {
			Node<T> last = tail;
			Node<T> newNode = new Node<>(data, null);
			size++;

			tail = newNode;
			if (last == null) {
				head = newNode;
			} else {
				last.next = newNode;
			}
		}

		public boolean delete(int index) {
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}

			if (index == 0) {
				if (head == null) {
					return false;
				}
				Node<T> first = head.next;

				head.next = null;
				head.item = null;
				head = first;
				size--;

				if (head == null) {
					tail = null;
				}
				return true;
			}

			Node<T> prev_node = search(index - 1);
			Node<T> del_node = prev_node.next;
			Node<T> next_node = del_node.next;

			del_node.next = null;
			del_node.item = null;

			size--;

			prev_node.next = next_node;

			return true;
		}

	}

	public static void main(String[] args) {
		MyLinkedList test = new MyLinkedList();
		test.add("구름톤");
		test.add("풀스택");
		test.add("4회차");
		test.add("정은아");

		System.out.println(test.get(0));
		System.out.println(test.get(1));
		System.out.println(test.get(2));
		System.out.println(test.get(3));
		test.delete(0);
		// 하나 없애면 바로 밀려서 정은아 출력 대신 4회차가 출력됨
		test.delete(2);

		System.out.println(test.get(0));
		System.out.println(test.get(1));

	}
}