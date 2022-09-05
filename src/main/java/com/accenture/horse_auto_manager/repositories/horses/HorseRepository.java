package com.accenture.horse_auto_manager.repositories.horses;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface HorseRepository extends JpaRepository<HorseEntity, Long> {

    /*

    @Query(value = "select o from tab_horses o where o.color = ?white")
    List<HorseEntity>findAllByWhiteColor();

    @Query(value = "select o from tab_horses o where o.color = ?brown")
    List<HorseEntity>findAllByBrownColor();

    @Query(value = "select o from tab_horses o where o.color = ?black")
    List<HorseEntity>findAllByBlackColor();

     */
    /*
        select H.* from tab_horses H inner join
        tab_rfid_chip B on H.chip_id = B.chip_id where B.breakfast_time>='11:00:00'
        and B.launch_time<='17:00:00';
     */
    @Query(value = "select h.* from tab_horses h inner join tab_rfid_chip " +
            "b on h.chip_id = b.chip_id " +
            "where (b.breakfast_time>='07:00:00' and b.launch_time<='12:00:00' " +
            " and b.dinner_time<='17:00:00')",
            nativeQuery = true)
    List<HorseEntity> findBlackByLocalTime(@Param("time") LocalTime time);

    @Query(value = "select h.* from tab_horses h inner join tab_rfid_chip " +
            "b on h.chip_id = b.chip_id " +
            "where (b.breakfast_time>='07:00:00' and b.launch_time>='14:00:00' " +
            " and b.dinner_time<='17:00:00')",
            nativeQuery = true)
    List<HorseEntity> findBrownByLocalTime(@Param("time") LocalTime time);

    @Query(value = "select h.* from tab_horses h inner join tab_rfid_chip " +
            "b on h.chip_id = b.chip_id " +
            "where (b.breakfast_time>='09:00:00' and b.launch_time>='14:00:00' " +
            " and b.dinner_time>='21:00:00')",
            nativeQuery = true)
    List<HorseEntity> findWhiteByLocalTime(@Param("time") LocalTime time);
}
