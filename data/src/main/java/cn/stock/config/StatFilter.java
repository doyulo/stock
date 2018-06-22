package cn.stock.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
class DruidStatFilter extends DruidStatProperties.WebStatFilter {
}