package org.sky.xxbk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStXxbkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStXxbkExample() {
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

        public Criteria andBhIsNull() {
            addCriterion("BH is null");
            return (Criteria) this;
        }

        public Criteria andBhIsNotNull() {
            addCriterion("BH is not null");
            return (Criteria) this;
        }

        public Criteria andBhEqualTo(String value) {
            addCriterion("BH =", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotEqualTo(String value) {
            addCriterion("BH <>", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThan(String value) {
            addCriterion("BH >", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThanOrEqualTo(String value) {
            addCriterion("BH >=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThan(String value) {
            addCriterion("BH <", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThanOrEqualTo(String value) {
            addCriterion("BH <=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLike(String value) {
            addCriterion("BH like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotLike(String value) {
            addCriterion("BH not like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhIn(List<String> values) {
            addCriterion("BH in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotIn(List<String> values) {
            addCriterion("BH not in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhBetween(String value1, String value2) {
            addCriterion("BH between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotBetween(String value1, String value2) {
            addCriterion("BH not between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andBknrIsNull() {
            addCriterion("BKNR is null");
            return (Criteria) this;
        }

        public Criteria andBknrIsNotNull() {
            addCriterion("BKNR is not null");
            return (Criteria) this;
        }

        public Criteria andBknrEqualTo(String value) {
            addCriterion("BKNR =", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrNotEqualTo(String value) {
            addCriterion("BKNR <>", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrGreaterThan(String value) {
            addCriterion("BKNR >", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrGreaterThanOrEqualTo(String value) {
            addCriterion("BKNR >=", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrLessThan(String value) {
            addCriterion("BKNR <", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrLessThanOrEqualTo(String value) {
            addCriterion("BKNR <=", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrLike(String value) {
            addCriterion("BKNR like", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrNotLike(String value) {
            addCriterion("BKNR not like", value, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrIn(List<String> values) {
            addCriterion("BKNR in", values, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrNotIn(List<String> values) {
            addCriterion("BKNR not in", values, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrBetween(String value1, String value2) {
            addCriterion("BKNR between", value1, value2, "bknr");
            return (Criteria) this;
        }

        public Criteria andBknrNotBetween(String value1, String value2) {
            addCriterion("BKNR not between", value1, value2, "bknr");
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

        public Criteria andTyzIsNull() {
            addCriterion("TYZ is null");
            return (Criteria) this;
        }

        public Criteria andTyzIsNotNull() {
            addCriterion("TYZ is not null");
            return (Criteria) this;
        }

        public Criteria andTyzEqualTo(String value) {
            addCriterion("TYZ =", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzNotEqualTo(String value) {
            addCriterion("TYZ <>", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzGreaterThan(String value) {
            addCriterion("TYZ >", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzGreaterThanOrEqualTo(String value) {
            addCriterion("TYZ >=", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzLessThan(String value) {
            addCriterion("TYZ <", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzLessThanOrEqualTo(String value) {
            addCriterion("TYZ <=", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzLike(String value) {
            addCriterion("TYZ like", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzNotLike(String value) {
            addCriterion("TYZ not like", value, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzIn(List<String> values) {
            addCriterion("TYZ in", values, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzNotIn(List<String> values) {
            addCriterion("TYZ not in", values, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzBetween(String value1, String value2) {
            addCriterion("TYZ between", value1, value2, "tyz");
            return (Criteria) this;
        }

        public Criteria andTyzNotBetween(String value1, String value2) {
            addCriterion("TYZ not between", value1, value2, "tyz");
            return (Criteria) this;
        }

        public Criteria andYxsjqIsNull() {
            addCriterion("YXSJQ is null");
            return (Criteria) this;
        }

        public Criteria andYxsjqIsNotNull() {
            addCriterion("YXSJQ is not null");
            return (Criteria) this;
        }

        public Criteria andYxsjqEqualTo(Date value) {
            addCriterion("YXSJQ =", value, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqNotEqualTo(Date value) {
            addCriterion("YXSJQ <>", value, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqGreaterThan(Date value) {
            addCriterion("YXSJQ >", value, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqGreaterThanOrEqualTo(Date value) {
            addCriterion("YXSJQ >=", value, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqLessThan(Date value) {
            addCriterion("YXSJQ <", value, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqLessThanOrEqualTo(Date value) {
            addCriterion("YXSJQ <=", value, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqIn(List<Date> values) {
            addCriterion("YXSJQ in", values, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqNotIn(List<Date> values) {
            addCriterion("YXSJQ not in", values, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqBetween(Date value1, Date value2) {
            addCriterion("YXSJQ between", value1, value2, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjqNotBetween(Date value1, Date value2) {
            addCriterion("YXSJQ not between", value1, value2, "yxsjq");
            return (Criteria) this;
        }

        public Criteria andYxsjzIsNull() {
            addCriterion("YXSJZ is null");
            return (Criteria) this;
        }

        public Criteria andYxsjzIsNotNull() {
            addCriterion("YXSJZ is not null");
            return (Criteria) this;
        }

        public Criteria andYxsjzEqualTo(Date value) {
            addCriterion("YXSJZ =", value, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzNotEqualTo(Date value) {
            addCriterion("YXSJZ <>", value, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzGreaterThan(Date value) {
            addCriterion("YXSJZ >", value, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzGreaterThanOrEqualTo(Date value) {
            addCriterion("YXSJZ >=", value, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzLessThan(Date value) {
            addCriterion("YXSJZ <", value, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzLessThanOrEqualTo(Date value) {
            addCriterion("YXSJZ <=", value, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzIn(List<Date> values) {
            addCriterion("YXSJZ in", values, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzNotIn(List<Date> values) {
            addCriterion("YXSJZ not in", values, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzBetween(Date value1, Date value2) {
            addCriterion("YXSJZ between", value1, value2, "yxsjz");
            return (Criteria) this;
        }

        public Criteria andYxsjzNotBetween(Date value1, Date value2) {
            addCriterion("YXSJZ not between", value1, value2, "yxsjz");
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

        public Criteria andZrrIsNull() {
            addCriterion("ZRR is null");
            return (Criteria) this;
        }

        public Criteria andZrrIsNotNull() {
            addCriterion("ZRR is not null");
            return (Criteria) this;
        }

        public Criteria andZrrEqualTo(String value) {
            addCriterion("ZRR =", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrNotEqualTo(String value) {
            addCriterion("ZRR <>", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrGreaterThan(String value) {
            addCriterion("ZRR >", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrGreaterThanOrEqualTo(String value) {
            addCriterion("ZRR >=", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrLessThan(String value) {
            addCriterion("ZRR <", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrLessThanOrEqualTo(String value) {
            addCriterion("ZRR <=", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrLike(String value) {
            addCriterion("ZRR like", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrNotLike(String value) {
            addCriterion("ZRR not like", value, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrIn(List<String> values) {
            addCriterion("ZRR in", values, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrNotIn(List<String> values) {
            addCriterion("ZRR not in", values, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrBetween(String value1, String value2) {
            addCriterion("ZRR between", value1, value2, "zrr");
            return (Criteria) this;
        }

        public Criteria andZrrNotBetween(String value1, String value2) {
            addCriterion("ZRR not between", value1, value2, "zrr");
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

        public Criteria andSprIsNull() {
            addCriterion("SPR is null");
            return (Criteria) this;
        }

        public Criteria andSprIsNotNull() {
            addCriterion("SPR is not null");
            return (Criteria) this;
        }

        public Criteria andSprEqualTo(String value) {
            addCriterion("SPR =", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprNotEqualTo(String value) {
            addCriterion("SPR <>", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprGreaterThan(String value) {
            addCriterion("SPR >", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprGreaterThanOrEqualTo(String value) {
            addCriterion("SPR >=", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprLessThan(String value) {
            addCriterion("SPR <", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprLessThanOrEqualTo(String value) {
            addCriterion("SPR <=", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprLike(String value) {
            addCriterion("SPR like", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprNotLike(String value) {
            addCriterion("SPR not like", value, "spr");
            return (Criteria) this;
        }

        public Criteria andSprIn(List<String> values) {
            addCriterion("SPR in", values, "spr");
            return (Criteria) this;
        }

        public Criteria andSprNotIn(List<String> values) {
            addCriterion("SPR not in", values, "spr");
            return (Criteria) this;
        }

        public Criteria andSprBetween(String value1, String value2) {
            addCriterion("SPR between", value1, value2, "spr");
            return (Criteria) this;
        }

        public Criteria andSprNotBetween(String value1, String value2) {
            addCriterion("SPR not between", value1, value2, "spr");
            return (Criteria) this;
        }

        public Criteria andSpsjIsNull() {
            addCriterion("SPSJ is null");
            return (Criteria) this;
        }

        public Criteria andSpsjIsNotNull() {
            addCriterion("SPSJ is not null");
            return (Criteria) this;
        }

        public Criteria andSpsjEqualTo(Date value) {
            addCriterion("SPSJ =", value, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjNotEqualTo(Date value) {
            addCriterion("SPSJ <>", value, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjGreaterThan(Date value) {
            addCriterion("SPSJ >", value, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjGreaterThanOrEqualTo(Date value) {
            addCriterion("SPSJ >=", value, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjLessThan(Date value) {
            addCriterion("SPSJ <", value, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjLessThanOrEqualTo(Date value) {
            addCriterion("SPSJ <=", value, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjIn(List<Date> values) {
            addCriterion("SPSJ in", values, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjNotIn(List<Date> values) {
            addCriterion("SPSJ not in", values, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjBetween(Date value1, Date value2) {
            addCriterion("SPSJ between", value1, value2, "spsj");
            return (Criteria) this;
        }

        public Criteria andSpsjNotBetween(Date value1, Date value2) {
            addCriterion("SPSJ not between", value1, value2, "spsj");
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