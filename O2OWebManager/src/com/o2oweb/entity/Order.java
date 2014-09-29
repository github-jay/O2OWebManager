// default package
package com.o2oweb.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="orderi"
    ,catalog="o2owebsit"
, uniqueConstraints = @UniqueConstraint(columnNames="OrderNum")
)

public class Order  implements java.io.Serializable {


    // Fields    

     private Integer orderId;
     private String orderNum;
     private Integer userId;
     private Date startTime;
     private Date finishTime;
     private String orderName;
     private String address;
     private boolean isPaied;
     private boolean chekOut;


    // Constructors

    /** default constructor */
    public Order() {
    }

	/** minimal constructor */
    public Order(String orderNum, Integer userId, Date startTime, String orderName, String address, boolean isPaied, boolean chekOut) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.startTime = startTime;
        this.orderName = orderName;
        this.address = address;
        this.isPaied = isPaied;
        this.chekOut = chekOut;
    }
    
    /** full constructor */
    public Order(String orderNum, Integer userId, Date startTime, Date finishTime, String orderName, String address, boolean isPaied, boolean chekOut) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.orderName = orderName;
        this.address = address;
        this.isPaied = isPaied;
        this.chekOut = chekOut;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="OrderId", unique=true, nullable=false)

    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    @Column(name="OrderNum", unique=true, nullable=false, length=45)

    public String getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    
    @Column(name="UserId", nullable=false)

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="startTime", nullable=false, length=10)

    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="finishTime", length=10)

    public Date getFinishTime() {
        return this.finishTime;
    }
    
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    
    @Column(name="OrderName", nullable=false, length=45)

    public String getOrderName() {
        return this.orderName;
    }
    
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    @Column(name="address", nullable=false, length=45)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="isPaied", nullable=false)

    public boolean getIsPaied() {
        return this.isPaied;
    }
    
    public void setIsPaied(boolean isPaied) {
        this.isPaied = isPaied;
    }
    
    @Column(name="chekOut", nullable=false)

    public boolean getChekOut() {
        return this.chekOut;
    }
    
    public void setChekOut(boolean chekOut) {
        this.chekOut = chekOut;
    }
   








}