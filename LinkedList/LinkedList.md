## Linked List

### What is it?

* A data structure that represents a sequence of nodes. There's two kinds of linked list, 
    * Singly linked list
    * Doubly linked list

### How is this different from an array?

A linked list does not provide constant time access to an index. So to retrieve the nth element, you have to iterate over N elements. 

### What are the advantages/disadvantages?

Well, since you're only given a pointer to the end of an element, you can easily add/remove the first item in the list of nodes. A caveat to this is you can't easily access an element within the list. 

### Creating a Linked list

```
Class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != this) {
            n.next;
        }
        n.next = end;
    }


```

### Deleting a node

#### Singly Linked List

* Given a node n, find the previous node prev
* Set prev.next equal to n.next

#### Doubly Linked list

* Update n.next 
* Set n.next.prev equal to n.prev

Note: Things to check are null pointers and update the head/tail pointer. 

```
Node deleteNode(Node head, int d) {
    Node n = head;

    if (n.data == d) {
        return head.next;
    }

    while (n.next != null) {
        if(n.next.data == d) {
            n.next = n.next.next;
            return head;
        }
        n = n.next;
    }
    return head;
}

```
