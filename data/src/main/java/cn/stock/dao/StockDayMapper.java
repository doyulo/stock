package cn.stock.dao;

import cn.stock.model.StockDay;
import cn.stock.model.StockDayExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface StockDayMapper {
    @SelectProvider(type=StockDaySqlProvider.class, method="countByExample")
    long countByExample(StockDayExample example);

    @DeleteProvider(type=StockDaySqlProvider.class, method="deleteByExample")
    int deleteByExample(StockDayExample example);

    @Insert({
        "insert into stock_day (code, name, ",
        "begin_pri, max_pri, ",
        "min_pri, pre_pri, ",
        "cur_pri, deal_qty, ",
        "deal_amt, rate, rate_range, ",
        "in_out_rate, cur_date, ",
        "market_cap, famc)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{beginPri,jdbcType=DECIMAL}, #{maxPri,jdbcType=DECIMAL}, ",
        "#{minPri,jdbcType=DECIMAL}, #{prePri,jdbcType=DECIMAL}, ",
        "#{curPri,jdbcType=DECIMAL}, #{dealQty,jdbcType=BIGINT}, ",
        "#{dealAmt,jdbcType=DECIMAL}, #{rate,jdbcType=DECIMAL}, #{rateRange,jdbcType=DECIMAL}, ",
        "#{inOutRate,jdbcType=DECIMAL}, #{curDate,jdbcType=DATE}, ",
        "#{marketCap,jdbcType=DECIMAL}, #{famc,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(StockDay record);

    @Insert(
            "<script>"+
            "insert into stock_day (code, name, "+
            "begin_pri, max_pri, "+
            "min_pri, pre_pri, "+
            "cur_pri, deal_qty, "+
            "deal_amt, rate, rate_range, "+
            "in_out_rate, cur_date, "+
            "market_cap, famc)"+
            "values " +
            "<foreach collection =\"records\" item=\"record\" index= \"index\" separator =\",\"> "+
                    "(#{record.code,jdbcType=VARCHAR}, #{record.name,jdbcType=VARCHAR}, "+
            "#{record.beginPri,jdbcType=DECIMAL}, #{record.maxPri,jdbcType=DECIMAL}, "+
            "#{record.minPri,jdbcType=DECIMAL}, #{record.prePri,jdbcType=DECIMAL}, "+
            "#{record.curPri,jdbcType=DECIMAL}, #{record.dealQty,jdbcType=BIGINT}, "+
            "#{record.dealAmt,jdbcType=DECIMAL}, #{record.rate,jdbcType=DECIMAL}, #{record.rateRange,jdbcType=DECIMAL}, "+
            "#{record.inOutRate,jdbcType=DECIMAL}, #{record.curDate,jdbcType=DATE}, "+
            "#{record.marketCap,jdbcType=DECIMAL}, #{record.famc,jdbcType=DECIMAL})"+
            "</foreach>"+
            "</script>"
    )

    int insertAll(@Param("records") List<StockDay> records);

    @InsertProvider(type=StockDaySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(StockDay record);

    @SelectProvider(type=StockDaySqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="begin_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="max_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="min_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="pre_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="cur_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="deal_qty", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="deal_amt", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="rate", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="rate_range", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="in_out_rate", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="cur_date", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="market_cap", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="famc", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL)
    })
    List<StockDay> selectByExample(StockDayExample example);

    @UpdateProvider(type=StockDaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StockDay record, @Param("example") StockDayExample example);

    @UpdateProvider(type=StockDaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StockDay record, @Param("example") StockDayExample example);

    @Select("select max(cur_date) from stock_day where code='sh601318'")
    Date getLastSaveDay();

    @Select("select id,code,name,begin_pri,max_pri,min_pri,pre_pri,cur_pri,deal_qty,deal_amt,rate,rate_range,in_out_rate,cur_date,market_cap,famc from stock_day where code=#{code,jdbcType=VARCHAR} and cur_date=#{curDate,jdbcType=DATE}")
    @ConstructorArgs({
            @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="begin_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="max_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="min_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="pre_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="cur_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="deal_qty", javaType=Long.class, jdbcType=JdbcType.BIGINT),
            @Arg(column="deal_amt", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="rate", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="rate_range", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="in_out_rate", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="cur_date", javaType=Date.class, jdbcType=JdbcType.DATE),
            @Arg(column="market_cap", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
            @Arg(column="famc", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL)
    })
    StockDay getStock(@Param("code") String code,@Param("curDate") Date curDate);
}