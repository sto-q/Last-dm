public class texter {
    public void JianCha(DianQi dianQi) {
        if(dianQi instanceof BingXiang){
            dianQi.show();
            ((BingXiang)dianQi).ping();
        }else if(dianQi instanceof dainshi){
            dianQi.show();
            ((dainshi)dianQi).ss();
        }
    }
}
