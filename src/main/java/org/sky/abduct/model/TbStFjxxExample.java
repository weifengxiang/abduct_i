package org.sky.abduct.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStFjxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStFjxxExample() {
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

        public Criteria andAjbhIsNull() {
            addCriterion("AJBH is null");
            return (Criteria) this;
        }

        public Criteria andAjbhIsNotNull() {
            addCriterion("AJBH is not null");
            return (Criteria) this;
        }

        public Criteria andAjbhEqualTo(String value) {
            addCriterion("AJBH =", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotEqualTo(String value) {
            addCriterion("AJBH <>", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhGreaterThan(String value) {
            addCriterion("AJBH >", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhGreaterThanOrEqualTo(String value) {
            addCriterion("AJBH >=", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhLessThan(String value) {
            addCriterion("AJBH <", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhLessThanOrEqualTo(String value) {
            addCriterion("AJBH <=", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhLike(String value) {
            addCriterion("AJBH like", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotLike(String value) {
            addCriterion("AJBH not like", value, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhIn(List<String> values) {
            addCriterion("AJBH in", values, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotIn(List<String> values) {
            addCriterion("AJBH not in", values, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhBetween(String value1, String value2) {
            addCriterion("AJBH between", value1, value2, "ajbh");
            return (Criteria) this;
        }

        public Criteria andAjbhNotBetween(String value1, String value2) {
            addCriterion("AJBH not between", value1, value2, "ajbh");
            return (Criteria) this;
        }

        public Criteria andFjmcIsNull() {
            addCriterion("FJMC is null");
            return (Criteria) this;
        }

        public Criteria andFjmcIsNotNull() {
            addCriterion("FJMC is not null");
            return (Criteria) this;
        }

        public Criteria andFjmcEqualTo(String value) {
            addCriterion("FJMC =", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcNotEqualTo(String value) {
            addCriterion("FJMC <>", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcGreaterThan(String value) {
            addCriterion("FJMC >", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcGreaterThanOrEqualTo(String value) {
            addCriterion("FJMC >=", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcLessThan(String value) {
            addCriterion("FJMC <", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcLessThanOrEqualTo(String value) {
            addCriterion("FJMC <=", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcLike(String value) {
            addCriterion("FJMC like", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcNotLike(String value) {
            addCriterion("FJMC not like", value, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcIn(List<String> values) {
            addCriterion("FJMC in", values, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcNotIn(List<String> values) {
            addCriterion("FJMC not in", values, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcBetween(String value1, String value2) {
            addCriterion("FJMC between", value1, value2, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjmcNotBetween(String value1, String value2) {
            addCriterion("FJMC not between", value1, value2, "fjmc");
            return (Criteria) this;
        }

        public Criteria andFjlxIsNull() {
            addCriterion("FJLX is null");
            return (Criteria) this;
        }

        public Criteria andFjlxIsNotNull() {
            addCriterion("FJLX is not null");
            return (Criteria) this;
        }

        public Criteria andFjlxEqualTo(String value) {
            addCriterion("FJLX =", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxNotEqualTo(String value) {
            addCriterion("FJLX <>", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxGreaterThan(String value) {
            addCriterion("FJLX >", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxGreaterThanOrEqualTo(String value) {
            addCriterion("FJLX >=", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxLessThan(String value) {
            addCriterion("FJLX <", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxLessThanOrEqualTo(String value) {
            addCriterion("FJLX <=", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxLike(String value) {
            addCriterion("FJLX like", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxNotLike(String value) {
            addCriterion("FJLX not like", value, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxIn(List<String> values) {
            addCriterion("FJLX in", values, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxNotIn(List<String> values) {
            addCriterion("FJLX not in", values, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxBetween(String value1, String value2) {
            addCriterion("FJLX between", value1, value2, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjlxNotBetween(String value1, String value2) {
            addCriterion("FJLX not between", value1, value2, "fjlx");
            return (Criteria) this;
        }

        public Criteria andFjdxIsNull() {
            addCriterion("FJDX is null");
            return (Criteria) this;
        }

        public Criteria andFjdxIsNotNull() {
            addCriterion("FJDX is not null");
            return (Criteria) this;
        }

        public Criteria andFjdxEqualTo(Integer value) {
            addCriterion("FJDX =", value, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxNotEqualTo(Integer value) {
            addCriterion("FJDX <>", value, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxGreaterThan(Integer value) {
            addCriterion("FJDX >", value, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxGreaterThanOrEqualTo(Integer value) {
            addCriterion("FJDX >=", value, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxLessThan(Integer value) {
            addCriterion("FJDX <", value, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxLessThanOrEqualTo(Integer value) {
            addCriterion("FJDX <=", value, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxIn(List<Integer> values) {
            addCriterion("FJDX in", values, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxNotIn(List<Integer> values) {
            addCriterion("FJDX not in", values, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxBetween(Integer value1, Integer value2) {
            addCriterion("FJDX between", value1, value2, "fjdx");
            return (Criteria) this;
        }

        public Criteria andFjdxNotBetween(Integer value1, Integer value2) {
            addCriterion("FJDX not between", value1, value2, "fjdx");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("CREATER is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("CREATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("CREATER =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("CREATER <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("CREATER >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("CREATER >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("CREATER <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("CREATER <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("CREATER like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("CREATER not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("CREATER in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("CREATER not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("CREATER between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("CREATER not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeIsNull() {
            addCriterion("CREATR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeIsNotNull() {
            addCriterion("CREATR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeEqualTo(Date value) {
            addCriterion("CREATR_TIME =", value, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeNotEqualTo(Date value) {
            addCriterion("CREATR_TIME <>", value, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeGreaterThan(Date value) {
            addCriterion("CREATR_TIME >", value, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATR_TIME >=", value, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeLessThan(Date value) {
            addCriterion("CREATR_TIME <", value, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATR_TIME <=", value, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeIn(List<Date> values) {
            addCriterion("CREATR_TIME in", values, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeNotIn(List<Date> values) {
            addCriterion("CREATR_TIME not in", values, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeBetween(Date value1, Date value2) {
            addCriterion("CREATR_TIME between", value1, value2, "creatrTime");
            return (Criteria) this;
        }

        public Criteria andCreatrTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATR_TIME not between", value1, value2, "creatrTime");
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