package com.test.bean;

public class Goods {
    private Integer gId;
    private String gName;
    private Integer price;
    private Integer stock;
    private Address address;

    @Override
    public String toString() {
        return "Goods{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getgId() {
        return gId;
    }

    public String getgName() {
        return gName;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
