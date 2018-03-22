package com.lmw.domain;

import java.io.Serializable;

public class TAntiThunder extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer pid;

	private String jiancedianmingcheng;

	private String jinshuwumingcheng;

	private String waiguanjiancha;

	private String lianjiedaoticailiaoheguige;

	private String yunxuzhi;

	private String shicezhi;

	private String yunxuzhi2;

	private String shicezhi2;

	private String changjinshuwumingcheng;

	private String kuajiezhuangkuang;

	private String kuajiedaoticailiaoheguige;

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

	public String getJiancedianmingcheng() {
		return jiancedianmingcheng;
	}

	public void setJiancedianmingcheng(String jiancedianmingcheng) {
		this.jiancedianmingcheng = jiancedianmingcheng == null ? null : jiancedianmingcheng.trim();
	}

	public String getJinshuwumingcheng() {
		return jinshuwumingcheng;
	}

	public void setJinshuwumingcheng(String jinshuwumingcheng) {
		this.jinshuwumingcheng = jinshuwumingcheng == null ? null : jinshuwumingcheng.trim();
	}

	public String getWaiguanjiancha() {
		return waiguanjiancha;
	}

	public void setWaiguanjiancha(String waiguanjiancha) {
		this.waiguanjiancha = waiguanjiancha == null ? null : waiguanjiancha.trim();
	}

	public String getLianjiedaoticailiaoheguige() {
		return lianjiedaoticailiaoheguige;
	}

	public void setLianjiedaoticailiaoheguige(String lianjiedaoticailiaoheguige) {
		this.lianjiedaoticailiaoheguige = lianjiedaoticailiaoheguige == null ? null : lianjiedaoticailiaoheguige.trim();
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

	public String getChangjinshuwumingcheng() {
		return changjinshuwumingcheng;
	}

	public void setChangjinshuwumingcheng(String changjinshuwumingcheng) {
		this.changjinshuwumingcheng = changjinshuwumingcheng == null ? null : changjinshuwumingcheng.trim();
	}

	public String getKuajiezhuangkuang() {
		return kuajiezhuangkuang;
	}

	public void setKuajiezhuangkuang(String kuajiezhuangkuang) {
		this.kuajiezhuangkuang = kuajiezhuangkuang == null ? null : kuajiezhuangkuang.trim();
	}

	public String getKuajiedaoticailiaoheguige() {
		return kuajiedaoticailiaoheguige;
	}

	public void setKuajiedaoticailiaoheguige(String kuajiedaoticailiaoheguige) {
		this.kuajiedaoticailiaoheguige = kuajiedaoticailiaoheguige == null ? null : kuajiedaoticailiaoheguige.trim();
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
		return "TAntiThunder [id=" + id + ", pid=" + pid + ", jiancedianmingcheng=" + jiancedianmingcheng + ", jinshuwumingcheng=" + jinshuwumingcheng + ", waiguanjiancha=" + waiguanjiancha + ", lianjiedaoticailiaoheguige=" + lianjiedaoticailiaoheguige + ", yunxuzhi=" + yunxuzhi + ", shicezhi=" + shicezhi + ", yunxuzhi2=" + yunxuzhi2 + ", shicezhi2=" + shicezhi2 + ", changjinshuwumingcheng="
				+ changjinshuwumingcheng + ", kuajiezhuangkuang=" + kuajiezhuangkuang + ", kuajiedaoticailiaoheguige=" + kuajiedaoticailiaoheguige + ", yunxuzhi3=" + yunxuzhi3 + ", shicezhi3=" + shicezhi3 + ", yunxuzhi4=" + yunxuzhi4 + ", shicezhi4=" + shicezhi4 + ", jielun=" + jielun + ", beizhu=" + beizhu + "]";
	}
	
}