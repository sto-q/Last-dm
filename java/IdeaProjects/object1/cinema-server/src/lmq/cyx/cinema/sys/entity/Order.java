package lmq.cyx.cinema.sys.entity;

import lmq.cyx.cinema.sys.util.DataUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 */
public class Order implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 影片名称
     */
    private String filmName;
    /**
     * 开始时间
     */
    private Date begin;
    /**
     * 结束时间
     */
    private Date end;
    /**
     * 座位信息
     */
    private String seatInfo;
    /**
     * 状态 1-正常 0-退订 2-已退订
     */
    private int state=1;
    private FilmPlan plan;
    /**
     * 所属用户
     */
    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(String seatInfo) {
        this.seatInfo = seatInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        String stateStr=state==0?"退订中":state==1?"正常":"已退订";
        return id+"\t"+filmName+"\t"+ DataUtil.data2Srt(begin) +"\t"+DataUtil.data2Srt(end)+"\t"+seatInfo+"\t"
                +owner+"\t"+stateStr;
    }
}
