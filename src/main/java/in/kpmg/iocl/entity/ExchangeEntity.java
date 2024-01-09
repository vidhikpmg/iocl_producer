package in.kpmg.iocl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
/*Local*/
/*@Table(name = "yv_exchg_rate_et_exch_rate", schema = "iocl")
Production*/
@Table(name = "yvb_exchange_rate", schema = "pricing_tool")
public class ExchangeEntity {

    @Id
    private BigInteger id;

    private String fcurr;

    private String ffact;

    private String gdatu;

    private String kurst;

    private String mandt;

    private String tcurr;

    private String tfact;

    private String ukurs;

    private Date createddate;

    private Boolean is_active;

    private Date modifieddate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFcurr() {
        return fcurr;
    }

    public void setFcurr(String fcurr) {
        this.fcurr = fcurr;
    }

    public String getFfact() {
        return ffact;
    }

    public void setFfact(String ffact) {
        this.ffact = ffact;
    }

    public String getGdatu() {
        return gdatu;
    }

    public void setGdatu(String gdatu) {
        this.gdatu = gdatu;
    }

    public String getKurst() {
        return kurst;
    }

    public void setKurst(String kurst) {
        this.kurst = kurst;
    }

    public String getMandt() {
        return mandt;
    }

    public void setMandt(String mandt) {
        this.mandt = mandt;
    }

    public String getTcurr() {
        return tcurr;
    }

    public void setTcurr(String tcurr) {
        this.tcurr = tcurr;
    }

    public String getTfact() {
        return tfact;
    }

    public void setTfact(String tfact) {
        this.tfact = tfact;
    }

    public String getUkurs() {
        return ukurs;
    }

    public void setUkurs(String ukurs) {
        this.ukurs = ukurs;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }
    
}