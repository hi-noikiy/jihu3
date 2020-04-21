package com.yqbing.servicebing.repository.database.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAgentBusinessLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAgentBusinessLogExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserroleIsNull() {
            addCriterion("userRole is null");
            return (Criteria) this;
        }

        public Criteria andUserroleIsNotNull() {
            addCriterion("userRole is not null");
            return (Criteria) this;
        }

        public Criteria andUserroleEqualTo(Byte value) {
            addCriterion("userRole =", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotEqualTo(Byte value) {
            addCriterion("userRole <>", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleGreaterThan(Byte value) {
            addCriterion("userRole >", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleGreaterThanOrEqualTo(Byte value) {
            addCriterion("userRole >=", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLessThan(Byte value) {
            addCriterion("userRole <", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLessThanOrEqualTo(Byte value) {
            addCriterion("userRole <=", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleIn(List<Byte> values) {
            addCriterion("userRole in", values, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotIn(List<Byte> values) {
            addCriterion("userRole not in", values, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleBetween(Byte value1, Byte value2) {
            addCriterion("userRole between", value1, value2, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotBetween(Byte value1, Byte value2) {
            addCriterion("userRole not between", value1, value2, "userrole");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNull() {
            addCriterion("storeId is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(Long value) {
            addCriterion("storeId =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(Long value) {
            addCriterion("storeId <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(Long value) {
            addCriterion("storeId >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(Long value) {
            addCriterion("storeId >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(Long value) {
            addCriterion("storeId <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(Long value) {
            addCriterion("storeId <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<Long> values) {
            addCriterion("storeId in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<Long> values) {
            addCriterion("storeId not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(Long value1, Long value2) {
            addCriterion("storeId between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(Long value1, Long value2) {
            addCriterion("storeId not between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNull() {
            addCriterion("storeName is null");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNotNull() {
            addCriterion("storeName is not null");
            return (Criteria) this;
        }

        public Criteria andStorenameEqualTo(String value) {
            addCriterion("storeName =", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotEqualTo(String value) {
            addCriterion("storeName <>", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThan(String value) {
            addCriterion("storeName >", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThanOrEqualTo(String value) {
            addCriterion("storeName >=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThan(String value) {
            addCriterion("storeName <", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThanOrEqualTo(String value) {
            addCriterion("storeName <=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLike(String value) {
            addCriterion("storeName like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotLike(String value) {
            addCriterion("storeName not like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameIn(List<String> values) {
            addCriterion("storeName in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotIn(List<String> values) {
            addCriterion("storeName not in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameBetween(String value1, String value2) {
            addCriterion("storeName between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotBetween(String value1, String value2) {
            addCriterion("storeName not between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNull() {
            addCriterion("agentId is null");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNotNull() {
            addCriterion("agentId is not null");
            return (Criteria) this;
        }

        public Criteria andAgentidEqualTo(Long value) {
            addCriterion("agentId =", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotEqualTo(Long value) {
            addCriterion("agentId <>", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThan(Long value) {
            addCriterion("agentId >", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThanOrEqualTo(Long value) {
            addCriterion("agentId >=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThan(Long value) {
            addCriterion("agentId <", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThanOrEqualTo(Long value) {
            addCriterion("agentId <=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidIn(List<Long> values) {
            addCriterion("agentId in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotIn(List<Long> values) {
            addCriterion("agentId not in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidBetween(Long value1, Long value2) {
            addCriterion("agentId between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotBetween(Long value1, Long value2) {
            addCriterion("agentId not between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgenttypeIsNull() {
            addCriterion("agentType is null");
            return (Criteria) this;
        }

        public Criteria andAgenttypeIsNotNull() {
            addCriterion("agentType is not null");
            return (Criteria) this;
        }

        public Criteria andAgenttypeEqualTo(Short value) {
            addCriterion("agentType =", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotEqualTo(Short value) {
            addCriterion("agentType <>", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeGreaterThan(Short value) {
            addCriterion("agentType >", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeGreaterThanOrEqualTo(Short value) {
            addCriterion("agentType >=", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeLessThan(Short value) {
            addCriterion("agentType <", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeLessThanOrEqualTo(Short value) {
            addCriterion("agentType <=", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeIn(List<Short> values) {
            addCriterion("agentType in", values, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotIn(List<Short> values) {
            addCriterion("agentType not in", values, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeBetween(Short value1, Short value2) {
            addCriterion("agentType between", value1, value2, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotBetween(Short value1, Short value2) {
            addCriterion("agentType not between", value1, value2, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgentpidIsNull() {
            addCriterion("agentPId is null");
            return (Criteria) this;
        }

        public Criteria andAgentpidIsNotNull() {
            addCriterion("agentPId is not null");
            return (Criteria) this;
        }

        public Criteria andAgentpidEqualTo(Long value) {
            addCriterion("agentPId =", value, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidNotEqualTo(Long value) {
            addCriterion("agentPId <>", value, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidGreaterThan(Long value) {
            addCriterion("agentPId >", value, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidGreaterThanOrEqualTo(Long value) {
            addCriterion("agentPId >=", value, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidLessThan(Long value) {
            addCriterion("agentPId <", value, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidLessThanOrEqualTo(Long value) {
            addCriterion("agentPId <=", value, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidIn(List<Long> values) {
            addCriterion("agentPId in", values, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidNotIn(List<Long> values) {
            addCriterion("agentPId not in", values, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidBetween(Long value1, Long value2) {
            addCriterion("agentPId between", value1, value2, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentpidNotBetween(Long value1, Long value2) {
            addCriterion("agentPId not between", value1, value2, "agentpid");
            return (Criteria) this;
        }

        public Criteria andAgentnameIsNull() {
            addCriterion("agentName is null");
            return (Criteria) this;
        }

        public Criteria andAgentnameIsNotNull() {
            addCriterion("agentName is not null");
            return (Criteria) this;
        }

        public Criteria andAgentnameEqualTo(String value) {
            addCriterion("agentName =", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotEqualTo(String value) {
            addCriterion("agentName <>", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameGreaterThan(String value) {
            addCriterion("agentName >", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameGreaterThanOrEqualTo(String value) {
            addCriterion("agentName >=", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameLessThan(String value) {
            addCriterion("agentName <", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameLessThanOrEqualTo(String value) {
            addCriterion("agentName <=", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameLike(String value) {
            addCriterion("agentName like", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotLike(String value) {
            addCriterion("agentName not like", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameIn(List<String> values) {
            addCriterion("agentName in", values, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotIn(List<String> values) {
            addCriterion("agentName not in", values, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameBetween(String value1, String value2) {
            addCriterion("agentName between", value1, value2, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotBetween(String value1, String value2) {
            addCriterion("agentName not between", value1, value2, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentmobileIsNull() {
            addCriterion("agentMobile is null");
            return (Criteria) this;
        }

        public Criteria andAgentmobileIsNotNull() {
            addCriterion("agentMobile is not null");
            return (Criteria) this;
        }

        public Criteria andAgentmobileEqualTo(String value) {
            addCriterion("agentMobile =", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileNotEqualTo(String value) {
            addCriterion("agentMobile <>", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileGreaterThan(String value) {
            addCriterion("agentMobile >", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileGreaterThanOrEqualTo(String value) {
            addCriterion("agentMobile >=", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileLessThan(String value) {
            addCriterion("agentMobile <", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileLessThanOrEqualTo(String value) {
            addCriterion("agentMobile <=", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileLike(String value) {
            addCriterion("agentMobile like", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileNotLike(String value) {
            addCriterion("agentMobile not like", value, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileIn(List<String> values) {
            addCriterion("agentMobile in", values, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileNotIn(List<String> values) {
            addCriterion("agentMobile not in", values, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileBetween(String value1, String value2) {
            addCriterion("agentMobile between", value1, value2, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andAgentmobileNotBetween(String value1, String value2) {
            addCriterion("agentMobile not between", value1, value2, "agentmobile");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeIsNull() {
            addCriterion("businessType is null");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeIsNotNull() {
            addCriterion("businessType is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeEqualTo(Short value) {
            addCriterion("businessType =", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotEqualTo(Short value) {
            addCriterion("businessType <>", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeGreaterThan(Short value) {
            addCriterion("businessType >", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeGreaterThanOrEqualTo(Short value) {
            addCriterion("businessType >=", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeLessThan(Short value) {
            addCriterion("businessType <", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeLessThanOrEqualTo(Short value) {
            addCriterion("businessType <=", value, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeIn(List<Short> values) {
            addCriterion("businessType in", values, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotIn(List<Short> values) {
            addCriterion("businessType not in", values, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeBetween(Short value1, Short value2) {
            addCriterion("businessType between", value1, value2, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypeNotBetween(Short value1, Short value2) {
            addCriterion("businessType not between", value1, value2, "businesstype");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameIsNull() {
            addCriterion("businessTypeName is null");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameIsNotNull() {
            addCriterion("businessTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameEqualTo(String value) {
            addCriterion("businessTypeName =", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameNotEqualTo(String value) {
            addCriterion("businessTypeName <>", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameGreaterThan(String value) {
            addCriterion("businessTypeName >", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameGreaterThanOrEqualTo(String value) {
            addCriterion("businessTypeName >=", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameLessThan(String value) {
            addCriterion("businessTypeName <", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameLessThanOrEqualTo(String value) {
            addCriterion("businessTypeName <=", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameLike(String value) {
            addCriterion("businessTypeName like", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameNotLike(String value) {
            addCriterion("businessTypeName not like", value, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameIn(List<String> values) {
            addCriterion("businessTypeName in", values, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameNotIn(List<String> values) {
            addCriterion("businessTypeName not in", values, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameBetween(String value1, String value2) {
            addCriterion("businessTypeName between", value1, value2, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesstypenameNotBetween(String value1, String value2) {
            addCriterion("businessTypeName not between", value1, value2, "businesstypename");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceIsNull() {
            addCriterion("businessPrice is null");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceIsNotNull() {
            addCriterion("businessPrice is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceEqualTo(Integer value) {
            addCriterion("businessPrice =", value, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceNotEqualTo(Integer value) {
            addCriterion("businessPrice <>", value, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceGreaterThan(Integer value) {
            addCriterion("businessPrice >", value, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("businessPrice >=", value, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceLessThan(Integer value) {
            addCriterion("businessPrice <", value, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceLessThanOrEqualTo(Integer value) {
            addCriterion("businessPrice <=", value, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceIn(List<Integer> values) {
            addCriterion("businessPrice in", values, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceNotIn(List<Integer> values) {
            addCriterion("businessPrice not in", values, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceBetween(Integer value1, Integer value2) {
            addCriterion("businessPrice between", value1, value2, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinesspriceNotBetween(Integer value1, Integer value2) {
            addCriterion("businessPrice not between", value1, value2, "businessprice");
            return (Criteria) this;
        }

        public Criteria andBusinessnumIsNull() {
            addCriterion("businessNum is null");
            return (Criteria) this;
        }

        public Criteria andBusinessnumIsNotNull() {
            addCriterion("businessNum is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessnumEqualTo(Integer value) {
            addCriterion("businessNum =", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotEqualTo(Integer value) {
            addCriterion("businessNum <>", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumGreaterThan(Integer value) {
            addCriterion("businessNum >", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("businessNum >=", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumLessThan(Integer value) {
            addCriterion("businessNum <", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumLessThanOrEqualTo(Integer value) {
            addCriterion("businessNum <=", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumIn(List<Integer> values) {
            addCriterion("businessNum in", values, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotIn(List<Integer> values) {
            addCriterion("businessNum not in", values, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumBetween(Integer value1, Integer value2) {
            addCriterion("businessNum between", value1, value2, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotBetween(Integer value1, Integer value2) {
            addCriterion("businessNum not between", value1, value2, "businessnum");
            return (Criteria) this;
        }

        public Criteria andProvinceidIsNull() {
            addCriterion("provinceId is null");
            return (Criteria) this;
        }

        public Criteria andProvinceidIsNotNull() {
            addCriterion("provinceId is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceidEqualTo(Long value) {
            addCriterion("provinceId =", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotEqualTo(Long value) {
            addCriterion("provinceId <>", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidGreaterThan(Long value) {
            addCriterion("provinceId >", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidGreaterThanOrEqualTo(Long value) {
            addCriterion("provinceId >=", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLessThan(Long value) {
            addCriterion("provinceId <", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLessThanOrEqualTo(Long value) {
            addCriterion("provinceId <=", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidIn(List<Long> values) {
            addCriterion("provinceId in", values, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotIn(List<Long> values) {
            addCriterion("provinceId not in", values, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidBetween(Long value1, Long value2) {
            addCriterion("provinceId between", value1, value2, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotBetween(Long value1, Long value2) {
            addCriterion("provinceId not between", value1, value2, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvincenameIsNull() {
            addCriterion("provinceName is null");
            return (Criteria) this;
        }

        public Criteria andProvincenameIsNotNull() {
            addCriterion("provinceName is not null");
            return (Criteria) this;
        }

        public Criteria andProvincenameEqualTo(String value) {
            addCriterion("provinceName =", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotEqualTo(String value) {
            addCriterion("provinceName <>", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameGreaterThan(String value) {
            addCriterion("provinceName >", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameGreaterThanOrEqualTo(String value) {
            addCriterion("provinceName >=", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameLessThan(String value) {
            addCriterion("provinceName <", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameLessThanOrEqualTo(String value) {
            addCriterion("provinceName <=", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameLike(String value) {
            addCriterion("provinceName like", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotLike(String value) {
            addCriterion("provinceName not like", value, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameIn(List<String> values) {
            addCriterion("provinceName in", values, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotIn(List<String> values) {
            addCriterion("provinceName not in", values, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameBetween(String value1, String value2) {
            addCriterion("provinceName between", value1, value2, "provincename");
            return (Criteria) this;
        }

        public Criteria andProvincenameNotBetween(String value1, String value2) {
            addCriterion("provinceName not between", value1, value2, "provincename");
            return (Criteria) this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("cityId is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityId is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Long value) {
            addCriterion("cityId =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Long value) {
            addCriterion("cityId <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Long value) {
            addCriterion("cityId >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Long value) {
            addCriterion("cityId >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Long value) {
            addCriterion("cityId <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Long value) {
            addCriterion("cityId <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Long> values) {
            addCriterion("cityId in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Long> values) {
            addCriterion("cityId not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Long value1, Long value2) {
            addCriterion("cityId between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Long value1, Long value2) {
            addCriterion("cityId not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityName is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityName is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityName =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityName <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityName >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityName >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityName <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityName <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityName like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityName not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityName in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityName not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityName between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityName not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCountyidIsNull() {
            addCriterion("countyId is null");
            return (Criteria) this;
        }

        public Criteria andCountyidIsNotNull() {
            addCriterion("countyId is not null");
            return (Criteria) this;
        }

        public Criteria andCountyidEqualTo(Long value) {
            addCriterion("countyId =", value, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidNotEqualTo(Long value) {
            addCriterion("countyId <>", value, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidGreaterThan(Long value) {
            addCriterion("countyId >", value, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidGreaterThanOrEqualTo(Long value) {
            addCriterion("countyId >=", value, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidLessThan(Long value) {
            addCriterion("countyId <", value, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidLessThanOrEqualTo(Long value) {
            addCriterion("countyId <=", value, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidIn(List<Long> values) {
            addCriterion("countyId in", values, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidNotIn(List<Long> values) {
            addCriterion("countyId not in", values, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidBetween(Long value1, Long value2) {
            addCriterion("countyId between", value1, value2, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountyidNotBetween(Long value1, Long value2) {
            addCriterion("countyId not between", value1, value2, "countyid");
            return (Criteria) this;
        }

        public Criteria andCountynameIsNull() {
            addCriterion("countyName is null");
            return (Criteria) this;
        }

        public Criteria andCountynameIsNotNull() {
            addCriterion("countyName is not null");
            return (Criteria) this;
        }

        public Criteria andCountynameEqualTo(String value) {
            addCriterion("countyName =", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameNotEqualTo(String value) {
            addCriterion("countyName <>", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameGreaterThan(String value) {
            addCriterion("countyName >", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameGreaterThanOrEqualTo(String value) {
            addCriterion("countyName >=", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameLessThan(String value) {
            addCriterion("countyName <", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameLessThanOrEqualTo(String value) {
            addCriterion("countyName <=", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameLike(String value) {
            addCriterion("countyName like", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameNotLike(String value) {
            addCriterion("countyName not like", value, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameIn(List<String> values) {
            addCriterion("countyName in", values, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameNotIn(List<String> values) {
            addCriterion("countyName not in", values, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameBetween(String value1, String value2) {
            addCriterion("countyName between", value1, value2, "countyname");
            return (Criteria) this;
        }

        public Criteria andCountynameNotBetween(String value1, String value2) {
            addCriterion("countyName not between", value1, value2, "countyname");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andIsbalanceIsNull() {
            addCriterion("isbalance is null");
            return (Criteria) this;
        }

        public Criteria andIsbalanceIsNotNull() {
            addCriterion("isbalance is not null");
            return (Criteria) this;
        }

        public Criteria andIsbalanceEqualTo(Byte value) {
            addCriterion("isbalance =", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceNotEqualTo(Byte value) {
            addCriterion("isbalance <>", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceGreaterThan(Byte value) {
            addCriterion("isbalance >", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceGreaterThanOrEqualTo(Byte value) {
            addCriterion("isbalance >=", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceLessThan(Byte value) {
            addCriterion("isbalance <", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceLessThanOrEqualTo(Byte value) {
            addCriterion("isbalance <=", value, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceIn(List<Byte> values) {
            addCriterion("isbalance in", values, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceNotIn(List<Byte> values) {
            addCriterion("isbalance not in", values, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceBetween(Byte value1, Byte value2) {
            addCriterion("isbalance between", value1, value2, "isbalance");
            return (Criteria) this;
        }

        public Criteria andIsbalanceNotBetween(Byte value1, Byte value2) {
            addCriterion("isbalance not between", value1, value2, "isbalance");
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