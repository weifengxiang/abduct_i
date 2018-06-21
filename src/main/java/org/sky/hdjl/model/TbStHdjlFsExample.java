package org.sky.hdjl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStHdjlFsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStHdjlFsExample() {
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

        public Criteria andXxnrIsNull() {
            addCriterion("XXNR is null");
            return (Criteria) this;
        }

        public Criteria andXxnrIsNotNull() {
            addCriterion("XXNR is not null");
            return (Criteria) this;
        }

        public Criteria andXxnrEqualTo(String value) {
            addCriterion("XXNR =", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrNotEqualTo(String value) {
            addCriterion("XXNR <>", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrGreaterThan(String value) {
            addCriterion("XXNR >", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrGreaterThanOrEqualTo(String value) {
            addCriterion("XXNR >=", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrLessThan(String value) {
            addCriterion("XXNR <", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrLessThanOrEqualTo(String value) {
            addCriterion("XXNR <=", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrLike(String value) {
            addCriterion("XXNR like", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrNotLike(String value) {
            addCriterion("XXNR not like", value, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrIn(List<String> values) {
            addCriterion("XXNR in", values, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrNotIn(List<String> values) {
            addCriterion("XXNR not in", values, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrBetween(String value1, String value2) {
            addCriterion("XXNR between", value1, value2, "xxnr");
            return (Criteria) this;
        }

        public Criteria andXxnrNotBetween(String value1, String value2) {
            addCriterion("XXNR not between", value1, value2, "xxnr");
            return (Criteria) this;
        }

        public Criteria andFssjIsNull() {
            addCriterion("FSSJ is null");
            return (Criteria) this;
        }

        public Criteria andFssjIsNotNull() {
            addCriterion("FSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andFssjEqualTo(Date value) {
            addCriterion("FSSJ =", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjNotEqualTo(Date value) {
            addCriterion("FSSJ <>", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjGreaterThan(Date value) {
            addCriterion("FSSJ >", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjGreaterThanOrEqualTo(Date value) {
            addCriterion("FSSJ >=", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjLessThan(Date value) {
            addCriterion("FSSJ <", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjLessThanOrEqualTo(Date value) {
            addCriterion("FSSJ <=", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjIn(List<Date> values) {
            addCriterion("FSSJ in", values, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjNotIn(List<Date> values) {
            addCriterion("FSSJ not in", values, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjBetween(Date value1, Date value2) {
            addCriterion("FSSJ between", value1, value2, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjNotBetween(Date value1, Date value2) {
            addCriterion("FSSJ not between", value1, value2, "fssj");
            return (Criteria) this;
        }

        public Criteria andFsrIsNull() {
            addCriterion("FSR is null");
            return (Criteria) this;
        }

        public Criteria andFsrIsNotNull() {
            addCriterion("FSR is not null");
            return (Criteria) this;
        }

        public Criteria andFsrEqualTo(String value) {
            addCriterion("FSR =", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrNotEqualTo(String value) {
            addCriterion("FSR <>", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrGreaterThan(String value) {
            addCriterion("FSR >", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrGreaterThanOrEqualTo(String value) {
            addCriterion("FSR >=", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrLessThan(String value) {
            addCriterion("FSR <", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrLessThanOrEqualTo(String value) {
            addCriterion("FSR <=", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrLike(String value) {
            addCriterion("FSR like", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrNotLike(String value) {
            addCriterion("FSR not like", value, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrIn(List<String> values) {
            addCriterion("FSR in", values, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrNotIn(List<String> values) {
            addCriterion("FSR not in", values, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrBetween(String value1, String value2) {
            addCriterion("FSR between", value1, value2, "fsr");
            return (Criteria) this;
        }

        public Criteria andFsrNotBetween(String value1, String value2) {
            addCriterion("FSR not between", value1, value2, "fsr");
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