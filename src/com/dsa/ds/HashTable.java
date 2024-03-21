package com.dsa.ds;

public class HashTable {

	private HashNode[] buckets;
	private int noOfBuckets;
	private int size;

	public HashTable() {
		noOfBuckets = 10;
		this.size = 0;
		this.buckets = new HashNode[10];
	}

	public HashTable(int cap) {
		this.noOfBuckets = cap;
		this.buckets = new HashNode[cap];
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static class HashNode {
		private Integer key;
		private String value;
		private HashNode next;

		public HashNode(Integer key, String value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	public void put(Integer key, String val) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = val;
				return;
			}
			head = head.next;
		}
		size++;
		head = buckets[bucketIndex];
		HashNode node = new HashNode(key, val);
		node.next = head;
		buckets[bucketIndex] = node;
	}

	public String get(Integer key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public String remove(Integer key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		String val = null;
		if (head != null && head.key.equals(key)) {
			val = head.value;
			buckets[bucketIndex] = head.next;
			size--;
			return val;
		}
		// 12 14 13
		while (head.next != null) {
			if (head.next.key.equals(key)) {
				val = head.next.value;
				head.next = head.next.next;
				size--;
				return val;
			}
			head = head.next;
		}
		return val;
	}

	public int getBucketIndex(Integer key) {
		return key % noOfBuckets;
	}

	public void printHashTable() {
		for (int i = 0; i < noOfBuckets; i++) {
			HashNode head = buckets[i];
			if (head != null) {
				System.out.print(i + " : ");
				while (head != null) {
					System.out.print("\t" + head.value + " ");
					head = head.next;
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String args[]) {

		HashTable ht = new HashTable();
		ht.put(10, "Hello World 10");
		ht.put(12, "Hello World 12");
		ht.put(13, "Hello World 13");
		ht.put(3, "Hello World 3");
		ht.put(33, "Hello World 33");

		ht.printHashTable();
		ht.remove(33);
		ht.printHashTable();

	}
}
