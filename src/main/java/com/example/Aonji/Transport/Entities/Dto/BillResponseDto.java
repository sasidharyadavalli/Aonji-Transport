package com.example.Aonji.Transport.Entities.Dto;

import java.util.Date;

public class BillResponseDto {
    private Long id;
    private Long lr_no;
    private Integer no_of_parcels;
    private Date date;
    private String parcel_description;
    private Double cost;
    private Boolean paid;

    public Long getId() {
        return id;
    }
       Long AgentMobile;

    public Long getAgentMobile() {
        return AgentMobile;
    }

    public void setAgentMobile(Long agentMobile) {
        AgentMobile = agentMobile;
    }

    public BillResponseDto() {
    }

    public BillResponseDto(Long AgentMobile,Long id, Long lr_no, Integer no_of_parcels, Date date, String parcel_description, Double cost, Boolean paid, String consignor, String consignee, String to_townOrCity, String from_TownOrCity, Long to_mobile, Long from_mobile) {
       this.AgentMobile=AgentMobile;
        this.id = id;
        this.lr_no = lr_no;
        this.no_of_parcels = no_of_parcels;
        this.date = date;
        this.parcel_description = parcel_description;
        this.cost = cost;
        this.paid = paid;
        this.consignor = consignor;
        this.consignee = consignee;
        this.to_townOrCity = to_townOrCity;
        this.from_TownOrCity = from_TownOrCity;
        this.to_mobile = to_mobile;
        this.from_mobile = from_mobile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLr_no() {
        return lr_no;
    }

    public void setLr_no(Long lr_no) {
        this.lr_no = lr_no;
    }

    public Integer getNo_of_parcels() {
        return no_of_parcels;
    }

    public void setNo_of_parcels(Integer no_of_parcels) {
        this.no_of_parcels = no_of_parcels;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParcel_description() {
        return parcel_description;
    }

    public void setParcel_description(String parcel_description) {
        this.parcel_description = parcel_description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTo_townOrCity() {
        return to_townOrCity;
    }

    public void setTo_townOrCity(String to_townOrCity) {
        this.to_townOrCity = to_townOrCity;
    }

    public String getFrom_TownOrCity() {
        return from_TownOrCity;
    }

    public void setFrom_TownOrCity(String from_TownOrCity) {
        this.from_TownOrCity = from_TownOrCity;
    }

    public Long getTo_mobile() {
        return to_mobile;
    }

    public void setTo_mobile(Long to_mobile) {
        this.to_mobile = to_mobile;
    }

    public Long getFrom_mobile() {
        return from_mobile;
    }

    public void setFrom_mobile(Long from_mobile) {
        this.from_mobile = from_mobile;
    }


    @Override
    public String toString() {
        return "BillResponseDto{" +
                "id=" + id +
                ", lr_no=" + lr_no +
                ", no_of_parcels=" + no_of_parcels +
                ", date=" + date +
                ", parcel_description='" + parcel_description + '\'' +
                ", cost=" + cost +
                ", paid=" + paid +
                ", AgentMobile=" + AgentMobile +
                ", consignor='" + consignor + '\'' +
                ", consignee='" + consignee + '\'' +
                ", to_townOrCity='" + to_townOrCity + '\'' +
                ", from_TownOrCity='" + from_TownOrCity + '\'' +
                ", to_mobile=" + to_mobile +
                ", from_mobile=" + from_mobile +
                '}';
    }

    private String consignor;
    private String consignee;
    private String to_townOrCity;
    private String from_TownOrCity;
    private Long to_mobile;
    private Long from_mobile;

}
