
public class ReverseLinkedList{
    public static LinkedNode reverse(LinkedNode startNode) {
        LinkedNode currNode=startNode, prevNode=null, nextNode=null;
        if (startNode ==null) return null; 
        /*
        1. save next node address (to nextNode)
        2. point to the "previous node" (the current node's next is actually prev node now) (so currNode.next = preNode)
        3. save current node address in prevNode
        4. currNode = nextNode //moving the currNode to point to the next node
        5. do 1-4 until currNode is moved to null
        */
        while (currNode!=null) {
            nextNode = currNode.next; //save the address of next node to nextNode
            currNode.next = prevNode; //change the pointer that origianlly points to next node to the previou node instead
            prevNode = currNode; //save currNode into preNode, for that preNode will be linked as the next node for next round
            currNode = nextNode;  //move current node to the next
        }
        currNode=prevNode; //the reason is that currNode will eventually be moved to null in that while loop, so we need to get it's "previous node"
        return currNode;
    }

    public static void main(String []args){
        LinkedNode ln0 = new LinkedNode(1); 
        LinkedNode ln1 = new LinkedNode(3);
        LinkedNode ln2 = new LinkedNode(5);
        LinkedNode ln3 = new LinkedNode(7);
        LinkedNode ln4 = new LinkedNode(9);
        LinkedNode ln5 = new LinkedNode(2);
        LinkedNode head = ln0, newHead = null;  
        ln0.next = ln1; 
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = null;
        newHead = reverse(head); 
      
        System.out.print("Print out reversed linked list: "); 
        for (; newHead!=null; newHead=newHead.next) {
            System.out.print(newHead.data+" "); 
        }
    }
}
class LinkedNode{
    int data; 
    LinkedNode next; 
    LinkedNode(int input){
        this.data = input;
    }
}