package lmq.cyx.cinema.sys.entity;

import lmq.cyx.cinema.sys.util.DataUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 影片播放计划
 */
public class FilmPlan implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 影片
     */
    private Film film;
    /**
     * 影厅
     */
    private FilmHall filmHall;
    /**
     * 开始时间
     */
    private Date begin;
    /**
     * 结束时间
     */
    private Date end;

    public FilmPlan(String id, Film film, FilmHall filmHall, Date begin, Date end) {
        this.id = id;
        this.film = film;
        this.filmHall = filmHall;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        String name=film==null?"":film.getName();
        String desc=film==null?"":film.getDescription();
        String nameHall=filmHall==null?"":filmHall.getName();
        int restTicket=filmHall==null?0:filmHall.getRestTicket();
        return id+"\t"+name+"\t"+desc+"\t"+nameHall+"\t"+ DataUtil.data2Srt(begin)+"\t"+DataUtil.data2Srt(end)+"\t"+restTicket;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
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
}
