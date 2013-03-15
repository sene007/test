package hr.mamateam.fiscalbillchecker;

import java.math.BigDecimal;
import java.sql.Date;

import android.graphics.Bitmap;

/**
 * Data object representing web form data.
 * @author Black
 */
public class WebFormDataObject {
	private String JIR = null;
	private String code = null;
	private Date billDate = null;
	private Integer billHour = null;
	private Integer billMinute = null;
	private BigDecimal billAmount = null;
	private Bitmap captcha = null;
	
	//Additional data
	private Integer billCheckStatus = null; //0-unchecked, 1-checked
	private String billStatus = null; //OK, NOK
	
	
	
	public String getJIR() {
		return JIR;
	}
	public void setJIR(String jIR) {
		JIR = jIR;
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
	public BigDecimal getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
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
	
	public String toString (){
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------");
		sb.append("\nJIR = "+getJIR());
		sb.append("\ncode = "+getCode());
		sb.append("\nbillDate = "+getBillDate());
		sb.append("\nbillHour = "+getBillHour());
		sb.append("\nbillMinute = "+getBillMinute());
		sb.append("\nbillAmount = "+getBillAmount());
		sb.append("\nisCaptchaSet = " + isCaptchaSet());
		sb.append("\nbillCheckStatus = "+getBillCheckStatus());
		sb.append("\nbillStatus = "+getBillStatus());
		sb.append("\n-----------------");
		
		return sb.toString();
	}
	
	

}
