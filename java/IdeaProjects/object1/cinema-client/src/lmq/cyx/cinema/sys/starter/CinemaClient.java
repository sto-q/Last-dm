package lmq.cyx.cinema.sys.starter;

import lmq.cyx.cinema.sys.action.UserAction;
import lmq.cyx.cinema.sys.entity.User;
import lmq.cyx.cinema.sys.menu.Menu;
import lmq.cyx.cinema.sys.menu.MenuManager;
import lmq.cyx.cinema.sys.util.InputUtil;

import java.util.*;

/**
 * 影院客户端
 */
public class CinemaClient {
    /**
     * 当前用户
     */
    private static User currentUser;
    public static void main(String[] args) {
       showInterface(MenuManager.LOGIN_MENUS);
    }

    /**
     * 展示界面
     */
    private static void showInterface(Menu[] menus) {
        MenuManager.showMenu(menus);
        int number= InputUtil.getInputInttegrt("请选择菜单编号:",1,menus.length);
        Menu select = menus[number-1];
        switch (select.getAction()){
            case "login":
                Map<String, Object>result=UserAction.login();
                if(result==null){//登录失败
                    System.out.println("登录失败，账号或密码错误");
                    showInterface(MenuManager.LOGIN_MENUS);
                }else {
                    int process= (int) result.get("process");
                    if(process==1){//登录成功
                         currentUser= (User) result.get("manager");
                        Menu[] mainMains=currentUser.isManager() ? MenuManager.MANAGER_MENUS :MenuManager.USER_MENUS;
                        showInterface(mainMains);
                    }else{
                        String msg;
                        if(process==0){//账号或密码错误
                            msg="登录失败，账号或密码错误";
                        }else if(process==-1){//账号不存在
                            msg="登录失败，账户不存在";
                        }else {//账号被冻结
                            msg="登录失败，账户被冻结";
                        }
                        System.out.println(msg);
                        showInterface(MenuManager.LOGIN_MENUS);
                    }
                }
                break;
            case "register":
                UserAction.register();
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case "getPasswordBack":
                UserAction.getPasswordBack();
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case "unfrozenApply":
                UserAction.unfrozenApply();
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case "quit":
                UserAction.quit();
                break;
            case "showChildren":
                List<Menu> children = select.getChildren();
                Menu[] childMenus=children.toArray(new Menu[children.size()]);
                showInterface(childMenus);
                break;
            case "goBackLogin":
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case"goBackMain":
                showInterface(currentUser.isManager()?MenuManager.MANAGER_MENUS:MenuManager.USER_MENUS);
                break;
            case "addFilmHall"://添加影厅
                UserAction.addFilmHall();
                showSiblingMenus(select);
                break;
            case "updateFilmHall"://修改影厅
                UserAction.updateFilmHall();
                showSiblingMenus(select);
                break;
            case "deleteFilmHall"://删除影厅
                UserAction.deleteFilmHall();
                showSiblingMenus(select);
                break;
            case "getFilmHallList"://查看影厅
                UserAction.getFilmHallList();
                showSiblingMenus(select);
                break;
            case "addFilm"://添加影片
                UserAction.addFilm();
                showSiblingMenus(select);
                break;
            case "updateFilm"://修改影片
                UserAction.updateFilm();
                showSiblingMenus(select);
                break;
            case "deleteFilm"://删除影片
                UserAction.deleteFilm();
                showSiblingMenus(select);
                break;
            case "getFilmList"://查看影片
                UserAction.getFilmList();
                showSiblingMenus(select);
                break;
            case "addFilmPlan"://添加播放计划
                UserAction.addFilmPlan();
                showSiblingMenus(select);
                break;
            case "updateFilmPlan"://修改播放计划
                UserAction.updateFilmPlan();
                showSiblingMenus(select);
                break;
            case "deleteFilmPlan"://删除播放计划
                UserAction.deleteFilmPlan();
                showSiblingMenus(select);
                break;
            case "getFilmPlanList"://查看播放计划
                UserAction.getFilmPlanList();
                showSiblingMenus(select);
                break;
            case "getUserList"://查看用户
                UserAction.getUserList();
                showSiblingMenus(select);
                break;
            case "frozenUser"://冻结用户
                UserAction.frozenUser();
                showSiblingMenus(select);
                break;
            case "unfrozenUser"://解冻用户
                UserAction.unfrozenUser();
                showSiblingMenus(select);
                break;
            case "getUnfrozenApply"://查看用户解冻申请
                UserAction.getUnfrozenApplyList();
                showSiblingMenus(select);
            case"getOrderList"://查看订单
                UserAction.getOrderList();
                showSiblingMenus(select);
                break;
            case"getUserOrderList":
                UserAction.getUserOrderList(currentUser.getUsername());
                showSiblingMenus(select);
                break;
            case"updateOrder"://修改订单
                UserAction.updateOrder();
                showSiblingMenus(select);
                break;
            case"cancelOrder"://取消订单
                UserAction.cancelOrder();
                showSiblingMenus(select);
                break;
            case "auditOrder"://审核订单
                UserAction.auditOrder();
                showSiblingMenus(select);
                break;
            case "orderSeatOnline"://在线订座
                UserAction.orderSeatOnline(currentUser.isManager());
                showSiblingMenus(select);
                break;
            default://其他子菜单操作
                showSiblingMenus(select);
        }
    }
//    private static void showLoginMenu(){
//        MenuManager.showMenu(MenuManager.LOGIN_MENUS);
//        int number= InputUtil.getInputInttegrt("请选择菜单编号:",1,MenuManager.LOGIN_MENUS.length);
//        Menu select = MenuManager.LOGIN_MENUS[number-1];
//        switch (select.getAction()){
//            case "login":
//                UserAction.login();
//                showMainMenu();
//                break;
//            case "register":
//                UserAction.register();
//                showLoginMenu();
//                break;
//            case "getPasswordBack":
//                UserAction.getPasswordBack();
//                showLoginMenu();
//                break;
//            case "unfrozenApply":
//                UserAction.unfrozenApply();
//                showLoginMenu();
//                break;
//            case "quit":
//                UserAction.quit();
//                break;
//        }
//
//    }
//    private static void showMainMenu(){
//        MenuManager.showMenu(MenuManager.USER_MENUS);
//        int number= InputUtil.getInputInttegrt("请选择菜单编号:",1,MenuManager.USER_MENUS.length);
//        Menu select = MenuManager.USER_MENUS[number-1];
//        switch (select.getAction()){
//            case "showChildren":
//                showChildren(select);
//                break;
//            case "goBackLogin":
//                showLoginMenu();
//                break;
//
//        }
//    }

    /**
     * 展示与所选子菜单同级的子菜单列表
     * @param childMenu
     */
    private static void showSiblingMenus(Menu childMenu) {
        Menu parent=childMenu.getParent();
        List<Menu> children = parent.getChildren();
        Menu[] menus=children.toArray(new Menu[children.size()]);
       showInterface(menus);
    }

}
