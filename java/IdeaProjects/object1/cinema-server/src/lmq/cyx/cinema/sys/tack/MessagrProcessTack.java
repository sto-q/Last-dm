package lmq.cyx.cinema.sys.tack;

import lmq.cyx.cinema.sys.entity.*;
import lmq.cyx.cinema.sys.message.Message;
import lmq.cyx.cinema.sys.util.DataUtil;
import lmq.cyx.cinema.sys.util.FileUtil;
import lmq.cyx.cinema.sys.util.IdGenerater;
import lmq.cyx.cinema.sys.util.SocketUtil;

import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class MessagrProcessTack implements Runnable {
    private final Socket  client;

    public MessagrProcessTack(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {//服务器端驱动后直接启动
        Message msg= SocketUtil.receiveMsg(client);//接收客户端发送的信息
        System.out.println(msg);//打印客户端发送的信息
        if (msg != null) {
            switch (msg.getAction()){//调用switch
                case "register"://注册
                    processRegister(msg);
                    break;
                case "login"://登录
                    prcessLogin(msg);
                    break;
                case "getPasswordBack"://找回密码
                    processGetPasswordBack(msg);
                    break;
                case "unfrozenApply"://解冻申请
                    processUnfrozenApply(msg);
                    break;
                case "addFilmHall"://添加影厅
                    prcessAddFilmHall(msg);
                    break;
                case "updateFilmHall"://修改影厅
                    prcessUpdateFilmHall(msg);
                    break;
                case "deleteFilmHall"://删除影厅
                    prcessDeleteFilmHall(msg);
                    break;
                case "getFilmHallList"://查看影厅
                    prcessGetFilmHallList();
                    break;
                case "addFilm"://添加影片
                    prcessAddFilm(msg);
                    break;
                case "updateFilm"://修改影片
                    prcessUpdateFilm(msg);
                    break;
                case "deleteFilm"://删除影片
                    prcessDeleteFilm(msg);
                    break;
                case "getFilmList"://查看影片
                    prcessGetFilmList(msg);
                    break;
                case "addFilmPlan"://添加播放计划
                    prcessAddFilmHPlan(msg);
                    break;
                case "updateFilmPlan"://修改播放计划
                    prcessUpdateFilmPlan(msg);
                    break;
                case "deleteFilmPlan"://删除播放计划
                    prcessDeleteFilmPlan(msg);
                    break;
                case "getFilmPlanList"://查看播放计划
                    prcessGetFilmPlanList(msg);
                    break;
                case "getUserList"://查看用户
                    prcessGetUserList();
                    break;
                case "frozenUser"://冻结用户
                    prcessFrozenUser(msg);
                    break;
                case "unfrozenUser"://解冻用户
                    processUnfrozenUser(msg);
                    break;
                case "getUnfrozenApplyList"://查看用户解冻申请
                    prcessGetUnfrozenApplyList();
                    break;
                case"getOrderList"://查看订单
                    processGetOrderList(msg);
                    break;
                case"getUserOrderList"://查看用户订单
                    processGetUserOrderList(msg);
                    break;
                case"updateOrder"://修改订单
                    processUpdateOrder(msg);
                    break;
                case"cancelOrder"://取消订单
                    processCancelOrder(msg);
                    break;
                case "auditOrder"://审核订单
                    processAuditOrder(msg);
                    break;
                case "orderSeatOnline"://在线订座
                    processOrderSeatOnline(msg);
                    break;

            }
        }
    }

    /**
     * 处理订单查看请求
     */
    private void processGetOrderList(Message msg) {
        Object data = msg.getData();
        List<Order>orders=FileUtil.readData(FileUtil.ORDER_FILE);
        if(data==null){
            SocketUtil.sendBack(client,orders);
        }else {
            int state=(int)data;
            List<Order>orderList=orders.stream().filter(order->order.getState()==state).collect(Collectors.toList());
            SocketUtil.sendBack(client,orderList);
        }
    }

    /**
     * 处理用户订单查看请求
     * @param msg
     */
    private void processGetUserOrderList(Message msg) {
        String username=(String)msg.getData();
        List<Order>orders=FileUtil.readData(FileUtil.ORDER_FILE);
        List<Order>result=orders.stream().filter(o->o.equals(username)).collect(Collectors.toList());
        SocketUtil.sendBack(client,result);
    }

    /**
     * 处理更新订单请求
     * @param msg
     */
    private void processUpdateOrder(Message msg) {

    }

    /**
     * 处理取消订单请求
     * @param msg
     */
    private void processCancelOrder(Message msg) {
        String orderId=(String)msg.getData();
        List<Order>orders=FileUtil.readData(FileUtil.ORDER_FILE);
        int index=-1;
        for (int i=0;i<orders.size();i++){
            Order order=orders.get(i);
            if (order.getId().equals(orderId)){
                index=i;
                break;
            }
        }
        if (index==-1){
            SocketUtil.sendBack(client,-1);
        }else {
            Order order=orders.get(index);
            if(order.getState()==1){
                order.setState(0);//更改订单为取消中
                orders.set(index, order);
                boolean success=FileUtil.saveData(orders,FileUtil.ORDER_FILE);
                SocketUtil.sendBack(client,success?1:0);
            }else {//订单取消中或已退订
                SocketUtil.sendBack(client,-2);
        }
    }
    }

    /**
     * 处理审核订单请求
     * @param msg
     */
    private void processAuditOrder(Message msg) {
        String orderId=(String)msg.getData();
        List<Order>orders=FileUtil.readData(FileUtil.ORDER_FILE);
        int index=-1;
        for (int i=0;i<orders.size();i++){
            Order order=orders.get(i);
            if (order.getId().equals(orderId)){
                index=i;
                break;
            }
        }
        if (index==-1){
            SocketUtil.sendBack(client,-1);
        }else {
            Order order=orders.get(index);
            order.setState(2);
            orders.set(index, order);
            boolean success=FileUtil.saveData(orders,FileUtil.ORDER_FILE);
            SocketUtil.sendBack(client,success?1:0);
        }
    }

    /**
     * 处理在线定座请求
     * @param msg
     */
    private void processOrderSeatOnline(Message msg) {
        Map<String,Object>data=(Map<String,Object>)msg.getData();
        String planId=(String)data.get("planId");
        int row=(int)data.get("row");
        int col=(int)data.get("col");
        String username=(String)data.get("username");
        List<FilmPlan>plans=FileUtil.readData(FileUtil.FILM_PLAN_FILE);
        int index=-1;
        for(int i=0;i<plans.size();i++){
            FilmPlan fp=plans.get(i);
            if(fp.getId().equals(planId)){
                index=i;
                break;
            }
        }
        if(index==-1){
            SocketUtil.sendBack(client,-1);
        }else {
            FilmPlan plan=plans.get(index);
            FilmHall hall=plan.getFilmHall();
            hall.setOwner(row,col,username);
            plan.setFilmHall(hall);
            plans.set(index, plan);
            boolean success=FileUtil.saveData(plans,FileUtil.FILM_PLAN_FILE);
            Order order=new Order();
            order.setId(IdGenerater.generaterId(10));
            order.setFilmName(plan.getFilm().getName());
            order.setOwner(username);
            order.setBegin(plan.getBegin());
            order.setEnd(plan.getEnd());
            String seatInfo=hall.getName()+"第"+row+"排第"+col+"列";
            order.setSeatInfo(seatInfo);
            List<Order> orders=FileUtil.readData(FileUtil.ORDER_FILE);
            orders.add(order);
            FileUtil.saveData(orders,FileUtil.ORDER_FILE);
            SocketUtil.sendBack(client,success?1:0);
        }
    }

    /**
     *处理用户查看请求
     */
    private void prcessGetUserList( ) {
        List<User>users=FileUtil.readData(FileUtil.USER_FILE);
        SocketUtil.sendBack(client,users);
    }

    /**
     * 处理用户冻结请求
     * @param msg
     */
    private void prcessFrozenUser(Message msg) {
        String username=(String)msg.getData();
        List<User>users=FileUtil.readData(FileUtil.USER_FILE);
        int index=-1;
        for(int i=0;i<users.size();i++){
            if(username.equals(users.get(i).getUsername())){
                index=i;
                break;
            }
        }
        if(index==-1){//账号不存在
            SocketUtil.sendBack(client,-1);
        }else {
            User user=users.get(index);
            if(user.getState()==1){//正常
                user.setState(0);//设置为冻结状态
                users.set(index, user);
                boolean success=FileUtil.saveData(users,FileUtil.USER_FILE);
                SocketUtil.sendBack(client,success?1:0);
            }else {//被冻结
                SocketUtil.sendBack(client,-2);

            }
        }
    }

    /**
     * 处理用户解冻申请
     * @param msg
     */
    private void processUnfrozenUser(Message msg) {
        Map<String,Object>map=(Map<String,Object>)msg.getData();
        String id=(String)map.get("id");
        int number=(int)map.get("number");
        List<UnfrozenApply>applies=FileUtil.readData(FileUtil.UNFROZEN_APPLY_FILE);
        int index=-1;
        for(int i=0;i<applies.size();i++){
            UnfrozenApply apply = applies.get(i);
            if(apply.getId().equals(id)){
                index=i;
                break;
            }
        }
        if(index==-1){
            SocketUtil.sendBack(client,-2);
        }else {
            UnfrozenApply apply=applies.get(index);
            int state=apply.getState();
            if(state==0){//待处理
                apply.setState(number);
                List<User>users=FileUtil.readData(FileUtil.USER_FILE);
                int userIndex=-1;
                for(int i=0;i<users.size();i++){
                    User user = users.get(i);
                    if(user.getUsername().equals(apply.getUsername())){
                        userIndex=i;
                        break;
                    }
                }
                if(number==1){
                    User user=users.get(userIndex);
                    user.setState(1);
                    users.set(userIndex, user);
                    FileUtil.saveData(users,FileUtil.USER_FILE);
                }
                applies.set(index, apply);
                boolean success=FileUtil.saveData(applies,FileUtil.UNFROZEN_APPLY_FILE);
                SocketUtil.sendBack(client,success?1:0);
            }else {//已处理
                SocketUtil.sendBack(client,-1);
            }
        }
    }

    /**
     *处理查看解冻申请请求
     */
    private void prcessGetUnfrozenApplyList( ) {
        List<UnfrozenApply>applies=FileUtil.readData(FileUtil.UNFROZEN_APPLY_FILE);
        SocketUtil.sendBack(client,applies);
    }

    /**
     * 添加播放计划请求
     */
    private void prcessAddFilmHPlan(Message msg) {
        FilmPlan plan = (FilmPlan) msg.getData();
        List<FilmPlan> plans = FileUtil.readData(FileUtil.FILM_PLAN_FILE);
        boolean conflict = plans.stream().anyMatch(fp -> DataUtil.isConflicPlan(plan, fp));
        if (conflict) {
            SocketUtil.sendBack(client, -1);
        } else {
            plans.add(plan);
            boolean success=FileUtil.saveData(plans, FileUtil.FILM_PLAN_FILE);
            SocketUtil.sendBack(client, success?1:0);
        }
    }
    /**
     * 更新播放计划请求
     * @param msg
     */
    private void prcessUpdateFilmPlan(Message msg) {
        FilmPlan plan = (FilmPlan) msg.getData();
        List<FilmPlan> plans = FileUtil.readData(FileUtil.FILM_PLAN_FILE);
        int index=-1;
        for(int i=0;i<plans.size();i++){
            FilmPlan fp=plans.get(i);
            if(plan.getId().equals(fp.getId())){
                index=i;
                break;
            }
        }
        if(index==-1){//播放计划不存在
SocketUtil.sendBack(client, -2);
        }else {
            FilmPlan remove=  plans.remove(index);//删除原来的播放计划
            boolean conflict = plans.stream().anyMatch(fp -> DataUtil.isConflicPlan(plan, fp));
            if (conflict) {
SocketUtil.sendBack(client, -1);
            }else {
                plan.setFilm(remove.getFilm());
                plan.setFilmHall(remove.getFilmHall());
                plans.add( plan);
                boolean success=FileUtil.saveData(plans, FileUtil.FILM_PLAN_FILE);
                SocketUtil.sendBack(client, success?1:0);
            }
        }
    }

    /**
     * 删除播放计划请求
     * @param msg
     */
    private void prcessDeleteFilmPlan(Message msg) {
        String planId = (String) msg.getData();
        List<FilmPlan> plans = FileUtil.readData(FileUtil.FILM_PLAN_FILE);
        int index=-1;
        for(int i=0;i<plans.size();i++){
            FilmPlan fp=plans.get(i);
            if(planId.equals(fp.getId())){
                index=i;
                break;
            }
        }
        if(index==-1){
            SocketUtil.sendBack(client, -1);
        }else {
            plans.remove(index);
            boolean success=FileUtil.saveData(plans, FileUtil.FILM_PLAN_FILE);
            SocketUtil.sendBack(client, success?1:0);
        }
    }

    /**
     * 查看播放计划请求
     * @param msg
     */
    private void prcessGetFilmPlanList(Message msg) {
String filmNAme = (String) msg.getData();
List<FilmPlan> Plans = FileUtil.readData(FileUtil.FILM_PLAN_FILE);
if(Plans==null||"".equals(Plans)){
    SocketUtil.sendBack(client, Plans);
}else {
    List<FilmPlan>result=Plans.stream().filter(fp ->{
        Film film=fp.getFilm();
        return film.getName().contains(filmNAme)||filmNAme.contains(film.getName());
    }).collect(Collectors.toList());
    SocketUtil.sendBack(client, result);
}
    }

    /**
     * 添加影厅请求
     * @param msg
     */
    private void prcessAddFilmHall(Message msg) {
        FilmHall hall= (FilmHall) msg.getData();
        List<FilmHall> filmHalls=FileUtil.readData(FileUtil.FILM_HALL_FILE);
        filmHalls.add(hall);
        boolean succcess=FileUtil.saveData(filmHalls,FileUtil.FILM_HALL_FILE);
        SocketUtil.sendBack(client,succcess?1:0);
    }

    /**
     * 更新影厅请求
     * @param msg
     */
    private void prcessUpdateFilmHall(Message msg) {
        FilmHall updateFilmHall=(FilmHall)msg.getData();
        List<FilmHall> halls=FileUtil.readData(FileUtil.FILM_HALL_FILE);
        int index=-1;
        for(int i=0;i<halls.size();i++){
            FilmHall hall=halls.get(i);
            if(updateFilmHall.getId().equals(hall.getId())){
                index=i;
                break;
            }
        }
        if(index==-1){//说明修改的影厅信息不存在
            SocketUtil.sendBack(client,-1);
        }else {//
            halls.set(index, updateFilmHall);
            boolean success=FileUtil.saveData(halls, FileUtil.FILM_HALL_FILE);
            SocketUtil.sendBack(client,success?1:0);
        }

    }

    /**
     * 删除影厅请求
     * @param msg
     */
    private void prcessDeleteFilmHall(Message msg) {
        String id=(String)msg.getData();
        List<FilmHall> halls=FileUtil.readData(FileUtil.FILM_HALL_FILE);
        int index=-1;
        for(int i=0;i<halls.size();i++){
            FilmHall film=halls.get(i);
            if(id.equals(film.getId())){
                index=i;
                break;
            }
        }
        if(index==-1){//说明删除的影片信息不存在
            SocketUtil.sendBack(client,-1);
        }else {//
            halls.remove(index);
            boolean success=FileUtil.saveData(halls, FileUtil.FILM_HALL_FILE);
            SocketUtil.sendBack(client,success?1:0);
        }
    }

    /**
     * 查看影厅请求
     *
     */
    private void prcessGetFilmHallList() {
        List<FilmHall> halls=FileUtil.readData(FileUtil.FILM_HALL_FILE);

            SocketUtil.sendBack(client,halls);
    }

    /**
     * 处理查看影片请求
     * @param msg
     */
    private void prcessGetFilmList(Message msg) {
        String name=(String)msg.getData();
        List<Film> films=FileUtil.readData(FileUtil.FILM_FILE);
        if(name==null||"".equals(name)){
            SocketUtil.sendBack(client,films);
        }else {
            List<Film>result=films.stream().filter(f->f.getName().contains(name)||name.contains(f.getName())).collect(Collectors.toList());
            SocketUtil.sendBack(client,result);
        }
    }

    /**
     * 处理删除影片请求
     * @param msg
     */
    private void prcessDeleteFilm(Message msg) {
        String id=(String)msg.getData();
        List<Film> films=FileUtil.readData(FileUtil.FILM_FILE);
        int index=-1;
        for(int i=0;i<films.size();i++){
            Film film=films.get(i);
            if(id.equals(film.getId())){
                index=i;
                break;
            }
        }
        if(index==-1){//说明删除的影片信息不存在
            SocketUtil.sendBack(client,-1);
        }else {//
            films.remove(index);
            boolean success=FileUtil.saveData(films, FileUtil.FILM_FILE);
            SocketUtil.sendBack(client,success?1:0);
        }
    }

    /**
     * 处理更新影片请求
     */
    private void prcessUpdateFilm(Message msg) {
        Film updateFilm=(Film)msg.getData();
        List<Film> films=FileUtil.readData(FileUtil.FILM_FILE);
        int index=-1;
        for(int i=0;i<films.size();i++){
            Film film=films.get(i);
            if(updateFilm.getId().equals(film.getId())){
                index=i;
                break;
            }
        }
        if(index==-1){//说明修改的影片信息不存在
            SocketUtil.sendBack(client,-1);
        }else {//
            films.set(index, updateFilm);
            boolean success=FileUtil.saveData(films, FileUtil.FILM_FILE);
            SocketUtil.sendBack(client,success?1:0);
        }
    }

    /**
     * 处理添加影片请求
     * @param msg
     */
    private void prcessAddFilm(Message msg) {
        Film film= (Film) msg.getData();
            List<Film> films=FileUtil.readData(FileUtil.FILM_FILE);
            films.add(film);
            boolean success=FileUtil.saveData(films, FileUtil.FILM_FILE);
            SocketUtil.sendBack(client,success?1:0);
    }

    /**
     * 处理解冻申请请求
     * @param msg
     */
    private void processUnfrozenApply(Message msg){
        UnfrozenApply apply=(UnfrozenApply) msg.getData();
        List<User>storageUsers = FileUtil.readData(FileUtil.USER_FILE);
        if(storageUsers.isEmpty()){//如果存档信息为空表示没有用户注册
            User user=new User("admin","123456","CYX");
            user.setManager(true);//设置为管理员
            storageUsers.add(user);
            FileUtil.saveData(storageUsers, FileUtil.USER_FILE);
        }
        int result;
        Optional<User> opt=storageUsers.stream().filter(u->u.getUsername().equals(apply.getUsername())).findFirst();
        if(opt.isPresent()){//账号存在
            User user=opt.get();
            if(user.getState()==1){//账号正常
                result=-1;
            }else {//账号被冻结
                List<UnfrozenApply> applies=FileUtil.readData(FileUtil.UNFROZEN_APPLY_FILE);
                applies.add(apply);
                boolean success=FileUtil.saveData(applies, FileUtil.UNFROZEN_APPLY_FILE);
                result=success?1:0;
            }
        }else {//账号不存在
            result=-1;
        }
        SocketUtil.sendBack(client,result);
}
    /**
     * 处理找回密码请求
     * @param msg
     */
    private void processGetPasswordBack(Message msg){
        User getBackuser= (User) msg.getData();
        List<User>storageUsers = FileUtil.readData(FileUtil.USER_FILE);
        if(storageUsers.isEmpty()){//如果存档信息为空表示没有用户注册
            User user=new User("admin","123456","CYX");
            user.setManager(true);//设置为管理员
            storageUsers.add(user);
            FileUtil.saveData(storageUsers, FileUtil.USER_FILE);
        }
        String result=null;
        Optional<User> opt=storageUsers.stream().filter(u->u.getPassword().equals(getBackuser.getPassword())).findFirst();
        if(opt.isPresent()){//如果有存储数据
            User user=opt.get();
            if(user.getSecurityCode().equals(getBackuser.getSecurityCode())){
                result=user.getPassword();
            }
        }
        SocketUtil.sendBack(client,result);
}
    /**
     * 处理注册请求
     */
    private void processRegister(Message msg){
        User registeruser = (User) msg.getData();//因为是注册所有直接转换为用户对象
        List<User>storageUsers = FileUtil.readData(FileUtil.USER_FILE);//直接用用户链表存储读取的用户对象
        if(storageUsers.isEmpty()){//如果存档信息为空表示没有用户注册
            User user=new User("admin","123456","CYX");
            user.setManager(true);//设置为管理员
            storageUsers.add(user);
        }
        //            boolean exists=storageUsers.stream().anyMatch(new Predicate<User>() {
//                @Override
//                public boolean test(User user) {
//                    return user.getUsername().equals(registeruser.getUsername());
//                }
//            });
        int result;
        boolean exists=storageUsers.stream().anyMatch(u->u.getUsername().equals(registeruser.getUsername()));//比较用户名是否存在
        if(exists){//账号以注册
          result = -1;
        }else {//用户不存在
            storageUsers.add(registeruser);//将用户信息添加到用户列表
            boolean success= FileUtil.saveData(storageUsers, FileUtil.USER_FILE);
            result = success ? 1 : 0;
        }
        SocketUtil.sendBack(client,result);
    }

    /**
     * 处理登录请求
     * @param msg
     */
    private void prcessLogin(Message msg){
        User loginuser = (User) msg.getData();
        List<User>saveUser = FileUtil.readData(FileUtil.USER_FILE);
        if(saveUser.isEmpty()){
            User user=new User("admin","123456","CYX");
            user.setManager(true);//设置为管理员
            saveUser.add(user);
        }
        Map<String, Object>result=new HashMap<>();
        //查找与登录用户匹配的账号
        Optional<User> opt= saveUser.stream().filter(u->u.getUsername().equals(loginuser.getUsername())).findFirst();
        if(opt.isPresent()){//如果找到
            User user=opt.get();//取出来
            int state=user.getState();
            if(state==1){//正常
                //密码匹配
                if(loginuser.getPassword().equals(user.getPassword())){
                    result.put("process",1);
                    result.put("user ",user);
                }else{//密码不匹配
                    result.put("process",0);
                }
            }else {//冻结
                result.put("process",-2);
            }
        }else {//账号不存在
            result.put("process",-1);

        }
        SocketUtil.sendBack(client,result);
    }
}
