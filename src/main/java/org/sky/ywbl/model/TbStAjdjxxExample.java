package org.sky.ywbl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStAjdjxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStAjdjxxExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBjsjIsNull() {
            addCriterion("BJSJ is null");
            return (Criteria) this;
        }

        public Criteria andBjsjIsNotNull() {
            addCriterion("BJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andBjsjEqualTo(Date value) {
            addCriterionForJDBCDate("BJSJ =", value, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("BJSJ <>", value, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjGreaterThan(Date value) {
            addCriterionForJDBCDate("BJSJ >", value, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BJSJ >=", value, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjLessThan(Date value) {
            addCriterionForJDBCDate("BJSJ <", value, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BJSJ <=", value, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjIn(List<Date> values) {
            addCriterionForJDBCDate("BJSJ in", values, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("BJSJ not in", values, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BJSJ between", value1, value2, "bjsj");
            return (Criteria) this;
        }

        public Criteria andBjsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BJSJ not between", value1, value2, "bjsj");
            return (Criteria) this;
        }

        public Criteria andSsfjIsNull() {
            addCriterion("SSFJ is null");
            return (Criteria) this;
        }

        public Criteria andSsfjIsNotNull() {
            addCriterion("SSFJ is not null");
            return (Criteria) this;
        }

        public Criteria andSsfjEqualTo(String value) {
            addCriterion("SSFJ =", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjNotEqualTo(String value) {
            addCriterion("SSFJ <>", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjGreaterThan(String value) {
            addCriterion("SSFJ >", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjGreaterThanOrEqualTo(String value) {
            addCriterion("SSFJ >=", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjLessThan(String value) {
            addCriterion("SSFJ <", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjLessThanOrEqualTo(String value) {
            addCriterion("SSFJ <=", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjLike(String value) {
            addCriterion("SSFJ like", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjNotLike(String value) {
            addCriterion("SSFJ not like", value, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjIn(List<String> values) {
            addCriterion("SSFJ in", values, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjNotIn(List<String> values) {
            addCriterion("SSFJ not in", values, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjBetween(String value1, String value2) {
            addCriterion("SSFJ between", value1, value2, "ssfj");
            return (Criteria) this;
        }

        public Criteria andSsfjNotBetween(String value1, String value2) {
            addCriterion("SSFJ not between", value1, value2, "ssfj");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNull() {
            addCriterion("LXDH is null");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNotNull() {
            addCriterion("LXDH is not null");
            return (Criteria) this;
        }

        public Criteria andLxdhEqualTo(String value) {
            addCriterion("LXDH =", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotEqualTo(String value) {
            addCriterion("LXDH <>", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThan(String value) {
            addCriterion("LXDH >", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThanOrEqualTo(String value) {
            addCriterion("LXDH >=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThan(String value) {
            addCriterion("LXDH <", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThanOrEqualTo(String value) {
            addCriterion("LXDH <=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLike(String value) {
            addCriterion("LXDH like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotLike(String value) {
            addCriterion("LXDH not like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhIn(List<String> values) {
            addCriterion("LXDH in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotIn(List<String> values) {
            addCriterion("LXDH not in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhBetween(String value1, String value2) {
            addCriterion("LXDH between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotBetween(String value1, String value2) {
            addCriterion("LXDH not between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andBjfsIsNull() {
            addCriterion("BJFS is null");
            return (Criteria) this;
        }

        public Criteria andBjfsIsNotNull() {
            addCriterion("BJFS is not null");
            return (Criteria) this;
        }

        public Criteria andBjfsEqualTo(String value) {
            addCriterion("BJFS =", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsNotEqualTo(String value) {
            addCriterion("BJFS <>", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsGreaterThan(String value) {
            addCriterion("BJFS >", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsGreaterThanOrEqualTo(String value) {
            addCriterion("BJFS >=", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsLessThan(String value) {
            addCriterion("BJFS <", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsLessThanOrEqualTo(String value) {
            addCriterion("BJFS <=", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsLike(String value) {
            addCriterion("BJFS like", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsNotLike(String value) {
            addCriterion("BJFS not like", value, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsIn(List<String> values) {
            addCriterion("BJFS in", values, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsNotIn(List<String> values) {
            addCriterion("BJFS not in", values, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsBetween(String value1, String value2) {
            addCriterion("BJFS between", value1, value2, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjfsNotBetween(String value1, String value2) {
            addCriterion("BJFS not between", value1, value2, "bjfs");
            return (Criteria) this;
        }

        public Criteria andBjlbIsNull() {
            addCriterion("BJLB is null");
            return (Criteria) this;
        }

        public Criteria andBjlbIsNotNull() {
            addCriterion("BJLB is not null");
            return (Criteria) this;
        }

        public Criteria andBjlbEqualTo(String value) {
            addCriterion("BJLB =", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbNotEqualTo(String value) {
            addCriterion("BJLB <>", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbGreaterThan(String value) {
            addCriterion("BJLB >", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbGreaterThanOrEqualTo(String value) {
            addCriterion("BJLB >=", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbLessThan(String value) {
            addCriterion("BJLB <", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbLessThanOrEqualTo(String value) {
            addCriterion("BJLB <=", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbLike(String value) {
            addCriterion("BJLB like", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbNotLike(String value) {
            addCriterion("BJLB not like", value, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbIn(List<String> values) {
            addCriterion("BJLB in", values, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbNotIn(List<String> values) {
            addCriterion("BJLB not in", values, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbBetween(String value1, String value2) {
            addCriterion("BJLB between", value1, value2, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlbNotBetween(String value1, String value2) {
            addCriterion("BJLB not between", value1, value2, "bjlb");
            return (Criteria) this;
        }

        public Criteria andBjlxIsNull() {
            addCriterion("BJLX is null");
            return (Criteria) this;
        }

        public Criteria andBjlxIsNotNull() {
            addCriterion("BJLX is not null");
            return (Criteria) this;
        }

        public Criteria andBjlxEqualTo(String value) {
            addCriterion("BJLX =", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxNotEqualTo(String value) {
            addCriterion("BJLX <>", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxGreaterThan(String value) {
            addCriterion("BJLX >", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxGreaterThanOrEqualTo(String value) {
            addCriterion("BJLX >=", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxLessThan(String value) {
            addCriterion("BJLX <", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxLessThanOrEqualTo(String value) {
            addCriterion("BJLX <=", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxLike(String value) {
            addCriterion("BJLX like", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxNotLike(String value) {
            addCriterion("BJLX not like", value, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxIn(List<String> values) {
            addCriterion("BJLX in", values, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxNotIn(List<String> values) {
            addCriterion("BJLX not in", values, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxBetween(String value1, String value2) {
            addCriterion("BJLX between", value1, value2, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjlxNotBetween(String value1, String value2) {
            addCriterion("BJLX not between", value1, value2, "bjlx");
            return (Criteria) this;
        }

        public Criteria andBjxlIsNull() {
            addCriterion("BJXL is null");
            return (Criteria) this;
        }

        public Criteria andBjxlIsNotNull() {
            addCriterion("BJXL is not null");
            return (Criteria) this;
        }

        public Criteria andBjxlEqualTo(String value) {
            addCriterion("BJXL =", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlNotEqualTo(String value) {
            addCriterion("BJXL <>", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlGreaterThan(String value) {
            addCriterion("BJXL >", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlGreaterThanOrEqualTo(String value) {
            addCriterion("BJXL >=", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlLessThan(String value) {
            addCriterion("BJXL <", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlLessThanOrEqualTo(String value) {
            addCriterion("BJXL <=", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlLike(String value) {
            addCriterion("BJXL like", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlNotLike(String value) {
            addCriterion("BJXL not like", value, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlIn(List<String> values) {
            addCriterion("BJXL in", values, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlNotIn(List<String> values) {
            addCriterion("BJXL not in", values, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlBetween(String value1, String value2) {
            addCriterion("BJXL between", value1, value2, "bjxl");
            return (Criteria) this;
        }

        public Criteria andBjxlNotBetween(String value1, String value2) {
            addCriterion("BJXL not between", value1, value2, "bjxl");
            return (Criteria) this;
        }

        public Criteria andSfdzIsNull() {
            addCriterion("SFDZ is null");
            return (Criteria) this;
        }

        public Criteria andSfdzIsNotNull() {
            addCriterion("SFDZ is not null");
            return (Criteria) this;
        }

        public Criteria andSfdzEqualTo(String value) {
            addCriterion("SFDZ =", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotEqualTo(String value) {
            addCriterion("SFDZ <>", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzGreaterThan(String value) {
            addCriterion("SFDZ >", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzGreaterThanOrEqualTo(String value) {
            addCriterion("SFDZ >=", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzLessThan(String value) {
            addCriterion("SFDZ <", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzLessThanOrEqualTo(String value) {
            addCriterion("SFDZ <=", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzLike(String value) {
            addCriterion("SFDZ like", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotLike(String value) {
            addCriterion("SFDZ not like", value, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzIn(List<String> values) {
            addCriterion("SFDZ in", values, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotIn(List<String> values) {
            addCriterion("SFDZ not in", values, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzBetween(String value1, String value2) {
            addCriterion("SFDZ between", value1, value2, "sfdz");
            return (Criteria) this;
        }

        public Criteria andSfdzNotBetween(String value1, String value2) {
            addCriterion("SFDZ not between", value1, value2, "sfdz");
            return (Criteria) this;
        }

        public Criteria andLhlbIsNull() {
            addCriterion("LHLB is null");
            return (Criteria) this;
        }

        public Criteria andLhlbIsNotNull() {
            addCriterion("LHLB is not null");
            return (Criteria) this;
        }

        public Criteria andLhlbEqualTo(String value) {
            addCriterion("LHLB =", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbNotEqualTo(String value) {
            addCriterion("LHLB <>", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbGreaterThan(String value) {
            addCriterion("LHLB >", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbGreaterThanOrEqualTo(String value) {
            addCriterion("LHLB >=", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbLessThan(String value) {
            addCriterion("LHLB <", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbLessThanOrEqualTo(String value) {
            addCriterion("LHLB <=", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbLike(String value) {
            addCriterion("LHLB like", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbNotLike(String value) {
            addCriterion("LHLB not like", value, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbIn(List<String> values) {
            addCriterion("LHLB in", values, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbNotIn(List<String> values) {
            addCriterion("LHLB not in", values, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbBetween(String value1, String value2) {
            addCriterion("LHLB between", value1, value2, "lhlb");
            return (Criteria) this;
        }

        public Criteria andLhlbNotBetween(String value1, String value2) {
            addCriterion("LHLB not between", value1, value2, "lhlb");
            return (Criteria) this;
        }

        public Criteria andBjrIsNull() {
            addCriterion("BJR is null");
            return (Criteria) this;
        }

        public Criteria andBjrIsNotNull() {
            addCriterion("BJR is not null");
            return (Criteria) this;
        }

        public Criteria andBjrEqualTo(String value) {
            addCriterion("BJR =", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotEqualTo(String value) {
            addCriterion("BJR <>", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrGreaterThan(String value) {
            addCriterion("BJR >", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrGreaterThanOrEqualTo(String value) {
            addCriterion("BJR >=", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrLessThan(String value) {
            addCriterion("BJR <", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrLessThanOrEqualTo(String value) {
            addCriterion("BJR <=", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrLike(String value) {
            addCriterion("BJR like", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotLike(String value) {
            addCriterion("BJR not like", value, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrIn(List<String> values) {
            addCriterion("BJR in", values, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotIn(List<String> values) {
            addCriterion("BJR not in", values, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrBetween(String value1, String value2) {
            addCriterion("BJR between", value1, value2, "bjr");
            return (Criteria) this;
        }

        public Criteria andBjrNotBetween(String value1, String value2) {
            addCriterion("BJR not between", value1, value2, "bjr");
            return (Criteria) this;
        }

        public Criteria andSjxqIsNull() {
            addCriterion("SJXQ is null");
            return (Criteria) this;
        }

        public Criteria andSjxqIsNotNull() {
            addCriterion("SJXQ is not null");
            return (Criteria) this;
        }

        public Criteria andSjxqEqualTo(String value) {
            addCriterion("SJXQ =", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqNotEqualTo(String value) {
            addCriterion("SJXQ <>", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqGreaterThan(String value) {
            addCriterion("SJXQ >", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqGreaterThanOrEqualTo(String value) {
            addCriterion("SJXQ >=", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqLessThan(String value) {
            addCriterion("SJXQ <", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqLessThanOrEqualTo(String value) {
            addCriterion("SJXQ <=", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqLike(String value) {
            addCriterion("SJXQ like", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqNotLike(String value) {
            addCriterion("SJXQ not like", value, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqIn(List<String> values) {
            addCriterion("SJXQ in", values, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqNotIn(List<String> values) {
            addCriterion("SJXQ not in", values, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqBetween(String value1, String value2) {
            addCriterion("SJXQ between", value1, value2, "sjxq");
            return (Criteria) this;
        }

        public Criteria andSjxqNotBetween(String value1, String value2) {
            addCriterion("SJXQ not between", value1, value2, "sjxq");
            return (Criteria) this;
        }

        public Criteria andXqdwIsNull() {
            addCriterion("XQDW is null");
            return (Criteria) this;
        }

        public Criteria andXqdwIsNotNull() {
            addCriterion("XQDW is not null");
            return (Criteria) this;
        }

        public Criteria andXqdwEqualTo(String value) {
            addCriterion("XQDW =", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwNotEqualTo(String value) {
            addCriterion("XQDW <>", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwGreaterThan(String value) {
            addCriterion("XQDW >", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwGreaterThanOrEqualTo(String value) {
            addCriterion("XQDW >=", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwLessThan(String value) {
            addCriterion("XQDW <", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwLessThanOrEqualTo(String value) {
            addCriterion("XQDW <=", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwLike(String value) {
            addCriterion("XQDW like", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwNotLike(String value) {
            addCriterion("XQDW not like", value, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwIn(List<String> values) {
            addCriterion("XQDW in", values, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwNotIn(List<String> values) {
            addCriterion("XQDW not in", values, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwBetween(String value1, String value2) {
            addCriterion("XQDW between", value1, value2, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXqdwNotBetween(String value1, String value2) {
            addCriterion("XQDW not between", value1, value2, "xqdw");
            return (Criteria) this;
        }

        public Criteria andXzqhIsNull() {
            addCriterion("XZQH is null");
            return (Criteria) this;
        }

        public Criteria andXzqhIsNotNull() {
            addCriterion("XZQH is not null");
            return (Criteria) this;
        }

        public Criteria andXzqhEqualTo(String value) {
            addCriterion("XZQH =", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotEqualTo(String value) {
            addCriterion("XZQH <>", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhGreaterThan(String value) {
            addCriterion("XZQH >", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhGreaterThanOrEqualTo(String value) {
            addCriterion("XZQH >=", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhLessThan(String value) {
            addCriterion("XZQH <", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhLessThanOrEqualTo(String value) {
            addCriterion("XZQH <=", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhLike(String value) {
            addCriterion("XZQH like", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotLike(String value) {
            addCriterion("XZQH not like", value, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhIn(List<String> values) {
            addCriterion("XZQH in", values, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotIn(List<String> values) {
            addCriterion("XZQH not in", values, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhBetween(String value1, String value2) {
            addCriterion("XZQH between", value1, value2, "xzqh");
            return (Criteria) this;
        }

        public Criteria andXzqhNotBetween(String value1, String value2) {
            addCriterion("XZQH not between", value1, value2, "xzqh");
            return (Criteria) this;
        }

        public Criteria andCjrIsNull() {
            addCriterion("CJR is null");
            return (Criteria) this;
        }

        public Criteria andCjrIsNotNull() {
            addCriterion("CJR is not null");
            return (Criteria) this;
        }

        public Criteria andCjrEqualTo(String value) {
            addCriterion("CJR =", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotEqualTo(String value) {
            addCriterion("CJR <>", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrGreaterThan(String value) {
            addCriterion("CJR >", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrGreaterThanOrEqualTo(String value) {
            addCriterion("CJR >=", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLessThan(String value) {
            addCriterion("CJR <", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLessThanOrEqualTo(String value) {
            addCriterion("CJR <=", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLike(String value) {
            addCriterion("CJR like", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotLike(String value) {
            addCriterion("CJR not like", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrIn(List<String> values) {
            addCriterion("CJR in", values, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotIn(List<String> values) {
            addCriterion("CJR not in", values, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrBetween(String value1, String value2) {
            addCriterion("CJR between", value1, value2, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotBetween(String value1, String value2) {
            addCriterion("CJR not between", value1, value2, "cjr");
            return (Criteria) this;
        }

        public Criteria andDcsjIsNull() {
            addCriterion("DCSJ is null");
            return (Criteria) this;
        }

        public Criteria andDcsjIsNotNull() {
            addCriterion("DCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andDcsjEqualTo(Date value) {
            addCriterionForJDBCDate("DCSJ =", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("DCSJ <>", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjGreaterThan(Date value) {
            addCriterionForJDBCDate("DCSJ >", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DCSJ >=", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjLessThan(Date value) {
            addCriterionForJDBCDate("DCSJ <", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DCSJ <=", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjIn(List<Date> values) {
            addCriterionForJDBCDate("DCSJ in", values, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("DCSJ not in", values, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DCSJ between", value1, value2, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DCSJ not between", value1, value2, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcqkIsNull() {
            addCriterion("DCQK is null");
            return (Criteria) this;
        }

        public Criteria andDcqkIsNotNull() {
            addCriterion("DCQK is not null");
            return (Criteria) this;
        }

        public Criteria andDcqkEqualTo(String value) {
            addCriterion("DCQK =", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkNotEqualTo(String value) {
            addCriterion("DCQK <>", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkGreaterThan(String value) {
            addCriterion("DCQK >", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkGreaterThanOrEqualTo(String value) {
            addCriterion("DCQK >=", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkLessThan(String value) {
            addCriterion("DCQK <", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkLessThanOrEqualTo(String value) {
            addCriterion("DCQK <=", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkLike(String value) {
            addCriterion("DCQK like", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkNotLike(String value) {
            addCriterion("DCQK not like", value, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkIn(List<String> values) {
            addCriterion("DCQK in", values, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkNotIn(List<String> values) {
            addCriterion("DCQK not in", values, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkBetween(String value1, String value2) {
            addCriterion("DCQK between", value1, value2, "dcqk");
            return (Criteria) this;
        }

        public Criteria andDcqkNotBetween(String value1, String value2) {
            addCriterion("DCQK not between", value1, value2, "dcqk");
            return (Criteria) this;
        }

        public Criteria andFknrIsNull() {
            addCriterion("FKNR is null");
            return (Criteria) this;
        }

        public Criteria andFknrIsNotNull() {
            addCriterion("FKNR is not null");
            return (Criteria) this;
        }

        public Criteria andFknrEqualTo(String value) {
            addCriterion("FKNR =", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrNotEqualTo(String value) {
            addCriterion("FKNR <>", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrGreaterThan(String value) {
            addCriterion("FKNR >", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrGreaterThanOrEqualTo(String value) {
            addCriterion("FKNR >=", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrLessThan(String value) {
            addCriterion("FKNR <", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrLessThanOrEqualTo(String value) {
            addCriterion("FKNR <=", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrLike(String value) {
            addCriterion("FKNR like", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrNotLike(String value) {
            addCriterion("FKNR not like", value, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrIn(List<String> values) {
            addCriterion("FKNR in", values, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrNotIn(List<String> values) {
            addCriterion("FKNR not in", values, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrBetween(String value1, String value2) {
            addCriterion("FKNR between", value1, value2, "fknr");
            return (Criteria) this;
        }

        public Criteria andFknrNotBetween(String value1, String value2) {
            addCriterion("FKNR not between", value1, value2, "fknr");
            return (Criteria) this;
        }

        public Criteria andCljgIsNull() {
            addCriterion("CLJG is null");
            return (Criteria) this;
        }

        public Criteria andCljgIsNotNull() {
            addCriterion("CLJG is not null");
            return (Criteria) this;
        }

        public Criteria andCljgEqualTo(String value) {
            addCriterion("CLJG =", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgNotEqualTo(String value) {
            addCriterion("CLJG <>", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgGreaterThan(String value) {
            addCriterion("CLJG >", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgGreaterThanOrEqualTo(String value) {
            addCriterion("CLJG >=", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgLessThan(String value) {
            addCriterion("CLJG <", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgLessThanOrEqualTo(String value) {
            addCriterion("CLJG <=", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgLike(String value) {
            addCriterion("CLJG like", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgNotLike(String value) {
            addCriterion("CLJG not like", value, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgIn(List<String> values) {
            addCriterion("CLJG in", values, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgNotIn(List<String> values) {
            addCriterion("CLJG not in", values, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgBetween(String value1, String value2) {
            addCriterion("CLJG between", value1, value2, "cljg");
            return (Criteria) this;
        }

        public Criteria andCljgNotBetween(String value1, String value2) {
            addCriterion("CLJG not between", value1, value2, "cljg");
            return (Criteria) this;
        }

        public Criteria andSjztIsNull() {
            addCriterion("SJZT is null");
            return (Criteria) this;
        }

        public Criteria andSjztIsNotNull() {
            addCriterion("SJZT is not null");
            return (Criteria) this;
        }

        public Criteria andSjztEqualTo(String value) {
            addCriterion("SJZT =", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztNotEqualTo(String value) {
            addCriterion("SJZT <>", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztGreaterThan(String value) {
            addCriterion("SJZT >", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztGreaterThanOrEqualTo(String value) {
            addCriterion("SJZT >=", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztLessThan(String value) {
            addCriterion("SJZT <", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztLessThanOrEqualTo(String value) {
            addCriterion("SJZT <=", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztLike(String value) {
            addCriterion("SJZT like", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztNotLike(String value) {
            addCriterion("SJZT not like", value, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztIn(List<String> values) {
            addCriterion("SJZT in", values, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztNotIn(List<String> values) {
            addCriterion("SJZT not in", values, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztBetween(String value1, String value2) {
            addCriterion("SJZT between", value1, value2, "sjzt");
            return (Criteria) this;
        }

        public Criteria andSjztNotBetween(String value1, String value2) {
            addCriterion("SJZT not between", value1, value2, "sjzt");
            return (Criteria) this;
        }

        public Criteria andJwqIsNull() {
            addCriterion("JWQ is null");
            return (Criteria) this;
        }

        public Criteria andJwqIsNotNull() {
            addCriterion("JWQ is not null");
            return (Criteria) this;
        }

        public Criteria andJwqEqualTo(String value) {
            addCriterion("JWQ =", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqNotEqualTo(String value) {
            addCriterion("JWQ <>", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqGreaterThan(String value) {
            addCriterion("JWQ >", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqGreaterThanOrEqualTo(String value) {
            addCriterion("JWQ >=", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqLessThan(String value) {
            addCriterion("JWQ <", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqLessThanOrEqualTo(String value) {
            addCriterion("JWQ <=", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqLike(String value) {
            addCriterion("JWQ like", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqNotLike(String value) {
            addCriterion("JWQ not like", value, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqIn(List<String> values) {
            addCriterion("JWQ in", values, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqNotIn(List<String> values) {
            addCriterion("JWQ not in", values, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqBetween(String value1, String value2) {
            addCriterion("JWQ between", value1, value2, "jwq");
            return (Criteria) this;
        }

        public Criteria andJwqNotBetween(String value1, String value2) {
            addCriterion("JWQ not between", value1, value2, "jwq");
            return (Criteria) this;
        }

        public Criteria andAfdzlbIsNull() {
            addCriterion("AFDZLB is null");
            return (Criteria) this;
        }

        public Criteria andAfdzlbIsNotNull() {
            addCriterion("AFDZLB is not null");
            return (Criteria) this;
        }

        public Criteria andAfdzlbEqualTo(String value) {
            addCriterion("AFDZLB =", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbNotEqualTo(String value) {
            addCriterion("AFDZLB <>", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbGreaterThan(String value) {
            addCriterion("AFDZLB >", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbGreaterThanOrEqualTo(String value) {
            addCriterion("AFDZLB >=", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbLessThan(String value) {
            addCriterion("AFDZLB <", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbLessThanOrEqualTo(String value) {
            addCriterion("AFDZLB <=", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbLike(String value) {
            addCriterion("AFDZLB like", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbNotLike(String value) {
            addCriterion("AFDZLB not like", value, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbIn(List<String> values) {
            addCriterion("AFDZLB in", values, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbNotIn(List<String> values) {
            addCriterion("AFDZLB not in", values, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbBetween(String value1, String value2) {
            addCriterion("AFDZLB between", value1, value2, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andAfdzlbNotBetween(String value1, String value2) {
            addCriterion("AFDZLB not between", value1, value2, "afdzlb");
            return (Criteria) this;
        }

        public Criteria andSjfsdzIsNull() {
            addCriterion("SJFSDZ is null");
            return (Criteria) this;
        }

        public Criteria andSjfsdzIsNotNull() {
            addCriterion("SJFSDZ is not null");
            return (Criteria) this;
        }

        public Criteria andSjfsdzEqualTo(String value) {
            addCriterion("SJFSDZ =", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzNotEqualTo(String value) {
            addCriterion("SJFSDZ <>", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzGreaterThan(String value) {
            addCriterion("SJFSDZ >", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzGreaterThanOrEqualTo(String value) {
            addCriterion("SJFSDZ >=", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzLessThan(String value) {
            addCriterion("SJFSDZ <", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzLessThanOrEqualTo(String value) {
            addCriterion("SJFSDZ <=", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzLike(String value) {
            addCriterion("SJFSDZ like", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzNotLike(String value) {
            addCriterion("SJFSDZ not like", value, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzIn(List<String> values) {
            addCriterion("SJFSDZ in", values, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzNotIn(List<String> values) {
            addCriterion("SJFSDZ not in", values, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzBetween(String value1, String value2) {
            addCriterion("SJFSDZ between", value1, value2, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andSjfsdzNotBetween(String value1, String value2) {
            addCriterion("SJFSDZ not between", value1, value2, "sjfsdz");
            return (Criteria) this;
        }

        public Criteria andDqdwIsNull() {
            addCriterion("DQDW is null");
            return (Criteria) this;
        }

        public Criteria andDqdwIsNotNull() {
            addCriterion("DQDW is not null");
            return (Criteria) this;
        }

        public Criteria andDqdwEqualTo(String value) {
            addCriterion("DQDW =", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwNotEqualTo(String value) {
            addCriterion("DQDW <>", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwGreaterThan(String value) {
            addCriterion("DQDW >", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwGreaterThanOrEqualTo(String value) {
            addCriterion("DQDW >=", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwLessThan(String value) {
            addCriterion("DQDW <", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwLessThanOrEqualTo(String value) {
            addCriterion("DQDW <=", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwLike(String value) {
            addCriterion("DQDW like", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwNotLike(String value) {
            addCriterion("DQDW not like", value, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwIn(List<String> values) {
            addCriterion("DQDW in", values, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwNotIn(List<String> values) {
            addCriterion("DQDW not in", values, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwBetween(String value1, String value2) {
            addCriterion("DQDW between", value1, value2, "dqdw");
            return (Criteria) this;
        }

        public Criteria andDqdwNotBetween(String value1, String value2) {
            addCriterion("DQDW not between", value1, value2, "dqdw");
            return (Criteria) this;
        }

        public Criteria andAjlyIsNull() {
            addCriterion("AJLY is null");
            return (Criteria) this;
        }

        public Criteria andAjlyIsNotNull() {
            addCriterion("AJLY is not null");
            return (Criteria) this;
        }

        public Criteria andAjlyEqualTo(String value) {
            addCriterion("AJLY =", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyNotEqualTo(String value) {
            addCriterion("AJLY <>", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyGreaterThan(String value) {
            addCriterion("AJLY >", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyGreaterThanOrEqualTo(String value) {
            addCriterion("AJLY >=", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyLessThan(String value) {
            addCriterion("AJLY <", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyLessThanOrEqualTo(String value) {
            addCriterion("AJLY <=", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyLike(String value) {
            addCriterion("AJLY like", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyNotLike(String value) {
            addCriterion("AJLY not like", value, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyIn(List<String> values) {
            addCriterion("AJLY in", values, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyNotIn(List<String> values) {
            addCriterion("AJLY not in", values, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyBetween(String value1, String value2) {
            addCriterion("AJLY between", value1, value2, "ajly");
            return (Criteria) this;
        }

        public Criteria andAjlyNotBetween(String value1, String value2) {
            addCriterion("AJLY not between", value1, value2, "ajly");
            return (Criteria) this;
        }

        public Criteria andDjrIsNull() {
            addCriterion("DJR is null");
            return (Criteria) this;
        }

        public Criteria andDjrIsNotNull() {
            addCriterion("DJR is not null");
            return (Criteria) this;
        }

        public Criteria andDjrEqualTo(String value) {
            addCriterion("DJR =", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrNotEqualTo(String value) {
            addCriterion("DJR <>", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrGreaterThan(String value) {
            addCriterion("DJR >", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrGreaterThanOrEqualTo(String value) {
            addCriterion("DJR >=", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrLessThan(String value) {
            addCriterion("DJR <", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrLessThanOrEqualTo(String value) {
            addCriterion("DJR <=", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrLike(String value) {
            addCriterion("DJR like", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrNotLike(String value) {
            addCriterion("DJR not like", value, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrIn(List<String> values) {
            addCriterion("DJR in", values, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrNotIn(List<String> values) {
            addCriterion("DJR not in", values, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrBetween(String value1, String value2) {
            addCriterion("DJR between", value1, value2, "djr");
            return (Criteria) this;
        }

        public Criteria andDjrNotBetween(String value1, String value2) {
            addCriterion("DJR not between", value1, value2, "djr");
            return (Criteria) this;
        }

        public Criteria andDjdwIsNull() {
            addCriterion("DJDW is null");
            return (Criteria) this;
        }

        public Criteria andDjdwIsNotNull() {
            addCriterion("DJDW is not null");
            return (Criteria) this;
        }

        public Criteria andDjdwEqualTo(String value) {
            addCriterion("DJDW =", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwNotEqualTo(String value) {
            addCriterion("DJDW <>", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwGreaterThan(String value) {
            addCriterion("DJDW >", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwGreaterThanOrEqualTo(String value) {
            addCriterion("DJDW >=", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwLessThan(String value) {
            addCriterion("DJDW <", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwLessThanOrEqualTo(String value) {
            addCriterion("DJDW <=", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwLike(String value) {
            addCriterion("DJDW like", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwNotLike(String value) {
            addCriterion("DJDW not like", value, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwIn(List<String> values) {
            addCriterion("DJDW in", values, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwNotIn(List<String> values) {
            addCriterion("DJDW not in", values, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwBetween(String value1, String value2) {
            addCriterion("DJDW between", value1, value2, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjdwNotBetween(String value1, String value2) {
            addCriterion("DJDW not between", value1, value2, "djdw");
            return (Criteria) this;
        }

        public Criteria andDjsjIsNull() {
            addCriterion("DJSJ is null");
            return (Criteria) this;
        }

        public Criteria andDjsjIsNotNull() {
            addCriterion("DJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andDjsjEqualTo(Date value) {
            addCriterionForJDBCDate("DJSJ =", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("DJSJ <>", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjGreaterThan(Date value) {
            addCriterionForJDBCDate("DJSJ >", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DJSJ >=", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjLessThan(Date value) {
            addCriterionForJDBCDate("DJSJ <", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DJSJ <=", value, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjIn(List<Date> values) {
            addCriterionForJDBCDate("DJSJ in", values, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("DJSJ not in", values, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DJSJ between", value1, value2, "djsj");
            return (Criteria) this;
        }

        public Criteria andDjsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DJSJ not between", value1, value2, "djsj");
            return (Criteria) this;
        }

        public Criteria andXsbhIsNull() {
            addCriterion("XSBH is null");
            return (Criteria) this;
        }

        public Criteria andXsbhIsNotNull() {
            addCriterion("XSBH is not null");
            return (Criteria) this;
        }

        public Criteria andXsbhEqualTo(String value) {
            addCriterion("XSBH =", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhNotEqualTo(String value) {
            addCriterion("XSBH <>", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhGreaterThan(String value) {
            addCriterion("XSBH >", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhGreaterThanOrEqualTo(String value) {
            addCriterion("XSBH >=", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhLessThan(String value) {
            addCriterion("XSBH <", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhLessThanOrEqualTo(String value) {
            addCriterion("XSBH <=", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhLike(String value) {
            addCriterion("XSBH like", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhNotLike(String value) {
            addCriterion("XSBH not like", value, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhIn(List<String> values) {
            addCriterion("XSBH in", values, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhNotIn(List<String> values) {
            addCriterion("XSBH not in", values, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhBetween(String value1, String value2) {
            addCriterion("XSBH between", value1, value2, "xsbh");
            return (Criteria) this;
        }

        public Criteria andXsbhNotBetween(String value1, String value2) {
            addCriterion("XSBH not between", value1, value2, "xsbh");
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