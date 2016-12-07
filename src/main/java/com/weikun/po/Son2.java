package com.weikun.po;

/**
 * Created by Administrator on 2016/12/7.
 */
@javax.persistence.Entity
public class Son2 {
    private int sid;
    private String sname;
    private Father2 father;

    @javax.persistence.Id
    @javax.persistence.Column(name = "sid", nullable = false)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "sname", nullable = true, length = 10)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Son2 son2 = (Son2) o;

        if (sid != son2.sid) return false;
        if (sname != null ? !sname.equals(son2.sname) : son2.sname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        return result;
    }

    @javax.persistence.ManyToOne(cascade = {})
    @javax.persistence.JoinColumn(name = "fid", referencedColumnName = "fid", nullable = true, table = "")
    public Father2 getFather() {
        return father;
    }

    public void setFather(Father2 father) {
        this.father = father;
    }
}
