/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlist;

/**
 *
 * @author btek
 */
public class CircularList {
    public DNode current;
    int size = 0; 
    
    public CircularList(){
        current = null;     
    } 
    
    public void insertAfterCurrent(String s){
        DNode dn = new DNode(s);
        if(current==null){
            current = dn;
            current.next= current;
            current.previous = current;
        }
        else{
            dn.previous = current;
            dn.next = current.next;
            current.next.previous = dn;
            current.next=dn;
        }
        size++;
    }
    
    public void rotate(){
        current = current.next;
    }
    
    public void insertBeforeCurrent(String s){
        DNode dn = new DNode(s);
        if(current==null){
            current = dn;
            current.next= current;
            current.previous = current;
        } 
        else{
            dn.previous = current.previous;
            current.previous.next =dn;
            dn.next = current;
            current.previous = dn;
        }
        size++;
    }
    public String toString(){
        DNode tmp = current;
        String s= "";
        while (tmp != current.previous){    
            s+=tmp.data+"->";
            tmp = tmp.next;
        }
        s+=tmp.data;
        
        return s;
    }
    
    public void longestWord(){
        int longestLen = 0;
        DNode longlestNode = null;
        for (int i = 0; i < size; i++) {
            if(longestLen < current.data.length()){
                longestLen = current.data.length();
                longlestNode = current;
            }
            rotate();
        }
        System.out.println("Longest: " + longlestNode.data);
    }
    
    class DNode{
        public String data;
        public DNode next;
        public DNode previous;
        public DNode(String data){
            this.data = data;
            next = null;
            previous= null;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CircularList cl = new CircularList();
        cl.insertAfterCurrent("sile");
        cl.insertAfterCurrent("agva");
        cl.insertBeforeCurrent("omerli");
        cl.insertBeforeCurrent("uskudar");
        
        
        
        
        cl.longestWord();
    }
}
