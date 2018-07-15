package cn.stock.dao;

import cn.stock.model.EastMoneyIndestry;
import cn.stock.model.EastMoneyIndestryExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EastMoneyIndestryMapper {
    @SelectProvider(type=EastMoneyIndestrySqlProvider.class, method="countByExample")
    long countByExample(EastMoneyIndestryExample example);

    @DeleteProvider(type=EastMoneyIndestrySqlProvider.class, method="deleteByExample")
    int deleteByExample(EastMoneyIndestryExample example);

    @Delete({
        "delete from east_money_indestry",
        "where code = #{code,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String code);

    @Insert({
        "insert into east_money_indestry (code, name)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(EastMoneyIndestry record);

    @InsertProvider(type=EastMoneyIndestrySqlProvider.class, method="insertSelective")
    int insertSelective(EastMoneyIndestry record);

    @SelectProvider(type=EastMoneyIndestrySqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<EastMoneyIndestry> selectByExample(EastMoneyIndestryExample example);

    @Select({
        "select",
        "code, name",
        "from east_money_indestry",
        "where code = #{code,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    EastMoneyIndestry selectByPrimaryKey(String code);

    @UpdateProvider(type=EastMoneyIndestrySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EastMoneyIndestry record, @Param("example") EastMoneyIndestryExample example);

    @UpdateProvider(type=EastMoneyIndestrySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EastMoneyIndestry record, @Param("example") EastMoneyIndestryExample example);

    @UpdateProvider(type=EastMoneyIndestrySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EastMoneyIndestry record);

    @Update({
        "update east_money_indestry",
        "set name = #{name,jdbcType=VARCHAR}",
        "where code = #{code,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EastMoneyIndestry record);
}