package com.ming.plc.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_plastic_pipe")
public class PlasticPipe implements Serializable {


    private long mainkey;
    private String type;
    private String code;
    private String name;
    private String cost;
    private String price;
    private String createdate;
    private String makercode;
    private String maker;
    private String moditime;
    private String modifier;
    private String modicode;

    public PlasticPipe() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getMainkey() {
        return mainkey;
    }

    public void setMainkey(long mainkey) {
        this.mainkey = mainkey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getMakercode() {
        return makercode;
    }

    public void setMakercode(String makercode) {
        this.makercode = makercode;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModitime() {
        return moditime;
    }

    public void setModitime(String moditime) {
        this.moditime = moditime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModicode() {
        return modicode;
    }

    public void setModicode(String modicode) {
        this.modicode = modicode;
    }


}
