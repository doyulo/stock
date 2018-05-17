package cn.stock.dao;

import cn.stock.model.StockDay;
import cn.stock.model.StockDayExample;
import cn.stock.model.StockDayExample.Criteria;
import cn.stock.model.StockDayExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class StockDaySqlProvider {

    public String countByExample(StockDayExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("stock_day");
        applyWhere(sql, example, false);

        String limit = "";
        if(example != null && example.getStart()!=null&&example.getLimit()!=null){
            limit = " LIMIT "+example.getStart()+","+example.getLimit();
        }else if(example != null && example.getLimit()!=null){
            limit = " LIMIT "+example.getLimit();
        }

        return sql.toString()+limit;
    }

    public String deleteByExample(StockDayExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("stock_day");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * "min_pri, pre_pri, ",
     "cur_pri, deal_qty, ",
     "deal_amt, rate, rate_range, ",
     "in_out_rate, cur_date, ",
     "market_cap, famc)",
     "values " ,
     * @return
     */
    /*public String insertAll(Map map){

        List<StockDay> records = (List<StockDay>) map.get("records");

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into stock_day (code, name, ")
                .append("begin_pri, max_pri, ")
                .append("min_pri, pre_pri,")
                .append("cur_pri, deal_qty,")
                .append("deal_amt, rate, rate_range,")
                .append("in_out_rate, cur_date,")
                .append("market_cap, famc) values ");

        for (StockDay record : records) {
            sqlBuilder.append()
        }

    }*/

    public String insertSelective(StockDay record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("stock_day");
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBeginPri() != null) {
            sql.VALUES("begin_pri", "#{beginPri,jdbcType=DECIMAL}");
        }
        
        if (record.getMaxPri() != null) {
            sql.VALUES("max_pri", "#{maxPri,jdbcType=DECIMAL}");
        }
        
        if (record.getMinPri() != null) {
            sql.VALUES("min_pri", "#{minPri,jdbcType=DECIMAL}");
        }
        
        if (record.getPrePri() != null) {
            sql.VALUES("pre_pri", "#{prePri,jdbcType=DECIMAL}");
        }
        
        if (record.getCurPri() != null) {
            sql.VALUES("cur_pri", "#{curPri,jdbcType=DECIMAL}");
        }
        
        if (record.getDealQty() != null) {
            sql.VALUES("deal_qty", "#{dealQty,jdbcType=BIGINT}");
        }
        
        if (record.getDealAmt() != null) {
            sql.VALUES("deal_amt", "#{dealAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getRate() != null) {
            sql.VALUES("rate", "#{rate,jdbcType=DECIMAL}");
        }
        
        if (record.getRateRange() != null) {
            sql.VALUES("rate_range", "#{rateRange,jdbcType=DECIMAL}");
        }
        
        if (record.getInOutRate() != null) {
            sql.VALUES("in_out_rate", "#{inOutRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCurDate() != null) {
            sql.VALUES("cur_date", "#{curDate,jdbcType=DATE}");
        }
        
        if (record.getMarketCap() != null) {
            sql.VALUES("market_cap", "#{marketCap,jdbcType=DECIMAL}");
        }
        
        if (record.getFamc() != null) {
            sql.VALUES("famc", "#{famc,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(StockDayExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("code");
        sql.SELECT("name");
        sql.SELECT("begin_pri");
        sql.SELECT("max_pri");
        sql.SELECT("min_pri");
        sql.SELECT("pre_pri");
        sql.SELECT("cur_pri");
        sql.SELECT("deal_qty");
        sql.SELECT("deal_amt");
        sql.SELECT("rate");
        sql.SELECT("rate_range");
        sql.SELECT("in_out_rate");
        sql.SELECT("cur_date");
        sql.SELECT("market_cap");
        sql.SELECT("famc");
        sql.FROM("stock_day");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        String limit = "";
        if(example != null && example.getStart()!=null&&example.getLimit()!=null){
            limit = " LIMIT "+example.getStart()+","+example.getLimit();
        }else if(example != null && example.getLimit()!=null){
            limit = " LIMIT "+example.getLimit();
        }
        
        return sql.toString()+limit;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StockDay record = (StockDay) parameter.get("record");
        StockDayExample example = (StockDayExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("stock_day");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getBeginPri() != null) {
            sql.SET("begin_pri = #{record.beginPri,jdbcType=DECIMAL}");
        }
        
        if (record.getMaxPri() != null) {
            sql.SET("max_pri = #{record.maxPri,jdbcType=DECIMAL}");
        }
        
        if (record.getMinPri() != null) {
            sql.SET("min_pri = #{record.minPri,jdbcType=DECIMAL}");
        }
        
        if (record.getPrePri() != null) {
            sql.SET("pre_pri = #{record.prePri,jdbcType=DECIMAL}");
        }
        
        if (record.getCurPri() != null) {
            sql.SET("cur_pri = #{record.curPri,jdbcType=DECIMAL}");
        }
        
        if (record.getDealQty() != null) {
            sql.SET("deal_qty = #{record.dealQty,jdbcType=BIGINT}");
        }
        
        if (record.getDealAmt() != null) {
            sql.SET("deal_amt = #{record.dealAmt,jdbcType=DECIMAL}");
        }
        
        if (record.getRate() != null) {
            sql.SET("rate = #{record.rate,jdbcType=DECIMAL}");
        }
        
        if (record.getRateRange() != null) {
            sql.SET("rate_range = #{record.rateRange,jdbcType=DECIMAL}");
        }
        
        if (record.getInOutRate() != null) {
            sql.SET("in_out_rate = #{record.inOutRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCurDate() != null) {
            sql.SET("cur_date = #{record.curDate,jdbcType=DATE}");
        }
        
        if (record.getMarketCap() != null) {
            sql.SET("market_cap = #{record.marketCap,jdbcType=DECIMAL}");
        }
        
        if (record.getFamc() != null) {
            sql.SET("famc = #{record.famc,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("stock_day");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("begin_pri = #{record.beginPri,jdbcType=DECIMAL}");
        sql.SET("max_pri = #{record.maxPri,jdbcType=DECIMAL}");
        sql.SET("min_pri = #{record.minPri,jdbcType=DECIMAL}");
        sql.SET("pre_pri = #{record.prePri,jdbcType=DECIMAL}");
        sql.SET("cur_pri = #{record.curPri,jdbcType=DECIMAL}");
        sql.SET("deal_qty = #{record.dealQty,jdbcType=BIGINT}");
        sql.SET("deal_amt = #{record.dealAmt,jdbcType=DECIMAL}");
        sql.SET("rate = #{record.rate,jdbcType=DECIMAL}");
        sql.SET("rate_range = #{record.rateRange,jdbcType=DECIMAL}");
        sql.SET("in_out_rate = #{record.inOutRate,jdbcType=DECIMAL}");
        sql.SET("cur_date = #{record.curDate,jdbcType=DATE}");
        sql.SET("market_cap = #{record.marketCap,jdbcType=DECIMAL}");
        sql.SET("famc = #{record.famc,jdbcType=DECIMAL}");
        
        StockDayExample example = (StockDayExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, StockDayExample example, boolean includeExamplePhrase) {
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