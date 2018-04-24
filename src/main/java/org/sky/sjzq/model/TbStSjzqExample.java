package org.sky.sjzq.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStSjzqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStSjzqExample() {
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

        public Criteria andXqlbIsNull() {
            addCriterion("XQLB is null");
            return (Criteria) this;
        }

        public Criteria andXqlbIsNotNull() {
            addCriterion("XQLB is not null");
            return (Criteria) this;
        }

        public Criteria andXqlbEqualTo(String value) {
            addCriterion("XQLB =", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbNotEqualTo(String value) {
            addCriterion("XQLB <>", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbGreaterThan(String value) {
            addCriterion("XQLB >", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbGreaterThanOrEqualTo(String value) {
            addCriterion("XQLB >=", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbLessThan(String value) {
            addCriterion("XQLB <", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbLessThanOrEqualTo(String value) {
            addCriterion("XQLB <=", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbLike(String value) {
            addCriterion("XQLB like", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbNotLike(String value) {
            addCriterion("XQLB not like", value, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbIn(List<String> values) {
            addCriterion("XQLB in", values, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbNotIn(List<String> values) {
            addCriterion("XQLB not in", values, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbBetween(String value1, String value2) {
            addCriterion("XQLB between", value1, value2, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqlbNotBetween(String value1, String value2) {
            addCriterion("XQLB not between", value1, value2, "xqlb");
            return (Criteria) this;
        }

        public Criteria andXqbhIsNull() {
            addCriterion("XQBH is null");
            return (Criteria) this;
        }

        public Criteria andXqbhIsNotNull() {
            addCriterion("XQBH is not null");
            return (Criteria) this;
        }

        public Criteria andXqbhEqualTo(String value) {
            addCriterion("XQBH =", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhNotEqualTo(String value) {
            addCriterion("XQBH <>", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhGreaterThan(String value) {
            addCriterion("XQBH >", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhGreaterThanOrEqualTo(String value) {
            addCriterion("XQBH >=", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhLessThan(String value) {
            addCriterion("XQBH <", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhLessThanOrEqualTo(String value) {
            addCriterion("XQBH <=", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhLike(String value) {
            addCriterion("XQBH like", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhNotLike(String value) {
            addCriterion("XQBH not like", value, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhIn(List<String> values) {
            addCriterion("XQBH in", values, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhNotIn(List<String> values) {
            addCriterion("XQBH not in", values, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhBetween(String value1, String value2) {
            addCriterion("XQBH between", value1, value2, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXqbhNotBetween(String value1, String value2) {
            addCriterion("XQBH not between", value1, value2, "xqbh");
            return (Criteria) this;
        }

        public Criteria andXmIsNull() {
            addCriterion("XM is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("XM <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("XM like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("XM not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("XM in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("XM not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("XM between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXbIsNull() {
            addCriterion("XB is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("XB is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(String value) {
            addCriterion("XB =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(String value) {
            addCriterion("XB <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(String value) {
            addCriterion("XB >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(String value) {
            addCriterion("XB >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(String value) {
            addCriterion("XB <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(String value) {
            addCriterion("XB <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLike(String value) {
            addCriterion("XB like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotLike(String value) {
            addCriterion("XB not like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<String> values) {
            addCriterion("XB in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<String> values) {
            addCriterion("XB not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(String value1, String value2) {
            addCriterion("XB between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(String value1, String value2) {
            addCriterion("XB not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNull() {
            addCriterion("CSRQ is null");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNotNull() {
            addCriterion("CSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andCsrqEqualTo(String value) {
            addCriterion("CSRQ =", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotEqualTo(String value) {
            addCriterion("CSRQ <>", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThan(String value) {
            addCriterion("CSRQ >", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThanOrEqualTo(String value) {
            addCriterion("CSRQ >=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThan(String value) {
            addCriterion("CSRQ <", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThanOrEqualTo(String value) {
            addCriterion("CSRQ <=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLike(String value) {
            addCriterion("CSRQ like", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotLike(String value) {
            addCriterion("CSRQ not like", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqIn(List<String> values) {
            addCriterion("CSRQ in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotIn(List<String> values) {
            addCriterion("CSRQ not in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqBetween(String value1, String value2) {
            addCriterion("CSRQ between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotBetween(String value1, String value2) {
            addCriterion("CSRQ not between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andSzssgIsNull() {
            addCriterion("SZSSG is null");
            return (Criteria) this;
        }

        public Criteria andSzssgIsNotNull() {
            addCriterion("SZSSG is not null");
            return (Criteria) this;
        }

        public Criteria andSzssgEqualTo(String value) {
            addCriterion("SZSSG =", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgNotEqualTo(String value) {
            addCriterion("SZSSG <>", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgGreaterThan(String value) {
            addCriterion("SZSSG >", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgGreaterThanOrEqualTo(String value) {
            addCriterion("SZSSG >=", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgLessThan(String value) {
            addCriterion("SZSSG <", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgLessThanOrEqualTo(String value) {
            addCriterion("SZSSG <=", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgLike(String value) {
            addCriterion("SZSSG like", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgNotLike(String value) {
            addCriterion("SZSSG not like", value, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgIn(List<String> values) {
            addCriterion("SZSSG in", values, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgNotIn(List<String> values) {
            addCriterion("SZSSG not in", values, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgBetween(String value1, String value2) {
            addCriterion("SZSSG between", value1, value2, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzssgNotBetween(String value1, String value2) {
            addCriterion("SZSSG not between", value1, value2, "szssg");
            return (Criteria) this;
        }

        public Criteria andSzsjIsNull() {
            addCriterion("SZSJ is null");
            return (Criteria) this;
        }

        public Criteria andSzsjIsNotNull() {
            addCriterion("SZSJ is not null");
            return (Criteria) this;
        }

        public Criteria andSzsjEqualTo(String value) {
            addCriterion("SZSJ =", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjNotEqualTo(String value) {
            addCriterion("SZSJ <>", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjGreaterThan(String value) {
            addCriterion("SZSJ >", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjGreaterThanOrEqualTo(String value) {
            addCriterion("SZSJ >=", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjLessThan(String value) {
            addCriterion("SZSJ <", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjLessThanOrEqualTo(String value) {
            addCriterion("SZSJ <=", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjLike(String value) {
            addCriterion("SZSJ like", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjNotLike(String value) {
            addCriterion("SZSJ not like", value, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjIn(List<String> values) {
            addCriterion("SZSJ in", values, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjNotIn(List<String> values) {
            addCriterion("SZSJ not in", values, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjBetween(String value1, String value2) {
            addCriterion("SZSJ between", value1, value2, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzsjNotBetween(String value1, String value2) {
            addCriterion("SZSJ not between", value1, value2, "szsj");
            return (Criteria) this;
        }

        public Criteria andSzrszdIsNull() {
            addCriterion("SZRSZD is null");
            return (Criteria) this;
        }

        public Criteria andSzrszdIsNotNull() {
            addCriterion("SZRSZD is not null");
            return (Criteria) this;
        }

        public Criteria andSzrszdEqualTo(String value) {
            addCriterion("SZRSZD =", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdNotEqualTo(String value) {
            addCriterion("SZRSZD <>", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdGreaterThan(String value) {
            addCriterion("SZRSZD >", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdGreaterThanOrEqualTo(String value) {
            addCriterion("SZRSZD >=", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdLessThan(String value) {
            addCriterion("SZRSZD <", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdLessThanOrEqualTo(String value) {
            addCriterion("SZRSZD <=", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdLike(String value) {
            addCriterion("SZRSZD like", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdNotLike(String value) {
            addCriterion("SZRSZD not like", value, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdIn(List<String> values) {
            addCriterion("SZRSZD in", values, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdNotIn(List<String> values) {
            addCriterion("SZRSZD not in", values, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdBetween(String value1, String value2) {
            addCriterion("SZRSZD between", value1, value2, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzrszdNotBetween(String value1, String value2) {
            addCriterion("SZRSZD not between", value1, value2, "szrszd");
            return (Criteria) this;
        }

        public Criteria andSzddIsNull() {
            addCriterion("SZDD is null");
            return (Criteria) this;
        }

        public Criteria andSzddIsNotNull() {
            addCriterion("SZDD is not null");
            return (Criteria) this;
        }

        public Criteria andSzddEqualTo(String value) {
            addCriterion("SZDD =", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddNotEqualTo(String value) {
            addCriterion("SZDD <>", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddGreaterThan(String value) {
            addCriterion("SZDD >", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddGreaterThanOrEqualTo(String value) {
            addCriterion("SZDD >=", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddLessThan(String value) {
            addCriterion("SZDD <", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddLessThanOrEqualTo(String value) {
            addCriterion("SZDD <=", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddLike(String value) {
            addCriterion("SZDD like", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddNotLike(String value) {
            addCriterion("SZDD not like", value, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddIn(List<String> values) {
            addCriterion("SZDD in", values, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddNotIn(List<String> values) {
            addCriterion("SZDD not in", values, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddBetween(String value1, String value2) {
            addCriterion("SZDD between", value1, value2, "szdd");
            return (Criteria) this;
        }

        public Criteria andSzddNotBetween(String value1, String value2) {
            addCriterion("SZDD not between", value1, value2, "szdd");
            return (Criteria) this;
        }

        public Criteria andXqztzmsIsNull() {
            addCriterion("XQZTZMS is null");
            return (Criteria) this;
        }

        public Criteria andXqztzmsIsNotNull() {
            addCriterion("XQZTZMS is not null");
            return (Criteria) this;
        }

        public Criteria andXqztzmsEqualTo(String value) {
            addCriterion("XQZTZMS =", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsNotEqualTo(String value) {
            addCriterion("XQZTZMS <>", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsGreaterThan(String value) {
            addCriterion("XQZTZMS >", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsGreaterThanOrEqualTo(String value) {
            addCriterion("XQZTZMS >=", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsLessThan(String value) {
            addCriterion("XQZTZMS <", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsLessThanOrEqualTo(String value) {
            addCriterion("XQZTZMS <=", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsLike(String value) {
            addCriterion("XQZTZMS like", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsNotLike(String value) {
            addCriterion("XQZTZMS not like", value, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsIn(List<String> values) {
            addCriterion("XQZTZMS in", values, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsNotIn(List<String> values) {
            addCriterion("XQZTZMS not in", values, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsBetween(String value1, String value2) {
            addCriterion("XQZTZMS between", value1, value2, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andXqztzmsNotBetween(String value1, String value2) {
            addCriterion("XQZTZMS not between", value1, value2, "xqztzms");
            return (Criteria) this;
        }

        public Criteria andQtzlIsNull() {
            addCriterion("QTZL is null");
            return (Criteria) this;
        }

        public Criteria andQtzlIsNotNull() {
            addCriterion("QTZL is not null");
            return (Criteria) this;
        }

        public Criteria andQtzlEqualTo(String value) {
            addCriterion("QTZL =", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlNotEqualTo(String value) {
            addCriterion("QTZL <>", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlGreaterThan(String value) {
            addCriterion("QTZL >", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlGreaterThanOrEqualTo(String value) {
            addCriterion("QTZL >=", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlLessThan(String value) {
            addCriterion("QTZL <", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlLessThanOrEqualTo(String value) {
            addCriterion("QTZL <=", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlLike(String value) {
            addCriterion("QTZL like", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlNotLike(String value) {
            addCriterion("QTZL not like", value, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlIn(List<String> values) {
            addCriterion("QTZL in", values, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlNotIn(List<String> values) {
            addCriterion("QTZL not in", values, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlBetween(String value1, String value2) {
            addCriterion("QTZL between", value1, value2, "qtzl");
            return (Criteria) this;
        }

        public Criteria andQtzlNotBetween(String value1, String value2) {
            addCriterion("QTZL not between", value1, value2, "qtzl");
            return (Criteria) this;
        }

        public Criteria andZcsjIsNull() {
            addCriterion("ZCSJ is null");
            return (Criteria) this;
        }

        public Criteria andZcsjIsNotNull() {
            addCriterion("ZCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andZcsjEqualTo(String value) {
            addCriterion("ZCSJ =", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjNotEqualTo(String value) {
            addCriterion("ZCSJ <>", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjGreaterThan(String value) {
            addCriterion("ZCSJ >", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjGreaterThanOrEqualTo(String value) {
            addCriterion("ZCSJ >=", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjLessThan(String value) {
            addCriterion("ZCSJ <", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjLessThanOrEqualTo(String value) {
            addCriterion("ZCSJ <=", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjLike(String value) {
            addCriterion("ZCSJ like", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjNotLike(String value) {
            addCriterion("ZCSJ not like", value, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjIn(List<String> values) {
            addCriterion("ZCSJ in", values, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjNotIn(List<String> values) {
            addCriterion("ZCSJ not in", values, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjBetween(String value1, String value2) {
            addCriterion("ZCSJ between", value1, value2, "zcsj");
            return (Criteria) this;
        }

        public Criteria andZcsjNotBetween(String value1, String value2) {
            addCriterion("ZCSJ not between", value1, value2, "zcsj");
            return (Criteria) this;
        }

        public Criteria andGjzyzIsNull() {
            addCriterion("GJZYZ is null");
            return (Criteria) this;
        }

        public Criteria andGjzyzIsNotNull() {
            addCriterion("GJZYZ is not null");
            return (Criteria) this;
        }

        public Criteria andGjzyzEqualTo(String value) {
            addCriterion("GJZYZ =", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzNotEqualTo(String value) {
            addCriterion("GJZYZ <>", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzGreaterThan(String value) {
            addCriterion("GJZYZ >", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzGreaterThanOrEqualTo(String value) {
            addCriterion("GJZYZ >=", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzLessThan(String value) {
            addCriterion("GJZYZ <", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzLessThanOrEqualTo(String value) {
            addCriterion("GJZYZ <=", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzLike(String value) {
            addCriterion("GJZYZ like", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzNotLike(String value) {
            addCriterion("GJZYZ not like", value, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzIn(List<String> values) {
            addCriterion("GJZYZ in", values, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzNotIn(List<String> values) {
            addCriterion("GJZYZ not in", values, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzBetween(String value1, String value2) {
            addCriterion("GJZYZ between", value1, value2, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andGjzyzNotBetween(String value1, String value2) {
            addCriterion("GJZYZ not between", value1, value2, "gjzyz");
            return (Criteria) this;
        }

        public Criteria andYswzIsNull() {
            addCriterion("YSWZ is null");
            return (Criteria) this;
        }

        public Criteria andYswzIsNotNull() {
            addCriterion("YSWZ is not null");
            return (Criteria) this;
        }

        public Criteria andYswzEqualTo(String value) {
            addCriterion("YSWZ =", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzNotEqualTo(String value) {
            addCriterion("YSWZ <>", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzGreaterThan(String value) {
            addCriterion("YSWZ >", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzGreaterThanOrEqualTo(String value) {
            addCriterion("YSWZ >=", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzLessThan(String value) {
            addCriterion("YSWZ <", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzLessThanOrEqualTo(String value) {
            addCriterion("YSWZ <=", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzLike(String value) {
            addCriterion("YSWZ like", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzNotLike(String value) {
            addCriterion("YSWZ not like", value, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzIn(List<String> values) {
            addCriterion("YSWZ in", values, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzNotIn(List<String> values) {
            addCriterion("YSWZ not in", values, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzBetween(String value1, String value2) {
            addCriterion("YSWZ between", value1, value2, "yswz");
            return (Criteria) this;
        }

        public Criteria andYswzNotBetween(String value1, String value2) {
            addCriterion("YSWZ not between", value1, value2, "yswz");
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

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
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