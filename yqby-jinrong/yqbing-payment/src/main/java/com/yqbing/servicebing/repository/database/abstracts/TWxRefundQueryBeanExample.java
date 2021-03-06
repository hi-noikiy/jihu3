package com.yqbing.servicebing.repository.database.abstracts;

import java.util.ArrayList;
import java.util.List;

public class TWxRefundQueryBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TWxRefundQueryBeanExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andNonceStrIsNull() {
            addCriterion("nonce_str is null");
            return (Criteria) this;
        }

        public Criteria andNonceStrIsNotNull() {
            addCriterion("nonce_str is not null");
            return (Criteria) this;
        }

        public Criteria andNonceStrEqualTo(String value) {
            addCriterion("nonce_str =", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotEqualTo(String value) {
            addCriterion("nonce_str <>", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrGreaterThan(String value) {
            addCriterion("nonce_str >", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrGreaterThanOrEqualTo(String value) {
            addCriterion("nonce_str >=", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLessThan(String value) {
            addCriterion("nonce_str <", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLessThanOrEqualTo(String value) {
            addCriterion("nonce_str <=", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLike(String value) {
            addCriterion("nonce_str like", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotLike(String value) {
            addCriterion("nonce_str not like", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrIn(List<String> values) {
            addCriterion("nonce_str in", values, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotIn(List<String> values) {
            addCriterion("nonce_str not in", values, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrBetween(String value1, String value2) {
            addCriterion("nonce_str between", value1, value2, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotBetween(String value1, String value2) {
            addCriterion("nonce_str not between", value1, value2, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoIsNull() {
            addCriterion("out_refund_no is null");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoIsNotNull() {
            addCriterion("out_refund_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoEqualTo(String value) {
            addCriterion("out_refund_no =", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNotEqualTo(String value) {
            addCriterion("out_refund_no <>", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoGreaterThan(String value) {
            addCriterion("out_refund_no >", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_refund_no >=", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoLessThan(String value) {
            addCriterion("out_refund_no <", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoLessThanOrEqualTo(String value) {
            addCriterion("out_refund_no <=", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoLike(String value) {
            addCriterion("out_refund_no like", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNotLike(String value) {
            addCriterion("out_refund_no not like", value, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoIn(List<String> values) {
            addCriterion("out_refund_no in", values, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNotIn(List<String> values) {
            addCriterion("out_refund_no not in", values, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoBetween(String value1, String value2) {
            addCriterion("out_refund_no between", value1, value2, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNotBetween(String value1, String value2) {
            addCriterion("out_refund_no not between", value1, value2, "outRefundNo");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(String value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(String value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(String value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(String value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(String value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLike(String value) {
            addCriterion("refund_id like", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotLike(String value) {
            addCriterion("refund_id not like", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<String> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<String> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(String value1, String value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(String value1, String value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNull() {
            addCriterion("return_code is null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNotNull() {
            addCriterion("return_code is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeEqualTo(String value) {
            addCriterion("return_code =", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotEqualTo(String value) {
            addCriterion("return_code <>", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThan(String value) {
            addCriterion("return_code >", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("return_code >=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThan(String value) {
            addCriterion("return_code <", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("return_code <=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLike(String value) {
            addCriterion("return_code like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotLike(String value) {
            addCriterion("return_code not like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIn(List<String> values) {
            addCriterion("return_code in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotIn(List<String> values) {
            addCriterion("return_code not in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeBetween(String value1, String value2) {
            addCriterion("return_code between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotBetween(String value1, String value2) {
            addCriterion("return_code not between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIsNull() {
            addCriterion("return_msg is null");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIsNotNull() {
            addCriterion("return_msg is not null");
            return (Criteria) this;
        }

        public Criteria andReturnMsgEqualTo(String value) {
            addCriterion("return_msg =", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotEqualTo(String value) {
            addCriterion("return_msg <>", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgGreaterThan(String value) {
            addCriterion("return_msg >", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgGreaterThanOrEqualTo(String value) {
            addCriterion("return_msg >=", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLessThan(String value) {
            addCriterion("return_msg <", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLessThanOrEqualTo(String value) {
            addCriterion("return_msg <=", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLike(String value) {
            addCriterion("return_msg like", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotLike(String value) {
            addCriterion("return_msg not like", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIn(List<String> values) {
            addCriterion("return_msg in", values, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotIn(List<String> values) {
            addCriterion("return_msg not in", values, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgBetween(String value1, String value2) {
            addCriterion("return_msg between", value1, value2, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotBetween(String value1, String value2) {
            addCriterion("return_msg not between", value1, value2, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNull() {
            addCriterion("result_code is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("result_code is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("result_code =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("result_code <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("result_code >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("result_code >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("result_code <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("result_code <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("result_code like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("result_code not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("result_code in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("result_code not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("result_code between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("result_code not between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("err_code is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("err_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(String value) {
            addCriterion("err_code =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(String value) {
            addCriterion("err_code <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(String value) {
            addCriterion("err_code >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("err_code >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(String value) {
            addCriterion("err_code <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(String value) {
            addCriterion("err_code <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLike(String value) {
            addCriterion("err_code like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotLike(String value) {
            addCriterion("err_code not like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<String> values) {
            addCriterion("err_code in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<String> values) {
            addCriterion("err_code not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(String value1, String value2) {
            addCriterion("err_code between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(String value1, String value2) {
            addCriterion("err_code not between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesIsNull() {
            addCriterion("err_code_des is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesIsNotNull() {
            addCriterion("err_code_des is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesEqualTo(String value) {
            addCriterion("err_code_des =", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotEqualTo(String value) {
            addCriterion("err_code_des <>", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesGreaterThan(String value) {
            addCriterion("err_code_des >", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesGreaterThanOrEqualTo(String value) {
            addCriterion("err_code_des >=", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesLessThan(String value) {
            addCriterion("err_code_des <", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesLessThanOrEqualTo(String value) {
            addCriterion("err_code_des <=", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesLike(String value) {
            addCriterion("err_code_des like", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotLike(String value) {
            addCriterion("err_code_des not like", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesIn(List<String> values) {
            addCriterion("err_code_des in", values, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotIn(List<String> values) {
            addCriterion("err_code_des not in", values, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesBetween(String value1, String value2) {
            addCriterion("err_code_des between", value1, value2, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotBetween(String value1, String value2) {
            addCriterion("err_code_des not between", value1, value2, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountIsNull() {
            addCriterion("total_refund_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountIsNotNull() {
            addCriterion("total_refund_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountEqualTo(Integer value) {
            addCriterion("total_refund_count =", value, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountNotEqualTo(Integer value) {
            addCriterion("total_refund_count <>", value, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountGreaterThan(Integer value) {
            addCriterion("total_refund_count >", value, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_refund_count >=", value, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountLessThan(Integer value) {
            addCriterion("total_refund_count <", value, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_refund_count <=", value, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountIn(List<Integer> values) {
            addCriterion("total_refund_count in", values, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountNotIn(List<Integer> values) {
            addCriterion("total_refund_count not in", values, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountBetween(Integer value1, Integer value2) {
            addCriterion("total_refund_count between", value1, value2, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andTotalRefundCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_refund_count not between", value1, value2, "totalRefundCount");
            return (Criteria) this;
        }

        public Criteria andCashFeeIsNull() {
            addCriterion("cash_fee is null");
            return (Criteria) this;
        }

        public Criteria andCashFeeIsNotNull() {
            addCriterion("cash_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCashFeeEqualTo(Integer value) {
            addCriterion("cash_fee =", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeNotEqualTo(Integer value) {
            addCriterion("cash_fee <>", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeGreaterThan(Integer value) {
            addCriterion("cash_fee >", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cash_fee >=", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeLessThan(Integer value) {
            addCriterion("cash_fee <", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeLessThanOrEqualTo(Integer value) {
            addCriterion("cash_fee <=", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeIn(List<Integer> values) {
            addCriterion("cash_fee in", values, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeNotIn(List<Integer> values) {
            addCriterion("cash_fee not in", values, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeBetween(Integer value1, Integer value2) {
            addCriterion("cash_fee between", value1, value2, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("cash_fee not between", value1, value2, "cashFee");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNull() {
            addCriterion("refund_count is null");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNotNull() {
            addCriterion("refund_count is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCountEqualTo(Integer value) {
            addCriterion("refund_count =", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotEqualTo(Integer value) {
            addCriterion("refund_count <>", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThan(Integer value) {
            addCriterion("refund_count >", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_count >=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThan(Integer value) {
            addCriterion("refund_count <", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThanOrEqualTo(Integer value) {
            addCriterion("refund_count <=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountIn(List<Integer> values) {
            addCriterion("refund_count in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotIn(List<Integer> values) {
            addCriterion("refund_count not in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountBetween(Integer value1, Integer value2) {
            addCriterion("refund_count between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_count not between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNIsNull() {
            addCriterion("out_refund_no_$n is null");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNIsNotNull() {
            addCriterion("out_refund_no_$n is not null");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNEqualTo(String value) {
            addCriterion("out_refund_no_$n =", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNNotEqualTo(String value) {
            addCriterion("out_refund_no_$n <>", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNGreaterThan(String value) {
            addCriterion("out_refund_no_$n >", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNGreaterThanOrEqualTo(String value) {
            addCriterion("out_refund_no_$n >=", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNLessThan(String value) {
            addCriterion("out_refund_no_$n <", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNLessThanOrEqualTo(String value) {
            addCriterion("out_refund_no_$n <=", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNLike(String value) {
            addCriterion("out_refund_no_$n like", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNNotLike(String value) {
            addCriterion("out_refund_no_$n not like", value, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNIn(List<String> values) {
            addCriterion("out_refund_no_$n in", values, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNNotIn(List<String> values) {
            addCriterion("out_refund_no_$n not in", values, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNBetween(String value1, String value2) {
            addCriterion("out_refund_no_$n between", value1, value2, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andOutRefundNoNNotBetween(String value1, String value2) {
            addCriterion("out_refund_no_$n not between", value1, value2, "outRefundNoN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNIsNull() {
            addCriterion("refund_id_$n is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdNIsNotNull() {
            addCriterion("refund_id_$n is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdNEqualTo(String value) {
            addCriterion("refund_id_$n =", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNNotEqualTo(String value) {
            addCriterion("refund_id_$n <>", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNGreaterThan(String value) {
            addCriterion("refund_id_$n >", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNGreaterThanOrEqualTo(String value) {
            addCriterion("refund_id_$n >=", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNLessThan(String value) {
            addCriterion("refund_id_$n <", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNLessThanOrEqualTo(String value) {
            addCriterion("refund_id_$n <=", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNLike(String value) {
            addCriterion("refund_id_$n like", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNNotLike(String value) {
            addCriterion("refund_id_$n not like", value, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNIn(List<String> values) {
            addCriterion("refund_id_$n in", values, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNNotIn(List<String> values) {
            addCriterion("refund_id_$n not in", values, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNBetween(String value1, String value2) {
            addCriterion("refund_id_$n between", value1, value2, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundIdNNotBetween(String value1, String value2) {
            addCriterion("refund_id_$n not between", value1, value2, "refundIdN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNIsNull() {
            addCriterion("refund_fee_$n is null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNIsNotNull() {
            addCriterion("refund_fee_$n is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNEqualTo(String value) {
            addCriterion("refund_fee_$n =", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNNotEqualTo(String value) {
            addCriterion("refund_fee_$n <>", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNGreaterThan(String value) {
            addCriterion("refund_fee_$n >", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNGreaterThanOrEqualTo(String value) {
            addCriterion("refund_fee_$n >=", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNLessThan(String value) {
            addCriterion("refund_fee_$n <", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNLessThanOrEqualTo(String value) {
            addCriterion("refund_fee_$n <=", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNLike(String value) {
            addCriterion("refund_fee_$n like", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNNotLike(String value) {
            addCriterion("refund_fee_$n not like", value, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNIn(List<String> values) {
            addCriterion("refund_fee_$n in", values, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNNotIn(List<String> values) {
            addCriterion("refund_fee_$n not in", values, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNBetween(String value1, String value2) {
            addCriterion("refund_fee_$n between", value1, value2, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNNotBetween(String value1, String value2) {
            addCriterion("refund_fee_$n not between", value1, value2, "refundFeeN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNIsNull() {
            addCriterion("refund_status_$n is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNIsNotNull() {
            addCriterion("refund_status_$n is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNEqualTo(String value) {
            addCriterion("refund_status_$n =", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNNotEqualTo(String value) {
            addCriterion("refund_status_$n <>", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNGreaterThan(String value) {
            addCriterion("refund_status_$n >", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNGreaterThanOrEqualTo(String value) {
            addCriterion("refund_status_$n >=", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNLessThan(String value) {
            addCriterion("refund_status_$n <", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNLessThanOrEqualTo(String value) {
            addCriterion("refund_status_$n <=", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNLike(String value) {
            addCriterion("refund_status_$n like", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNNotLike(String value) {
            addCriterion("refund_status_$n not like", value, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNIn(List<String> values) {
            addCriterion("refund_status_$n in", values, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNNotIn(List<String> values) {
            addCriterion("refund_status_$n not in", values, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNBetween(String value1, String value2) {
            addCriterion("refund_status_$n between", value1, value2, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNNotBetween(String value1, String value2) {
            addCriterion("refund_status_$n not between", value1, value2, "refundStatusN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNIsNull() {
            addCriterion("refund_recv_accout_$n is null");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNIsNotNull() {
            addCriterion("refund_recv_accout_$n is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNEqualTo(String value) {
            addCriterion("refund_recv_accout_$n =", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNNotEqualTo(String value) {
            addCriterion("refund_recv_accout_$n <>", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNGreaterThan(String value) {
            addCriterion("refund_recv_accout_$n >", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNGreaterThanOrEqualTo(String value) {
            addCriterion("refund_recv_accout_$n >=", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNLessThan(String value) {
            addCriterion("refund_recv_accout_$n <", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNLessThanOrEqualTo(String value) {
            addCriterion("refund_recv_accout_$n <=", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNLike(String value) {
            addCriterion("refund_recv_accout_$n like", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNNotLike(String value) {
            addCriterion("refund_recv_accout_$n not like", value, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNIn(List<String> values) {
            addCriterion("refund_recv_accout_$n in", values, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNNotIn(List<String> values) {
            addCriterion("refund_recv_accout_$n not in", values, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNBetween(String value1, String value2) {
            addCriterion("refund_recv_accout_$n between", value1, value2, "refundRecvAccoutN");
            return (Criteria) this;
        }

        public Criteria andRefundRecvAccoutNNotBetween(String value1, String value2) {
            addCriterion("refund_recv_accout_$n not between", value1, value2, "refundRecvAccoutN");
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