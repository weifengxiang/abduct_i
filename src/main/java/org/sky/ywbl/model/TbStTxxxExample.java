package org.sky.ywbl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStTxxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStTxxxExample() {
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

        public Criteria andTxmcIsNull() {
            addCriterion("TXMC is null");
            return (Criteria) this;
        }

        public Criteria andTxmcIsNotNull() {
            addCriterion("TXMC is not null");
            return (Criteria) this;
        }

        public Criteria andTxmcEqualTo(String value) {
            addCriterion("TXMC =", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcNotEqualTo(String value) {
            addCriterion("TXMC <>", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcGreaterThan(String value) {
            addCriterion("TXMC >", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcGreaterThanOrEqualTo(String value) {
            addCriterion("TXMC >=", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcLessThan(String value) {
            addCriterion("TXMC <", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcLessThanOrEqualTo(String value) {
            addCriterion("TXMC <=", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcLike(String value) {
            addCriterion("TXMC like", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcNotLike(String value) {
            addCriterion("TXMC not like", value, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcIn(List<String> values) {
            addCriterion("TXMC in", values, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcNotIn(List<String> values) {
            addCriterion("TXMC not in", values, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcBetween(String value1, String value2) {
            addCriterion("TXMC between", value1, value2, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxmcNotBetween(String value1, String value2) {
            addCriterion("TXMC not between", value1, value2, "txmc");
            return (Criteria) this;
        }

        public Criteria andTxlxIsNull() {
            addCriterion("TXLX is null");
            return (Criteria) this;
        }

        public Criteria andTxlxIsNotNull() {
            addCriterion("TXLX is not null");
            return (Criteria) this;
        }

        public Criteria andTxlxEqualTo(String value) {
            addCriterion("TXLX =", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxNotEqualTo(String value) {
            addCriterion("TXLX <>", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxGreaterThan(String value) {
            addCriterion("TXLX >", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxGreaterThanOrEqualTo(String value) {
            addCriterion("TXLX >=", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxLessThan(String value) {
            addCriterion("TXLX <", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxLessThanOrEqualTo(String value) {
            addCriterion("TXLX <=", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxLike(String value) {
            addCriterion("TXLX like", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxNotLike(String value) {
            addCriterion("TXLX not like", value, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxIn(List<String> values) {
            addCriterion("TXLX in", values, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxNotIn(List<String> values) {
            addCriterion("TXLX not in", values, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxBetween(String value1, String value2) {
            addCriterion("TXLX between", value1, value2, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxlxNotBetween(String value1, String value2) {
            addCriterion("TXLX not between", value1, value2, "txlx");
            return (Criteria) this;
        }

        public Criteria andTxdxIsNull() {
            addCriterion("TXDX is null");
            return (Criteria) this;
        }

        public Criteria andTxdxIsNotNull() {
            addCriterion("TXDX is not null");
            return (Criteria) this;
        }

        public Criteria andTxdxEqualTo(Integer value) {
            addCriterion("TXDX =", value, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxNotEqualTo(Integer value) {
            addCriterion("TXDX <>", value, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxGreaterThan(Integer value) {
            addCriterion("TXDX >", value, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxGreaterThanOrEqualTo(Integer value) {
            addCriterion("TXDX >=", value, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxLessThan(Integer value) {
            addCriterion("TXDX <", value, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxLessThanOrEqualTo(Integer value) {
            addCriterion("TXDX <=", value, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxIn(List<Integer> values) {
            addCriterion("TXDX in", values, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxNotIn(List<Integer> values) {
            addCriterion("TXDX not in", values, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxBetween(Integer value1, Integer value2) {
            addCriterion("TXDX between", value1, value2, "txdx");
            return (Criteria) this;
        }

        public Criteria andTxdxNotBetween(Integer value1, Integer value2) {
            addCriterion("TXDX not between", value1, value2, "txdx");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
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