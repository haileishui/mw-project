package com.lmw.domain;

import java.io.Serializable;

public class TPowerSupply extends BaseBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer pid;

    private String jiancedianbianhao;

    private String anzhuangweizhi;

    private String chanpinxinghao;

    private String changdu;

    private String yunxuzhi;

    private String shicezhi;

    private String sebiao;

    private String cailiao;

    private String yunxuzhi2;

    private String shicezhi2;

    private String yunxuzhi3;

    private String shicezhi3;

    private String yunxuzhi4;

    private String shicezhi4;

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

	public String getJiancedianbianhao() {
        return jiancedianbianhao;
    }

    public void setJiancedianbianhao(String jiancedianbianhao) {
        this.jiancedianbianhao = jiancedianbianhao == null ? null : jiancedianbianhao.trim();
    }

    public String getAnzhuangweizhi() {
        return anzhuangweizhi;
    }

    public void setAnzhuangweizhi(String anzhuangweizhi) {
        this.anzhuangweizhi = anzhuangweizhi == null ? null : anzhuangweizhi.trim();
    }

    public String getChanpinxinghao() {
        return chanpinxinghao;
    }

    public void setChanpinxinghao(String chanpinxinghao) {
        this.chanpinxinghao = chanpinxinghao == null ? null : chanpinxinghao.trim();
    }

    public String getChangdu() {
        return changdu;
    }

    public void setChangdu(String changdu) {
        this.changdu = changdu == null ? null : changdu.trim();
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

    public String getSebiao() {
        return sebiao;
    }

    public void setSebiao(String sebiao) {
        this.sebiao = sebiao == null ? null : sebiao.trim();
    }

    public String getCailiao() {
        return cailiao;
    }

    public void setCailiao(String cailiao) {
        this.cailiao = cailiao == null ? null : cailiao.trim();
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

    public String getYunxuzhi4() {
        return yunxuzhi4;
    }

    public void setYunxuzhi4(String yunxuzhi4) {
        this.yunxuzhi4 = yunxuzhi4 == null ? null : yunxuzhi4.trim();
    }

    public String getShicezhi4() {
        return shicezhi4;
    }

    public void setShicezhi4(String shicezhi4) {
        this.shicezhi4 = shicezhi4 == null ? null : shicezhi4.trim();
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
		return "TPowerSupply [id=" + id + ", pid=" + pid + ", jiancedianbianhao=" + jiancedianbianhao + ", anzhuangweizhi=" + anzhuangweizhi + ", chanpinxinghao=" + chanpinxinghao + ", changdu=" + changdu + ", yunxuzhi=" + yunxuzhi + ", shicezhi=" + shicezhi + ", sebiao=" + sebiao + ", cailiao=" + cailiao + ", yunxuzhi2=" + yunxuzhi2 + ", shicezhi2=" + shicezhi2 + ", yunxuzhi3=" + yunxuzhi3
				+ ", shicezhi3=" + shicezhi3 + ", yunxuzhi4=" + yunxuzhi4 + ", shicezhi4=" + shicezhi4 + ", jielun=" + jielun + ", beizhu=" + beizhu + "]";
	}
}