package com.example.Aonji.Transport.Entities.Dto;

import com.example.Aonji.Transport.Entities.Details;

import java.time.LocalDate;
import java.util.List;

public class BillResponseDto {
    private Long id;
    private Long lrNo;
    private Integer no_of_parcels;
    private LocalDate date;
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

    public BillResponseDto(Boolean reached,Long id, Long lrNo, Integer no_of_parcels, LocalDate date, String parcel_description, Double cost, Boolean paid, Long agentMobile, String consignor, String consignee, String to, String from, Long to_mobile, Long from_mobile, List<Details> details) {
        this.id = id;
        this.lrNo = lrNo;
        this.no_of_parcels = no_of_parcels;
        this.date = date;
        this.parcel_description = parcel_description;
        this.cost = cost;
        this.paid = paid;
        AgentMobile = agentMobile;
        this.consignor = consignor;
        this.consignee = consignee;
        this.to = to;
        this.from = from;
        this.to_mobile = to_mobile;
        this.from_mobile = from_mobile;
        this.details = details;
        this.reached=reached;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLrNo() {
        return lrNo;
    }

    public void setLrNo(Long lrNo) {
        this.lrNo = lrNo;
    }

    public Integer getNo_of_parcels() {
        return no_of_parcels;
    }

    public void setNo_of_parcels(Integer no_of_parcels) {
        this.no_of_parcels = no_of_parcels;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public Boolean getReached() {
        return reached;
    }

    public void setReached(Boolean reached) {
        this.reached = reached;
    }

    @Override
    public String toString() {
        return "BillResponseDto{" +
                "id=" + id +
                ", lrNo=" + lrNo +
                ", no_of_parcels=" + no_of_parcels +
                ", date=" + date +
                ", parcel_description='" + parcel_description + '\'' +
                ", cost=" + cost +
                ", paid=" + paid +
                ", AgentMobile=" + AgentMobile +
                ", reached=" + reached +
                ", consignor='" + consignor + '\'' +
                ", consignee='" + consignee + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", to_mobile=" + to_mobile +
                ", from_mobile=" + from_mobile +
                ", details=" + details +
                '}';
    }

    private Boolean reached;
    private String consignor;
    private String consignee;
    private String to;
    private String from;
    private Long to_mobile;
    private Long from_mobile;

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }

    private List<Details>details;

}
