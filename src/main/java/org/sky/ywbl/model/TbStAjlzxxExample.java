package org.sky.ywbl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStAjlzxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStAjlzxxExample() {
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

        public Criteria andLzbhIsNull() {
            addCriterion("LZBH is null");
            return (Criteria) this;
        }

        public Criteria andLzbhIsNotNull() {
            addCriterion("LZBH is not null");
            return (Criteria) this;
        }

        public Criteria andLzbhEqualTo(String value) {
            addCriterion("LZBH =", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhNotEqualTo(String value) {
            addCriterion("LZBH <>", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhGreaterThan(String value) {
            addCriterion("LZBH >", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhGreaterThanOrEqualTo(String value) {
            addCriterion("LZBH >=", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhLessThan(String value) {
            addCriterion("LZBH <", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhLessThanOrEqualTo(String value) {
            addCriterion("LZBH <=", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhLike(String value) {
            addCriterion("LZBH like", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhNotLike(String value) {
            addCriterion("LZBH not like", value, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhIn(List<String> values) {
            addCriterion("LZBH in", values, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhNotIn(List<String> values) {
            addCriterion("LZBH not in", values, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhBetween(String value1, String value2) {
            addCriterion("LZBH between", value1, value2, "lzbh");
            return (Criteria) this;
        }

        public Criteria andLzbhNotBetween(String value1, String value2) {
            addCriterion("LZBH not between", value1, value2, "lzbh");
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

        public Criteria andSblzbhIsNull() {
            addCriterion("SBLZBH is null");
            return (Criteria) this;
        }

        public Criteria andSblzbhIsNotNull() {
            addCriterion("SBLZBH is not null");
            return (Criteria) this;
        }

        public Criteria andSblzbhEqualTo(String value) {
            addCriterion("SBLZBH =", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhNotEqualTo(String value) {
            addCriterion("SBLZBH <>", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhGreaterThan(String value) {
            addCriterion("SBLZBH >", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhGreaterThanOrEqualTo(String value) {
            addCriterion("SBLZBH >=", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhLessThan(String value) {
            addCriterion("SBLZBH <", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhLessThanOrEqualTo(String value) {
            addCriterion("SBLZBH <=", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhLike(String value) {
            addCriterion("SBLZBH like", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhNotLike(String value) {
            addCriterion("SBLZBH not like", value, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhIn(List<String> values) {
            addCriterion("SBLZBH in", values, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhNotIn(List<String> values) {
            addCriterion("SBLZBH not in", values, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhBetween(String value1, String value2) {
            addCriterion("SBLZBH between", value1, value2, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andSblzbhNotBetween(String value1, String value2) {
            addCriterion("SBLZBH not between", value1, value2, "sblzbh");
            return (Criteria) this;
        }

        public Criteria andLzrIsNull() {
            addCriterion("LZR is null");
            return (Criteria) this;
        }

        public Criteria andLzrIsNotNull() {
            addCriterion("LZR is not null");
            return (Criteria) this;
        }

        public Criteria andLzrEqualTo(String value) {
            addCriterion("LZR =", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrNotEqualTo(String value) {
            addCriterion("LZR <>", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrGreaterThan(String value) {
            addCriterion("LZR >", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrGreaterThanOrEqualTo(String value) {
            addCriterion("LZR >=", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrLessThan(String value) {
            addCriterion("LZR <", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrLessThanOrEqualTo(String value) {
            addCriterion("LZR <=", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrLike(String value) {
            addCriterion("LZR like", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrNotLike(String value) {
            addCriterion("LZR not like", value, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrIn(List<String> values) {
            addCriterion("LZR in", values, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrNotIn(List<String> values) {
            addCriterion("LZR not in", values, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrBetween(String value1, String value2) {
            addCriterion("LZR between", value1, value2, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzrNotBetween(String value1, String value2) {
            addCriterion("LZR not between", value1, value2, "lzr");
            return (Criteria) this;
        }

        public Criteria andLzdwIsNull() {
            addCriterion("LZDW is null");
            return (Criteria) this;
        }

        public Criteria andLzdwIsNotNull() {
            addCriterion("LZDW is not null");
            return (Criteria) this;
        }

        public Criteria andLzdwEqualTo(String value) {
            addCriterion("LZDW =", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwNotEqualTo(String value) {
            addCriterion("LZDW <>", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwGreaterThan(String value) {
            addCriterion("LZDW >", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwGreaterThanOrEqualTo(String value) {
            addCriterion("LZDW >=", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwLessThan(String value) {
            addCriterion("LZDW <", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwLessThanOrEqualTo(String value) {
            addCriterion("LZDW <=", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwLike(String value) {
            addCriterion("LZDW like", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwNotLike(String value) {
            addCriterion("LZDW not like", value, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwIn(List<String> values) {
            addCriterion("LZDW in", values, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwNotIn(List<String> values) {
            addCriterion("LZDW not in", values, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwBetween(String value1, String value2) {
            addCriterion("LZDW between", value1, value2, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzdwNotBetween(String value1, String value2) {
            addCriterion("LZDW not between", value1, value2, "lzdw");
            return (Criteria) this;
        }

        public Criteria andLzyyIsNull() {
            addCriterion("LZYY is null");
            return (Criteria) this;
        }

        public Criteria andLzyyIsNotNull() {
            addCriterion("LZYY is not null");
            return (Criteria) this;
        }

        public Criteria andLzyyEqualTo(String value) {
            addCriterion("LZYY =", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyNotEqualTo(String value) {
            addCriterion("LZYY <>", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyGreaterThan(String value) {
            addCriterion("LZYY >", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyGreaterThanOrEqualTo(String value) {
            addCriterion("LZYY >=", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyLessThan(String value) {
            addCriterion("LZYY <", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyLessThanOrEqualTo(String value) {
            addCriterion("LZYY <=", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyLike(String value) {
            addCriterion("LZYY like", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyNotLike(String value) {
            addCriterion("LZYY not like", value, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyIn(List<String> values) {
            addCriterion("LZYY in", values, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyNotIn(List<String> values) {
            addCriterion("LZYY not in", values, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyBetween(String value1, String value2) {
            addCriterion("LZYY between", value1, value2, "lzyy");
            return (Criteria) this;
        }

        public Criteria andLzyyNotBetween(String value1, String value2) {
            addCriterion("LZYY not between", value1, value2, "lzyy");
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

        public Criteria andLzsjIsNull() {
            addCriterion("LZSJ is null");
            return (Criteria) this;
        }

        public Criteria andLzsjIsNotNull() {
            addCriterion("LZSJ is not null");
            return (Criteria) this;
        }

        public Criteria andLzsjEqualTo(Date value) {
            addCriterion("LZSJ =", value, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjNotEqualTo(Date value) {
            addCriterion("LZSJ <>", value, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjGreaterThan(Date value) {
            addCriterion("LZSJ >", value, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjGreaterThanOrEqualTo(Date value) {
            addCriterion("LZSJ >=", value, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjLessThan(Date value) {
            addCriterion("LZSJ <", value, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjLessThanOrEqualTo(Date value) {
            addCriterion("LZSJ <=", value, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjIn(List<Date> values) {
            addCriterion("LZSJ in", values, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjNotIn(List<Date> values) {
            addCriterion("LZSJ not in", values, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjBetween(Date value1, Date value2) {
            addCriterion("LZSJ between", value1, value2, "lzsj");
            return (Criteria) this;
        }

        public Criteria andLzsjNotBetween(Date value1, Date value2) {
            addCriterion("LZSJ not between", value1, value2, "lzsj");
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