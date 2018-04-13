package org.sky.ywbl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStXsxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStXsxxExample() {
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

        public Criteria andJbrIsNull() {
            addCriterion("JBR is null");
            return (Criteria) this;
        }

        public Criteria andJbrIsNotNull() {
            addCriterion("JBR is not null");
            return (Criteria) this;
        }

        public Criteria andJbrEqualTo(String value) {
            addCriterion("JBR =", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrNotEqualTo(String value) {
            addCriterion("JBR <>", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrGreaterThan(String value) {
            addCriterion("JBR >", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrGreaterThanOrEqualTo(String value) {
            addCriterion("JBR >=", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrLessThan(String value) {
            addCriterion("JBR <", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrLessThanOrEqualTo(String value) {
            addCriterion("JBR <=", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrLike(String value) {
            addCriterion("JBR like", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrNotLike(String value) {
            addCriterion("JBR not like", value, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrIn(List<String> values) {
            addCriterion("JBR in", values, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrNotIn(List<String> values) {
            addCriterion("JBR not in", values, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrBetween(String value1, String value2) {
            addCriterion("JBR between", value1, value2, "jbr");
            return (Criteria) this;
        }

        public Criteria andJbrNotBetween(String value1, String value2) {
            addCriterion("JBR not between", value1, value2, "jbr");
            return (Criteria) this;
        }

        public Criteria andZjlxIsNull() {
            addCriterion("ZJLX is null");
            return (Criteria) this;
        }

        public Criteria andZjlxIsNotNull() {
            addCriterion("ZJLX is not null");
            return (Criteria) this;
        }

        public Criteria andZjlxEqualTo(String value) {
            addCriterion("ZJLX =", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotEqualTo(String value) {
            addCriterion("ZJLX <>", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxGreaterThan(String value) {
            addCriterion("ZJLX >", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxGreaterThanOrEqualTo(String value) {
            addCriterion("ZJLX >=", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLessThan(String value) {
            addCriterion("ZJLX <", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLessThanOrEqualTo(String value) {
            addCriterion("ZJLX <=", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLike(String value) {
            addCriterion("ZJLX like", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotLike(String value) {
            addCriterion("ZJLX not like", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxIn(List<String> values) {
            addCriterion("ZJLX in", values, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotIn(List<String> values) {
            addCriterion("ZJLX not in", values, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxBetween(String value1, String value2) {
            addCriterion("ZJLX between", value1, value2, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotBetween(String value1, String value2) {
            addCriterion("ZJLX not between", value1, value2, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjhmIsNull() {
            addCriterion("ZJHM is null");
            return (Criteria) this;
        }

        public Criteria andZjhmIsNotNull() {
            addCriterion("ZJHM is not null");
            return (Criteria) this;
        }

        public Criteria andZjhmEqualTo(String value) {
            addCriterion("ZJHM =", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmNotEqualTo(String value) {
            addCriterion("ZJHM <>", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmGreaterThan(String value) {
            addCriterion("ZJHM >", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmGreaterThanOrEqualTo(String value) {
            addCriterion("ZJHM >=", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmLessThan(String value) {
            addCriterion("ZJHM <", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmLessThanOrEqualTo(String value) {
            addCriterion("ZJHM <=", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmLike(String value) {
            addCriterion("ZJHM like", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmNotLike(String value) {
            addCriterion("ZJHM not like", value, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmIn(List<String> values) {
            addCriterion("ZJHM in", values, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmNotIn(List<String> values) {
            addCriterion("ZJHM not in", values, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmBetween(String value1, String value2) {
            addCriterion("ZJHM between", value1, value2, "zjhm");
            return (Criteria) this;
        }

        public Criteria andZjhmNotBetween(String value1, String value2) {
            addCriterion("ZJHM not between", value1, value2, "zjhm");
            return (Criteria) this;
        }

        public Criteria andDhIsNull() {
            addCriterion("DH is null");
            return (Criteria) this;
        }

        public Criteria andDhIsNotNull() {
            addCriterion("DH is not null");
            return (Criteria) this;
        }

        public Criteria andDhEqualTo(String value) {
            addCriterion("DH =", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotEqualTo(String value) {
            addCriterion("DH <>", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThan(String value) {
            addCriterion("DH >", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThanOrEqualTo(String value) {
            addCriterion("DH >=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThan(String value) {
            addCriterion("DH <", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThanOrEqualTo(String value) {
            addCriterion("DH <=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLike(String value) {
            addCriterion("DH like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotLike(String value) {
            addCriterion("DH not like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhIn(List<String> values) {
            addCriterion("DH in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotIn(List<String> values) {
            addCriterion("DH not in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBetween(String value1, String value2) {
            addCriterion("DH between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotBetween(String value1, String value2) {
            addCriterion("DH not between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andSfdIsNull() {
            addCriterion("SFD is null");
            return (Criteria) this;
        }

        public Criteria andSfdIsNotNull() {
            addCriterion("SFD is not null");
            return (Criteria) this;
        }

        public Criteria andSfdEqualTo(String value) {
            addCriterion("SFD =", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdNotEqualTo(String value) {
            addCriterion("SFD <>", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdGreaterThan(String value) {
            addCriterion("SFD >", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdGreaterThanOrEqualTo(String value) {
            addCriterion("SFD >=", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdLessThan(String value) {
            addCriterion("SFD <", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdLessThanOrEqualTo(String value) {
            addCriterion("SFD <=", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdLike(String value) {
            addCriterion("SFD like", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdNotLike(String value) {
            addCriterion("SFD not like", value, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdIn(List<String> values) {
            addCriterion("SFD in", values, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdNotIn(List<String> values) {
            addCriterion("SFD not in", values, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdBetween(String value1, String value2) {
            addCriterion("SFD between", value1, value2, "sfd");
            return (Criteria) this;
        }

        public Criteria andSfdNotBetween(String value1, String value2) {
            addCriterion("SFD not between", value1, value2, "sfd");
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

        public Criteria andXslyIsNull() {
            addCriterion("XSLY is null");
            return (Criteria) this;
        }

        public Criteria andXslyIsNotNull() {
            addCriterion("XSLY is not null");
            return (Criteria) this;
        }

        public Criteria andXslyEqualTo(String value) {
            addCriterion("XSLY =", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyNotEqualTo(String value) {
            addCriterion("XSLY <>", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyGreaterThan(String value) {
            addCriterion("XSLY >", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyGreaterThanOrEqualTo(String value) {
            addCriterion("XSLY >=", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyLessThan(String value) {
            addCriterion("XSLY <", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyLessThanOrEqualTo(String value) {
            addCriterion("XSLY <=", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyLike(String value) {
            addCriterion("XSLY like", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyNotLike(String value) {
            addCriterion("XSLY not like", value, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyIn(List<String> values) {
            addCriterion("XSLY in", values, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyNotIn(List<String> values) {
            addCriterion("XSLY not in", values, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyBetween(String value1, String value2) {
            addCriterion("XSLY between", value1, value2, "xsly");
            return (Criteria) this;
        }

        public Criteria andXslyNotBetween(String value1, String value2) {
            addCriterion("XSLY not between", value1, value2, "xsly");
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