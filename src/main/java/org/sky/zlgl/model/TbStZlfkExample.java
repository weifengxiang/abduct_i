package org.sky.zlgl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStZlfkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStZlfkExample() {
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

        public Criteria andZlbhIsNull() {
            addCriterion("ZLBH is null");
            return (Criteria) this;
        }

        public Criteria andZlbhIsNotNull() {
            addCriterion("ZLBH is not null");
            return (Criteria) this;
        }

        public Criteria andZlbhEqualTo(String value) {
            addCriterion("ZLBH =", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhNotEqualTo(String value) {
            addCriterion("ZLBH <>", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhGreaterThan(String value) {
            addCriterion("ZLBH >", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhGreaterThanOrEqualTo(String value) {
            addCriterion("ZLBH >=", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhLessThan(String value) {
            addCriterion("ZLBH <", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhLessThanOrEqualTo(String value) {
            addCriterion("ZLBH <=", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhLike(String value) {
            addCriterion("ZLBH like", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhNotLike(String value) {
            addCriterion("ZLBH not like", value, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhIn(List<String> values) {
            addCriterion("ZLBH in", values, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhNotIn(List<String> values) {
            addCriterion("ZLBH not in", values, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhBetween(String value1, String value2) {
            addCriterion("ZLBH between", value1, value2, "zlbh");
            return (Criteria) this;
        }

        public Criteria andZlbhNotBetween(String value1, String value2) {
            addCriterion("ZLBH not between", value1, value2, "zlbh");
            return (Criteria) this;
        }

        public Criteria andJsdwIsNull() {
            addCriterion("JSDW is null");
            return (Criteria) this;
        }

        public Criteria andJsdwIsNotNull() {
            addCriterion("JSDW is not null");
            return (Criteria) this;
        }

        public Criteria andJsdwEqualTo(String value) {
            addCriterion("JSDW =", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotEqualTo(String value) {
            addCriterion("JSDW <>", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwGreaterThan(String value) {
            addCriterion("JSDW >", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwGreaterThanOrEqualTo(String value) {
            addCriterion("JSDW >=", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwLessThan(String value) {
            addCriterion("JSDW <", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwLessThanOrEqualTo(String value) {
            addCriterion("JSDW <=", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwLike(String value) {
            addCriterion("JSDW like", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotLike(String value) {
            addCriterion("JSDW not like", value, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwIn(List<String> values) {
            addCriterion("JSDW in", values, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotIn(List<String> values) {
            addCriterion("JSDW not in", values, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwBetween(String value1, String value2) {
            addCriterion("JSDW between", value1, value2, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJsdwNotBetween(String value1, String value2) {
            addCriterion("JSDW not between", value1, value2, "jsdw");
            return (Criteria) this;
        }

        public Criteria andJssjIsNull() {
            addCriterion("JSSJ is null");
            return (Criteria) this;
        }

        public Criteria andJssjIsNotNull() {
            addCriterion("JSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andJssjEqualTo(Date value) {
            addCriterion("JSSJ =", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotEqualTo(Date value) {
            addCriterion("JSSJ <>", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThan(Date value) {
            addCriterion("JSSJ >", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjGreaterThanOrEqualTo(Date value) {
            addCriterion("JSSJ >=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThan(Date value) {
            addCriterion("JSSJ <", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjLessThanOrEqualTo(Date value) {
            addCriterion("JSSJ <=", value, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjIn(List<Date> values) {
            addCriterion("JSSJ in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotIn(List<Date> values) {
            addCriterion("JSSJ not in", values, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjBetween(Date value1, Date value2) {
            addCriterion("JSSJ between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andJssjNotBetween(Date value1, Date value2) {
            addCriterion("JSSJ not between", value1, value2, "jssj");
            return (Criteria) this;
        }

        public Criteria andFksjIsNull() {
            addCriterion("FKSJ is null");
            return (Criteria) this;
        }

        public Criteria andFksjIsNotNull() {
            addCriterion("FKSJ is not null");
            return (Criteria) this;
        }

        public Criteria andFksjEqualTo(Date value) {
            addCriterion("FKSJ =", value, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjNotEqualTo(Date value) {
            addCriterion("FKSJ <>", value, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjGreaterThan(Date value) {
            addCriterion("FKSJ >", value, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjGreaterThanOrEqualTo(Date value) {
            addCriterion("FKSJ >=", value, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjLessThan(Date value) {
            addCriterion("FKSJ <", value, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjLessThanOrEqualTo(Date value) {
            addCriterion("FKSJ <=", value, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjIn(List<Date> values) {
            addCriterion("FKSJ in", values, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjNotIn(List<Date> values) {
            addCriterion("FKSJ not in", values, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjBetween(Date value1, Date value2) {
            addCriterion("FKSJ between", value1, value2, "fksj");
            return (Criteria) this;
        }

        public Criteria andFksjNotBetween(Date value1, Date value2) {
            addCriterion("FKSJ not between", value1, value2, "fksj");
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

        public Criteria andZtIsNull() {
            addCriterion("ZT is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("ZT is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("ZT =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("ZT <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("ZT >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("ZT >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("ZT <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("ZT <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("ZT like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("ZT not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("ZT in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("ZT not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("ZT between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("ZT not between", value1, value2, "zt");
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