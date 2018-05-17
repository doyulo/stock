package cn.stock.dao;

import cn.stock.model.DealDetail;
import cn.stock.model.DealDetailExample.Criteria;
import cn.stock.model.DealDetailExample.Criterion;
import cn.stock.model.DealDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DealDetailSqlProvider {

    public String countByExample(DealDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("deal_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DealDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("deal_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DealDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("deal_detail");
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getDealTime() != null) {
            sql.VALUES("deal_time", "#{dealTime,jdbcType=TIME}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPriceDiff() != null) {
            sql.VALUES("price_diff", "#{priceDiff,jdbcType=DECIMAL}");
        }
        
        if (record.getQty() != null) {
            sql.VALUES("qty", "#{qty,jdbcType=INTEGER}");
        }
        
        if (record.getAmt() != null) {
            sql.VALUES("amt", "#{amt,jdbcType=DECIMAL}");
        }
        
        if (record.getSign() != null) {
            sql.VALUES("sign", "#{sign,jdbcType=SMALLINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(DealDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_deal_detail");
        } else {
            sql.SELECT("id_deal_detail");
        }
        sql.SELECT("parent_id");
        sql.SELECT("deal_time");
        sql.SELECT("price");
        sql.SELECT("price_diff");
        sql.SELECT("qty");
        sql.SELECT("amt");
        sql.SELECT("sign");
        sql.FROM("deal_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DealDetail record = (DealDetail) parameter.get("record");
        DealDetailExample example = (DealDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("deal_detail");
        
        if (record.getIdDealDetail() != null) {
            sql.SET("id_deal_detail = #{record.idDealDetail,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getDealTime() != null) {
            sql.SET("deal_time = #{record.dealTime,jdbcType=TIME}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getPriceDiff() != null) {
            sql.SET("price_diff = #{record.priceDiff,jdbcType=DECIMAL}");
        }
        
        if (record.getQty() != null) {
            sql.SET("qty = #{record.qty,jdbcType=INTEGER}");
        }
        
        if (record.getAmt() != null) {
            sql.SET("amt = #{record.amt,jdbcType=DECIMAL}");
        }
        
        if (record.getSign() != null) {
            sql.SET("sign = #{record.sign,jdbcType=SMALLINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("deal_detail");
        
        sql.SET("id_deal_detail = #{record.idDealDetail,jdbcType=INTEGER}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("deal_time = #{record.dealTime,jdbcType=TIME}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("price_diff = #{record.priceDiff,jdbcType=DECIMAL}");
        sql.SET("qty = #{record.qty,jdbcType=INTEGER}");
        sql.SET("amt = #{record.amt,jdbcType=DECIMAL}");
        sql.SET("sign = #{record.sign,jdbcType=SMALLINT}");
        
        DealDetailExample example = (DealDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DealDetailExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}