package tws.repository;

import org.apache.ibatis.annotations.*;
import tws.entity.Parkinglot;
import java.util.List;

@Mapper

public interface ParkingLotMapper {

    @Select("select * from parkinglot;")
    List<Parkinglot> selectAll();

    @Insert("insert into parkinglot values (#{parkinglot.parkinglotId}, #{parkinglot.parkinglotCapacity}, #{parkinglot.parkinglotAvailablePositionCount}, #{parkinglot.parkingboyId});")
    void insert(@Param("parkinglot") Parkinglot parkinglot);

    @Update("update parkinglot set parkinglot.parkinglotCapacity=#{employee.parkinglotCapacity}, parkinglot.parkinglotAvailablePositionCount=#{employee.parkinglotAvailablePositionCount} where parkinglot.parkingboyId = #{parkingboyId};")
    void update(@Param("parkinglot") int parkingBoyId, @Param("employee") Parkinglot parkinglot);

    @Delete("delete from parkinglot where parkinglot.parkingboyId #{parkingBoysId};")
    void deleteOne(@Param("parkingBoysId") int parkingBoysId);
}
