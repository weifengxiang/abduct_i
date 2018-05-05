package org.sky.txsb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStTxsbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStTxsbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    public List<Criteria> integratedQuery(Map queryCondationMap) {
            Criteria criteria = createCriteriaInternal();
    for(Object key : queryCondationMap.keySet()) {
		String field = ((String)key).split("@")[0];
		String opt = ((String)key).split("@")[1];
		if(((String)key).toUpperCase().contains("BETWEEN")){
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,((String)queryCondationMap.get(key)).split(",")[0],((String)queryCondationMap.get(key)).split(",")[1],(String)key);
		}else if(((String)key).toUpperCase().contains("IS NULL")||((String)key).toUpperCase().contains("IS NOT NULL")){
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt);
		}else if(((String)key).toUpperCase().contains("@IN")||((String)key).toUpperCase().contains("@NOT IN")){
         String values = (String)queryCondationMap.get(key);
 		  List val=Arrays.asList(values.split(","));
 		  criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,val,(String)key);
		}else{
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,queryCondationMap.get(key),(String)key);
		}
    }
	 oredCriteria.add(criteria);
    return oredCriteria;

    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYwlxIsNull() {
            addCriterion("YWLX is null");
            return (Criteria) this;
        }

        public Criteria andYwlxIsNotNull() {
            addCriterion("YWLX is not null");
            return (Criteria) this;
        }

        public Criteria andYwlxEqualTo(String value) {
            addCriterion("YWLX =", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotEqualTo(String value) {
            addCriterion("YWLX <>", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxGreaterThan(String value) {
            addCriterion("YWLX >", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxGreaterThanOrEqualTo(String value) {
            addCriterion("YWLX >=", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxLessThan(String value) {
            addCriterion("YWLX <", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxLessThanOrEqualTo(String value) {
            addCriterion("YWLX <=", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxLike(String value) {
            addCriterion("YWLX like", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotLike(String value) {
            addCriterion("YWLX not like", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxIn(List<String> values) {
            addCriterion("YWLX in", values, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotIn(List<String> values) {
            addCriterion("YWLX not in", values, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxBetween(String value1, String value2) {
            addCriterion("YWLX between", value1, value2, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotBetween(String value1, String value2) {
            addCriterion("YWLX not between", value1, value2, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwbhIsNull() {
            addCriterion("YWBH is null");
            return (Criteria) this;
        }

        public Criteria andYwbhIsNotNull() {
            addCriterion("YWBH is not null");
            return (Criteria) this;
        }

        public Criteria andYwbhEqualTo(String value) {
            addCriterion("YWBH =", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhNotEqualTo(String value) {
            addCriterion("YWBH <>", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhGreaterThan(String value) {
            addCriterion("YWBH >", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhGreaterThanOrEqualTo(String value) {
            addCriterion("YWBH >=", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhLessThan(String value) {
            addCriterion("YWBH <", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhLessThanOrEqualTo(String value) {
            addCriterion("YWBH <=", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhLike(String value) {
            addCriterion("YWBH like", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhNotLike(String value) {
            addCriterion("YWBH not like", value, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhIn(List<String> values) {
            addCriterion("YWBH in", values, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhNotIn(List<String> values) {
            addCriterion("YWBH not in", values, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhBetween(String value1, String value2) {
            addCriterion("YWBH between", value1, value2, "ywbh");
            return (Criteria) this;
        }

        public Criteria andYwbhNotBetween(String value1, String value2) {
            addCriterion("YWBH not between", value1, value2, "ywbh");
            return (Criteria) this;
        }

        public Criteria andTxxhIsNull() {
            addCriterion("TXXH is null");
            return (Criteria) this;
        }

        public Criteria andTxxhIsNotNull() {
            addCriterion("TXXH is not null");
            return (Criteria) this;
        }

        public Criteria andTxxhEqualTo(Integer value) {
            addCriterion("TXXH =", value, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhNotEqualTo(Integer value) {
            addCriterion("TXXH <>", value, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhGreaterThan(Integer value) {
            addCriterion("TXXH >", value, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhGreaterThanOrEqualTo(Integer value) {
            addCriterion("TXXH >=", value, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhLessThan(Integer value) {
            addCriterion("TXXH <", value, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhLessThanOrEqualTo(Integer value) {
            addCriterion("TXXH <=", value, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhIn(List<Integer> values) {
            addCriterion("TXXH in", values, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhNotIn(List<Integer> values) {
            addCriterion("TXXH not in", values, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhBetween(Integer value1, Integer value2) {
            addCriterion("TXXH between", value1, value2, "txxh");
            return (Criteria) this;
        }

        public Criteria andTxxhNotBetween(Integer value1, Integer value2) {
            addCriterion("TXXH not between", value1, value2, "txxh");
            return (Criteria) this;
        }

        public Criteria andXsdIsNull() {
            addCriterion("XSD is null");
            return (Criteria) this;
        }

        public Criteria andXsdIsNotNull() {
            addCriterion("XSD is not null");
            return (Criteria) this;
        }

        public Criteria andXsdEqualTo(BigDecimal value) {
            addCriterion("XSD =", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdNotEqualTo(BigDecimal value) {
            addCriterion("XSD <>", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdGreaterThan(BigDecimal value) {
            addCriterion("XSD >", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XSD >=", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdLessThan(BigDecimal value) {
            addCriterion("XSD <", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XSD <=", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdIn(List<BigDecimal> values) {
            addCriterion("XSD in", values, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdNotIn(List<BigDecimal> values) {
            addCriterion("XSD not in", values, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XSD between", value1, value2, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XSD not between", value1, value2, "xsd");
            return (Criteria) this;
        }

        public Criteria andWzIsNull() {
            addCriterion("WZ is null");
            return (Criteria) this;
        }

        public Criteria andWzIsNotNull() {
            addCriterion("WZ is not null");
            return (Criteria) this;
        }

        public Criteria andWzEqualTo(String value) {
            addCriterion("WZ =", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzNotEqualTo(String value) {
            addCriterion("WZ <>", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzGreaterThan(String value) {
            addCriterion("WZ >", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzGreaterThanOrEqualTo(String value) {
            addCriterion("WZ >=", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzLessThan(String value) {
            addCriterion("WZ <", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzLessThanOrEqualTo(String value) {
            addCriterion("WZ <=", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzLike(String value) {
            addCriterion("WZ like", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzNotLike(String value) {
            addCriterion("WZ not like", value, "wz");
            return (Criteria) this;
        }

        public Criteria andWzIn(List<String> values) {
            addCriterion("WZ in", values, "wz");
            return (Criteria) this;
        }

        public Criteria andWzNotIn(List<String> values) {
            addCriterion("WZ not in", values, "wz");
            return (Criteria) this;
        }

        public Criteria andWzBetween(String value1, String value2) {
            addCriterion("WZ between", value1, value2, "wz");
            return (Criteria) this;
        }

        public Criteria andWzNotBetween(String value1, String value2) {
            addCriterion("WZ not between", value1, value2, "wz");
            return (Criteria) this;
        }

        public Criteria andSbsjIsNull() {
            addCriterion("SBSJ is null");
            return (Criteria) this;
        }

        public Criteria andSbsjIsNotNull() {
            addCriterion("SBSJ is not null");
            return (Criteria) this;
        }

        public Criteria andSbsjEqualTo(Date value) {
            addCriterion("SBSJ =", value, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjNotEqualTo(Date value) {
            addCriterion("SBSJ <>", value, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjGreaterThan(Date value) {
            addCriterion("SBSJ >", value, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjGreaterThanOrEqualTo(Date value) {
            addCriterion("SBSJ >=", value, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjLessThan(Date value) {
            addCriterion("SBSJ <", value, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjLessThanOrEqualTo(Date value) {
            addCriterion("SBSJ <=", value, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjIn(List<Date> values) {
            addCriterion("SBSJ in", values, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjNotIn(List<Date> values) {
            addCriterion("SBSJ not in", values, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjBetween(Date value1, Date value2) {
            addCriterion("SBSJ between", value1, value2, "sbsj");
            return (Criteria) this;
        }

        public Criteria andSbsjNotBetween(Date value1, Date value2) {
            addCriterion("SBSJ not between", value1, value2, "sbsj");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}