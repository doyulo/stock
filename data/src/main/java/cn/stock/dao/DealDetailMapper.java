package cn.stock.dao;

import cn.stock.model.DealDetail;
import cn.stock.model.DealDetailExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface DealDetailMapper {
    @SelectProvider(type=DealDetailSqlProvider.class, method="countByExample")
    long countByExample(DealDetailExample example);

    @DeleteProvider(type=DealDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(DealDetailExample example);

    @Insert({
            "<script>",
        "insert into deal_detail (parent_id, deal_time, ",
        "price, price_diff, ",
        "qty, amt, sign)",
            "values ",
            "<foreach collection =\"dealDetails\" item=\"record\" index= \"index\" separator =\",\">",
            "(#{record.parentId,jdbcType=INTEGER}, #{record.dealTime,jdbcType=TIME},",
            "#{record.price,jdbcType=DECIMAL}, #{record.priceDiff,jdbcType=DECIMAL}, ",
            "#{record.qty,jdbcType=INTEGER}, #{record.amt,jdbcType=DECIMAL}, #{record.sign,jdbcType=SMALLINT})",
            "</foreach>",
            "</script>"
    })
    int insertAll(@Param("dealDetails") List<DealDetail> dealDetails);

    @Insert({
        "insert into deal_detail (parent_id, deal_time, ",
        "price, price_diff, ",
        "qty, amt, sign)",
        "values (#{parentId,jdbcType=INTEGER}, #{dealTime,jdbcType=TIME}, ",
        "#{price,jdbcType=DECIMAL}, #{priceDiff,jdbcType=DECIMAL}, ",
        "#{qty,jdbcType=INTEGER}, #{amt,jdbcType=DECIMAL}, #{sign,jdbcType=SMALLINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="idDealDetail", before=false, resultType=Integer.class)
    int insert(DealDetail record);

    @InsertProvider(type=DealDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="idDealDetail", before=false, resultType=Integer.class)
    int insertSelective(DealDetail record);

    @SelectProvider(type=DealDetailSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id_deal_detail", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="parent_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="deal_time", javaType=Date.class, jdbcType=JdbcType.TIME),
        @Arg(column="price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="price_diff", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="qty", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="amt", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="sign", javaType=Short.class, jdbcType=JdbcType.SMALLINT)
    })
    List<DealDetail> selectByExample(DealDetailExample example);

    @UpdateProvider(type=DealDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DealDetail record, @Param("example") DealDetailExample example);

    @UpdateProvider(type=DealDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DealDetail record, @Param("example") DealDetailExample example);
}