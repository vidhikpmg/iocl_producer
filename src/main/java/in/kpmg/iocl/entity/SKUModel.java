package in.kpmg.iocl.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="yv_material_master_all_views_e_marm",schema = "pricing_tool")
public class SKUModel {
        @Id
        private Long id;
        private Boolean isActive = true;

        @Column(name="createddate")
        public LocalDateTime createdOn;

        @Column(name="modifieddate")
        public LocalDateTime modifiedDate;

        private String matnr;
        private String umren;
        private String meinh;
        private String seprtr;

        public String getUmrez() {
                return umrez;
        }

        public void setUmrez(String umrez) {
                this.umrez = umrez;
        }

        private String umrez;
        private String meins;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Boolean getActive() {
                return isActive;
        }

        public void setActive(Boolean active) {
                isActive = active;
        }

        public LocalDateTime getCreatedOn() {
                return createdOn;
        }

        public void setCreatedOn(LocalDateTime createdOn) {
                this.createdOn = createdOn;
        }

        public LocalDateTime getModifiedDate() {
                return modifiedDate;
        }

        public void setModifiedDate(LocalDateTime modifiedDate) {
                this.modifiedDate = modifiedDate;
        }

        public String getMatnr() {
                return matnr;
        }

        public void setMatnr(String matnr) {
                this.matnr = matnr;
        }

        public String getUmren() {
                return umren;
        }

        public void setUmren(String umren) {
                this.umren = umren;
        }

        public String getMeinh() {
                return meinh;
        }

        public void setMeinh(String meinh) {
                this.meinh = meinh;
        }

        public String getSeprtr() {
                return seprtr;
        }

        public void setSeprtr(String seprtr) {
                this.seprtr = seprtr;
        }

        public String getMeins() {
                return meins;
        }

        public void setMeins(String meins) {
                this.meins = meins;
        }

    }

