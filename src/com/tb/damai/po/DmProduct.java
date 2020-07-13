package com.tb.damai.po;

import java.sql.Timestamp;

public class DmProduct {
	private Integer id;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private Timestamp createtime;
	private Integer cid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((is_hot == null) ? 0 : is_hot.hashCode());
		result = prime * result + ((market_price == null) ? 0 : market_price.hashCode());
		result = prime * result + ((pdesc == null) ? 0 : pdesc.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + ((shop_price == null) ? 0 : shop_price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DmProduct other = (DmProduct) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (is_hot == null) {
			if (other.is_hot != null)
				return false;
		} else if (!is_hot.equals(other.is_hot))
			return false;
		if (market_price == null) {
			if (other.market_price != null)
				return false;
		} else if (!market_price.equals(other.market_price))
			return false;
		if (pdesc == null) {
			if (other.pdesc != null)
				return false;
		} else if (!pdesc.equals(other.pdesc))
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (shop_price == null) {
			if (other.shop_price != null)
				return false;
		} else if (!shop_price.equals(other.shop_price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DmProduct [id=" + id + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", image=" + image + ", pdesc=" + pdesc + ", is_hot=" + is_hot + ", createtime="
				+ createtime + ", cid=" + cid + "]";
	}
	
	
}
