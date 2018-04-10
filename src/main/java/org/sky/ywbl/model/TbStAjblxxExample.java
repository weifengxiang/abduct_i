package org.sky.ywbl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStAjblxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStAjblxxExample() {
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

        public Criteria andBljgIsNull() {
            addCriterion("BLJG is null");
            return (Criteria) this;
        }

        public Criteria andBljgIsNotNull() {
            addCriterion("BLJG is not null");
            return (Criteria) this;
        }

        public Criteria andBljgEqualTo(String value) {
            addCriterion("BLJG =", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgNotEqualTo(String value) {
            addCriterion("BLJG <>", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgGreaterThan(String value) {
            addCriterion("BLJG >", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgGreaterThanOrEqualTo(String value) {
            addCriterion("BLJG >=", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgLessThan(String value) {
            addCriterion("BLJG <", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgLessThanOrEqualTo(String value) {
            addCriterion("BLJG <=", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgLike(String value) {
            addCriterion("BLJG like", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgNotLike(String value) {
            addCriterion("BLJG not like", value, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgIn(List<String> values) {
            addCriterion("BLJG in", values, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgNotIn(List<String> values) {
            addCriterion("BLJG not in", values, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgBetween(String value1, String value2) {
            addCriterion("BLJG between", value1, value2, "bljg");
            return (Criteria) this;
        }

        public Criteria andBljgNotBetween(String value1, String value2) {
            addCriterion("BLJG not between", value1, value2, "bljg");
            return (Criteria) this;
        }

        public Criteria andBlyjIsNull() {
            addCriterion("BLYJ is null");
            return (Criteria) this;
        }

        public Criteria andBlyjIsNotNull() {
            addCriterion("BLYJ is not null");
            return (Criteria) this;
        }

        public Criteria andBlyjEqualTo(String value) {
            addCriterion("BLYJ =", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjNotEqualTo(String value) {
            addCriterion("BLYJ <>", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjGreaterThan(String value) {
            addCriterion("BLYJ >", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjGreaterThanOrEqualTo(String value) {
            addCriterion("BLYJ >=", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjLessThan(String value) {
            addCriterion("BLYJ <", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjLessThanOrEqualTo(String value) {
            addCriterion("BLYJ <=", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjLike(String value) {
            addCriterion("BLYJ like", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjNotLike(String value) {
            addCriterion("BLYJ not like", value, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjIn(List<String> values) {
            addCriterion("BLYJ in", values, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjNotIn(List<String> values) {
            addCriterion("BLYJ not in", values, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjBetween(String value1, String value2) {
            addCriterion("BLYJ between", value1, value2, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlyjNotBetween(String value1, String value2) {
            addCriterion("BLYJ not between", value1, value2, "blyj");
            return (Criteria) this;
        }

        public Criteria andBlsjIsNull() {
            addCriterion("BLSJ is null");
            return (Criteria) this;
        }

        public Criteria andBlsjIsNotNull() {
            addCriterion("BLSJ is not null");
            return (Criteria) this;
        }

        public Criteria andBlsjEqualTo(Date value) {
            addCriterionForJDBCDate("BLSJ =", value, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("BLSJ <>", value, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjGreaterThan(Date value) {
            addCriterionForJDBCDate("BLSJ >", value, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BLSJ >=", value, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjLessThan(Date value) {
            addCriterionForJDBCDate("BLSJ <", value, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BLSJ <=", value, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjIn(List<Date> values) {
            addCriterionForJDBCDate("BLSJ in", values, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("BLSJ not in", values, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BLSJ between", value1, value2, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BLSJ not between", value1, value2, "blsj");
            return (Criteria) this;
        }

        public Criteria andBlrIsNull() {
            addCriterion("BLR is null");
            return (Criteria) this;
        }

        public Criteria andBlrIsNotNull() {
            addCriterion("BLR is not null");
            return (Criteria) this;
        }

        public Criteria andBlrEqualTo(String value) {
            addCriterion("BLR =", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrNotEqualTo(String value) {
            addCriterion("BLR <>", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrGreaterThan(String value) {
            addCriterion("BLR >", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrGreaterThanOrEqualTo(String value) {
            addCriterion("BLR >=", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrLessThan(String value) {
            addCriterion("BLR <", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrLessThanOrEqualTo(String value) {
            addCriterion("BLR <=", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrLike(String value) {
            addCriterion("BLR like", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrNotLike(String value) {
            addCriterion("BLR not like", value, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrIn(List<String> values) {
            addCriterion("BLR in", values, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrNotIn(List<String> values) {
            addCriterion("BLR not in", values, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrBetween(String value1, String value2) {
            addCriterion("BLR between", value1, value2, "blr");
            return (Criteria) this;
        }

        public Criteria andBlrNotBetween(String value1, String value2) {
            addCriterion("BLR not between", value1, value2, "blr");
            return (Criteria) this;
        }

        public Criteria andBldwIsNull() {
            addCriterion("BLDW is null");
            return (Criteria) this;
        }

        public Criteria andBldwIsNotNull() {
            addCriterion("BLDW is not null");
            return (Criteria) this;
        }

        public Criteria andBldwEqualTo(String value) {
            addCriterion("BLDW =", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwNotEqualTo(String value) {
            addCriterion("BLDW <>", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwGreaterThan(String value) {
            addCriterion("BLDW >", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwGreaterThanOrEqualTo(String value) {
            addCriterion("BLDW >=", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwLessThan(String value) {
            addCriterion("BLDW <", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwLessThanOrEqualTo(String value) {
            addCriterion("BLDW <=", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwLike(String value) {
            addCriterion("BLDW like", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwNotLike(String value) {
            addCriterion("BLDW not like", value, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwIn(List<String> values) {
            addCriterion("BLDW in", values, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwNotIn(List<String> values) {
            addCriterion("BLDW not in", values, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwBetween(String value1, String value2) {
            addCriterion("BLDW between", value1, value2, "bldw");
            return (Criteria) this;
        }

        public Criteria andBldwNotBetween(String value1, String value2) {
            addCriterion("BLDW not between", value1, value2, "bldw");
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

        public Criteria andCreaterTimeIsNull() {
            addCriterion("CREATER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeIsNotNull() {
            addCriterion("CREATER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeEqualTo(Date value) {
            addCriterion("CREATER_TIME =", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeNotEqualTo(Date value) {
            addCriterion("CREATER_TIME <>", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeGreaterThan(Date value) {
            addCriterion("CREATER_TIME >", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATER_TIME >=", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeLessThan(Date value) {
            addCriterion("CREATER_TIME <", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATER_TIME <=", value, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeIn(List<Date> values) {
            addCriterion("CREATER_TIME in", values, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeNotIn(List<Date> values) {
            addCriterion("CREATER_TIME not in", values, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeBetween(Date value1, Date value2) {
            addCriterion("CREATER_TIME between", value1, value2, "createrTime");
            return (Criteria) this;
        }

        public Criteria andCreaterTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATER_TIME not between", value1, value2, "createrTime");
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

        public Criteria andUpdaterTimeIsNull() {
            addCriterion("UPDATER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeIsNotNull() {
            addCriterion("UPDATER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeEqualTo(Date value) {
            addCriterion("UPDATER_TIME =", value, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeNotEqualTo(Date value) {
            addCriterion("UPDATER_TIME <>", value, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeGreaterThan(Date value) {
            addCriterion("UPDATER_TIME >", value, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATER_TIME >=", value, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeLessThan(Date value) {
            addCriterion("UPDATER_TIME <", value, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATER_TIME <=", value, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeIn(List<Date> values) {
            addCriterion("UPDATER_TIME in", values, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeNotIn(List<Date> values) {
            addCriterion("UPDATER_TIME not in", values, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATER_TIME between", value1, value2, "updaterTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATER_TIME not between", value1, value2, "updaterTime");
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