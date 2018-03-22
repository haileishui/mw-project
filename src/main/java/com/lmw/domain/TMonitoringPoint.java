package com.lmw.domain;

import java.io.Serializable;

public class TMonitoringPoint extends BaseBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer pid;

    private String jiancedianmingchen;

    private String jiashegaodu;

    private String xingzhuang;

    private String cailiao;

    private String yunxuzhi;

    private String shicezhi;

    private String cailiao2;

    private String fushefangshi;

    private String jianju;

    private String yunxuzhi2;

    private String shicezhi2;

    private String yunxuzhi3;

    private String shicezhi3;

    private String jielun;

    private String beizhu;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getJiancedianmingchen() {
        return jiancedianmingchen;
    }

    public void setJiancedianmingchen(String jiancedianmingchen) {
        this.jiancedianmingchen = jiancedianmingchen == null ? null : jiancedianmingchen.trim();
    }

    public String getJiashegaodu() {
        return jiashegaodu;
    }

    public void setJiashegaodu(String jiashegaodu) {
        this.jiashegaodu = jiashegaodu == null ? null : jiashegaodu.trim();
    }

    public String getXingzhuang() {
        return xingzhuang;
    }

    public void setXingzhuang(String xingzhuang) {
        this.xingzhuang = xingzhuang == null ? null : xingzhuang.trim();
    }

    public String getCailiao() {
        return cailiao;
    }

    public void setCailiao(String cailiao) {
        this.cailiao = cailiao == null ? null : cailiao.trim();
    }

    public String getYunxuzhi() {
        return yunxuzhi;
    }

    public void setYunxuzhi(String yunxuzhi) {
        this.yunxuzhi = yunxuzhi == null ? null : yunxuzhi.trim();
    }

    public String getShicezhi() {
        return shicezhi;
    }

    public void setShicezhi(String shicezhi) {
        this.shicezhi = shicezhi == null ? null : shicezhi.trim();
    }

    public String getCailiao2() {
        return cailiao2;
    }

    public void setCailiao2(String cailiao2) {
        this.cailiao2 = cailiao2 == null ? null : cailiao2.trim();
    }

    public String getFushefangshi() {
        return fushefangshi;
    }

    public void setFushefangshi(String fushefangshi) {
        this.fushefangshi = fushefangshi == null ? null : fushefangshi.trim();
    }

    public String getJianju() {
        return jianju;
    }

    public void setJianju(String jianju) {
        this.jianju = jianju == null ? null : jianju.trim();
    }

    public String getYunxuzhi2() {
        return yunxuzhi2;
    }

    public void setYunxuzhi2(String yunxuzhi2) {
        this.yunxuzhi2 = yunxuzhi2 == null ? null : yunxuzhi2.trim();
    }

    public String getShicezhi2() {
        return shicezhi2;
    }

    public void setShicezhi2(String shicezhi2) {
        this.shicezhi2 = shicezhi2 == null ? null : shicezhi2.trim();
    }

    public String getYunxuzhi3() {
        return yunxuzhi3;
    }

    public void setYunxuzhi3(String yunxuzhi3) {
        this.yunxuzhi3 = yunxuzhi3 == null ? null : yunxuzhi3.trim();
    }

    public String getShicezhi3() {
        return shicezhi3;
    }

    public void setShicezhi3(String shicezhi3) {
        this.shicezhi3 = shicezhi3 == null ? null : shicezhi3.trim();
    }

    public String getJielun() {
        return jielun;
    }

    public void setJielun(String jielun) {
        this.jielun = jielun == null ? null : jielun.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }
	@Override
	public String toString() {
		return "TMonitoringPoint [id=" + id + ", pid=" + pid + ", jiancedianmingchen=" + jiancedianmingchen + ", jiashegaodu=" + jiashegaodu + ", xingzhuang=" + xingzhuang + ", cailiao=" + cailiao + ", yunxuzhi=" + yunxuzhi + ", shicezhi=" + shicezhi + ", cailiao2=" + cailiao2 + ", fushefangshi=" + fushefangshi + ", jianju=" + jianju + ", yunxuzhi2=" + yunxuzhi2 + ", shicezhi2=" + shicezhi2
				+ ", yunxuzhi3=" + yunxuzhi3 + ", shicezhi3=" + shicezhi3 + ", jielun=" + jielun + ", beizhu=" + beizhu + "]";
	}
}