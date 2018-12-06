package com.sunxu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunxu.entity.Menu;
import com.sunxu.vo.MenuVo;

import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<Menu> {

	List<MenuVo> generateRoutes(@Param("userId") String userId);

}