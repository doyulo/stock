package cn.stock.dao;

import cn.stock.model.RaskAlyz;
import cn.stock.model.RaskAlyzExample.Criteria;
import cn.stock.model.RaskAlyzExample.Criterion;
import cn.stock.model.RaskAlyzExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RaskAlyzSqlProvider {

    public String countByExample(RaskAlyzExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("rask_alyz");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RaskAlyzExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("rask_alyz");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RaskAlyz record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rask_alyz");
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCurPri() != null) {
            sql.VALUES("cur_pri", "#{curPri,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri() != null) {
            sql.VALUES("avr_pri", "#{avrPri,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri1() != null) {
            sql.VALUES("avr_pri_1", "#{avrPri1,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri2() != null) {
            sql.VALUES("avr_pri_2", "#{avrPri2,jdbcType=DECIMAL}");
        }
        
        if (record.getRate() != null) {
            sql.VALUES("rate", "#{rate,jdbcType=DECIMAL}");
        }
        
        if (record.getSlope() != null) {
            sql.VALUES("slope", "#{slope,jdbcType=INTEGER}");
        }
        
        if (record.getSlope1() != null) {
            sql.VALUES("slope1", "#{slope1,jdbcType=INTEGER}");
        }
        
        if (record.getSlope2() != null) {
            sql.VALUES("slope2", "#{slope2,jdbcType=INTEGER}");
        }
        
        if (record.getDealDate() != null) {
            sql.VALUES("deal_date", "#{dealDate,jdbcType=DATE}");
        }
        
        if (record.getHold() != null) {
            sql.VALUES("hold", "#{hold,jdbcType=BIT}");
        }
        
        if (record.getReversalRate() != null) {
            sql.VALUES("reversal_rate", "#{reversalRate,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RaskAlyzExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("code");
        sql.SELECT("name");
        sql.SELECT("cur_pri");
        sql.SELECT("avr_pri");
        sql.SELECT("avr_pri_1");
        sql.SELECT("avr_pri_2");
        sql.SELECT("rate");
        sql.SELECT("slope");
        sql.SELECT("slope1");
        sql.SELECT("slope2");
        sql.SELECT("deal_date");
        sql.SELECT("hold");
        sql.SELECT("reversal_rate");
        sql.SELECT("remark");
        sql.FROM("rask_alyz");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RaskAlyz record = (RaskAlyz) parameter.get("record");
        RaskAlyzExample example = (RaskAlyzExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("rask_alyz");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCurPri() != null) {
            sql.SET("cur_pri = #{record.curPri,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri() != null) {
            sql.SET("avr_pri = #{record.avrPri,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri1() != null) {
            sql.SET("avr_pri_1 = #{record.avrPri1,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri2() != null) {
            sql.SET("avr_pri_2 = #{record.avrPri2,jdbcType=DECIMAL}");
        }
        
        if (record.getRate() != null) {
            sql.SET("rate = #{record.rate,jdbcType=DECIMAL}");
        }
        
        if (record.getSlope() != null) {
            sql.SET("slope = #{record.slope,jdbcType=INTEGER}");
        }
        
        if (record.getSlope1() != null) {
            sql.SET("slope1 = #{record.slope1,jdbcType=INTEGER}");
        }
        
        if (record.getSlope2() != null) {
            sql.SET("slope2 = #{record.slope2,jdbcType=INTEGER}");
        }
        
        if (record.getDealDate() != null) {
            sql.SET("deal_date = #{record.dealDate,jdbcType=DATE}");
        }
        
        if (record.getHold() != null) {
            sql.SET("hold = #{record.hold,jdbcType=BIT}");
        }
        
        if (record.getReversalRate() != null) {
            sql.SET("reversal_rate = #{record.reversalRate,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("rask_alyz");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("cur_pri = #{record.curPri,jdbcType=DECIMAL}");
        sql.SET("avr_pri = #{record.avrPri,jdbcType=DECIMAL}");
        sql.SET("avr_pri_1 = #{record.avrPri1,jdbcType=DECIMAL}");
        sql.SET("avr_pri_2 = #{record.avrPri2,jdbcType=DECIMAL}");
        sql.SET("rate = #{record.rate,jdbcType=DECIMAL}");
        sql.SET("slope = #{record.slope,jdbcType=INTEGER}");
        sql.SET("slope1 = #{record.slope1,jdbcType=INTEGER}");
        sql.SET("slope2 = #{record.slope2,jdbcType=INTEGER}");
        sql.SET("deal_date = #{record.dealDate,jdbcType=DATE}");
        sql.SET("hold = #{record.hold,jdbcType=BIT}");
        sql.SET("reversal_rate = #{record.reversalRate,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        
        RaskAlyzExample example = (RaskAlyzExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RaskAlyz record) {
        SQL sql = new SQL();
        sql.UPDATE("rask_alyz");
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCurPri() != null) {
            sql.SET("cur_pri = #{curPri,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri() != null) {
            sql.SET("avr_pri = #{avrPri,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri1() != null) {
            sql.SET("avr_pri_1 = #{avrPri1,jdbcType=DECIMAL}");
        }
        
        if (record.getAvrPri2() != null) {
            sql.SET("avr_pri_2 = #{avrPri2,jdbcType=DECIMAL}");
        }
        
        if (record.getRate() != null) {
            sql.SET("rate = #{rate,jdbcType=DECIMAL}");
        }
        
        if (record.getSlope() != null) {
            sql.SET("slope = #{slope,jdbcType=INTEGER}");
        }
        
        if (record.getSlope1() != null) {
            sql.SET("slope1 = #{slope1,jdbcType=INTEGER}");
        }
        
        if (record.getSlope2() != null) {
            sql.SET("slope2 = #{slope2,jdbcType=INTEGER}");
        }
        
        if (record.getDealDate() != null) {
            sql.SET("deal_date = #{dealDate,jdbcType=DATE}");
        }
        
        if (record.getHold() != null) {
            sql.SET("hold = #{hold,jdbcType=BIT}");
        }
        
        if (record.getReversalRate() != null) {
            sql.SET("reversal_rate = #{reversalRate,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RaskAlyzExample example, boolean includeExamplePhrase) {
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