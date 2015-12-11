package cn.ilongfei.springbootbasic.domain.ups;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ilongfei.springbootbasic.domain.OracleBaseEntity;


/*
 * 内部出款请求， 由requestDetail经分拣，填入渠道号、拆分/合并，等待定时任务出款
 */
@Entity
@Table(name = "TBL_TRANS")
public class Trans  extends OracleBaseEntity<Long>{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seq;				//内部流水号
	private long requestSeq;			//请求明细流水，用于追溯原交易。 
	//trans和request关系为多对多关系，关系表为transRequest，这里填一个requestSeq是冗余信息，
	//为了方便更新状态时定位用，当trans与request为一对一，或多对一（拆分）时，本属性不为空；为一对多(合并出款)时，
	//为空，需要查关系表transRequest
	private String tunnelCode;		//出款渠道号
	private String opration;			//网银操作，默认是代付
	private long amount;				//金额
	private String topBankName;		//总行名
	private String bankName;			//支行行名
	private String bankNo;			//行号
	private String accountNo;		//账号
	private String accountName;		//账户名
	private String province;			//开户行省份
	private String city;				//开户行城市
	private String phone;			//收款人手机号码
	private String status;			//状态 1:已分拣，待出款 2:已出款待确认 3:出款成功 4:出款失败
	private String flag;				//作废标志  0:正常 9:已作废
	private String imBalFlag;		//是否差错帐记录，0:正常记录（默认） 1:差错帐记录 		
	private long origSeq;			//差错帐记录对应的原始记录
	private String payTime;			//付款时间 14位 yyyyMMddhhmmss
	private String clientMsg;		//客户通知消息，显示在收款人网银或发送到手机
	private String memo;				//付款备注
	private int paySeq;				//出款批次中的序号 每个批次中从1开始
	private String resultSeq;		//出款操作银行返回的序号，用于单笔查询（暂时不用）
	
	@Override
	public Long getId() {
		return seq;
	}
	
	public void setId(Long id) {
		this.seq = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public long getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(long requestSeq) {
		this.requestSeq = requestSeq;
	}

	public String getTunnelCode() {
		return tunnelCode;
	}

	public void setTunnelCode(String tunnelCode) {
		this.tunnelCode = tunnelCode;
	}

	public String getOpration() {
		return opration;
	}

	public void setOpration(String opration) {
		this.opration = opration;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getImBalFlag() {
		return imBalFlag;
	}

	public void setImBalFlag(String imBalFlag) {
		this.imBalFlag = imBalFlag;
	}

	public long getOrigSeq() {
		return origSeq;
	}

	public void setOrigSeq(long origSeq) {
		this.origSeq = origSeq;
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

	public int getPaySeq() {
		return paySeq;
	}

	public void setPaySeq(int paySeq) {
		this.paySeq = paySeq;
	}

	public String getResultSeq() {
		return resultSeq;
	}

	public void setResultSeq(String resultSeq) {
		this.resultSeq = resultSeq;
	}
	
	
	
}
