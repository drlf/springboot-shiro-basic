package cn.ilongfei.springbootbasic.domain.ups;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ilongfei.springbootbasic.domain.OracleBaseEntity;

/*
 * 外部系统出款请求批次
 */
@Entity
@Table(name = "TBL_UPS_REQUEST_BATCH")
public class RequestBatch  extends OracleBaseEntity<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String seq;				//内部流水号
	private String clientCode;		//客户代码
	private String transCode;		//客户交易代码，根据客户代码和交易代码唯一确定一个出款通道
	private String opration;			//操作代码，默认为代付 
	private String tunnelCode;		//出款渠道代码 内部分拣时计算并填写
	private String requestTime;		//请求时间 14位 yyyyMMddhhmmss
	private String requestId;		//请求序号，与客户代码一起唯一识别一个批次
	private long  count;				//总笔数 金额为整数，是实际金额的100倍，以下同
	private long amount;				//总金额
	private String status;			//状态 0:初始状态 1:待出款 2:已出款待确认 3:已确认部分识别（有差错待处理）4:结束
	private long succCount;			//确认出款成功笔数
	private long succAmount;			//确认出款成功合计金额
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

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getOpration() {
		return opration;
	}

	public void setOpration(String opration) {
		this.opration = opration;
	}

	public String getTunnelCode() {
		return tunnelCode;
	}

	public void setTunnelCode(String tunnelCode) {
		this.tunnelCode = tunnelCode;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getSuccCount() {
		return succCount;
	}

	public void setSuccCount(long succCount) {
		this.succCount = succCount;
	}

	public long getSuccAmount() {
		return succAmount;
	}

	public void setSuccAmount(long succAmount) {
		this.succAmount = succAmount;
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
