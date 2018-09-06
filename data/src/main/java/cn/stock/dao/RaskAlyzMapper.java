package cn.stock.dao;

import cn.stock.model.RaskAlyz;
import cn.stock.model.RaskAlyzExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface RaskAlyzMapper {
    @SelectProvider(type=RaskAlyzSqlProvider.class, method="countByExample")
    long countByExample(RaskAlyzExample example);

    @DeleteProvider(type=RaskAlyzSqlProvider.class, method="deleteByExample")
    int deleteByExample(RaskAlyzExample example);

    @Delete({
        "delete from rask_alyz",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into rask_alyz (code, name, ",
        "cur_pri, avr_pri, ",
        "avr_pri_1, avr_pri_2, ",
        "rate, slope, slope1, ",
        "slope2, deal_date, hold, ",
        "reversal_rate, high_risk_days, ",
        "remark, postive_days)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{curPri,jdbcType=DECIMAL}, #{avrPri,jdbcType=DECIMAL}, ",
        "#{avrPri1,jdbcType=DECIMAL}, #{avrPri2,jdbcType=DECIMAL}, ",
        "#{rate,jdbcType=DECIMAL}, #{slope,jdbcType=INTEGER}, #{slope1,jdbcType=INTEGER}, ",
        "#{slope2,jdbcType=INTEGER}, #{dealDate,jdbcType=DATE}, #{hold,jdbcType=BIT}, ",
        "#{reversalRate,jdbcType=VARCHAR}, #{highRiskDays,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{postiveDays,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RaskAlyz record);

    @InsertProvider(type=RaskAlyzSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RaskAlyz record);

    @Insert({
            "<script>",
            "insert into rask_alyz (code, name, ",
            "cur_pri, avr_pri, ",
            "avr_pri_1, avr_pri_2, ",
            "rate, slope, slope1, ",
            "slope2, deal_date, hold, ",
            "remark, reversal_rate,high_risk_days,postive_days)",
            "values ",
            "<foreach collection =\"records\" item=\"record\" index= \"index\" separator =\",\"> ",
            "(#{record.code,jdbcType=VARCHAR}, #{record.name,jdbcType=VARCHAR}, ",
            "#{record.curPri,jdbcType=DECIMAL}, #{record.avrPri,jdbcType=DECIMAL}, ",
            "#{record.avrPri1,jdbcType=DECIMAL}, #{record.avrPri2,jdbcType=DECIMAL}, ",
            "#{record.rate,jdbcType=DECIMAL}, #{record.slope,jdbcType=INTEGER}, #{record.slope1,jdbcType=INTEGER}, ",
            "#{record.slope2,jdbcType=INTEGER}, #{record.dealDate,jdbcType=DATE}, #{record.hold,jdbcType=BIT}, ",
            "#{record.remark,jdbcType=VARCHAR}, #{record.reversalRate,jdbcType=DECIMAL},#{record.highRiskDays,jdbcType=INTEGER},",
            "#{record.postiveDays,jdbcType=INTEGER})",
            "</foreach>",
            "</script>"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertAll(@Param("records") List<RaskAlyz> records);

    @Select("select max(deal_date) from rask_alyz where code='sh601318'")
    Date getLastAlyzDay();

    @SelectProvider(type=RaskAlyzSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cur_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="avr_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="avr_pri_1", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="avr_pri_2", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="rate", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="slope", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="slope1", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="slope2", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="deal_date", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="hold", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="reversal_rate", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="high_risk_days", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="postive_days", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<RaskAlyz> selectByExample(RaskAlyzExample example);

    @Select({
        "select",
        "id, code, name, cur_pri, avr_pri, avr_pri_1, avr_pri_2, rate, slope, slope1, ",
        "slope2, deal_date, hold, reversal_rate, high_risk_days, remark, postive_days",
        "from rask_alyz",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cur_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="avr_pri", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="avr_pri_1", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="avr_pri_2", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="rate", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="slope", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="slope1", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="slope2", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="deal_date", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="hold", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="reversal_rate", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="high_risk_days", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="postive_days", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    RaskAlyz selectByPrimaryKey(Long id);

    @UpdateProvider(type=RaskAlyzSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RaskAlyz record, @Param("example") RaskAlyzExample example);

    @UpdateProvider(type=RaskAlyzSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RaskAlyz record, @Param("example") RaskAlyzExample example);

    @UpdateProvider(type=RaskAlyzSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RaskAlyz record);

    @Update({
        "update rask_alyz",
        "set code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "cur_pri = #{curPri,jdbcType=DECIMAL},",
          "avr_pri = #{avrPri,jdbcType=DECIMAL},",
          "avr_pri_1 = #{avrPri1,jdbcType=DECIMAL},",
          "avr_pri_2 = #{avrPri2,jdbcType=DECIMAL},",
          "rate = #{rate,jdbcType=DECIMAL},",
          "slope = #{slope,jdbcType=INTEGER},",
          "slope1 = #{slope1,jdbcType=INTEGER},",
          "slope2 = #{slope2,jdbcType=INTEGER},",
          "deal_date = #{dealDate,jdbcType=DATE},",
          "hold = #{hold,jdbcType=BIT},",
          "reversal_rate = #{reversalRate,jdbcType=VARCHAR},",
          "high_risk_days = #{highRiskDays,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "postive_days = #{postiveDays,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RaskAlyz record);
}