package com.vmax.mapper;

import com.vmax.entity.Tbpermission;
import java.util.List;

public interface TbpermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbpermission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long lid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbpermission
     *
     * @mbggenerated
     */
    int insert(Tbpermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbpermission
     *
     * @mbggenerated
     */
    Tbpermission selectByPrimaryKey(Long lid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbpermission
     *
     * @mbggenerated
     */
    List<Tbpermission> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbpermission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Tbpermission record);
}