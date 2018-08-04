package org.sky.txbk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStTxbkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStTxbkExample() {
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

        public Criteria andTxbhIsNull() {
            addCriterion("TXBH is null");
            return (Criteria) this;
        }

        public Criteria andTxbhIsNotNull() {
            addCriterion("TXBH is not null");
            return (Criteria) this;
        }

        public Criteria andTxbhEqualTo(String value) {
            addCriterion("TXBH =", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhNotEqualTo(String value) {
            addCriterion("TXBH <>", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhGreaterThan(String value) {
            addCriterion("TXBH >", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhGreaterThanOrEqualTo(String value) {
            addCriterion("TXBH >=", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhLessThan(String value) {
            addCriterion("TXBH <", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhLessThanOrEqualTo(String value) {
            addCriterion("TXBH <=", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhLike(String value) {
            addCriterion("TXBH like", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhNotLike(String value) {
            addCriterion("TXBH not like", value, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhIn(List<String> values) {
            addCriterion("TXBH in", values, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhNotIn(List<String> values) {
            addCriterion("TXBH not in", values, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhBetween(String value1, String value2) {
            addCriterion("TXBH between", value1, value2, "txbh");
            return (Criteria) this;
        }

        public Criteria andTxbhNotBetween(String value1, String value2) {
            addCriterion("TXBH not between", value1, value2, "txbh");
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

        public Criteria andYsmcIsNull() {
            addCriterion("YSMC is null");
            return (Criteria) this;
        }

        public Criteria andYsmcIsNotNull() {
            addCriterion("YSMC is not null");
            return (Criteria) this;
        }

        public Criteria andYsmcEqualTo(String value) {
            addCriterion("YSMC =", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcNotEqualTo(String value) {
            addCriterion("YSMC <>", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcGreaterThan(String value) {
            addCriterion("YSMC >", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcGreaterThanOrEqualTo(String value) {
            addCriterion("YSMC >=", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcLessThan(String value) {
            addCriterion("YSMC <", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcLessThanOrEqualTo(String value) {
            addCriterion("YSMC <=", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcLike(String value) {
            addCriterion("YSMC like", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcNotLike(String value) {
            addCriterion("YSMC not like", value, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcIn(List<String> values) {
            addCriterion("YSMC in", values, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcNotIn(List<String> values) {
            addCriterion("YSMC not in", values, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcBetween(String value1, String value2) {
            addCriterion("YSMC between", value1, value2, "ysmc");
            return (Criteria) this;
        }

        public Criteria andYsmcNotBetween(String value1, String value2) {
            addCriterion("YSMC not between", value1, value2, "ysmc");
            return (Criteria) this;
        }

        public Criteria andBkkIsNull() {
            addCriterion("BKK is null");
            return (Criteria) this;
        }

        public Criteria andBkkIsNotNull() {
            addCriterion("BKK is not null");
            return (Criteria) this;
        }

        public Criteria andBkkEqualTo(String value) {
            addCriterion("BKK =", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkNotEqualTo(String value) {
            addCriterion("BKK <>", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkGreaterThan(String value) {
            addCriterion("BKK >", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkGreaterThanOrEqualTo(String value) {
            addCriterion("BKK >=", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkLessThan(String value) {
            addCriterion("BKK <", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkLessThanOrEqualTo(String value) {
            addCriterion("BKK <=", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkLike(String value) {
            addCriterion("BKK like", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkNotLike(String value) {
            addCriterion("BKK not like", value, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkIn(List<String> values) {
            addCriterion("BKK in", values, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkNotIn(List<String> values) {
            addCriterion("BKK not in", values, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkBetween(String value1, String value2) {
            addCriterion("BKK between", value1, value2, "bkk");
            return (Criteria) this;
        }

        public Criteria andBkkNotBetween(String value1, String value2) {
            addCriterion("BKK not between", value1, value2, "bkk");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
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

        public Criteria andUpdaterIsNull() {
            addCriterion("UPDATER is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("UPDATER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("UPDATER =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("UPDATER <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("UPDATER >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATER >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("UPDATER <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("UPDATER <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("UPDATER like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("UPDATER not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("UPDATER in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("UPDATER not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("UPDATER between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("UPDATER not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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