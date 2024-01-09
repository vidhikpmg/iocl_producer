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
        @CreationTimestamp
        @Column(name="createddate")
        public LocalDateTime createdOn;
        @UpdateTimestamp
        @Column(name="modifieddate")
        public LocalDateTime modifiedDate;

        private String MANTR;
        private String UMREN;
        private String MEINH;
        private String SEPRTR;
        private String UMREZ;

        private String MEINS;

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

        public String getMANTR() {
                return MANTR;
        }

        public void setMANTR(String MANTR) {
                this.MANTR = MANTR;
        }

        public String getUMREN() {
                return UMREN;
        }

        public void setUMREN(String UMREN) {
                this.UMREN = UMREN;
        }

        public String getMEINH() {
                return MEINH;
        }

        public void setMEINH(String MEINH) {
                this.MEINH = MEINH;
        }

        public String getSEPRTR() {
                return SEPRTR;
        }

        public void setSEPRTR(String SEPRTR) {
                this.SEPRTR = SEPRTR;
        }

        public String getUMREZ() {
                return UMREZ;
        }

        public void setUMREZ(String UMREZ) {
                this.UMREZ = UMREZ;
        }

        public String getMEINS() {
                return MEINS;
        }

        public void setMEINS(String MEINS) {
                this.MEINS = MEINS;
        }

    }

