public class next {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(3);
        ListNode c=new ListNode(4);
        ListNode d=new ListNode(5);
        ListNode kk=new ListNode(6250);
        head.next=a;
        a.next=b;
        b.next=c;
        c.next=d;
        a.addlistNode(a,kk);
        c.remove(b);
        a.show(head);
        ListNode M= d.access(head,3);
        System.out.println(M.data);
    }
}
