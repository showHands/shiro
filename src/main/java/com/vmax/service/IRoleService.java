package com.vmax.service;

import com.vmax.entity.Tbrole;
import com.vmax.entity.Tbuser;
import com.vmax.utils.TbUserStateEmum;

import java.util.List;
import java.util.Set;

public interface IRoleService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbrole
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long lid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbrole
     *
     * @mbggenerated
     */
    int insert(Tbrole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbrole
     *
     * @mbggenerated
     */
    Tbrole selectByPrimaryKey(Long lid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbrole
     *
     * @mbggenerated
     */
    List<Tbrole> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbrole
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Tbrole record);

    // 以下是自定义方法
}
