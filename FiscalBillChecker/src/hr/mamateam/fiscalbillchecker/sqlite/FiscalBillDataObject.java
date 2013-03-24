package hr.mamateam.fiscalbillchecker.sqlite;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import android.graphics.Bitmap;

/**
 * Data object representing web form data.
 * @author Black
 */
public class FiscalBillDataObject {
	private Integer ID = null;
	private String JIR = null;
	private ArrayList<String> JIRList = null;
	private String code = null;
	private Date billDate = null;
	private Integer billHour = null;
	private Integer billMinute = null;
	private BigDecimal billAmountKn = null;
	private BigDecimal billAmountLp = null;
	private Bitmap captcha = null;
	
	//Additional data
	private Integer billCheckStatus = null; //0-unchecked, 1-checked
	private String billStatus = null; //OK, NOK
	
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getJIR() {
		return JIR;
	}
	public void setJIR(String jIR) {
		JIR = jIR;
	}
	public ArrayList<String> getJIRList() {
		return JIRList;
	}
	public void setJIRList(ArrayList<String> jIRList) {
		JIRList = jIRList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Integer getBillHour() {
		return billHour;
	}
	public void setBillHour(Integer billHour) {
		this.billHour = billHour;
	}
	public Integer getBillMinute() {
		return billMinute;
	}
	public void setBillMinute(Integer billMinute) {
		this.billMinute = billMinute;
	}
	public BigDecimal getBillAmountKn() {
		return billAmountKn;
	}
	public void setBillAmountKn(BigDecimal billAmountKn) {
		this.billAmountKn = billAmountKn;
	}
	public BigDecimal getBillAmountLp() {
		return billAmountLp;
	}
	public void setBillAmountLp(BigDecimal billAmountLp) {
		this.billAmountLp = billAmountLp;
	}
	public Bitmap getCaptcha() {
		return captcha;
	}
	public void setCaptcha(Bitmap captcha) {
		this.captcha = captcha;
	}
	public Integer getBillCheckStatus() {
		return billCheckStatus;
	}
	public void setBillCheckStatus(Integer billCheckStatus) {
		this.billCheckStatus = billCheckStatus;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public boolean isCaptchaSet(){
		if (this.captcha == null) return false;
		else return true;
	}
	
	public String printValues (){
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------");
		sb.append("\nJIR = "+getJIR());
		sb.append("\ncode = "+getCode());
		sb.append("\nbillDate = "+getBillDate());
		sb.append("\nbillHour = "+getBillHour());
		sb.append("\nbillMinute = "+getBillMinute());
		sb.append("\nbillAmountKn = "+getBillAmountKn());
		sb.append("\nbillAmountLp = "+getBillAmountLp());
		sb.append("\nisCaptchaSet = " + isCaptchaSet());
		sb.append("\nbillCheckStatus = "+getBillCheckStatus());
		sb.append("\nbillStatus = "+getBillStatus());
		sb.append("\n-----------------");
		
		return sb.toString();
	}
	
	public String toString (){
		
		
		return "";  //TODO
	}
	
	

}
