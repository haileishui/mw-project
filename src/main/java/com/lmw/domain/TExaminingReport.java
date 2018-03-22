package com.lmw.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TExaminingReport extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String weituodanwei;

	private String fangleileibie;
	
	private String jiancexingzhi;
	
	private String jiancedanwei;

	private String dizhi;

	private String youbian;

	private String lianxidianhua;

	private String lianxiren;

	private String tianqiqingkuang;

	private String dimianzhuangkuang;

	private String jianceyiqi;

	private String jianceriqi;

	private String jianceyiju;

	private String cunzaiwenti;

	private String jiancejielun;

	private String youxiaoqiStart;

	private String youxiaoqiEnd;

	private String jianceren;

	private String jiaohe;

	private String pizhunren;
	
	//页面传递json数组
	private String monitoringPointJson;
	//页面传递json数组
	private String antiThunderJson;
	//页面传递json数组
	private String powerSupplyJson;
	

	//防直击雷
	private List<TMonitoringPoint> monitoringPointList = new ArrayList<TMonitoringPoint>();
	//防雷电感应、防雷电波侵入
	private List<TAntiThunder> antiThunderList = new ArrayList<TAntiThunder>();
	//电源
	private List<TPowerSupply> powerSupplyList = new ArrayList<TPowerSupply>();
	//页面查询条件
	private String jianceriqiStart;
	
	private String jianceriqiEnd;

	private String title;
	private String baogaobianhao;
	private String jianzhuwuleibie;
	private String jiancejine;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeituodanwei() {
		return weituodanwei;
	}

	public void setWeituodanwei(String weituodanwei) {
		this.weituodanwei = weituodanwei == null ? null : weituodanwei.trim();
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi == null ? null : dizhi.trim();
	}

	public String getYoubian() {
		return youbian;
	}

	public void setYoubian(String youbian) {
		this.youbian = youbian == null ? null : youbian.trim();
	}

	public String getLianxidianhua() {
		return lianxidianhua;
	}

	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua == null ? null : lianxidianhua.trim();
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren == null ? null : lianxiren.trim();
	}

	public String getTianqiqingkuang() {
		return tianqiqingkuang;
	}

	public void setTianqiqingkuang(String tianqiqingkuang) {
		this.tianqiqingkuang = tianqiqingkuang == null ? null : tianqiqingkuang.trim();
	}

	public String getDimianzhuangkuang() {
		return dimianzhuangkuang;
	}

	public void setDimianzhuangkuang(String dimianzhuangkuang) {
		this.dimianzhuangkuang = dimianzhuangkuang == null ? null : dimianzhuangkuang.trim();
	}

	public String getJianceyiqi() {
		return jianceyiqi;
	}

	public void setJianceyiqi(String jianceyiqi) {
		this.jianceyiqi = jianceyiqi == null ? null : jianceyiqi.trim();
	}

	public String getJianceriqi() {
		return jianceriqi;
	}

	public void setJianceriqi(String jianceriqi) {
		this.jianceriqi = jianceriqi == null ? null : jianceriqi.trim();
	}

	public String getJianceyiju() {
		return jianceyiju;
	}

	public void setJianceyiju(String jianceyiju) {
		this.jianceyiju = jianceyiju == null ? null : jianceyiju.trim();
	}

	public String getCunzaiwenti() {
		return cunzaiwenti;
	}

	public void setCunzaiwenti(String cunzaiwenti) {
		this.cunzaiwenti = cunzaiwenti == null ? null : cunzaiwenti.trim();
	}

	public String getJiancejielun() {
		return jiancejielun;
	}

	public void setJiancejielun(String jiancejielun) {
		this.jiancejielun = jiancejielun == null ? null : jiancejielun.trim();
	}

	public String getYouxiaoqiStart() {
		return youxiaoqiStart;
	}

	public void setYouxiaoqiStart(String youxiaoqiStart) {
		this.youxiaoqiStart = youxiaoqiStart == null ? null : youxiaoqiStart.trim();
	}

	public String getYouxiaoqiEnd() {
		return youxiaoqiEnd;
	}

	public void setYouxiaoqiEnd(String youxiaoqiEnd) {
		this.youxiaoqiEnd = youxiaoqiEnd == null ? null : youxiaoqiEnd.trim();
	}

	public String getJianceren() {
		return jianceren;
	}

	public void setJianceren(String jianceren) {
		this.jianceren = jianceren == null ? null : jianceren.trim();
	}

	public String getJiaohe() {
		return jiaohe;
	}

	public void setJiaohe(String jiaohe) {
		this.jiaohe = jiaohe == null ? null : jiaohe.trim();
	}

	public String getPizhunren() {
		return pizhunren;
	}

	public void setPizhunren(String pizhunren) {
		this.pizhunren = pizhunren == null ? null : pizhunren.trim();
	}

	public List<TMonitoringPoint> getMonitoringPointList() {
		return monitoringPointList;
	}

	public void setMonitoringPointList(List<TMonitoringPoint> monitoringPointList) {
		this.monitoringPointList = monitoringPointList;
	}

	public List<TAntiThunder> getAntiThunderList() {
		return antiThunderList;
	}

	public void setAntiThunderList(List<TAntiThunder> antiThunderList) {
		this.antiThunderList = antiThunderList;
	}

	public List<TPowerSupply> getPowerSupplyList() {
		return powerSupplyList;
	}

	public void setPowerSupplyList(List<TPowerSupply> powerSupplyList) {
		this.powerSupplyList = powerSupplyList;
	}

	public String getMonitoringPointJson() {
		return monitoringPointJson;
	}

	public void setMonitoringPointJson(String monitoringPointJson) {
		this.monitoringPointJson = monitoringPointJson;
	}

	public String getAntiThunderJson() {
		return antiThunderJson;
	}

	public void setAntiThunderJson(String antiThunderJson) {
		this.antiThunderJson = antiThunderJson;
	}

	public String getPowerSupplyJson() {
		return powerSupplyJson;
	}

	public void setPowerSupplyJson(String powerSupplyJson) {
		this.powerSupplyJson = powerSupplyJson;
	}

	public String getJianceriqiStart() {
		return jianceriqiStart;
	}

	public void setJianceriqiStart(String jianceriqiStart) {
		this.jianceriqiStart = jianceriqiStart;
	}

	public String getJianceriqiEnd() {
		return jianceriqiEnd;
	}

	public void setJianceriqiEnd(String jianceriqiEnd) {
		this.jianceriqiEnd = jianceriqiEnd;
	}

	public String getFangleileibie() {
		return fangleileibie;
	}

	public void setFangleileibie(String fangleileibie) {
		this.fangleileibie = fangleileibie;
	}

	public String getJiancexingzhi() {
		return jiancexingzhi;
	}

	public void setJiancexingzhi(String jiancexingzhi) {
		this.jiancexingzhi = jiancexingzhi;
	}

	public String getJiancedanwei() {
		return jiancedanwei;
	}

	public void setJiancedanwei(String jiancedanwei) {
		this.jiancedanwei = jiancedanwei;
	}

	public String getBaogaobianhao() {
		return baogaobianhao;
	}

	public void setBaogaobianhao(String baogaobianhao) {
		this.baogaobianhao = baogaobianhao;
	}

	public String getJianzhuwuleibie() {
		return jianzhuwuleibie;
	}

	public void setJianzhuwuleibie(String jianzhuwuleibie) {
		this.jianzhuwuleibie = jianzhuwuleibie;
	}

	public String getJiancejine() {
		return jiancejine;
	}

	public void setJiancejine(String jiancejine) {
		this.jiancejine = jiancejine;
	}

	@Override
	public String toString() {
		return "TExaminingReport [id=" + id + ", weituodanwei=" + weituodanwei + ", fangleileibie=" + fangleileibie + ", jiancexingzhi=" + jiancexingzhi + ", jiancedanwei=" + jiancedanwei + ", dizhi=" + dizhi + ", youbian=" + youbian + ", lianxidianhua=" + lianxidianhua + ", lianxiren=" + lianxiren + ", tianqiqingkuang=" + tianqiqingkuang + ", dimianzhuangkuang=" + dimianzhuangkuang
				+ ", jianceyiqi=" + jianceyiqi + ", jianceriqi=" + jianceriqi + ", jianceyiju=" + jianceyiju + ", cunzaiwenti=" + cunzaiwenti + ", jiancejielun=" + jiancejielun + ", youxiaoqiStart=" + youxiaoqiStart + ", youxiaoqiEnd=" + youxiaoqiEnd + ", jianceren=" + jianceren + ", jiaohe=" + jiaohe + ", pizhunren=" + pizhunren + ", monitoringPointJson=" + monitoringPointJson
				+ ", antiThunderJson=" + antiThunderJson + ", powerSupplyJson=" + powerSupplyJson + ", monitoringPointList=" + monitoringPointList + ", antiThunderList=" + antiThunderList + ", powerSupplyList=" + powerSupplyList + ", jianceriqiStart=" + jianceriqiStart + ", jianceriqiEnd=" + jianceriqiEnd + ", title=" + title + ", baogaobianhao=" + baogaobianhao + ", jianzhuwuleibie="
				+ jianzhuwuleibie + ", jiancejine=" + jiancejine + "]";
	}

}