package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FixedLossMapper {

    /**
     * 待查勘定损
     * @param m
     * @return
     */
    public Map scheduleFindBy(Map m);

    /**
     * 待车损定损
     * @param m
     * @return
     */
    public Map carFixedFind(Map m);

    /**
     * 人伤查询
     * @param m
     * @return
     */
    public List<Map> humanFind(Map m);

    /**
     * 物损
     * @param m
     * @return
     */
    public List<Map> damage(Map m);

    /**
     * 根据调度编号查询对应车损数据
     */
    public Map InvestigationFindBy(Map m);

    /**
     * 往事故现场查勘照片表插入数据
     * @param m
     * @return
     */
    public int investigatioImgAdd(Map m);

    /**
     * 往现场查勘表插入数据
     */
    public int investigationAdd(Map m);

    /**
     * 根据调度编号查询盗抢信息表
     */
    public Map robberyDamageFind(Map m);


    public int robberyDamageAdd(Map m);


}
