package cn.ilongfei.springbootbasic.domain.ups;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ilongfei.springbootbasic.domain.OracleBaseEntity;

/*
 * 外部系统出款请求明细
 */
@Entity
@Table(name = "TBL_UPS_REQUEST_DETAIL")
public class RequestDetail  extends OracleBaseEntity<String>{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String seq;				//内部流水号
	private String batchSeq;			//批次流水号
	private String requestId;		//请求明细流水，用于对账
	private String amount;			//金额
	private String topBankName;		//总行名
	private String bankName;			//支行行名
	private String bankNo;			//行号
	private String accountNo;		//账号
	private String accountName;		//账户名
	private String province;			//开户行省份
	private String city;				//开户行城市
	private String phone;			//收款人手机号码
	private String status;			//状态 0:初始状态 1:已分拣，待出款 2:已出款待确认 3:已确认部分识别（有差错待处理）4:结束 8: pending 锁定，正在更新 9: 错误或作废
	private String payTime;			//付款时间 14位 yyyyMMddhhmmss
	private String clientMsg;		//客户通知消息，显示在收款人网银或发送到手机
	private String memo;				//付款备注
	
	@Override
	public String getId() {
		return seq;
	}
	
	public void setId(String id) {
		this.seq = id;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getBatchSeq() {
		return batchSeq;
	}

	public void setBatchSeq(String batchSeq) {
		this.batchSeq = batchSeq;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTopBankName() {
		return topBankName;
	}

	public void setTopBankName(String topBankName) {
		this.topBankName = topBankName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getClientMsg() {
		return clientMsg;
	}

	public void setClientMsg(String clientMsg) {
		this.clientMsg = clientMsg;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
