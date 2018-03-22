package com.lmw.domain;

import java.io.Serializable;

public class TExaminingReportStatistics extends BaseBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String baogaobianhao;

    private String beijiancedanweimingcheng;

    private String lianxiren;

    private String dianhua;

    private String jianceren;

    private String feiyong;

    private String fapiaoshijian;

    private String daozhangshijian;

    private String jianceriqi;

    private String xiaciriqi;

    private String baogaolingquren;

    private String beizhu;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBaogaobianhao() {
        return baogaobianhao;
    }

    public void setBaogaobianhao(String baogaobianhao) {
        this.baogaobianhao = baogaobianhao == null ? null : baogaobianhao.trim();
    }

    public String getBeijiancedanweimingcheng() {
        return beijiancedanweimingcheng;
    }

    public void setBeijiancedanweimingcheng(String beijiancedanweimingcheng) {
        this.beijiancedanweimingcheng = beijiancedanweimingcheng == null ? null : beijiancedanweimingcheng.trim();
    }

    public String getLianxiren() {
        return lianxiren;
    }

    public void setLianxiren(String lianxiren) {
        this.lianxiren = lianxiren == null ? null : lianxiren.trim();
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua == null ? null : dianhua.trim();
    }

    public String getJianceren() {
        return jianceren;
    }

    public void setJianceren(String jianceren) {
        this.jianceren = jianceren == null ? null : jianceren.trim();
    }

    public String getFeiyong() {
        return feiyong;
    }

    public void setFeiyong(String feiyong) {
        this.feiyong = feiyong == null ? null : feiyong.trim();
    }

    public String getFapiaoshijian() {
        return fapiaoshijian;
    }

    public void setFapiaoshijian(String fapiaoshijian) {
        this.fapiaoshijian = fapiaoshijian == null ? null : fapiaoshijian.trim();
    }

    public String getDaozhangshijian() {
        return daozhangshijian;
    }

    public void setDaozhangshijian(String daozhangshijian) {
        this.daozhangshijian = daozhangshijian == null ? null : daozhangshijian.trim();
    }

    public String getJianceriqi() {
        return jianceriqi;
    }

    public void setJianceriqi(String jianceriqi) {
        this.jianceriqi = jianceriqi == null ? null : jianceriqi.trim();
    }

    public String getXiaciriqi() {
        return xiaciriqi;
    }

    public void setXiaciriqi(String xiaciriqi) {
        this.xiaciriqi = xiaciriqi == null ? null : xiaciriqi.trim();
    }

    public String getBaogaolingquren() {
        return baogaolingquren;
    }

    public void setBaogaolingquren(String baogaolingquren) {
        this.baogaolingquren = baogaolingquren == null ? null : baogaolingquren.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

	@Override
	public String toString() {
		return "TExaminingReportStatistics [id=" + id + ", baogaobianhao=" + baogaobianhao + ", beijiancedanweimingcheng=" + beijiancedanweimingcheng + ", lianxiren=" + lianxiren + ", dianhua=" + dianhua + ", jianceren=" + jianceren + ", feiyong=" + feiyong + ", fapiaoshijian=" + fapiaoshijian + ", daozhangshijian=" + daozhangshijian + ", jianceriqi=" + jianceriqi + ", xiaciriqi=" + xiaciriqi
				+ ", baogaolingquren=" + baogaolingquren + ", beizhu=" + beizhu + "]";
	}
    
}