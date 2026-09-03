 class ListNode {
    int data;
    ListNode next;
     ListNode(int data){
        this.data=data;
    }
     /* 在链表的节点 n0 之后插入节点 P */
     void addlistNode( ListNode a, ListNode b){
         ListNode temp=a.next;
         a.next=b;
         b.next=temp;
    }
//    void remove(ListNode a){
//         if(a.next==null)return;
//         ListNode temp=a.next;
//         a.next=temp.next;
//     }
/* 删除链表的节点 n0 之后的首个节点 */
     void remove(ListNode a){
         if(a.next!=null){
             a.next=a.next.next;
         }
     }
     /* 访问链表中索引为 index 的节点 */
     ListNode access(ListNode head, int index) {
         for (int i = 0; i < index; i++) {
             if (head == null) return null;
             head = head.next;
         }
         return head;
     }
     //遍历
     void show(ListNode head){
         ListNode AA=head;
         while(AA!=null){
             System.out.println(AA.data);
             AA=AA.next;
         }
     }
     //查找位置
     int find(ListNode head, int target){
         ListNode A=head;
         int count=0;
         while(A!=null){
             if(A.data==target){
                 return count;
             }
             A=A.next;
             count++;
         }
         return -1;
     }
}
