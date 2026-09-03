public class comper {
    private USB[] usbs=new USB[3];
    public void add(USB usb,int index){
        if(index<0||index>=usbs.length){
            System.out.println("GUN");
        }else{
            usbs[index]=usb;
            usb.service();
        }
    }
}
