package org.bu01.database.dto;

import java.util.Date;

public class CategoryDto {
    public static class RequestCategory{

        private String code;
        private String name;
        private Date effectiveDate;

        private Date expiredDate;

        private String description;

        private String categoryType;

        public RequestCategory() {
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(Date effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public Date getExpiredDate() {
            return expiredDate;
        }

        public void setExpiredDate(Date expiredDate) {
            this.expiredDate = expiredDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategoryType() {
            return categoryType;
        }

        public void setCategoryType(String categoryType) {
            this.categoryType = categoryType;
        }
    }
}
