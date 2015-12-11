package cn.ilongfei.springbootbasic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_UPSTUNNEL")
public class UPSTunnel {
	@Id
	private String code;					//
	private String name;					//
	private String dispname;				//
	private String pubKey;				//
}
