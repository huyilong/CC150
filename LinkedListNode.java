class LinkedListNode
{
    public Object data;
    public LinkedListNode next;

    public LinkedListNode(Object data) {
    this.data = data;
    }
}

class DeleteNodeLinkedList
{
    public static void main(String[] args) 
    {
        LinkedListNode node_1 = new LinkedListNode("first");        
        LinkedListNode node_2 = new LinkedListNode("second");
        node_1.next = node_2;
        LinkedListNode node_3 = new LinkedListNode("third");
        node_2.next = node_3;

        System.out.println("*** Print contents of linked list");
        LinkedListNode  current = node_1;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("*** Now delete second node");
        deleteNode(node_2);

        System.out.println("*** Print after deleting second node");
        current = node_1;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static boolean deleteNode(LinkedListNode n) 
    {
        if (n == null || n.next == null) {
            return false; // Failure
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}