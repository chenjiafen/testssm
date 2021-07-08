package com.tensquare.gathering.dao;

import com.tensquare.gathering.entity.Gathering;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tyler.chen
 * @version 1.0 2020/6/24
 * @date 2020/6/24 0:08
 */
public interface GatheringDao {
   /**
    * 查询所有
    * @return
    */
   List<Gathering> getGatheringList();

   /**
    * id和name查询
    * @param ga
    * @return
    */
   //   select * from tb_gathering where id=#{ga.id} and `name`=#{ga.name};
   Gathering getGathering(@Param("ga") Gathering ga);

   /**
    * 根据name查询
    * @param ga
    * @return
    */
   List<Gathering> getByName(@Param("ga") Gathering ga);

   /**
    * 把name为a的数据状态更新为2
    */
   void updateGathering(Gathering ga);

   /**
    * 根据id更新数据
    * @param ga
    * @return
    */
   Boolean updategathering(@Param ( "ga" ) Gathering ga);

   void updatega(List<Gathering> ga);
}
