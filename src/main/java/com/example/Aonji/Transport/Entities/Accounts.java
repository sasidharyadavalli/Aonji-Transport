package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Accounts {
    public Accounts(Long id, LocalDate date, double paidAmount, double unPaidAmount, double agentShare, double ourShare, String to, double totalAmount, Agent agent, List<Long> billIds) {
        this.id = id;
        this.date = date;
        this.paidAmount = paidAmount;
        this.unPaidAmount = unPaidAmount;
        this.agentShare = agentShare;
        this.ourShare = ourShare;
        this.to = to;
        this.totalAmount = totalAmount;
        this.agent = agent;
        this.billIds = billIds;
    }

    public Accounts() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private   Long id;

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", date=" + date +
                ", paidAmount=" + paidAmount +
                ", unPaidAmount=" + unPaidAmount +
                ", agentShare=" + agentShare +
                ", ourShare=" + ourShare +
                ", to='" + to + '\'' +
                ", totalAmount=" + totalAmount +
                ", agent=" + agent +
                ", billIds=" + billIds +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getUnPaidAmount() {
        return unPaidAmount;
    }

    public void setUnPaidAmount(double unPaidAmount) {
        this.unPaidAmount = unPaidAmount;
    }

    public double getAgentShare() {
        return agentShare;
    }

    public void setAgentShare(double agentShare) {
        this.agentShare = agentShare;
    }

    public double getOurShare() {
        return ourShare;
    }

    public void setOurShare(double ourShare) {
        this.ourShare = ourShare;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    private LocalDate date;

   private double paidAmount;
   private double unPaidAmount;

   private double agentShare;
   private double ourShare;
   @Column(name = "`to`")
   private String to;
   private double totalAmount;

    @ManyToOne
     @JoinColumn(name = "agent_id")
   private Agent agent;

    @ElementCollection
    @CollectionTable(name = "account_ids",joinColumns = @JoinColumn(name = "account_id"))
   @Column(name = "bill_id")
    private List<Long> billIds;

    public List<Long> getBillIds() {
        return billIds;
    }

    public void setBillIds(List<Long> billIds) {
        this.billIds = billIds;
    }
}
